package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import es.ucm.tp1.supercars.SuperCars;
import es.ucm.tp1.supercars.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.logic.Game;

public class DumpCommand extends Command {
	private static final String ERROR_MSG = "An error ocurred on reading a file";

	private static final String NAME = "dump";

	private static final String DETAILS = "[d]ump <filename>";

	private static final String SHORTCUT = "d";

	private static final String HELP = "Shows the content of a saved file";

	private String file;
	public DumpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		
		
		file=file+".txt";
		StringBuilder buffer = new StringBuilder();
		buffer.append(SuperCars.WELCOME_MSG);

		//try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
		try
		{
			//BufferedWriter bufferedWriter= new BufferedWriter(file);
			String line = new String();
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			 
			 bufferedWriter.newLine();

			while (line != null) {
				buffer.append(line + "\n");
				bufferedWriter.newLine();
			}
			System.out.print(buffer.toString());
		}

	
		//}
		catch (IOException e) {
		
				
				throw new CommandExecuteException(ERROR_MSG);
				
		}
	
		return false;
	}
	
	
	//@Override
	/*protected Command parse(Writer words) throws CommandParseExeption {
		if (matchCommandName(words[0])) {
			if (words.length != 2)
				throw new CommandParseExeption(
						String.format("%s Command %s: %s", ERROR_MSG, SHORTCUT, INCORRECT_NUMBER_OF_ARGS_MSG));
			else {
				file = words[1];
				return this;
			}
		}
		return null;
	}*/


	
	
}
