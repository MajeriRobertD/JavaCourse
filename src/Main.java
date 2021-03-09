import controller.Controller;
import domain.Entity;
import exceptions.TeacherException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repository.Repository;
import ui.Ui;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, TeacherException {
        Ui ui = new Ui();
        ui.run();


    }
}


//public class Main extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        FXMLLoader loader = FXMLLoader.load(getClass().getResource("gui.fxml"));
//        guiController controller = new guiController();
//
//        loader.setController(controller);
//
//        Parent root = (Parent) loader.load();
//
//
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 1100, 500));
//        primaryStage.show();
//    };
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
//

