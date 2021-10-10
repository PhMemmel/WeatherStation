package edv.memmel.weatherstation;

import edv.memmel.weatherstation.model.WeatherDataCollector;
import edv.memmel.weatherstation.view.ConsoleLogger;
import edv.memmel.weatherstation.view.JavaFxGuiStarter;

/** Main starter class. Needed for properly building fat jar with JavaFX libraries included. */
public class Main {

  /**
   * Start the weather station observer demonstration project.
   *
   * @param args none
   */
  public static void main(String[] args) {
    new Thread(() -> JavaFxGuiStarter.main(args)).start();
    // wait for JavaFX framework to be up, so Platform.runLater doesn't throw any exceptions
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    WeatherDataCollector weatherDataCollector = WeatherDataCollector.getInstance();
    new ConsoleLogger(weatherDataCollector);
    weatherDataCollector.start();
  }
}
