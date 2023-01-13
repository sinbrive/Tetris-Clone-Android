package com.example.tetris.state;



import static com.example.tetris.GameView.*;
import static processing.core.PConstants.CENTER;

import processing.core.PApplet;

public class MenuState extends State{

    private long chrono;
    private PApplet pr;

    Game game;

    public MenuState(Game game, PApplet pr) {
        this.pr=pr;
        this.game=game;

    }

    @Override
    public void setup() {
        chrono=pr.millis();
    }

    @Override
    public void update() {
        if (pr.millis()-chrono > 4000){
            State.setState(playingState);
            State.getState().setup();
        }

    }

    @Override
    public void draw() {
        game.displayGrid();
        game.displaySideBoard();
        pr.fill(255, 100, 100);
        pr.textAlign(CENTER);
        pr.textSize(WIDTH*0.3f);
        pr.text(""+(4000-(pr.millis()-chrono))/1000, WIDTH/2, HEIGHT/2);
    }

    @Override
    public void mouse_pressed(int key) {

    }

}

