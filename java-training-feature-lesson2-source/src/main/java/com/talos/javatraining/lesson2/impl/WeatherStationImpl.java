package com.talos.javatraining.lesson2.impl;

import com.talos.javatraining.lesson2.Measure;
import com.talos.javatraining.lesson2.WeatherStation;

import java.math.BigDecimal;
import java.util.function.BiFunction;


/**
 * Mock Weather station.
 */
public class WeatherStationImpl implements WeatherStation
{

	private final int id;

	public WeatherStationImpl(int id)
	{
		this.id = id;
	}

	@Override
	public Measure<BigDecimal> read()
	{
		// TODO change this lambda expression to method reference
		return createMeasure((max, min) -> generateValue(max, min));
	}

	@Override
	public int getId()
	{
		return id;
	}

	/**
	 * Generates a values based on the provided limits
	 *
	 * @param maxNumber the max number
	 * @param minNumber the min number
	 * @return the number between the limits
	 */
	private BigDecimal generateValue(int maxNumber, int minNumber)
	{
		double value = (Math.random() * putZeros(maxNumber - minNumber)) + putZeros(minNumber);
		BigDecimal result = new BigDecimal(value);
		return result.movePointLeft(5);
	}

	private double putZeros(int number)
	{
		return 100000d * (double) number;
	}

	private Measure<BigDecimal> createMeasure(BiFunction<Integer, Integer, BigDecimal> generator)
	{
		Measure<BigDecimal> result = new ExactMeasure();
		result.setHumidity(generator.apply(100, 0));
		result.setPressure(generator.apply(101325, 101300));
		result.setTemperature(generator.apply(40, 0));
		result.setWindSpeed(generator.apply(130, 0));
		result.setStationId(getId());
		return result;
	}
}
