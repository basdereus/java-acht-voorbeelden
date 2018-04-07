package nl.bdr.java.streams;

import java.util.stream.IntStream;

public class IntStreams {

	public static void printZeroToNine() {
		IntStream.range(0, 10).forEach(System.out::println);
	}
}
