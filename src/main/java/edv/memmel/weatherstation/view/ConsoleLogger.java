package edv.memmel.weatherstation.view;

import edv.memmel.weatherstation.model.WeatherDataCollector;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * ConsoleLogger class: Observer of the WeatherDataCollector, dumping the changes to the console.
 */
public class ConsoleLogger implements PropertyChangeListener {

  private final WeatherDataCollector weatherDataCollector;

  public ConsoleLogger(WeatherDataCollector weatherDataCollector) {
    this.weatherDataCollector = weatherDataCollector;
    weatherDataCollector.addPropertyChangeListener(this);
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    if (evt.getPropertyName().equals(WeatherDataCollector.TEMPERATURE_KEY)) {
      double temperature = (double) evt.getNewValue();
      System.out.println("Neue Temperatur gemessen: " + String.format("%.1f", temperature));
    } else if (evt.getPropertyName().equals(WeatherDataCollector.WIND_SPEED_KEY)) {
      System.out.println("Neue Windgeschwindigkeit gemessen: " + evt.getNewValue());
    }
    /*
     * The more classic observer pattern way would be to not use the information in the sent event,
     * but use the getter method in WeatherDataCollector to read the needed values.
     * The event would only signal that there has been some change in this case.
     */
  }
}
