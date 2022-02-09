package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public abstract class GameObject implements Collider {

	protected int x, y;

	protected Game game;

	protected String symbol;
	protected String I;
	protected Boolean alive;

	public GameObject(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
		alive=true;
	}

	protected String getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		if (isAlive()) {
			return getSymbol();
		}

		return "";
	}

	public boolean isInPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void AumentarX() {
		x += 1;
	}
	
	public boolean isAlive() {
		return alive;
	}
	public String getInfo()
	{
		return I;
		
	}
    public String serialize()
    {
    	return symbol + " " + "(" + x +", " + y + ")"+"\n";
    }
	public abstract void onEnter();

	public abstract void update();

	public abstract void onDelete();
     
	public void deleteObject()
	{
		alive=false;
	}

	// TODO add your code

}
