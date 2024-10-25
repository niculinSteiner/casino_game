package ch.nicustei.gameserver.domain;

import java.util.Optional;


public record GameResult(boolean isSuccess, String message, Optional<Double> moneyWon) {
}
