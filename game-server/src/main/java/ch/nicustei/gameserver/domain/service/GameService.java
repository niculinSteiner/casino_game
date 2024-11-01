package ch.nicustei.gameserver.domain.service;

import ch.nicustei.gameserver.domain.GameBet;
import ch.nicustei.gameserver.domain.GameResult;

/**
 * Interface to manage the game mechanism. Contains core functions of each game.
 *
 * @param <T> Bet type which should be used for each implementation.
 */
public interface GameService<T extends GameBet> {

    /**
     * Method to start the game.
     *
     * @param bet bet, which should be validated against the game result.
     * @return a game result, containing all required informations.
     */
    GameResult startGame(T bet);
}
