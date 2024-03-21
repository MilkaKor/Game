package com.example.game.handlers;

import com.example.game.Logic.Engine;
import com.example.game.models.Handler;
import com.example.game.models.Processor;
import com.example.game.models.Result;

public class PolygonHandler extends Processor {
    public PolygonHandler(Processor next) {
        super(next);
    }

    public boolean handle(Result result, Engine game) {
        if (result != Result.RECTANGLE) {
            return super.handle(result, game);
        } else {
            Handler var3 = game.getPlayer();
            var3.Diamond = var3.Diamond + 1;
            return true;
        }
    }
}
