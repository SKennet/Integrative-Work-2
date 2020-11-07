package model;
import model.*;

public class PublicPlaylist extends Playlist{
	
	double averageRate, totalRate; 	    //This stores the average rating.
	int ratersUsers;		//This stores how many users has rated.
	
	public PublicPlaylist(){
		super();
		averageRate = 0;
		ratersUsers = 0;
		totalRate = 0;
	}
	
	@Override
	public void addRate(double newRate){
		
		ratersUsers++; 			//This counts how many users has rated the playlist.
		totalRate += newRate;
		averageRate = (totalRate/ratersUsers); //This calculates the average rate.
	
	}
	@Override
	public double getRate(){
		return averageRate;
	}
	
	@Override
	public String addSong(Song songToAdd){
		String msg = super.addSong(songToAdd);
		return msg;
	}
	
	@Override 
	public String displayPlaylist(){
		String msg = super.displayPlaylist();
		msg += "La calificaci�n promedio de la playlist es de: " + averageRate;
		return msg;
	}
}
