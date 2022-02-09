package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.gameobjects.GameObject;
import es.ucm.tp1.supercars.logic.GameObjectContainer;
public class WaveAction implements InstantAction {

	@Override
	public void execute(Game game) {
		
		boolean ok=false;
		GameObject obj=null;
		for(int i = game.getVisibility(); i >=0; i--) {
			for(int j = game.getRoadWidth()-1; j >=0; j--) {
              obj= game.inPosition(i,j);
              if(obj!=null) {
           
              obj.AumentarX();
			}
			}
		}
	}

}
