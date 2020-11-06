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
	public String addSong(String songName, String artistName, String duration, int genre){
		String msg = super.addSong(songName, artistName, duration, genre);
		return msg;
	}
}
