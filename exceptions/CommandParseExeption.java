package es.ucm.tp1.supercars.exceptions;

import java.io.PrintStream;

public class CommandParseExeption extends GameException {

	public CommandParseExeption(String message) {
      super(message);
	}

	public CommandParseExeption(PrintStream format) {
		super(format);
	}

}
