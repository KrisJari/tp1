package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Pedestrian extends GameObject {

	public static final String INFO = "[PEDESTRIAN] person crossing the road up and down";
	private static final String SYMBOL = "☺";
	private static int contpedestrian = 0;

	public Pedestrian(int x, int y, Game game) {
		super(game, y, x);
		// TODO Auto-generated constructor stub
		symbol = SYMBOL;
		I=INFO;
	}

	public String toString() {
		return symbol;

	}
	public String getI()
	{
		return I;
	}
	
	public boolean receiveShoot() {
		
         alive=false;
         
         
		return false;
	}

	@Override
	public void update() {
		
		// si el objeto se mueve se hace el update como playerq

		if (y > 0)
			pedestrianUP();
		
		else if (y < game.getRoadWidth() - 1) {
			pedestrianDown();
		}
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		contpedestrian++;

	}

	public void pedestrianUP() {
		y = (y - 1);
	}

	public void pedestrianDown() {
		y = (y + 1);
	}

	@Override
	public boolean doCollision() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveCollision(Player player) {
		// TODO Auto-generated method stub
		alive = false;
		return false;
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
       contpedestrian--;
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
