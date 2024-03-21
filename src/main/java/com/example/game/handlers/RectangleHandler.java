package com.example.game.handlers;

import com.example.game.Logic.Engine;
import com.example.game.models.Handler;
import com.example.game.models.Processor;
import com.example.game.models.Result;

public class RectangleHandler extends Processor {
    public RectangleHandler(Processor next) {
        super(next);
    }

    public boolean handle(Result result, Engine game) {
        if (result != Result.POLYGON) {
            return super.handle(result, game);
        } else {
            Handler var3 = game.getPlayer();
            var3.Redstone = var3.Redstone + 1;
            return true;
        }
    }
}
