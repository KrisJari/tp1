package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class WaveCommand extends Command {
	private static final String NAME = "wave";

	private static final String DETAILS = "[w]wave";

	private static final String SHORTCUT = "w";

	private static final String HELP = "do wave ";

	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		
	}

}
