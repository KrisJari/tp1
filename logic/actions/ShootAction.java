package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class ShootAction implements InstantAction {

	@Override
	public void execute(Game game) {
		// TODO Auto-generated method stub
		int i =0;
		Boolean ok=false;
		while(i<game.getVisibility()&&!ok)
		{
			GameObject obj=game.inPosition(i,game.getPlayerX());
			
				if(obj!=null)
				{
					if(obj.receiveShoot())
					{	break;
					
					}
				}
			
			i++;
		}
	}

	
	
	

	
}
