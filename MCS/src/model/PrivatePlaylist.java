package model;
import model.*;

public class PrivatePlaylist extends Playlist{
	
	String ownerUser; //This two variables are for user verification.
	boolean canAcces = false;
	
	public PrivatePlaylist(){
		super();
		
		this.ownerUser = ownerUser; //This its for future versions.
	}
	
	
	@Override
	public String addSong(String songName, String artistName, String duration, int genre){
		String msg = super.addSong(songName, artistName, duration, genre);
		return msg;
	}
}
