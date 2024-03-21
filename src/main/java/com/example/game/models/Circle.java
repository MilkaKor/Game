package com.example.game.models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Circle extends EnterObject {
    public Circle(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public Result onEnter() {
        return Result.CIRCLE;
    }

    public Shape asObj() {
        javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle();
        circle.setRadius(12.0);
        circle.setFill(Color.ORANGE);
        circle.setCenterX((double)(this.X * 25 + 12));
        circle.setCenterY((double)(this.Y * 25 + 12));
        return circle;
    }
}
