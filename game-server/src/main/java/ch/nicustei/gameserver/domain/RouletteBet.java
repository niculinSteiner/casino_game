package ch.nicustei.gameserver.domain;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RouletteBet implements GameBet{

	private static final Double DEFAULT_ROULETTE_MULTIPLICATION_FACTOR = 1.0;

	private final Double amount;
	private final Colour colour;
	private final BetNumber number;
	@Nullable
	private final Double multiplicationFactor;

	@Override
	public Double getMultiplicationFactor() {
		return multiplicationFactor == null ? DEFAULT_ROULETTE_MULTIPLICATION_FACTOR : multiplicationFactor;
	}
}
