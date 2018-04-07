package nl.bdr.java.streams;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.stream.IntStream;

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

}
