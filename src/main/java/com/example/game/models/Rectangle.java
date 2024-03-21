package com.example.game.models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Rectangle extends EnterObject {
    public Rectangle(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public Result onEnter() {
        return Result.POLYGON;
    }

    public Shape asObj() {
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle();
        rectangle.setWidth(25.0);
        rectangle.setHeight(25.0);
        rectangle.setFill(Color.SIENNA);
        rectangle.setX((double)(this.X * 25));
        rectangle.setY((double)(this.Y * 25));
        return rectangle;
    }
}
