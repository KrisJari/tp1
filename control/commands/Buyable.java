package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.exceptions.NotEnoughCoinsException;
import es.ucm.tp1.supercars.logic.Game;

public interface Buyable {
  
	
	String FAILED_MSG = "Not money";

	public int cost();
	
	public default boolean buy(Game game) throws NotEnoughCoinsException
	{
		
//corregir esta parte solo se hace en Game y debe estar solo game.minusCoins
				if(game.playerCoins()-cost()>=0)
		
				{
			game.minusCoins(cost());
			return true;
		
				}else {
				
				throw new NotEnoughCoinsException(String.format("[ERROR]: %s",FAILED_MSG));
			}
		
	}
	
	
}
