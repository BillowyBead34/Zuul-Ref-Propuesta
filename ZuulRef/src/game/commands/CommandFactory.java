package game.commands;

/**
 *
 * @author hikingcarrot7
 */
public class CommandFactory {

    public static Command createCommand(String commandWord, String directionWord) {
	switch (commandWord) {
	    case GoCommand.COMMAND_WORD:
		return new GoCommand(directionWord);
	    case HelpCommand.COMMAND_WORD:
		return new HelpCommand();
	    case QuitCommand.COMMAND_WORD:
		return new QuitCommand();
	    default:
		return new NullCommand();
	}
    }

}
