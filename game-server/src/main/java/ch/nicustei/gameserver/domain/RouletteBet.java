package ch.nicustei.gameserver.domain;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RouletteBet implements GameBet {

    private static final Double DEFAULT_ROULETTE_MULTIPLICATION_FACTOR = 2.0;

    private final Double amount;

    @Nullable
    private final Colour colour;

    @Nullable
    private final BetNumber number;

    @Nullable
    private Double multiplicationFactor;

    @Override
    public Double getMultiplicationFactor() {
        return multiplicationFactor == null ? DEFAULT_ROULETTE_MULTIPLICATION_FACTOR : multiplicationFactor;
    }

    public RouletteBet setMultiplicationFactor(Double multiplicationFactor) {
        this.multiplicationFactor = multiplicationFactor;
        return this;
    }
}
