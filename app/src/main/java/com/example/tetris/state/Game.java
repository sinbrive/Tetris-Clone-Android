package com.example.tetris.state;

import static com.example.tetris.GameView.*;
import static processing.core.PConstants.CENTER;
import com.example.tetris.Point;
import com.example.tetris.Shape;

import java.util.ArrayList;
import java.util.Iterator;

import processing.core.PApplet;

public class Game {

    private int rotIndex = 0;
    private ArrayList<Point> lines;
    public  int score = 0;
    private int points_per_level=100;
    public  int level=1;
    private double chrono;
    private int timeLevel=1000;
    public Shape shape;
    public Shape nextShape;
    private PApplet pr;

    //------------------
    public Game(PApplet pr) {
        this.pr=pr;
        setup();
    }

    //------------------
    public void setup() {
        pr.rectMode(CENTER);
        chrono=pr.millis();
        lines=new ArrayList();
        score = 0;
        level = 1;
        rotIndex = 0;
        lines = new ArrayList<Point>();
        shape = new Shape(wCell/2, hCell/2, pr);
        nextShape = new Shape(WIDTH+70, 50, pr);
    }

    //------------------
    public void update() {
        makeStepDown();
        if (!shape.canMoveDown(lines) || nextOnFloor()) {
            shape.move(0, -hCell);
            lockCurrentShape();
            switchToNextShape();
            checkUpdateScore();
            checkGameOver();
        }
    }

    //------------------
    public void draw() {
        displayGrid();
        shape.draw();
        drawLines();
        displaySideBoard();
    }

    //------------------
    public void makeStepDown() {
        if ((pr.millis() - chrono) > timeLevel) {
            chrono = pr.millis();
            shape.move(0, hCell);
        }
    }

    //------------------
    public boolean nextOnFloor() {
        return (!(shape.highestY() < HEIGHT));
    }

    //------------------
    public void lockCurrentShape() {
        lines.addAll(shape.getRealCoords());
    }

    //------------------
    public void switchToNextShape() {
        rotIndex = 0;
        chrono = pr.millis();
        shape = nextShape;
        shape.setXoffset(wCell/2);
        shape.setYoffset(hCell/2);
        nextShape = new Shape(WIDTH+70, 50, pr);
    }

    //------------------
    public void checkUpdateScore() {
        float row = HEIGHT - hCell/2;
        int count;
        do {
            count = 0;
            for (Iterator<Point> it = lines.listIterator(); it.hasNext(); ) {
                Point ln = it.next();
                if (ln.y == row) count++;
                if (count == 10) {
                    count = 0;
                    removeLine(row);
                    it = lines.listIterator();  // reset iterator cause lines were modified https://stackoverflow.com/a/13689311
                    score += 20;
                    if (score > points_per_level * level) {
                        score = 0;
                        level += 1;
                    }
                }
            }
            row -= hCell;
        } while (row > 100);
    }

    //------------------
    public void removeLine(float row) {

        Iterator<Point> itr = lines.iterator();
        while (itr.hasNext()) {
            Point ln = itr.next();
            if (ln.y == row) {
                itr.remove();
            }
        }

        //lines.removeIf(p -> pr.y == row);  // Java 8

        for (Point ln : lines) {
            if (ln.y < row) {
                ln.y +=hCell;
            }
        }
    }

    //------------------
    public void checkGameOver() {
        for (Point ln : lines) {
            if (ln.y < 3*hCell) {
                //game_over= true;
                State.setState(endState);
                return;
            }
        }
    }


    //------------------
    public void displayGrid() {
        pr.noFill();
        pr.stroke(100);
        //pr.strokeWeight(0.5f*displayDensity);
        for (int y=hCell/2; y<HEIGHT; y+=hCell) {
            for (int x=wCell/2; x<WIDTH; x+=wCell) {
                pr.rect(x, y, wCell, hCell);
            }
        }
    }


    //------------------
    public void drawLines() {
        for (Point ln : lines) {
            pr.fill(ln.c);
            pr.rect(ln.x, ln.y, wCell, hCell);
        }
    }

    //------------------
    public void displaySideBoard() {
        pr.fill(0xff222222);
        pr.rectMode(CORNER);
        pr.rect (WIDTH, 0, pr.width/3, HEIGHT);
        pr.rectMode(CENTER);

        nextShape.draw();
        pr.textAlign(CORNER);
        pr.fill(130);
        pr.textSize(WIDTH*0.07f);
        pr.text("Level "+level, WIDTH+30, HEIGHT*0.5f);
        pr.text("Score "+score, WIDTH+30, HEIGHT*0.55f);
        // pause button
        pr.rect(WIDTH+WIDTH*0.5f/2, HEIGHT*0.75f, WIDTH*0.3f, HEIGHT*0.05f);
        pr.fill(0);
        pr.text("Pause", WIDTH+WIDTH*0.3f/2, HEIGHT*0.76f);

        displayFooter();
    }


    //------------------
    public void displayFooter() {

        pr.fill(180);
        pr.stroke(255);
        pr.strokeWeight(5);
        pr.line(0, HEIGHT, pr.width, HEIGHT);
        pr.textAlign(CENTER);
        pr.text("Tetris Game", pr.width/2, pr.height*0.85f);

        pr.fill(255, 100, 100);
        pr.textSize(WIDTH*0.05f);
        pr.textAlign(CORNER);
        pr.text("LEFT and RIGHT for move.", WIDTH*0.2f, pr.height*0.9f);
        pr.text("DOWN to drop down,", WIDTH*0.2f, pr.height*0.93f);
        pr.text("UP for rotate.", WIDTH*0.2f, pr.height*0.96f);
    }

    //------------------
    public void mouse_pressed(int key) {
        float a=0;
        float b=0;

        if (key==DOWN) {
            do {
                shape.move(0, hCell);
            } while (shape.canMoveDown(lines) && !nextOnFloor());
            shape.move(0, -hCell);
            return;
        }

        // move right
        if (key == RIGHT) {
            a = shape.getXoffset();
            if (a < WIDTH - wCell * shape.getNbX()) {
                shape.move(wCell, 0);
                return;
            }
        }

        // move left
        if (key == LEFT) {
            a= shape.getXoffset();
            if (a > wCell) {
                shape.move(-wCell, 0);
                return;
            }
        }

        // rotate
        if (key == UP) {
            int save =rotIndex;
            rotIndex+=1;
            rotIndex = rotIndex % 4;
            // disable rotation to prevent overflow
            shape.rotate(rotIndex);
            if (shape.xOutRightSide(WIDTH)) {
                rotIndex = save;
                shape.rotate(rotIndex);
            }
        }
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }
}