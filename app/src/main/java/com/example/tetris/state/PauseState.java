package com.example.tetris.state;


import static com.example.tetris.GameView.*;

import processing.core.PApplet;

public class PauseState extends State {


    private Game game;
    PApplet pr;

    public PauseState(Game game, PApplet pr) {
        this.pr=pr;
        this.game = game;
    }

    @Override
    public void setup() {
    }

    @Override
    public void update() {
    }

    @Override
    public void draw() {
        game.draw();
        pr.fill(150, 50, 50);
        pr.textSize(WIDTH*0.07f);
        pr.text("Pause", WIDTH+WIDTH*0.3f/2, HEIGHT*0.70f);
    }

    @Override
    public void mouse_pressed(int key) {
        if (key == 'p') {
            State.setState(playingState);
        }
    }
}