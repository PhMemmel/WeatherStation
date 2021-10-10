package edv.memmel.weatherstation;

import edv.memmel.weatherstation.model.WeatherDataCollector;
import edv.memmel.weatherstation.view.ConsoleLogger;

/**
 * Main starter class. Needed for properly building fat jar with JavaFX libraries included.
 */
public class Main {

  /**
   * Start the weather station observer demonstration project.
   *
   * @param args none
   */
  public static void main(String[] args) {
    //JavaFxGuiStarter.main(args);
    WeatherDataCollector weatherDataCollector = new WeatherDataCollector();
    new ConsoleLogger(weatherDataCollector);
    weatherDataCollector.start();
  }
}