package ch.nicustei.gameserver.service;

import ch.nicustei.gameserver.domain.GameBet;
import ch.nicustei.gameserver.domain.GameResult;
import org.springframework.stereotype.Service;

@Service
public class RouletteService extends GameServiceBase {

	@Override
	public GameResult startGame(GameBet bet) {
		return new GameResult(true, "test", calculatePriceMoneyByFactor(bet));
	}
}
