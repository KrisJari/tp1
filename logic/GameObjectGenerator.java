package es.ucm.tp1.supercars.logic;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.logic.actions.ThunderAction;
import es.ucm.tp1.supercars.logic.gameobjects.Coin;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.gameobjects.Obstacles;
import es.ucm.tp1.supercars.logic.gameobjects.Pedestrian;
import es.ucm.tp1.supercars.logic.gameobjects.SuperCoin;
import es.ucm.tp1.supercars.logic.gameobjects.Truck;
import es.ucm.tp1.supercars.logic.gameobjects.Turbo;
import es.ucm.tp1.supercars.logic.gameobjects.Wall;

// TODO add your imports

public class GameObjectGenerator {
	
     private static Obstacles obst;
     private static Coin coin;
	public static void generateGameObjects(Game game, Level level) {

		for (int x = game.getVisibility() / 2; x < game.getRoadLength(); x++) {
			
			
			game.tryAddObject(new Obstacles(game, x, game.getRandomLane()), level.obstacleFrequency());
			game.tryAddObject(new Coin(game, x, game.getRandomLane()), level.coinFrequency());
			
			
			if(level.hasAdvancedObjects())
			{
				
				game.tryAddObject(new Wall(game.getRandomLane(),x,game),level.advancedObjectFrequency());
				game.tryAddObject(new Turbo(game,x,game.getRandomLane()),level.advancedObjectFrequency());
				
				if(!SuperCoin.hasSuperCoin())
				{
					game.tryAddObject(new SuperCoin(game,x,game.getRandomLane()), level.advancedObjectFrequency());
				}
				
				game.tryAddObject(new Truck(game.getRandomLane(), x, game), level.obstacleFrequency());
				game.tryAddObject(new Pedestrian(0, x, game), level.coinFrequency());
					
				
			}
			
			
			
		}
	}

	public static void reset(Level level) { 
		
		/*reiniciar los obstacles y los coin se les pasa el level para que no tengas que repretir cosas
		  */
		coin.reset();
		obst.reset();
	
	}

	public static void generateRuntimeObjects(Game game) {
		// TODO add your code
		
		if(game.getLevel().hasAdvancedObjects())
		{
			game.execute(new ThunderAction());
		}
		
		
	}
	
	public static void forceAdvanceObject(Game game,int id,int x)
	{
		GameObject o =null;
		
		switch(id)
		{
		case 1:
			o=new Wall(game.getRandomLane(),x,game);
			break;
		case 2:
			o=new Turbo(game,x,game.getRandomLane());
			break;
		case 3:
			o=new SuperCoin(game,x,game.getRandomLane());
			break;
		case 4:
			o=new Truck(game.getRandomLane(),x,game);
			break;
		case 5:
			o=new Pedestrian(0,x,game);
			break;


		}
		
	game.forceAddObject(o);
	}
}
