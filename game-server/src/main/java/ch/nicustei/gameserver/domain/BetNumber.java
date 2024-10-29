package ch.nicustei.gameserver.domain;

import lombok.Getter;

@Getter
public class BetNumber {
    private int number;

    private BetNumber(int number) {
        checkAndSaveNumber(number);
    }

    public static BetNumber of(final int number) {
        return new BetNumber(number);
    }

    private void checkAndSaveNumber(int number) {
        if (isBetween(number, 0, 36)) {
            this.number = number;
        }
        else {
            throw new IllegalArgumentException("test");
        }
    }

    private boolean isBetween(int number, int min, int max) {
        return number >= min && number <= max;
    }

    public Colour mapToColour () {
        if (number == 0) {
            return Colour.GREEN;
        }
        if (number % 2 == 0) {
            return Colour.BLACK;
        }
        return Colour.RED;
    }
}
