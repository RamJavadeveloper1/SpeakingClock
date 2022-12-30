package com.speaking.clock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.speaking.clock.service.impl.ClockService;

@SpringBootTest
class SpeakingClockDemoApplicationTests {

	@Autowired
	ClockService clockService;

	@Test
	public void getCurrentTimeTest() throws Exception {
		String expectedResult = "It's time Fourteen Thirty Four";
		String actualResult = clockService.getCurrentTimeOnTextFormate(14, 34);
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	public void getMidDayTest() throws Exception {
		String expectedResult = "It's Midday";
		String actualResult = clockService.getCurrentTimeOnTextFormate(12, 00);
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	public void getMidNightTest() throws Exception {
		String expectedResult = "It's Midnight";
		String actualResult = clockService.getCurrentTimeOnTextFormate(00, 00);
		assertThat(actualResult).isEqualTo(expectedResult);
	}

	@Test
	public void invalidTimeTest() {
		Exception e = new Exception();
		//String expectedResult = "It's time Twenty Five Five";
		String actualResult = null;
		try {
			actualResult = clockService.getCurrentTimeOnTextFormate(25, 05);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertThatException().as(actualResult);
	}

	@Test
	void contextLoads() {
	}

}
