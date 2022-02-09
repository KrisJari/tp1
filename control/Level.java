package es.ucm.tp1.supercars.control;



public enum Level {
	TEST(10, 3, 8, 0.5, 0,0), EASY(30, 3, 8, 0.5, 0.5,0), HARD(100, 5, 6, 0.7, 0.3,0),ADVANCED(100, 3, 8, 0.3, 0.3,0.1);

	private int length;

	private int width;

	private int visibility;

	private double coinFrequency;

	private double obstacleFrequency;
	
	private double advObjFrequency;

	private Level(int length, int width, int visibility, double obstacleFrequency, double coinFrequency,double advObjFrequency ) {
		this.length = length;
		this.width = width;
		this.visibility = visibility;
		this.obstacleFrequency = obstacleFrequency;
		this.coinFrequency = coinFrequency;
		this.advObjFrequency=advObjFrequency;
	}


	public static Level valueOfIgnoreCase(String inputString) {
		for (Level level : Level.values()) {
			if (level.name().equalsIgnoreCase(inputString)) {
				return level;
			}
		}
		return null;
	}

	public static String all(String separator) {
		StringBuilder buffer = new StringBuilder();
		int levelCount = 0;
		for (Level level : Level.values()) {
			if (levelCount > 0) {
				buffer.append(separator);
			}
			buffer.append(level.name());
			levelCount++;
		}
		return buffer.toString();
	}
	
	
	public int getRoadWidth() {
		return this.width;
	}
	
	public Double coinFrequency() {
		return this.coinFrequency;
	}
	
	public Double obstacleFrequency() {
		return this.obstacleFrequency;
	}
	
	public int getVisibility() {
		return this.visibility;
	}
	
	public int getLength() {
		return this.length;
	}
public static String levelcosos(String s)
{
	StringBuilder buffer =new StringBuilder();
	int cont=0;
	for(Level level:Level.values())
	{
		if(cont>0)
		{
			buffer.append(s);
		}
		buffer.append(level.name());
		cont++;
	}
	return buffer.toString();
}
	public boolean hasAdvancedObjects() {
	
		//devolvera true si la frecuencia avanzada es mayor que 0 
		if(advancedObjectFrequency()>0)
		{
			return true;
		}
		
		return false;
	}
	@Override
	public String toString()
	{
		return name().toUpperCase();
	}

   public double advancedObjectFrequency() {
	
		return this.advObjFrequency;
	}
}
