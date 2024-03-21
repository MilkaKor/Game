package com.example.game.models;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Polygon extends EnterObject {
    public Polygon(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public Result onEnter() {
        return Result.RECTANGLE;
    }

    public Shape asObj() {
        javafx.scene.shape.Polygon obj = new javafx.scene.shape.Polygon();
        double halfSize = 12.5;
        double[] points = new double[]{(double)(this.X * 25), (double)(this.Y * 25 + 25), (double)(this.X * 25) + halfSize, (double)(this.Y * 25), (double)(this.X * 25 + 25), (double)(this.Y * 25 + 25)};
        List<Double> pointsList = new ArrayList();
        double[] var6 = points;
        int var7 = points.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            double point = var6[var8];
            pointsList.add(point);
        }

        obj.getPoints().addAll(pointsList);
        obj.setFill(Color.DEEPSKYBLUE);
        return obj;
    }
}

