package com.example.game.handlers;

import com.example.game.Logic.Engine;
import com.example.game.models.Handler;
import com.example.game.models.Processor;
import com.example.game.models.Result;

public class CircleHandler extends Processor {
    public CircleHandler(Processor next) {
        super(next);
    }

    public boolean handle(Result result, Engine game) {
        if (result != Result.CIRCLE) {
            return super.handle(result, game);
        } else {
            Handler var3 = game.getPlayer();
            var3.Gold = var3.Gold + 1;
            return true;
        }
    }
}
