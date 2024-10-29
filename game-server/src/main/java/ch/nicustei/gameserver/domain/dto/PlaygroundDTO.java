package ch.nicustei.gameserver.domain.dto;

import ch.nicustei.gameserver.domain.Colour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlaygroundDTO {
    private int betNumber;
    private Colour colour;
}
