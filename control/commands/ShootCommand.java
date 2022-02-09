package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.actions.ShootAction;

public class ShootCommand extends Command {

	private static final String NAME = "shoot";

	private static final String DETAILS = "[s]hoot: shoot bullet";

	private static final String SHORTCUT = "s";

	private static final String HELP = "shoot bullet";

	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.execute(new ShootAction());
		return true;
}
}