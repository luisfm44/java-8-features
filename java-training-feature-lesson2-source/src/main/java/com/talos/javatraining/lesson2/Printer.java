package com.talos.javatraining.lesson2;

import java.io.IOException;
import java.io.Writer;


/**
 * Functional interface that prints a measure
 */
@FunctionalInterface
public interface Printer<T>
{
	/**
	 * prints the measure in the given writer
	 *
	 * @param measure the measure
	 * @param writer  the writer
	 * @throws IOException in case any problem writing into the writer
	 */
	void print(Measure<T> measure, Writer writer) throws IOException;
}
