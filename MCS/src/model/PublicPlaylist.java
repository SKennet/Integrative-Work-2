package model;
import model.*;

public class PublicPlaylist extends Playlist{
	
	double averageRate, totalRate; 	    //This stores the average rating.
	int ratersUsers;		//This stores how many users has rated.
	
	/**
	*This method creates a public playlist.<br>
	*<b>pre:</b> the package model must be imported in the class that it's going to create the playlist.<br>
	*<b>post:</b> the method will create a public playlist.<br>
	*@return void.<br>
	*/
	public PublicPlaylist(){
		super();
		averageRate = 0;
		ratersUsers = 0;
		totalRate = 0;
	}
	
	/**
	*This method adds a new rate to a total, so the program can calculates the average rate.<br>
	*<b>pre:</b> the playlist must be inicializated, and the param must be a double.<br>
	*<b>post:</b> <br>
	*@param averageRate, this double adds a new rate to the total rate.<br>
	*@return void.<br>
	*/
	@Override
	public void addRate(double newRate){
		
		ratersUsers++; 			//This counts how many users has rated the playlist.
		totalRate += newRate;
		averageRate = (totalRate/ratersUsers); //This calculates the average rate.
	
	}
	
	/**
	*This method will let other classes know the average rate of the playlist.<br>
	*<b>pre:</b> the playlist must be inicializated, and the "averageRate" too.<br>
	*<b>post:</b> the user will know the average rate of the playlist.<br>
	*@return double, this method returns a double with the average rate.<br>
	*/
	@Override
	public double getRate(){
		return averageRate;
	}
	
	/**
	*This method adds a song to the playlist.<br>
	*<b>pre:</b> the song and playlist must be inicializated before.<br>
	*<b>post:</b> the playlist will have another song.<br>
	*@param songToAdd, this song it's going to be added to the playlist.<br>
	*@return String, this method will let the user knows if the song was added or not.<br>
	*/
	@Override
	public String addSong(Song songToAdd){
		String msg = super.addSong(songToAdd);
		return msg;
	}
	
	/**
	*This method displays the information of the playlist.<br>
	*<b>pre:</b> the playlist must be inicializated before, and the averageRate too.<br>
	*<b>post:</b> the user will see the information of the playlist.<br>
	*@return String, this method returns a String with the information of the playlist.<br>
	*/
	@Override 
	public String displayPlaylist(){
		String msg = super.displayPlaylist();
		msg += "La calificación promedio de la playlist es de: " + averageRate;
		return msg;
	}
}
