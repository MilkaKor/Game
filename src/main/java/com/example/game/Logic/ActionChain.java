package com.example.game.Logic;

import com.example.game.handlers.CircleHandler;
import com.example.game.handlers.PolygonHandler;
import com.example.game.handlers.RectangleHandler;
import com.example.game.models.Processor;
import com.example.game.models.Result;

public class ActionChain {
    Processor chain;

    public ActionChain() {
        this.buildChain();
    }

    private void buildChain() {
        this.chain = new RectangleHandler(new PolygonHandler(new CircleHandler((Processor)null)));
    }

    public Processor getChain() {
        return this.chain;
    }

    public void handle(Result result, Engine gameEngine) {
        this.chain.handle(result, gameEngine);
    }
}
