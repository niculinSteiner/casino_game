package ch.nicustei.gameserver.domain;

import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static ch.nicustei.gameserver.domain.BetNumber.of;
import static ch.nicustei.gameserver.domain.Colour.*;

@Getter
public final class Playground {
    private final Map<BetNumber, Colour> playGroundMap;

    private Playground(Map<BetNumber, Colour> playGroundMap) {
        this.playGroundMap = Collections.unmodifiableMap(playGroundMap);
    }

    public static Playground aDefaultPlayground() {
        return new Playground(standardFields());
    }

    private static Map<BetNumber, Colour> standardFields() {
        Map<BetNumber, Colour> fields = new HashMap<>();
        fields.put(of(0), GREEN);
        for (int i = 1; i <= 36; i++) {
            if (i % 2 == 0) {
                fields.put(of(i), BLACK);
                continue;
            }
            fields.put(of(i), RED);
        }
        return fields;
    }
}
