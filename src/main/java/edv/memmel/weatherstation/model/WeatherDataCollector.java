package edv.memmel.weatherstation.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The WeatherDataCollector.
 *
 * <p>This class represents the model and subject in the observer pattern example.
 */
public class WeatherDataCollector {

  public static final String TEMPERATURE_KEY = "temperature";
  public static final String WIND_SPEED_KEY = "windspeed";

  private PropertyChangeSupport support;
  private double temperature;
  private int windSpeed;

  public WeatherDataCollector() {
    support = new PropertyChangeSupport(this);
  }

  public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
    support.addPropertyChangeListener(propertyChangeListener);
  }

  public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
    support.removePropertyChangeListener(propertyChangeListener);
  }

  /** Simulates receiving of new values. */
  public void start() {
    Thread temperatureGeneratorThread =
        new Thread(
            () -> {
              while (true) {
                temperature = ThreadLocalRandom.current().nextDouble(-30.0, 50.0);
                support.firePropertyChange(TEMPERATURE_KEY, null, temperature);
                try {
                  Thread.sleep(ThreadLocalRandom.current().nextInt(200, 1200));
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });
    Thread windSpeedGeneratorThread =
        new Thread(
            () -> {
              while (true) {
                windSpeed = ThreadLocalRandom.current().nextInt(0, 180);
                support.firePropertyChange(WIND_SPEED_KEY, null, windSpeed);
                try {
                  Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 4000));
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });

    temperatureGeneratorThread.start();
    windSpeedGeneratorThread.start();
  }

  public double getTemperature() {
    return temperature;
  }

  public int getWindSpeed() {
    return windSpeed;
  }
}
