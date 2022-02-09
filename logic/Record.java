package es.ucm.tp1.supercars.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.exceptions.InputOutputRecordException;

public class Record {

	private static final String Name_file="record.txt";
	private static final String error_message=String.format("Incorrect format", Name_file);
	
	
	Level level;
	double playertime;
	
	public Record(Level level)
	{
		this.level=level;
		
	}
	public String timetoString()
	{
		String s=String.valueOf(playertime);
		return s;
	}
	
	private void timerecord() throws InputOutputRecordException, IOException
	{
		boolean ok=false;
		String tokens[] = null;
		String s;
		
	//te creas un buffer que lee las lineas del txt 
			BufferedReader in =new BufferedReader(new FileReader(Name_file));
			s=in.readLine();
			//si lo lee
			int i=0;
		while(!ok&&s!=null&&i<tokens.length)
			{
				try
				{tokens=s.split(":");
					tokens[i]=level.name();
					tokens[i+1]=timetoString();
					ok=true;
					if(!ok)
				{
					s=in.readLine();
				}
				   i++;}catch(NumberFormatException n)
				{
					throw new InputOutputRecordException(error_message);
				}
				
			}
		
		if(!ok)
		{
			playertime=Long.MAX_VALUE;
		}
		
		
		
	}
	
	public void setNewRecord(double newRecord) throws InputOutputRecordException, FileNotFoundException, IOException
	{
		
		StringBuilder in=new StringBuilder();
		playertime=newRecord;
		
		in.append(String.format("%s:%.00f\n",level.name().toUpperCase(),playertime));
		try(BufferedReader buffer =new BufferedReader(new FileReader(Name_file)))
		{
			String s=new String();
			s=buffer.readLine();
			
			while(s!=null)
			{
				if (!level.name().equalsIgnoreCase(s.split(":")[0]))
				s = buffer.readLine();
			}
		}
		catch (IOException e) {
			throw new InputOutputRecordException(error_message);
		}

		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(Name_file))) {
			buffer.append(buffer.toString());
		}
		catch (IOException e) {
			throw new InputOutputRecordException(error_message);
		}
	}
		public void showRecord()
		{
			System.out.format(Locale.FRANCE, "%s record is %.02fd s\n",level.toString(),playertime/1000);
		}

	public double getRecord()
	{
		return playertime;
		
	}
	
	
}
	
	/*
	 * HARD:22340
	 * EASY:17890
	 * ADVANCED:1030
	 * */

