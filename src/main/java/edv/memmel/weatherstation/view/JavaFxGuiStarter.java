package edv.memmel.weatherstation.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX Application starter class.
 */
public class JavaFxGuiStarter extends Application {


  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader fxmlLoader =
        new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
    Parent root = fxmlLoader.load();
    primaryStage.setTitle("Weather Display");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }
}
