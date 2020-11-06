package model;
import model.*;

public class PrivatePlaylist extends Playlist{
	
	String ownerUser; //This two variables are for user verification.
	boolean canAcces = false;
	User userOwner;
	
	public PrivatePlaylist(){
		super();		
	}
	
	//This it's the constructor if the user wants to set the owner user.
	public PrivatePlaylist(String ownerUser){
		super();
		this.ownerUser = ownerUser; //This its for future versions.
	}
	
	
	@Override
	public String addSong(String songName, String artistName, String duration, int genre){
		String msg = super.addSong(songName, artistName, duration, genre);
		return msg;
	}
	
	@Override
	public String displayPlaylist(){
		String msg = super.displayPlaylist();
		msg += "El usuario dueño de la playlist es: " + ownerUser;
		return msg;		
	}
}
