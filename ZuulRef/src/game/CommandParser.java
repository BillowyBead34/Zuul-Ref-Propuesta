package game;

import game.commands.Command;
import game.commands.CommandFactory;
import game.commands.NullCommand;
import java.util.Scanner;

/**
 *
 * @author hikingcarrot7
 */
public class CommandParser {

    public Command getCommand() {
	String[] words = readWords();
	String commandWord = getCommandWord(words);
	String directionWord = getDirectionWord(words);
	return CommandFactory.createCommand(commandWord, directionWord);
    }

    private String getCommandWord(String[] words) {
	if (words.length > 0)
	    return words[0];

	return NullCommand.INVALID_COMMAND_WORD;
    }

    private String getDirectionWord(String[] words) {
	if (words.length > 1)
	    return words[1];

	return NullCommand.INVALID_DIRECTION_WORD;
    }

    private String[] readWords() {
	Scanner scanner = new Scanner(System.in);
	String phrase = scanner.nextLine();
	return phrase.split("\\s+");
    }

}
