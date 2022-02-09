package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.exceptions.InvalidPositionException;
import es.ucm.tp1.supercars.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.Grenade;

public class GrenadeCommand extends Command implements Buyable{

	private static final String NAME = "grenade";

	private static final String DETAILS = "[g]renade";

	private static final String SHORTCUT = "g";

	private static final String HELP = "explodes everything";
	
	private static final int PENALITATION=3;
	
	private int x;
	
	private int y;
	
	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public int cost() {
		return PENALITATION;
	}

	@Override
	public boolean execute(Game game) throws NotEnoughCoinsException, InvalidPositionException {
		if(buy(game)) {
			if(!game.isCTM(x,y)&&!(game.isCTM2(x,y)==null))
			{
				throw new InvalidPositionException("Invalid Position");
			}
			game.tryAddObject(new Grenade( game, x + game.getPlayerX() , y ), 1);
		}
			return true;
	
	}
	/* @Override
	    protected Command parse(String[] words) {
	        if (matchCommandName(words[0])) {
	        	
	        	if(words.length==3) {
	        		x=Integer.parseInt(words[1]);
	        	    y= Integer.parseInt(words[2]);
	        		return this;
	        	}
	        	else if (words.length != 3) {
	                System.out.format("[ERROR]: Command %s: %s%n%n", NAME, INCORRECT_NUMBER_OF_ARGS_MSG);
	                return null;
	            }
	        }
	        return null;
	 }*/
}
