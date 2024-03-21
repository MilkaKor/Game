package com.example.game.models;

import com.example.game.Logic.Engine;

public abstract class Processor {
    Processor next;

    public Processor(Processor next) {
        this.next = next;
    }

    public boolean handle(Result result, Engine game) {
        return result != null ? this.next.handle(result, game) : true;
    }
}
