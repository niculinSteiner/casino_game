package ch.nicustei.gameserver.service;

import ch.nicustei.gameserver.domain.GameBet;
import ch.nicustei.gameserver.domain.service.GameService;

import java.util.Optional;

import static java.util.Optional.of;

public abstract class GameServiceBase implements GameService {

	public static Optional<Double> calculatePriceMoneyByFactor(GameBet gameBet) {
			return of(gameBet.getAmount() * gameBet.getMultiplicationFactor());
	}
}
