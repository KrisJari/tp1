package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class Player extends GameObject {


	private int cont_life;
	
	private int nCoin;

	public static final String PLAYER_SYMBOL = ">";
	private static final String DEAD_SYMBOL = "@";
	private int ciclo = 0;// contador de los movimientos del jugador
	private static final String INFO ="[Car] the racing car";
	private static Boolean exit;
	
	public Player (int x, int y,Game game) {
		super(game,x,y);
		nCoin=5;
		symbol = PLAYER_SYMBOL;
		 exit=false;
		 I=INFO;
	}
	
	public String getI()
	{
		return I;
	}
	
	public void decreaseCoin(int coin)
	{
		nCoin-=coin;
	}
	
	public boolean getExit()
	{
		return exit;
	}
	public void exit()
	{
		 exit = true;
	}
		
	//Collider del Player
	
	public boolean doCollision()
	{
		
		Collider other= game.getObjectInPosition(x, y);
		if(other!=null)
		{
			return other.receiveCollision(this);
		}
		
		return false;
	}
	
	
	public int increase_Cont_Coin()
	{
        return nCoin++;
	}
	public int win_Coin()
	{
        return nCoin+=5;
	}
	public int getCoin()
	{
		return nCoin;
	}
	
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void putX(int x) {
		this.x = x;
	}
	public void putY(int y) {
		this.y = y;
	}
	public void Up()
	{	
			x--;
	}

	public void Down()
	{	
			x++;
	}
	public void Forward()
	{	
			y++;
	}
	public String toString() {
	
		if (isAlive())
			return PLAYER_SYMBOL;
		return DEAD_SYMBOL;
	}
	
	public boolean hasArrived() {
		return (game.getRoadLength() - getX() + 1 == 0);
	}

	
	public boolean positionOfPlayer(int x, int y) {
		return this.x == x && this.y == y;
	}
	
	public int restar() {
		return this.cont_life--;
	}
	
	public void restarY() {
		this.y--;
	}
	public void decreaseCoins(int coins) {
		nCoin -= coins;
	}
	public String getMode() {
		String resultado = this.PLAYER_SYMBOL;
		return resultado;
	}

	public int contadorciclo() {
		return ciclo += 1;
	}

	public void moveCarUP() {
		x = (x -1);
	}

	public void moveCarDown() {
		x = (x + 1);
	}

	public void moveCarForward() {
		y = y + 1;
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
		// TODO Auto-generated method stub
		
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
