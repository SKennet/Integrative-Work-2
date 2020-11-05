package model;
import model.*;
public class RestrictedPlaylist extends Playlist{
	int MAXIMUM_USERS = 5;
	
	public RestrictedPlaylist(){
		super();
	}
	
	
	@Override
	public String addSong(String songName, String artistName, String duration, int genre){
		String msg = super.addSong(songName, artistName, duration, genre);
		return msg;
	}
}
