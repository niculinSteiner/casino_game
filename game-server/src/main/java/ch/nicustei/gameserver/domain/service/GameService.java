package ch.nicustei.gameserver.domain.service;

import ch.nicustei.gameserver.domain.GameBet;
import ch.nicustei.gameserver.domain.GameResult;

public interface GameService<T extends GameBet> {

    GameResult startGame(T bet);
}
