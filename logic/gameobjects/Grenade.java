package es.ucm.tp1.supercars.logic.gameobjects;

import es.ucm.tp1.supercars.logic.Game;
import es.ucm.tp1.supercars.logic.actions.ExplosionAction;

public class Grenade extends GameObject {
public static final String INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around";
private int countExplosion = 3;
private static final String SYMBOL="ð";
	public Grenade(Game game, int x, int y) {
		super(game, x, y);
		symbol=SYMBOL;
		I=INFO;
	}
	public String getI()
	{
		return I;
	}
	

    @Override
    public String toString() {

        if (countExplosion == 0) {
            return "";
        }

        return SYMBOL + "[" + countExplosion + "]";
    }
	@Override
	public boolean doCollision() {
		
		return false;
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
	
	}

	@Override
	public void update() {
		  countExplosion--;

	        if (countExplosion <= 0) {
	            game.execute(new ExplosionAction(x,y));
	            alive=false;
	        }
		
	}

	@Override
	public void onDelete() {
		
		
	}
	



	@Override
	public boolean receiveThunder() {
		return alive;
	
		
	}


	@Override
	public boolean receiveExplosion() {
	
		return false;
	}
	

}
