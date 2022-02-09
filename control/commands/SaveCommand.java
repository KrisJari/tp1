package es.ucm.tp1.supercars.control.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.supercars.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseExeption;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.view.GameSerialize;

public class SaveCommand extends Command{
	
	private static final String NAME = "save ";

	private static final String DETAILS = "sa[v]e <filename>";

	private static final String SHORTCUT = "v";

	private static final String HELP = "save game";

	private static final String ERROR_PROMPT = "ERROR";

	private static final String ERROR_SAVING_MSG ="not save";

	private String file;

	

	public SaveCommand() {
		super(NAME,SHORTCUT,DETAILS,HELP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		file = file + ".txt";
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
			GameSerialize serializer = new GameSerialize(game);
			bufferedWriter.append(serializer.toString());
			System.out.println("Game successfully saved to file " + file);
		}
		catch (IOException e) {
			throw new CommandExecuteException(String.format("%s %s", ERROR_PROMPT, ERROR_SAVING_MSG));
		}

		return false;
	}
	
	
	@Override
	protected Command parse(String[] words) throws CommandParseExeption {
		if (matchCommandName(words[0])) {
			if (words.length != 2)
				throw new CommandParseExeption(
						String.format("%s Command %s: %s", ERROR_PROMPT, SHORTCUT, INCORRECT_NUMBER_OF_ARGS_MSG));
			else {
				file= words[1];
				return this;
			}
		}
		return null;
	}
}
