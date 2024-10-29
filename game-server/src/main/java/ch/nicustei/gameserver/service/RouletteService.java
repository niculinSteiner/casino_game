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
            return new GameResult(false, "Bet is Invalid", Optional.of(bet.getAmount()), randomNumber.colour, randomNumber.number.getNumber());
        }
        if (bet.getColour() == null) {
            boolean isWin = bet.getNumber().equals(randomNumber.number);
            return isWin ? getWin(bet.setMultiplicationFactor(36.00), randomNumber) : getLose(randomNumber);
        }
        if (bet.getNumber() == null) {
            boolean isWin = bet.getColour().equals(randomNumber.colour);
            return isWin ? getWin(bet, randomNumber) : getLose(randomNumber);
        }
        return new GameResult(false, "U lose.", Optional.empty(), randomNumber.colour, randomNumber.number.getNumber());
    }

    private static GameResult getWin(RouletteBet bet, ColourNumberPair randomNumber) {
        return new GameResult(true, "Congratulation u win.", calculatePriceMoneyByFactor(bet), randomNumber.colour, randomNumber.number.getNumber());
    }

    private static GameResult getLose(ColourNumberPair randomNumber) {
        return new GameResult(false, "U lose", Optional.empty(), randomNumber.colour, randomNumber.number.getNumber());
    }

    private static ColourNumberPair getRandomNumber() {
        int randomNumber = (int) (Math.random() * 37);
        BetNumber number = of(randomNumber);
        return new ColourNumberPair(number, number.mapToColour());
    }

    private record ColourNumberPair(BetNumber number, Colour colour) {
    }
}
