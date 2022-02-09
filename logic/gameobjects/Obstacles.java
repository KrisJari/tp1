package es.ucm.tp1.supercars.logic.gameobjects;


import es.ucm.tp1.supercars.logic.Game;

public class Obstacles extends GameObject{

    private static int contobst=0;
	private static final String SYMBOL = "░";
	public static final String INFO = "[Obstacle] hits car";
	
	public Obstacles(Game game,int x, int y) {
		super(game,x,y);
		symbol = SYMBOL;
		I=INFO;
		}
	
	//player collision with obstacles
		public boolean receiveCollision(Player player)
		{
		  
			player.alive=false;
			player.toString();
			alive=false;
			game.isFinished();
			return false;
			
		}
	
	//eliminacion
		@Override
		public void onDelete()
		{
			contobst--;
		}
		public String getI()
		{
			return I;
		}
		
		
	public void reset()
	{
		contobst=0;
	}
	
	public String toString() {
		if (isAlive())
			return symbol;
		return "";
	}
	
	public boolean positionOfObstacle(int x, int y) {
		return this.x==x && this.y==y;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean receiveShoot() {
		// TODO Auto-generated method stub
	    alive=false;
		return false;
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		contobst++;
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public static int getObstaclesCount() {
		// TODO Auto-generated method stub
		return contobst;
	}

	@Override
	public boolean receiveThunder() {
		return alive;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean receiveExplosion() {
		
		alive=false;
          return false;
	}


	

	
	

}