package com.example.game.Logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.game.models.EnterObject;
import com.example.game.models.Handler;
import javafx.application.Platform;
import javafx.scene.layout.Pane;

public class Engine {
    Handler player = new Handler();
    Pane pane;
    ActionChain chain = new ActionChain();
    Thread main;
    public final int maxX = 12;
    public final int maxY = 10;
    public List<EnterObject> objects = new ArrayList();
    private List<EnterObject> removable = new ArrayList();
    private Boolean gameOver = false;

    public Engine(Pane pane, Thread main) {
        this.player.SetCords(8, 12);
        this.main = main;
        this.pane = pane;
        this.GameMove(this.pane);
    }

    public void run() {
        (new Thread(new Runnable() {
            public void run() {
                while(!Engine.this.gameOver) {
                    Iterator var1 = Engine.this.objects.iterator();

                    EnterObject j;
                    while(var1.hasNext()) {
                        j = (EnterObject)var1.next();
                        Integer var4 = j.Y;
                        j.Y = j.Y + 1;
                        if (j.Y > 12) {
                            Engine.this.removable.add(j);
                        }
                    }

                    var1 = Engine.this.removable.iterator();

                    while(var1.hasNext()) {
                        j = (EnterObject)var1.next();
                        Engine.this.objects.remove(j);
                    }

                    if (Engine.this.objects.isEmpty()) {
                        Engine.this.gameOver = true;
                    }

                    Platform.runLater(() -> {
                        Engine.this.DrawScene(Engine.this.pane);
                    });

                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var5) {
                        throw new RuntimeException(var5);
                    }
                }

            }
        })).start();
    }

    public Handler getPlayer() {
        return this.player;
    }

    void DrawScene(Pane pane) {
        pane.getChildren().clear();
        pane.getChildren().add(this.player.asObj());

        for(int i = 0; i < this.objects.size(); ++i) {
            pane.getChildren().add(((EnterObject)this.objects.get(i)).asObj());
        }

    }

    public void GameMove(Pane pane) {
        for(int i = 0; i < this.objects.size(); ++i) {
            if (this.player.X == ((EnterObject)this.objects.get(i)).X && this.player.Y == ((EnterObject)this.objects.get(i)).Y && !this.gameOver) {
                this.chain.handle(((EnterObject)this.objects.get(i)).onEnter(), this);
                this.objects.remove(i);
            }
        }

        this.DrawScene(pane);
        System.out.println("Квадрат: " + this.player.Redstone);
        System.out.println("Круг: " + this.player.Gold);
        System.out.println("Треугольник: " + this.player.Diamond);
        System.out.println("\n\n");
    }

    public boolean CheckCords(int X, int Y) {
        Iterator var3 = this.objects.iterator();

        EnterObject o;
        do {
            if (!var3.hasNext()) {
                return true;
            }

            o = (EnterObject)var3.next();
        } while(o.X != X || o.Y != Y);

        return false;
    }

    public void PlayerMove(int X, int Y) {
        if (!this.gameOver && this.player.X + X < 12 && this.player.X + X >= 0) {
            Handler var3 = this.player;
            var3.X = var3.X + X;
        }

    }
}
