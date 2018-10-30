package com.talos.javatraining.lesson2;

import java.math.BigDecimal;


/**
 * Represents a Weather station.
 */
public interface WeatherStation
{

	/**
	 * Reads a value from the station
	 *
	 * @return the measure
	 */
	Measure<BigDecimal> read();

	/**
	 * The station id
	 *
	 * @return the id
	 */
	int getId();
}
