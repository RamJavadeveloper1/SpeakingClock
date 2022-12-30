package com.speaking.clock.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.speaking.clock.exception.InvalidTimeInputException;
import com.speaking.clock.service.impl.utill.DigitToTextMapUtill;

@Service
public class ClockService {
	Logger logger = LoggerFactory.getLogger(ClockService.class);

	public String getCurrentTimeOnTextFormate(int hour, int minutes) throws InvalidTimeInputException  {

		logger.info("ClockService::  called getCurrentTimeOnTextFormate");
		String time = "";
		if (validate(hour, minutes)) {

			if (hour == 0 && minutes == 0) {
				return time = "It's Midnight";
			} else if (hour == 12 && minutes == 0) {
				return time = "It's Midday";
			} else {
				String h = DigitToWordConverter(hour);
				String m = DigitToWordConverter(minutes);
				time = "It's time " + h + " " + m;
			}
		} else {
			logger.error("Time hour and minute is not correct "+ "hour : " + hour +" andutes : "+ minutes);
			throw new InvalidTimeInputException("Time hour and minute is not correct "+ "hour : " + hour +" and minutes : "+ minutes);
		}
		return time;

	}

	public String DigitToWordConverter(int time) {
		logger.info("ClockService::  called DigitToWordConverter by function call getCurrentTimeOnTextFormate");
		Map<Integer, String> tenthDigitMap = DigitToTextMapUtill.tenthOneDigiMap();
		Map<Integer, String> tenthTwoDigitNo = DigitToTextMapUtill.tenthTwoDigitNo();
		Integer partA = time / 10;
		Integer partB = time % 10;
		String result = "";
		// System.out.println(time + " : " + partA + " : " + partB);

		if (partA == 0) {
			result = tenthDigitMap.get(time);
			// System.out.println("One Digi time : " + result);
		} else {
			if (partB == 0) {
				if (tenthDigitMap.containsKey(time)) {
					result = tenthDigitMap.get(time);
					// System.out.println("Two digi : " + result);
				} else {
					if (partA == 1) {
						String twoDigitExactTime = tenthDigitMap.get(time);
						result = twoDigitExactTime;
						// System.out.println("Two digi : " + result);
					}

				}
			} else if (tenthDigitMap.containsKey(time)) {
				result = tenthDigitMap.get(time);
				// System.out.println("it's time " + result);
			} else {
				result = tenthTwoDigitNo.get(partA) + " " + tenthDigitMap.get(partB);
				// System.out.println("it's time " + result);
			}

		}

		return result;
	}

	public boolean validate(int hour, int minutes) {
		boolean result = false;
		if (hour >= 0 && hour < 24 && minutes >= 0 && minutes < 60) {
			result = true;
		}

		return result;

	}
}
