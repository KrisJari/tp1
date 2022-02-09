package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Wall extends Obstacles {

	private int resistencia=3;
	public static final String INFO = "[WALL] hard obstacle";
	private static final String SYMBOL="█";
	public Wall(int x, int y, Game game) {
		super(game, y, x);
		symbol=SYMBOL;
		I=INFO;
	}
	public String toString()
	{
	
		  if(resistencia==2)
			{symbol="▒";
				
			}
			else if(resistencia==1)
			{
				symbol="░";
			}
			else if(resistencia==0)
			{
				symbol="";
			}
		
		return symbol;
	}
	public String getI()
	{
		return I;
	}
	

	public boolean receiveCollision(Player player)
	{
	//hara lo mismo que un obstacle 
	     alive=false;
		player.toString();
		
		return false;
		
	}
	public boolean receiveShoot()
	{
		//aqui la bala choca contra el wall y se pierden los puntos de resistencia
		resistencia--;
		toString();
		game.add_CoinShoot();
		
		return false;
		
	}

}
