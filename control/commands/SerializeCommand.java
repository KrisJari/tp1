package es.ucm.tp1.supercars.control.commands;


import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GameSerialize;

public class SerializeCommand extends Command{

	private static final String NAME = "serialize";

	private static final String DETAILS = "seriali[z]e";

	private static final String SHORTCUT = "z";

	private static final String HELP = "Serializes the board";
	
	
	
	
	public SerializeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(new GameSerialize(game));
		return false;
	}

}
