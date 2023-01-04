package com.speaking.clock.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.speaking.clock.exception.InvalidTimeInputException;
import com.speaking.clock.service.impl.ClockService;

@RestController
@RequestMapping("/api/v1/clock")
public class ClockController {

	@Autowired
	ClockService service;

	Logger logger = LoggerFactory.getLogger(ClockController.class);

	@GetMapping("/currentTime")
	private String getTimetOnTextFormate() throws InvalidTimeInputException {
		logger.info("ClockController :: called getTimeOnTextFormate function");
		Date date = new Date();
		return service.getCurrentTimeOnTextFormate(date.getHours(), date.getMinutes());
	}

	// Rest Api
	// http://localhost:8083/api/v1/clock/currentTime/byInput?hour=12&minutes=34
	@GetMapping("/currentTime/byInput")
	private String getTimetOnTextFormateByInputValue(@RequestParam Integer hour, @RequestParam Integer minutes)
			throws InvalidTimeInputException {
		logger.info(
				"ClockController :: called getTimetOnTextFormateByInputValue hour: " + hour + " minutes : " + minutes);
		return service.getCurrentTimeOnTextFormate(hour, minutes);
	}

	// Rest api
	// http://localhost:8083/api/v1/clock/currentTime/byTimeformateInput?time=01:05
	@GetMapping("/currentTime/byTimeformateInput")
	private String getTimetOnTextFormateByTimeformateInput(@RequestParam String time) throws InvalidTimeInputException {
		if (time == null) {
			throw new InvalidTimeInputException("Please check the time input");
		}
		String[] hm = time.split(":");
		if (hm.length > 2) {
			throw new InvalidTimeInputException("Please check the time input formate");
		}

		int hour = Integer.parseInt(hm[0]);
		int minutes = Integer.parseInt(hm[1]);
		logger.info("ClockController :: called getTimetOnTextFormateByTimeformateInput hour: " + hour + " minutes : "
				+ minutes);
		return service.getCurrentTimeOnTextFormate(hour, minutes);

	}
}
