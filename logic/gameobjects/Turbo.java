package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Turbo extends GameObject {

	
	public static final String INFO = "[TURBO] pushes the car 3 columns" ;
	
	private String SYMBOL = ">>>";
	
	public Turbo(Game game, int x, int y) {
		super(game, x, y);
		symbol=SYMBOL;
		I=INFO;
		
	}

	public String getI() {
		return I;
	}

	public String toString() {
		return symbol;
	}
	
	@Override
	public boolean doCollision() {
	
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		
		for (int i = 0; i < 3; i++) {
			player.moveCarForward();
		}
		player.doCollision();
		return false;
		
	}

	@Override
	public boolean receiveShoot() {
	
		return false;
	}

	@Override
	public void onEnter() {
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean receiveExplosion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveThunder() {
		// TODO Auto-generated method stub
		return false;
	}
			

}
