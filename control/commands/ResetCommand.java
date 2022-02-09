package es.ucm.tp1.supercars.control.commands;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseExeption;
import es.ucm.tp1.supercars.exceptions.GameException;
public class ResetCommand extends Command {
	
		private static final String NAME = "reset";

		private static final String DETAILS = "[r]eset";

		private static final String SHORTCUT = "r";

		private static final String HELP = "reset game";

		public ResetCommand() {
			super(NAME, SHORTCUT, DETAILS, HELP);
		}

		@Override
		public boolean execute(Game game) throws CommandExecuteException {
		try 
			{
				
				Level level = game.getLevel();
				long seed=2;
				game.reset(seed,level);
				return true;
			
		} catch (GameException e) {
			
			e.printStackTrace();
		}
		return true;
		}

		@Override
		protected Command parse(String[] commandWords) throws CommandParseExeption{
			if ("".equalsIgnoreCase(commandWords[0])) {
				commandWords[0] = SHORTCUT;
			}
			return super.parse(commandWords);
		}
		
	}
