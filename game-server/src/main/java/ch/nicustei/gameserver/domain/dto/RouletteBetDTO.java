package ch.nicustei.gameserver.domain.dto;

import ch.nicustei.gameserver.domain.Colour;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RouletteBetDTO {
    private final Double amount;

    @Nullable
    private final Colour colour;

    @Nullable
    private final Integer number;

    @Nullable
    private Double multiplicationFactor;
}
