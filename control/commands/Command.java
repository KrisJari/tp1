package es.ucm.tp1.supercars.control.commands;

import java.io.IOException;

import es.ucm.tp1.supercars.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.exceptions.CommandParseExeption;
import es.ucm.tp1.supercars.logic.Game;

public abstract class Command {
	protected static final String UNKNOWN_COMMAND_MSG = "Unknown command";

	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = "Incorrect number of arguments";

	/* @formatter:off */
	protected static final Command[] AVAILABLE_COMMANDS = { 
			new HelpCommand(), 
			new InfoCommand(), 
			new UpdateCommand(),
			new MoveUpCommand(), 
			new MoveDownCommand(),
			new ResetCommand(), 
			new ExitCommand(), 
			new TestCommand(),
			new WaveCommand(),
			new ShootCommand(),
			new GrenadeCommand(),
			new SerializeCommand(),
			new SaveCommand(),
			new ShowRecordCommand(),
			new DumpCommand(),
			new CheatCommand()
			};
	/* @formatter:on */

	public static Command getCommand(String[] commandWords) throws CommandParseExeption {
		Command command = null;
		// TODO Add your code
		int i = 0;
		boolean ok = false;
		while (!ok && i < AVAILABLE_COMMANDS.length) {
			if (AVAILABLE_COMMANDS[i].parse(commandWords) == null) {
				i++;
			} else {
				return AVAILABLE_COMMANDS[i].parse(commandWords);

			}
		}
		throw new CommandParseExeption(System.out.format("[ERROR]:%s", UNKNOWN_COMMAND_MSG));
		
	}

	private final String name;

	private final String shortcut;

	private final String details;

	private final String help;
	
	
	//protected abstract Command parse(String[]commandWords) throws CommandParseExeption;
	

	public Command(String name, String shortcut, String details, String help) {
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
	}

	public abstract boolean execute(Game game) throws CommandExecuteException;

	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}

	protected Command parse(String[] words) throws CommandParseExeption {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				//System.out.format("[ERROR]: Command %s: %s%n%n", name, INCORRECT_NUMBER_OF_ARGS_MSG);
				throw new CommandParseExeption(String.format("[ERROR]:Command %s: %s", name,
						INCORRECT_NUMBER_OF_ARGS_MSG));
				
			} else {
				return this;
			}
		}
		return null;
	}

	public static String HelpInfo() {
		String help = "";
		for (int i=0;i< AVAILABLE_COMMANDS.length;i++) {
			help += AVAILABLE_COMMANDS[i].details + ":" + AVAILABLE_COMMANDS[i].help + "\n";

		}
		return help;
	}

}
