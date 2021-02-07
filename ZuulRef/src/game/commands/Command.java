package game.commands;

import game.Game;

/**
 *
 * @author hikingcarrot7
 */
public abstract class Command {

    private final String commandWord;
    private final String directionWord;

    public Command(String commandWord, String directionWord) {
	this.commandWord = commandWord;
	this.directionWord = directionWord;
    }

    public abstract void executeCommand(Game game);

    public boolean isValidCommand(String aString) {
	return getCommandWord().equals(aString);
    }

    public boolean isUnknown() {
	return commandWord == null;
    }

    public boolean hasDirectionWord() {
	return directionWord != null;
    }

    public String getCommandWord() {
	return commandWord;
    }

    public String getDirectionWord() {
	return directionWord;
    }

}
