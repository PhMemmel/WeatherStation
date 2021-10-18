package edv.memmel.weatherstation.view;

import edv.memmel.weatherstation.model.WeatherDataCollector;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/** FX controller class for main window. */
public class MainWindowFxController {

  @FXML Label temperatureLabel;
  @FXML Label windSpeedLabel;
  private WeatherDataCollector weatherDataCollector;

  public MainWindowFxController() {
    weatherDataCollector = WeatherDataCollector.getInstance();
  }

  @FXML
  void initialize() {
    // Binds the properties of the labels directly to the properties in the data model.
    // Of course, it would also be possible to implement the PropertyChangeListener interface
    // in this class and react to the property changes by setting the textProperties of the
    // labels in this class right here.
    temperatureLabel
        .textProperty()
        .bind(weatherDataCollector.temperatureProperty().asString("%.1f"));
    windSpeedLabel
        .textProperty()
        .bind(weatherDataCollector.windSpeedProperty().asString());
  }

  @FXML
  void loadData() {
    weatherDataCollector.randomizeData();
  }
}
