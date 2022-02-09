package es.ucm.tp1.supercars.logic;

import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

public class GameObjectContainer {
	private List<GameObject> gameobjects;
	private GameObject object;
    private Game game;
	public GameObjectContainer() {
		gameobjects = new ArrayList<>();
	}

	public GameObject isInPosition(int x, int y) {
		// TODO Auto-generated method stub
		for (GameObject obj : gameobjects) {
			if (obj.isInPosition(x, y)) {
				return obj;
			}
		}

		return null;
	}
	
	public String toString(int x, int y) {
		String s = "";
		for (GameObject obj : gameobjects) {
			if (obj.isInPosition(y, x)) {
				s += obj.toString();
			}
		}
		return s;
	}

	public String serializeContainer(int x, int y) {
	   String s = "";
		for (GameObject obj : gameobjects) {
			if (obj.isInPosition(y, x)) {
				 s+=obj.serialize();
			}
		}
		return s;
	}

	// encontrar la pos en el array
	private int posArray(int x, int y) {
		int pos = 0;
		boolean ok = false;
		while ((pos < gameobjects.size()) && (!ok)) {
			if ((gameobjects.get(pos).getX() == x) && (gameobjects.get(y).getY() == y)) {
				ok = true;
			} else {
				pos++;
			}
		}
		return pos;
	}
//eliminar un objeto

	public void eliminar(int x, int y) {
		gameobjects.remove(posArray(x, y));
	}

	// clearcommand eliminar todos
	public void killAll() {
		/*
		 * for(int i=0;i<gameobjects.size();i++) { object.onDelete(); }
		 */
		gameobjects.clear();
		object.onDelete();
	}

	public void add(GameObject obj) {
		// TODO Auto-generated method stub
		gameobjects.add(obj);
		obj.onEnter();
	}
      
	
	public void mover(Game game) {
		for(int i = game.getVisibility(); i >=0; i--) {
			for(int j = game.getRoadWidth()-1; j >=0; j--) {
              GameObject obj =  isInPosition(i,j);
              if(obj!=null) {
           
              obj.AumentarX();
			}
			}
		}
	}
	
	public void recorrerUpdate()
	{
		for(GameObject obj : gameobjects )
		{
			obj.update();
		}
	
	}
	
	
}