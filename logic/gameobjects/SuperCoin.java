package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class SuperCoin extends GameObject{
public static final String INFO = "[SUPERCOIN] gives 1000 coins";
private String SYMBOL="$";

private static final int value=1000;
private static boolean exists=false;

	public SuperCoin(Game game, int x, int y) {
		super(game, x, y);
		symbol=SYMBOL;
		exists=true;
		I=INFO;
		
	}
	public String getI()
	{
		return I;
	}
	

	@Override
	public boolean doCollision() {
		
		return false;
	}


	@Override
	public boolean receiveCollision(Player player) {
	
		return false;
	}


	@Override
	public boolean receiveShoot() {
	
		return false;
	}


	@Override
	public void onEnter() {
	exists=true;
		
	}


	@Override
	public void update() {
		
		
	}


	@Override
	public void onDelete() {
		
		exists=false;
		
	}


	public static boolean hasSuperCoin() {
		
		return exists;
	}



	@Override
	public boolean receiveExplosion() {
		
		return false;
	}


	@Override
	public boolean receiveThunder() {
	
		return false;
	}

}
