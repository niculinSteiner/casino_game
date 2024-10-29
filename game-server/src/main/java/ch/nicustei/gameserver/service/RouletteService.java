package ch.nicustei.gameserver.service;

import ch.nicustei.gameserver.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ch.nicustei.gameserver.domain.BetNumber.of;

@Service
public class RouletteService extends GameServiceBase<RouletteBet> {

    @Override
    public GameResult startGame(RouletteBet bet) {
        return play(bet);
    }

    private GameResult play(RouletteBet bet) {
        ColourNumberPair randomNumber = getRandomNumber();
        if (bet.getColour() == null && bet.getNumber() == null) {
            return new GameResult(false, "Bet is Invalid", Optional.of(bet.getAmount()));
        }
        if (bet.getColour() == null) {
            boolean isWin = bet.getNumber().equals(randomNumber.number);
            return isWin ? getWin(bet.setMultiplicationFactor(36.00)) : getLose();
        }
        if (bet.getNumber() == null) {
            boolean isWin = bet.getColour().equals(randomNumber.colour);
            return isWin ? getWin(bet) : getLose();
        }
        return new GameResult(false, "U lose.", Optional.empty());
    }

    private static GameResult getWin(RouletteBet bet) {
        return new GameResult(true, "Congratulation u win.", calculatePriceMoneyByFactor(bet));
    }

    private static GameResult getLose() {
        return new GameResult(false, "U lose", Optional.empty());
    }

    private static ColourNumberPair getRandomNumber() {
        int randomNumber = (int) (Math.random() * 37);
        BetNumber number = of(randomNumber);
        return new ColourNumberPair(number, number.mapToColour());
    }

    private record ColourNumberPair(BetNumber number, Colour colour) {
    }
}
