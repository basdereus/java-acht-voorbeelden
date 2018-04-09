package nl.bdr.java.streams;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class IntStreamRangeTest {

	private static IntStream zeroToTenRange;
	
	@Before
	public void setup() {
		zeroToTenRange = IntStream.range(0, 3);
	}
	
	@Test
	public void testRange_count() {
		assertThat(zeroToTenRange.count(), equalTo(3L));
	}
	
	@Test
	public void testRange_sum() {
		assertThat(zeroToTenRange.sum(), equalTo(3));
	}

	@Test
	public void testRange_average() {
		OptionalDouble average = zeroToTenRange.average();
		
		assertThat(average.getAsDouble(), closeTo(1d, 0.001d));
	}

	@Test
	public void testRange_min() {
		OptionalInt min = zeroToTenRange.min();
		
		assertThat(min.getAsInt(), equalTo(0));
	}

	@Test
	public void testRange_max() {
		OptionalInt max = zeroToTenRange.max();
		
		assertThat(max.getAsInt(), equalTo(2));
	}

	@Test
	public void testRange_findFirst() {
		OptionalInt findFirst = zeroToTenRange.findFirst();
		
		assertThat(findFirst.getAsInt(), equalTo(0));
	}

	@Test
	public void testRange_findAny() {
		OptionalInt findAny = zeroToTenRange.findAny();
		
		assertThat(findAny.getAsInt(), equalTo(0));
	}

	@Test
	public void testRange_boxed_tolist() {
		Stream<Integer> integerStream = zeroToTenRange.boxed();
		
		List<Integer> integerList = integerStream.collect(Collectors.toList());
		
		assertThat(integerList.size(), equalTo(3));
		assertThat(integerList.get(2), equalTo(2));
	}

	@Test
	public void testRange_map_tolist() {
		Stream<Integer> integerStream = zeroToTenRange.mapToObj(i -> i);
		
		List<Integer> integerList = integerStream.collect(Collectors.toList());

		assertThat(integerList.size(), equalTo(3));
		assertThat(integerList.get(2), equalTo(2));
	}
	
	@Test
	public void testRange_reduce() {
		int sum = zeroToTenRange.reduce(0, (i1, i2) -> i1 + i2);
		
		assertThat(sum, equalTo(3));
	}
}
