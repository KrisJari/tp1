package es.ucm.tp1.supercars.logic;



import es.ucm.tp1.supercars.logic.gameobjects.GameObject;

import es.ucm.tp1.supercars.logic.gameobjects.Player;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.exceptions.CommandParseExeption;
import es.ucm.tp1.supercars.exceptions.InputOutputRecordException;
import es.ucm.tp1.supercars.logic.GameObjectContainer;
import es.ucm.tp1.supercars.logic.GameObjectGenerator;
import es.ucm.tp1.supercars.logic.actions.InstantAction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {


	private Level level;
	private Player player;

	private Random rand;
	private GameObjectContainer container;
	private Record record;
	private GameObject obj;
	
	//private static final String PROMPT = "Command > ";
	private int distance = 0;
	private double startTime;
	private boolean test;
	 private long seed ;
      private Record record1;
	public Game(long seed, Level level) {
		this.level = level;
		this.seed=seed;
		rand = new Random(seed);
		startTime = System.currentTimeMillis();
		container = new GameObjectContainer();
		iniObjects();
	}

	public void reset(long seed, Level level) throws CommandParseExeption {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		switch (s) {
		case "EASY":
			level = Level.EASY;
			break;
		case "HARD":
			level = Level.HARD;
			break;
		case "TEST":
			level = Level.TEST;
			break;
		case "ADVANCED":
			level=level.ADVANCED;
			break;
		default:
			throw new CommandParseExeption("[ERROR]: Unknown Command");
		}
 
		this.setLevel(level);
		try
		{
			seed = sc.nextInt();
		}catch(NumberFormatException e)
		{
			System.out.println("ERROR ");
		}
		
		iniObjects();
	}

	public boolean isCTM (int a ,int b)
	{
		return player.getX()<=a&& a < getVisibility() + getPlayerX() &&
				0 <= b&& b< getRoadWidth();
	}
	public GameObject isCTM2 (int a,int b)
	{
		return container.isInPosition(a, b);
	}

	public GameObject getObjectInPosition(int x, int y) {
		return container.isInPosition(y, x);
	}

	public int getRoadLength() {
		return level.getLength();
	}

	public int getRoadWidth() {
		return level.getRoadWidth();
	}

	// comando Shoot
	public void execute(InstantAction ia) {
		ia.execute(this);
	}

	public void iniObjects() {
		player = new Player(level.getRoadWidth() / 2, 0, this);
		tryToGenerate();

	}

	public long elapsedTime() {
		long elapsedTime = (long) (System.currentTimeMillis() - startTime);
		long elapsedSeconds = elapsedTime / 1000;
		long secondsDisplay = elapsedSeconds % 60;
		return secondsDisplay;
	}

	public int getRandomColum() {

		return (int) (getRandom() * getVisibility());
	}

	public long getRandom() {
		return rand.nextLong();
	}

	public String toString() {
		return"";
	}
	public String getPositionToString(int a, int b) {
		String s = "";
		int advanceY=player.getY()+b;
		if (player.isInPosition(a,advanceY))
			s += player.toString();
		else if(advanceY==getRoadLength())
		{
			s+="¦";
		}
		s += container.toString(a,advanceY);
		return s;
	}
	

	public void add_CoinShoot()
	{
		player.win_Coin();
	}
	
	public void setNewRecord(double newTime) throws InputOutputRecordException, FileNotFoundException, IOException {
		record1.setNewRecord(newTime);
	}

	public void showRecord1() {
		record1.showRecord();
	}

	public double getRecord1() {
		return record1.getRecord();
	}

	public boolean isNewRecord(double time) {
		return getRecord1() > time;
	}

	
	public int getRandomLane() {
		return (int) (getRandomNumber() * level.getRoadWidth());
	}

	private double getRandomNumber() {
		return rand.nextDouble();
	}


	
	public int getDistancetoGoal() {
		return level.getLength() - distance;
	}

	public void toggleTest() {
		test = true;
	}

	public void tryToGenerate() {
		GameObjectGenerator.generateGameObjects(this, level);
	}

	public void update() {
		
		player.moveCarForward();
		player.doCollision();
		container.recorrerUpdate();
		
		distance++;
	}

	public void movingUpPlayer() {
		if (player.getX() > 0) {
			player.moveCarUP();
			player.doCollision();
		}
	}

	public void movingDownPlayer() {
		if (player.getX() < level.getRoadWidth() - 1) {
			player.moveCarDown();
			player.doCollision();
		}
	}

	public boolean meta() {
		return getDistancetoGoal() == 0;
	}

	public int getVisibility() {
		
		return level.getVisibility();
	}

	public boolean isUserExit() {

		Boolean exit =true;
		return exit;
	}

	public boolean isTestMode() {
	
		return false;
	}

	public boolean hasArrived() {
		
		return false;
	}

	
	public String tableserializeObjects(int x,int y)
	{
		String s=new String();
		if(player.isInPosition(y, x))
			return player.serialize()+"\n";
		
		return container.serializeContainer(y, x);
		
	}
	
	
	public boolean isNewRecord() {
	
		return false;
	}

	public Level getLevel() {
		return this.level;
	}
	public String LeveltoString()
	{
		return level.toString();
	}

	public void setLevel(Level lvl) {
		this.level = lvl;
	}

	public int playerCoins() {
	//monedas que tiene el jugador
		return player.getCoin();
	}

	public int getCycle() {
		// TODO Auto-generated method stub
		return player.contadorciclo();
	}

	public long getRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getPlayerX()
	{
		return player.getX();
	}
	
	public void minusCoins(int coin)
	{
		player.decreaseCoin(coin);
	}
	
	public int getPlayerY() {
		return player.getY();
	}

	public GameObject inPosition(int x, int y) {
		return container.isInPosition(x, y);
	}

	public void tryAddObject(GameObject obj, double objectFrequency) {
		if (rand.nextDouble() < objectFrequency) {
			container.add(obj);
		}
	}
public boolean isFinished() {
	
		return meta()||player.getExit()||!player.isAlive();
	}

	public void eliminAte() {
		container.killAll();

	}

	public void forceAddObject(GameObject o) {
		// TODO Auto-generated method stub

		container.add(o);

	}
	public void wave_move()
	{
		container.mover(this);
	}

	public void eliminateCol() {
		int colUlt = getVisibility() + player.getY();
		for (int i = 0; i < getRoadWidth(); i++) {

			container.eliminar(i, colUlt);
		}

	}

	public int lastColumn() {
		int colUlt =getVisibility()-1;
		return colUlt;
	}

	public void exit() {
		// TODO Auto-generated method stub
		player.exit();
	}
	public boolean saLida()
	{
		return player.getExit();
		
	}
	
	
	public void showRecord() {
	
		
	}

	

}
