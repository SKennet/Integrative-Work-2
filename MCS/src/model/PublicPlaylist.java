package model;
import model.*;

public class PublicPlaylist extends Playlist{
	
	int averageRate = 0; 	    //This stores the average rating.
	int ratersUsers = 0;		//This stores how many users has rated.
	
	public PublicPlaylist(){
		super();
	}
	
	public void addRate(int newRate){
		ratersUsers++; 			//This counts how many users has rated the playlist.
		
		int averageRate = (averageRate/ratersUsers); //This calculates the average rate.
	
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
