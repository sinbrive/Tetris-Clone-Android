package com.example.tetris;

import static com.example.tetris.GameView.*;

import java.util.ArrayList;
import processing.core.PApplet;

public class Shape extends Tetros {

    private int [] colrs={0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00,
                                                     0xffff00ff, 0xff00ffff, 0xfffffefe};

    float x, y;
    int c;
    int index, rotIndex;
    final Point [][] pattern;
    Point [] p;
    PApplet pr;


    //------------------
    public Shape(float x, float y, PApplet pr) {
        this.pr=pr;
        this.x = x;
        this.y = y;
        rotIndex=0;
        index = (int) this.pr.random(7);
        pattern=tetrosList[index];
        p = pattern[rotIndex];
        c =colrs[index];
    }

    //------------------
    public float getXoffset() {
        return x;
    }

    //------------------
    public float getYoffset() {
        return y;
    }

    //------------------
    public void setXoffset(float _x) {
        x=_x;
    }

    //------------------
    public void setYoffset(float _y) {
        y=_y;
    }

    //------------------
    public void rotate(int rot) {
        rotIndex=rot;
        p = pattern[rotIndex];
    }

    //------------------
    public Point [] getPattern() {
        return p;
    }

    //------------------
    public int getColor() {
        return c;
    }

    //------------------
    public void move(float _x, float _y) {
        x += _x;
        y += _y;
    }

    //------------------
    public void draw() {
        pr.noStroke();
        pr.fill(c);
        for (Point s : p) {
            float x = s.x * wCell + this.x;
            float y = s.y * hCell + this.y;
            pr.rect(x, y, wCell, hCell);
        }
    }

    //------------------
    public float maxY() {
        float largest = 0;
        for (Point point : p) {
            if (largest < point.y) {
                largest = point.y;
            }
        }
        return largest;
    }


    //------------------
    public float getNbX() {
        float largest = 0;
        for (Point point : p) {
            if (largest < point.x) {
                largest = point.x;
            }
        }
        return largest+1;
    }


    //------------------
    public boolean xOutRightSide(float limit) {
        float l;
        for (Point s : p) {
            l = s.x * wCell + this.x;
            if (l > limit) return true;
        }
        return false;
    }


    //------------------
    public boolean canMoveDown(ArrayList<Point> wall) {
        for (Point ln : wall) {
            for (int j=0; j<4; j++) {
                float a = p[j].x * wCell + x;
                float b = p[j].y * hCell + y;
                if ((a == ln.x) && (b == ln.y)) {
                    return false;
                }
            }
        }
        return true;
    }

    //------------------
    public float highestY() {
        return (y + hCell * maxY());
    }

    //------------------
    public ArrayList<Point> getRealCoords() {
        ArrayList<Point> ret= new ArrayList<>();
        Point  q;
        float  _x;
        float  _y;

        for (int i=0; i<p.length; i++) {
            _x = p[i].x * wCell + this.x;
            _y = p[i].y * hCell + this.y;
            q = new Point(_x, _y, c);
            ret.add(q);
        }
        return ret;
    }
}
