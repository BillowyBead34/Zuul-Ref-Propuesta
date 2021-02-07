package game.exceptions;

/**
 *
 * @author hikingcarrot7
 */
public class InvalidDirectionException extends RuntimeException {

    public InvalidDirectionException(String word) {
	super("Invalid Direction: " + word);
    }

}
