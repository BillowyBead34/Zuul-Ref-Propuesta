package game.commands;

import game.Game;

/**
 *
 * @author hikingcarrot7
 */
public class GoCommand extends Command {

    public static final String COMMAND_WORD = "go";

    public GoCommand(String secondWord) {
	super(COMMAND_WORD, secondWord);
    }

    @Override public void executeCommand(Game game) {
	game.goRoom(this);
    }

}
