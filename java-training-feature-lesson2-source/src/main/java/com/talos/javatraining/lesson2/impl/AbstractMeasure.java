package com.talos.javatraining.lesson2.impl;

import com.talos.javatraining.lesson2.Measure;


/**
 * Generic class that contains attributes to store the measures.
 *
 * @param <T> the type
 */
public abstract class AbstractMeasure<T> implements Measure<T>
{
	private int stationId;
	private T temperature;
	private T windSpeed;
	private T pressure;
	private T humidity;

	@Override
	public T getTemperature()
	{
		return temperature;
	}

	@Override
	public void setTemperature(T temperature)
	{
		this.temperature = temperature;
	}

	@Override
	public T getWindSpeed()
	{
		return windSpeed;
	}

	@Override
	public void setWindSpeed(T windSpeed)
	{
		this.windSpeed = windSpeed;
	}

	@Override
	public T getPressure()
	{
		return pressure;
	}

	@Override
	public void setPressure(T pressure)
	{
		this.pressure = pressure;
	}

	@Override
	public T getHumidity()
	{
		return humidity;
	}

	@Override
	public void setHumidity(T humidity)
	{
		this.humidity = humidity;
	}

	@Override
	public int getStationId()
	{
		return stationId;
	}

	@Override
	public void setStationId(int stationId)
	{
		this.stationId = stationId;
	}
}
