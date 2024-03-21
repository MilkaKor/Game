package com.example.game;


import com.example.game.Logic.Engine;
import com.example.game.models.Circle;
import com.example.game.models.Polygon;
import com.example.game.models.Rectangle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HelloController implements EventHandler<KeyEvent> {
    @FXML
    private Pane mainPane;
    @FXML
    private VBox mainWindow;
    Engine game;

    public HelloController() {
    }

    public void initialize() {
        this.mainPane.toFront();
        this.mainWindow.setOnKeyPressed(this::handle);
        this.game = new Engine(this.mainPane, Thread.currentThread());
        this.game.objects.add(new Rectangle(14, 10));
        this.game.objects.add(new Rectangle(6, 9));
        this.game.objects.add(new Rectangle(6, 1));
        this.game.objects.add(new Rectangle(10, 0));
        this.game.objects.add(new Rectangle(2, 6));
        this.game.objects.add(new Circle(13, 6));
        this.game.objects.add(new Circle(10, 9));
        this.game.objects.add(new Circle(2, 0));
        this.game.objects.add(new Polygon(14, 3));
        this.game.objects.add(new Polygon(5, 7));
        this.game.objects.add(new Polygon(1, 10));
        this.game.objects.add(new Polygon(4, 4));
        this.game.GameMove(this.mainPane);
        this.game.run();
    }

    public void handle(KeyEvent e) {
        if (e.getCode() == KeyCode.W) {
            this.game.PlayerMove(0, -1);
        }

        if (e.getCode() == KeyCode.A) {
            this.game.PlayerMove(-1, 0);
        }

        if (e.getCode() == KeyCode.S) {
            this.game.PlayerMove(0, 1);
        }

        if (e.getCode() == KeyCode.D) {
            this.game.PlayerMove(1, 0);
        }

        this.game.GameMove(this.mainPane);
    }
}
