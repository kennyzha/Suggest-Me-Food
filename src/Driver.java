import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver extends Application{

    public static void main(String[] args){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //FCSJRRFIFSJDJNISJ
        Parent root = FXMLLoader.load(getClass().getResource("Main Screen.fxml"));
            //seocnonco
        Scene scene = new Scene(root);

        primaryStage.setTitle("Suggest Me Food!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
