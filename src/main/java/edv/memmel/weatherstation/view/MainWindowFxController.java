package edv.memmel.weatherstation.view;

import edv.memmel.weatherstation.model.WeatherDataCollector;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/** FX controller class for main window. */
public class MainWindowFxController {

  @FXML Label temperatureLabel;

  @FXML Label windSpeedLabel;

  @FXML
  void initialize() {
    temperatureLabel
        .textProperty()
        .bind(WeatherDataCollector.getInstance().temperatureProperty().asString("%,1f"));
    windSpeedLabel
        .textProperty()
        .bind(WeatherDataCollector.getInstance().windSpeedProperty().asString());
  }
}
