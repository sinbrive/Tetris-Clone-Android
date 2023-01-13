package com.example.tetris.state;


import static com.example.tetris.GameView.pauseState;


import processing.core.PApplet;

public class PlayingState extends State {

    private Game game;

    public PlayingState(Game game, PApplet pr) {
        this.game = game;
    }

    @Override
    public void setup() {
        game.setup();
    }

    @Override
    public void update() {
        game.update();
    }

    @Override
    public void draw() {
        game.draw();
    }

    @Override
    public void mouse_pressed(int key) {
        if (key == 'p') {
            State.setState(pauseState);
            return;
        }
        game.mouse_pressed(key);
    }
}
