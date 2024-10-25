package ch.nicustei.gameserver.controller;

import ch.nicustei.gameserver.domain.GameResult;
import ch.nicustei.gameserver.domain.Playground;
import ch.nicustei.gameserver.domain.RouletteBet;
import ch.nicustei.gameserver.domain.dto.PlaygroundDTO;
import ch.nicustei.gameserver.domain.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

@RestController
@RequestMapping("/games/roulette")
public final class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
	    this.gameService = gameService;
    }

    @GetMapping("/playground")
    public List<PlaygroundDTO> getPlayground() {
        Playground playground = Playground.aDefaultPlayground();
        return playground.getPlayGroundMap().entrySet().stream()
                .map(entry -> new PlaygroundDTO(entry.getKey().getNumber(), entry.getValue()))
                .sorted(comparingInt(PlaygroundDTO::getBetNumber))
                .collect(Collectors.toList());
    }

    @GetMapping("/start")
    public GameResult startGame(@RequestBody  RouletteBet rouletteBet) {
        return gameService.startGame(rouletteBet);
    }


}
