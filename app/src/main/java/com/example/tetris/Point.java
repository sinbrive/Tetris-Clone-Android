package com.example.tetris;

import processing.core.PApplet;

public class Point extends PApplet {
    public float x;
    public float y;
    public int c;
    //PApplet pr;

    Point(float x, float y) {
        this.x=x;
        this.y=y;
        this.c=color(0);
    }

    Point(float x, float y, int c) {
        this.x=x;
        this.y=y;
        this.c =c;
    }
}
