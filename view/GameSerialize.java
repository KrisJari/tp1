package es.ucm.tp1.supercars.view;

import java.util.Locale;

import es.ucm.tp1.supercars.logic.Game;

public class GameSerialize {

	private static final String SERIALIZE_MESSAGE = "----ROAD FIGHTER SERIALIZED----";
	private Game game;
	
	public GameSerialize(Game game)
	{
		this.game=game;
	}
	
	private String infoGameSerialize()
	{
		StringBuilder buffer= new StringBuilder();
		buffer.append("Level:"+game.LeveltoString());
		buffer.append("\nCycles:"+game.getCycle());
		buffer.append("\nCoins:"+game.getCycle());
		buffer.append("\nEllapsedTime"+elapsedtimeInString());
		
		return buffer.toString();
		
	}
	protected String elapsedtimeInString() {
	return String.format(Locale.US, "%d", (game.elapsedTime() / 1000));
	}
	@Override
	public String toString()
	{
		StringBuilder buffer=new StringBuilder();
		
		buffer.append(SERIALIZE_MESSAGE+"\n");
		buffer.append(infoGameSerialize()+"\n");
		buffer.append("Game Objects:\n");
		
		for(int j=0;j<game.getRoadLength();j++)
		{
			for(int i=0;i<game.getRoadWidth();i++)
			{
				buffer.append(game.tableserializeObjects(j, i));
			}
		}
		
		return buffer.toString();
	}
	
	
	
}
