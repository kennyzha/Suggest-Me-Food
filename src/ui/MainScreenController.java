package ui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.awt.event.MouseEvent;

public class MainScreenController {

    @FXML
    private TreeView<?> treeView;

    @FXML
    private AnchorPane recipesAnchorPane;

    @FXML
    private TextField searchBar;

    @FXML
    private Pane close;

    @FXML
    private Pane minimize;


    @FXML
    public void mouseClickedRoot(MouseEvent event) {

    }

    @FXML
    public void mouseDraggedRoot(MouseEvent event) {
    }


    @FXML
    public void mouseDraggedRoot(Event event) {
    }

    @FXML
    public void mouseClickedRoot(Event event) {

    }

    @FXML
    public void mouseEnteredX(Event event) {
        System.out.println("dadadadadda");
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(0), new KeyValue(close.scaleXProperty(), 0.1)),
                new KeyFrame(Duration.millis(0), new KeyValue(close.scaleYProperty(), 0.1)),
                new KeyFrame(Duration.millis(300), new KeyValue(close.scaleXProperty(), 0.2)),
                new KeyFrame(Duration.millis(300), new KeyValue(close.scaleYProperty(), 0.2)));
        timeline.play();
    }

    @FXML
    public void mouseExitedX(Event event) {
    }

    @FXML
    public void mouseEnteredMinimize(Event event) {
    }

    @FXML
    public void mouseExitedMinimize(Event event) {

    }
}
