package com.example.tetris.state;


public abstract class State { // "static" is needed in processing because this class is inner class
    // https://stackoverflow.com/a/44251009

    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    // CLASS
    public abstract void setup();

    public abstract void update();

    public abstract void draw();

    public abstract void mouse_pressed(int e);

}

