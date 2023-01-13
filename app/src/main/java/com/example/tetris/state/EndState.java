package com.example.tetris.state;

import static processing.core.PConstants.*;

import com.example.tetris.GameView;

import processing.core.PApplet;

public class EndState extends State {

    Game game;
    PApplet pr;
    public EndState(Game game, PApplet pr) {
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
        game.displayGrid();
        game.displaySideBoard();
        pr.fill(255, 100, 100);
        pr.text("Game Over", 50, GameView.HEIGHT / 2);
        pr.text("UP to re-start", 50, GameView.HEIGHT/2 + 100);
        pr.text("LEFT or RIGHT to quit", 50, GameView.HEIGHT /2 + 160);
    }

    @Override
    public void mouse_pressed(int key) {
        if (key == UP) {
            State.setState(GameView.playingState);
            State.getState().setup();
        } else if ((key == RIGHT) || (key == LEFT)) {
            pr.exit();
        }
    }
}
