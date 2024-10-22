package ch.nicustei.gameserver.controller;

import ch.nicustei.gameserver.domain.Playground;
import ch.nicustei.gameserver.domain.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static ch.nicustei.gameserver.domain.Playground.*;

@Controller("/games/roulette")
public final class GameController {

	@GetMapping("play-ground")
	public Playground getPlayground() {
		return aDefaultPlayground();
	}

	@PostMapping("/roule")
	public Result startGame() {

	}
}
