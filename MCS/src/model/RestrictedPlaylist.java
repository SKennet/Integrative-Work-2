package model;
import model.*;
public class RestrictedPlaylist extends Playlist{
	public static final int MAXIMUM_USERS = 5;
	User [] usersAllowed = new User[MAXIMUM_USERS];
	
	public RestrictedPlaylist(){
		super();
	}
	
	
	@Override
	public String addSong(Song songToAdd){
		String msg = super.addSong(songToAdd);
		return msg;
	}
	
	//This it's the constructor if the user wants to set the owners users.
	public RestrictedPlaylist(User ownerUser1, User ownerUser2, User ownerUser3, User ownerUser4, User ownerUser5){
		super();
		 
		usersAllowed[0] = ownerUser1;
		usersAllowed[1] = ownerUser2;
		usersAllowed[2] = ownerUser3;
		usersAllowed[3] = ownerUser4;
		usersAllowed[4] = ownerUser5;
	}
	
	@Override
	public String displayPlaylist(){
		boolean space = false;
		String msg = super.displayPlaylist();
		msg += "Los usuarios que pueden manipular la lista son: \n";
		for(int i = 0; i<MAXIMUM_USERS&& space != true; i++){
			if(usersAllowed[i] != null){
				msg += usersAllowed[i].getNickName() + ", ";
			}
			else{
				space = true;
			}
		}
		msg += "********************************************* \n";
		return msg;
	}
}
