package game.commands;

import game.Game;

/**
 *
 * @author hikingcarrot7
 */
public class QuitCommand extends Command {

    public static final String COMMAND_WORD = "quit";

    public QuitCommand() {
	super(COMMAND_WORD, NullCommand.INVALID_DIRECTION_WORD);
    }

    @Override public void executeCommand(Game game) {
	game.quitGame(this);
    }

}
