package es.ucm.tp1.supercars.logic.actions;

import es.ucm.tp1.supercars.logic.Collider;
import es.ucm.tp1.supercars.logic.Game;

public class ThunderAction implements InstantAction{

	@Override
	public void execute(Game game) {
		// TODO Auto-generated method stub
		int x = game.getPlayerX() + game.getRandomColum();
		int y = game.getRandomLane();
		boolean hit=false;
		
		Collider other = game.getObjectInPosition(x, y);
		String s="";
		
		if (other != null) {
			s=other.toString();
			other.receiveThunder();
			hit=true;
		}
		
		String line = "Thunder hit position: (" + (x - game.getPlayerX()) + ", " + y + ")";
		
        if (hit) {
        	line += " -> " + s+ " hit";
        }
		
		System.out.println(line);
	}

}
