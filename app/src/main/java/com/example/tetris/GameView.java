package com.example.tetris;

import com.example.tetris.state.EndState;
import com.example.tetris.state.Game;
import com.example.tetris.state.MenuState;
import com.example.tetris.state.PauseState;
import com.example.tetris.state.PlayingState;
import com.example.tetris.state.State;

import processing.core.PApplet;

public class GameView extends PApplet {

    public static State playingState;
    public static State menuState;
    public static State endState;
    public static State pauseState;


    Game game;
    int mousePressedX, mousePressedY;

    public static int wCell;
    public static int hCell;

    public static int WIDTH;
    public static int HEIGHT;

    //------------------
    @Override
    public void setup() {

        WIDTH = width-width/3;
        HEIGHT = 2*WIDTH;

        wCell=WIDTH/10;
        hCell=HEIGHT/20; // HEIGHT/20;

        orientation(PORTRAIT);

        game = new Game(this);

        menuState = new MenuState(game, this);

        pauseState = new PauseState(game, this);

        playingState = new PlayingState(game, this);

        endState = new EndState(game, this);

        State.setState(menuState);

        State.getState().setup();
    }

    //------------------
    @Override
    public void draw() {
        background(0);
        State.getState().update();
        State.getState().draw();
    }

    @Override
    public void mousePressed() {
        mousePressedX=mouseX;
        mousePressedY=mouseY;
    }

    @Override
    public void mouseReleased() {
        int dx=mouseX-mousePressedX;
        int dy=mouseY-mousePressedY;

        // Pause Tap
        // rect(WIDTH+WIDTH*0.35/2, HEIGHT*0.75, WIDTH*0.3, HEIGHT*0.05); // rect 'pause': see game display side bar
        float xx=WIDTH+WIDTH*0.5f/2, yy=HEIGHT*0.75f;
        float w =WIDTH*0.3f, h=HEIGHT*0.05f;

        if (abs(mousePressedX - xx) < w/2 && abs(mousePressedY - yy) < h/2) {
            State.getState().mouse_pressed('p');
            return;
        }

        if ( abs( dx ) > abs( dy ) ) {
            if (dx > 0) {
                State.getState().mouse_pressed(RIGHT);
            } else {
                State.getState().mouse_pressed(LEFT);
            }
        } else {
            if (dy > 0) {
                State.getState().mouse_pressed(DOWN);  // drop down
            } else {
                State.getState().mouse_pressed(UP);  // rotate
            }
        }
        mousePressedX=mouseX;
        mousePressedY=mouseY;
    }

    @Override
    public void settings() {  size(displayWidth, displayHeight); }

}
