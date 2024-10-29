package ch.nicustei.gameserver.controller;

import ch.nicustei.gameserver.domain.GameResult;
import ch.nicustei.gameserver.domain.Playground;
import ch.nicustei.gameserver.domain.RouletteBet;
import ch.nicustei.gameserver.domain.dto.PlaygroundDTO;
import ch.nicustei.gameserver.domain.dto.RouletteBetDTO;
import ch.nicustei.gameserver.domain.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static ch.nicustei.gameserver.domain.BetNumber.of;
import static java.util.Comparator.comparingInt;

@RestController
@RequestMapping("/games/roulette")
public final class GameController {

    private final GameService<RouletteBet> gameService;

    @Autowired
    public GameController(GameService<RouletteBet> gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/playground")
    @CrossOrigin
    public List<PlaygroundDTO> getPlayground() {
        Playground playground = Playground.aDefaultPlayground();
        return playground.getPlayGroundMap().entrySet().stream()
                .map(entry -> new PlaygroundDTO(entry.getKey().getNumber(), entry.getValue()))
                .sorted(comparingInt(PlaygroundDTO::getBetNumber))
                .collect(Collectors.toList());
    }

    @GetMapping("/start")
    @CrossOrigin
    public GameResult startGame(@RequestBody RouletteBetDTO rouletteBetDTO) {
        return gameService.startGame(new RouletteBet(
                rouletteBetDTO.getAmount(),
                rouletteBetDTO.getColour(),
                rouletteBetDTO.getNumber() == null ? null : of(rouletteBetDTO.getNumber()),
                rouletteBetDTO.getMultiplicationFactor()));
    }
}
