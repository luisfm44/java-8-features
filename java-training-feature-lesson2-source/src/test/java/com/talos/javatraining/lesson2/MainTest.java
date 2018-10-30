package com.talos.javatraining.lesson2;

import com.talos.javatraining.lesson2.impl.ExactMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


@RunWith(MockitoJUnitRunner.class)
public class MainTest
{

	private static final Pattern PATTERN = Pattern
			.compile("^(Humidity|Wind speed|Pressure|Temperature) : (\\d+\\.\\d+) (%|mph|pa|°C)$", Pattern.MULTILINE);

	@Spy
	private Main main = new Main();

	@Before
	public void setup()
	{
		main.init();
	}


	@Test
	public void testMakeItReadableBeforeHalf()
	{
		BigDecimal number = new BigDecimal("12.34457");
		String actual = main.makeItReadable(number, "unit");

		assertEquals("12.34 unit", actual);
	}

	@Test
	public void testMakeItReadableAfterHalf()
	{
		BigDecimal number = new BigDecimal("12.34557");
		String actual = main.makeItReadable(number, "unit");

		assertEquals("12.35 unit", actual);
	}

	@Test
	public void testReadStation()
	{
		WeatherStation station = mock(WeatherStation.class);
		Measure<String> expected = mock(Measure.class);
		Measure<BigDecimal> measure = mock(Measure.class);
		doReturn(measure).when(station).read();
		doReturn(expected).when(main).makeItReadable(measure);

		Measure<String> actual = main.readStation(station);

		assertEquals(expected, actual);
	}

	@Test
	public void testMakeItReadableMeasure()
	{
		Measure<BigDecimal> measure = new ExactMeasure();
		measure.setStationId(23);
		measure.setWindSpeed(new BigDecimal("10.34666"));
		measure.setTemperature(new BigDecimal("23.55567"));
		measure.setPressure(new BigDecimal("101303.46012"));
		measure.setHumidity(new BigDecimal("30.45678"));

		Measure<String> result = main.makeItReadable(measure);

		assertNotNull(result);
		assertEquals(23, result.getStationId());
		assertEquals("10.35 mph", result.getWindSpeed());
		assertEquals("23.56 °C", result.getTemperature());
		assertEquals("101303.46 pa", result.getPressure());
		assertEquals("30.46 %", result.getHumidity());
	}

	@Test
	public void testReadStations() throws Exception
	{
		StringWriter writer = new StringWriter();

		main.readStations(writer);

		String result = writer.toString();
		System.out.println(result);
		Matcher matcher = PATTERN.matcher(result);
		int count = 0;
		while(matcher.find()){
			int groups = matcher.groupCount();
			assertEquals(3, groups);
			count ++;
		}
		assertEquals("Expected 40 results", 40, count);
	}
}
