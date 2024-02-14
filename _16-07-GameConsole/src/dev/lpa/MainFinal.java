package dev.lpa;

import dev.lpa.game.Game;
import dev.lpa.game.GameAction;
import dev.lpa.game.GameConsole;
import dev.lpa.game.Player;
import dev.lpa.pirate.PirateGame;
import dev.lpa.pirate.Weapon;

//class SpecialGameAction extends Weapon {}
// Can't extend from record or enum

//class SpecialGameConsole<T extends Game<? extends Player>> extends GameConsole<Game<? extends Player>> {
//
//    public SpecialGameConsole(Game<? extends Player> game) {
//        super(game);
//    }
//}
// Can't extend final class

public class MainFinal {

    public static void main(String[] args) {

//        SpecialGameConsole<PirateGame> game = new SpecialGameConsole<>(new PirateGame("Pirate Game"));

        GameConsole<PirateGame> game = new GameConsole<>(new PirateGame("Pirate Game"));
    }
}
