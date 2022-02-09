package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Coin extends GameObject{


	public static final String INFO = "[Coin] gives 1 coin to the player";
	private static int contcoin=0;
	private static final String SYMBOL="¢";
	
	public Coin(Game game,int f,int c) {
		super(game,f,c);
		symbol=SYMBOL;
		I=INFO;
	}
	
	public boolean isInThisPositionCoin(int f, int c) {
		return this.x==f && this.y == c;
	}
	public String getI()
	{
		return I;
	}
	
	//player collision with coin
	public boolean receiveCollision(Player player)
	{
		player.increase_Cont_Coin();
	    alive=false;
		return false;
		
	}
	public void reset()
	{
		contcoin=0;
	}
	
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}

	public void restarX() {
		this.x--;
	}
	
	@Override
	public boolean doCollision() {
	
		return false;
	}

	@Override
	public boolean receiveShoot() {
	
		return false;
	}

	@Override
	//el contador que lleva cuantas coin tiene Gameobject
	public void onEnter() {
		
		contcoin++;
		
	}

	@Override
	public void update() {
		
		
	}

	@Override
	public void onDelete() {
		contcoin--;
		
	}

	public static int getCoinsCount() {
	
		return contcoin;
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
