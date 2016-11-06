import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Driver extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Suggest Me Foosd!");

        Parent root = FXMLLoader.load(getClass().getResource("ui/Main Screen.fxml"));
        Scene scene = new Scene(root, Color.TRANSPARENT);

//        scene.setFill(null);
        stage.setScene(scene);
        stage.show();
    }
}
