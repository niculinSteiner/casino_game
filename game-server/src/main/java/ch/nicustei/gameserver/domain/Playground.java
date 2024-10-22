package ch.nicustei.gameserver.domain;

import lombok.Getter;

import java.util.Collections;
import java.util.Map;

import static ch.nicustei.gameserver.domain.Colour.RED;

@Getter
public final class Playground {
	private final Map<Colour, BetNumber> playGroundMap;

	private Playground(Map<Colour, BetNumber> playGroundMap) {
		this.playGroundMap = Collections.unmodifiableMap(playGroundMap);
	}

	public static Playground aDefaultPlayground() {
		return new Playground(Map.of(RED, new BetNumber(1)));
	}
}
