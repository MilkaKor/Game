package com.example.game.models;

import javafx.scene.shape.Shape;

public abstract class FirstObject {
    protected final int SIZE = 25;
    public Integer X;
    public Integer Y;

    public FirstObject() {
    }

    public abstract Shape asObj();

    public void SetCords(int x, int y) {
        this.X = x;
        this.Y = y;
    }
}