package model;
import model.*;

public class PublicPlaylist extends Playlist{
	
	int averageRate; 	    //This stores the average rating.
	int ratersUsers;		//This stores how many users has rated.
	
	public PublicPlaylist(){
		super();
		averageRate = 0;
		ratersUsers = 0;
	}
	
	public void addRate(int newRate){
		
		ratersUsers++; 			//This counts how many users has rated the playlist.
		
		averageRate = (averageRate/ratersUsers); //This calculates the average rate.
	
	}
	public int getRate(){
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
		msg += "La calificación promedio de la playlist es de: " + averageRate;
		return msg;
	}
}
