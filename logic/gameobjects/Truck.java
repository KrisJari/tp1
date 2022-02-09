package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;

public class Truck extends GameObject{

	public static final String INFO ="[TRUCK] moves towards the player";
    private static final String SYMBOL="←";
    
    
	public Truck(int x, int y, Game game) {
		super(game, y, x);
		// TODO Auto-generated constructor stub
		symbol=SYMBOL;
		I=INFO;
	}
public String toString()
{
	return symbol;
}
public String getI()
{
	return I;
}

public void truckMove()
{
	x=x-1;
	
}
@Override
public boolean doCollision() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean receiveCollision(Player player) {
	
	player.alive=false;
	player.toString();
	return false;
}
@Override
public boolean receiveShoot() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public void onEnter() {
	
	
}
@Override
public void update() {

	truckMove();
}
@Override
public void onDelete() {
	
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
