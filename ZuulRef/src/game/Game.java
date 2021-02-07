package game;

import game.commands.Command;
import game.exceptions.InvalidDirectionException;
import game.rooms.Room;
import game.rooms.RoomDirection;
import game.rooms.RoomExitsBuilder;

/**
 *
 * @author hikingcarrot7
 */
public class Game {

    private Room currentRoom;
    private CommandParser parser;
    private boolean gameOver;

    public Game() {
	parser = new CommandParser();
	setGameOver(false);
	createRooms();
    }

    private void createRooms() {
	Room outside, theatre, pub, lab, office;

	outside = new Room("outside the main entrance of the university");
	theatre = new Room("in a lecture theatre");
	pub = new Room("in the campus pub");
	lab = new Room("in a computing lab");
	office = new Room("in the computing admin office");

	outside.setExits(new RoomExitsBuilder()
		.setSouthRoom(lab)
		.setEastRoom(theatre)
		.setWestRoom(pub)
		.build());

	theatre.setExits(new RoomExitsBuilder()
		.setEastRoom(outside)
		.build());

	pub.setExits(new RoomExitsBuilder()
		.setEastRoom(outside)
		.build());

	lab.setExits(new RoomExitsBuilder()
		.setNorthRoom(outside)
		.setEastRoom(office)
		.build());

	office.setExits(new RoomExitsBuilder()
		.setWestRoom(lab)
		.build());

	setCurrentRoom(outside);
    }

    public void printWelcome() {
	System.out.println();
	System.out.println("Welcome to the World of Zuul!");
	System.out.println("World of Zuul is a new, incredibly boring adventure game.");
	System.out.println("Type 'help' if you need help.");
	System.out.println();

	getCurrentRoom().printExits();
    }

    public void printHelp() {
	System.out.println("You are lost. You are alone. You wander");
	System.out.println("around at the university.");
	System.out.println();
	System.out.println("Your command words are:");
	System.out.println("   go quit help");
    }

    public void play() {
	printWelcome();

	do {
	    Command command = parser.getCommand();
	    processCommand(command);
	} while (!isGameOver());

	System.out.println("Thank you for playing.  Good bye.");
    }

    private void processCommand(Command command) {
	if (command.isUnknown()) {
	    System.out.println("I don't know what you mean...");
	    return;
	}

	command.executeCommand(this);
    }

    public void goRoom(Command command) {
	try {
	    tryGoRoom(command);
	} catch (InvalidDirectionException e) {
	    System.out.println(e.getMessage());
	}
    }

    private void tryGoRoom(Command command) {
	if (!command.hasDirectionWord()) {
	    System.out.println("Go where?");
	    return;
	}

	String direction = command.getDirectionWord();

	Room nextRoom = getCurrentRoom().determineNextRoom(RoomDirection.getDirection(direction));
	setCurrentRoom(nextRoom);
	getCurrentRoom().printExits();
    }

    public void quitGame(Command command) {
	if (command.hasDirectionWord()) {
	    System.out.println("Quit what?");
	    return;
	}

	setGameOver(true);
    }

    public Room getCurrentRoom() {
	return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
	this.currentRoom = currentRoom;
    }

    public boolean isGameOver() {
	return gameOver;
    }

    public void setGameOver(boolean gameOver) {
	this.gameOver = gameOver;
    }

}
