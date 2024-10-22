package ch.nicustei.gameserver.domain;

import lombok.Getter;

@Getter
public class BetNumber {
	private int number;

	public BetNumber(int number) {
		checkAndSaveNumber(number);
	}

	private void checkAndSaveNumber(int number) {
		if (isBetween(number, 0, 36)){
			this.number = number;
		}
		throw new IllegalArgumentException("test");
	}

	private boolean isBetween(int number, int min, int max) {
		return number >= min && number <= max;
	}
}
