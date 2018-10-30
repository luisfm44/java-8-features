package com.talos.javatraining.lesson2;

/**
 * Represents a weather status
 *
 * @param <T> the type
 */
public interface Measure<T>
{
	T getTemperature();

	void setTemperature(T temperature);

	T getWindSpeed();

	void setWindSpeed(T windSpeed);

	T getPressure();

	void setPressure(T pressure);

	T getHumidity();

	void setHumidity(T humidity);

	int getStationId();

	void setStationId(int id);
}
