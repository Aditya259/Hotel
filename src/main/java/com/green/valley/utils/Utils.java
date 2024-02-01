package com.green.valley.utils;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class Utils {

	public int fourDigitRandom() {
		Random random = new Random();
		int randomId = random.nextInt(9000) + 1000;
		return randomId;
	}

}
