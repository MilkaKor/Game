package com.example.game.models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Handler extends FirstObject {
    public Integer Redstone = 0;
    public Integer Gold = 0;
    public Integer Diamond = 0;

    public Handler() {
    }

    public Shape asObj() {
        Circle player = new Circle();
        player.setFill(Color.HOTPINK);
        player.setRadius(27.0);
        player.setCenterX((double)(this.X * 25 + 12));
        player.setCenterY((double)(this.Y * 25 + 12));
        return player;
    }
}
