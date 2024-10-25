package ch.nicustei.gameserver.domain.service;

import ch.nicustei.gameserver.domain.GameBet;
import ch.nicustei.gameserver.domain.GameResult;

public interface GameService {

	GameResult startGame(GameBet bet);
}
