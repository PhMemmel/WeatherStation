package edv.memmel.weatherstation.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * The WeatherDataCollector.
 *
 * <p>This class represents the model and subject in the observer pattern example.
 */
public class WeatherDataCollector {

  public static final String TEMPERATURE_KEY = "temperature";
  public static final String WIND_SPEED_KEY = "windspeed";
  private static WeatherDataCollector instance;
  private PropertyChangeSupport support;
  private DoubleProperty temperatureProperty = new SimpleDoubleProperty(0.0);
  private IntegerProperty windSpeedProperty = new SimpleIntegerProperty(0);

  private WeatherDataCollector() {
    support = new PropertyChangeSupport(this);
  }

  /**
   * Returns the singleton instance of the WeatherDataCollector.
   *
   * @return instance of the WeatherDataCollector
   */
  public static synchronized WeatherDataCollector getInstance() {
    if (instance == null) {
      instance = new WeatherDataCollector();
    }
    return instance;
  }

  public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
    support.addPropertyChangeListener(propertyChangeListener);
  }

  public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
    support.removePropertyChangeListener(propertyChangeListener);
  }

  public DoubleProperty temperatureProperty() {
    return temperatureProperty;
  }

  public IntegerProperty windSpeedProperty() {
    return windSpeedProperty;
  }

  /**
   * Method to simulate the change of the data hold by this class.
   */
  public void randomizeData() {
    Platform.runLater(
        () -> {
          windSpeedProperty.set(ThreadLocalRandom.current().nextInt(0, 180));
          support.firePropertyChange(WIND_SPEED_KEY, null, windSpeedProperty.getValue());
          temperatureProperty.set(ThreadLocalRandom.current().nextDouble(-30.0, 50.0));
          support.firePropertyChange(TEMPERATURE_KEY, null, temperatureProperty.getValue());
        });
  }
}
