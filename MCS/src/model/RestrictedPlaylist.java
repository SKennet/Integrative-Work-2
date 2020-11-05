package model;
import model.*;
public class RestrictedPlaylist extends Playlist{
	int MAXIMUM_USERS = 5;
	
	public RestrictedPlaylist(){
		super();
	}
	
	
	@Override
	public void addSong(String songName, String artistName, int minutes, int seconds, Genre genre){
		String msg = super.addSong(songName, artistName, minutes, seconds, genre);
	}
}
