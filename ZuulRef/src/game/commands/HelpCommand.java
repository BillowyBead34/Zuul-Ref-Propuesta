package game.commands;

import game.Game;

/**
 *
 * @author hikingcarrot7
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public HelpCommand() {
	super(COMMAND_WORD, NullCommand.INVALID_DIRECTION_WORD);
    }

    @Override public void executeCommand(Game game) {
	game.printHelp();
    }

}
