package com.speaking.clock.service.impl.utill;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

public class  DigitToTextMapUtill {

	public static  Map<Integer, String> tenthOneDigiMap() {
		Map<Integer, String> tenthDigitMap = new HashMap<Integer, String>();
		tenthDigitMap.put(0, "");
		tenthDigitMap.put(1, "One");
		tenthDigitMap.put(2, "Two");
		tenthDigitMap.put(3, "Three");
		tenthDigitMap.put(4, "Four");
		tenthDigitMap.put(5, "Five");
		tenthDigitMap.put(6, "Six");
		tenthDigitMap.put(7, "Seven");
		tenthDigitMap.put(8, "eight");
		tenthDigitMap.put(9, "Nine");

		tenthDigitMap.put(10, "Ten");
		tenthDigitMap.put(11, "eleven");
		tenthDigitMap.put(12, "Twelve");
		tenthDigitMap.put(13, "Thirdteen");
		tenthDigitMap.put(14, "Fourteen");
		tenthDigitMap.put(15, "Fifteen");
		tenthDigitMap.put(16, "Sixteen");
		tenthDigitMap.put(17, "Seventeen");
		tenthDigitMap.put(18, "eighteen");
		tenthDigitMap.put(19, "Ninteen");
		tenthDigitMap.put(20, "Twenty");
		tenthDigitMap.put(30, "Thirty");
		tenthDigitMap.put(40, "Fourty");
		tenthDigitMap.put(50, "Fifty");
		tenthDigitMap.put(60, "Sixty");
		return tenthDigitMap;

	}

	public static  Map<Integer, String> tenthTwoDigitNo() {
		 Map<Integer, String> tenthTwoDigitNo = new HashMap<Integer, String>();
		tenthTwoDigitNo.put(2, "Twenty");
		tenthTwoDigitNo.put(3, "Thirty");
		tenthTwoDigitNo.put(4, "Fourty");
		tenthTwoDigitNo.put(5, "Fifty");
		tenthTwoDigitNo.put(6, "Sixty");
		return tenthTwoDigitNo;
	}
}
