package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.exceptions.CommandParseExeption;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.GameObjectGenerator;

public class CheatCommand extends Command {

	private static final String NAME = "cheatcommand";

	private static final String DETAILS = "Cheat [1..5]";

	private static final String SHORTCUT = "";
	
	private static final int MAX_ID = 5;
	
	private static final int MIN_ID = 1;
	
	private static final String HELP = " Removes all elements of last visible column, and adds an Advanced Object";
	private int id;

	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {

		GameObjectGenerator.forceAdvanceObject(game, id, game.lastColumn());
		return true;
	}

	@Override
	public Command parse(String[] words) throws CommandParseExeption {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				System.out.format("[ERROR]: Command %s: %s%n%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			} else {
				id = Integer.parseInt(words[0]);
				return this;
			}
		}
		return null;
	}

	@Override
	protected boolean matchCommandName(String name) {
		return (Integer.parseInt(name) >= MIN_ID && Integer.parseInt(name) <= MAX_ID);
	}
}
