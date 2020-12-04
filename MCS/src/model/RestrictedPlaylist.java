package model;
import model.*;
public class RestrictedPlaylist extends Playlist{
	public static final int MAXIMUM_USERS = 5;
	User [] usersAllowed = new User[MAXIMUM_USERS];
	
	/**
	*This method creates a restricted playlist.<br>
	*<b>pre:</b> the package model must be imported in the class that it's going to create the playlist.<br>
	*<b>post:</b> the method will create a restricted playlist.<br>
	*@return void.<br>
	*/
	public RestrictedPlaylist(){
		super();
	}
	
	/**
	*This method displays the information of the playlist.<br>
	*<b>pre:</b> the playlist must be inicializated before, and the averageRate too.<br>
	*<b>post:</b> the user will see the information of the playlist.<br>
	*@return String, this method returns a String with the information of the playlist.<br>
	*/
	@Override
	public String addSong(Song songToAdd){
		String msg = super.addSong(songToAdd);
		return msg;
	}
	
	/**
	* This method adds a owner user to the playlist.<br>
	*<b>pre: </b> the user and the playlist must be inicializated before.<br>
	*<b>post: </b> the playlist will have another owner. <br>
	*@param ownerUser, this User object will be saved to check who can acces the playlist.<br>
	*@return String, this method returns a String to let the user know if the owner user was added or not.<br>
	*/
	@Override
	public String addOwnerUser(User ownerUser){
		
		String msg = "";
		boolean space = false;
		
		for(int i = 0; i<MAXIMUM_USERS && space != true ; i++){
			if(usersAllowed[i] == null){
				usersAllowed[i] = ownerUser;
				msg = "Usuario agregado correctamente.";
				space = true;
			}
			else{
				msg = "No se pudo agregar el usuario.";
			}
		}
		return msg;
	}
	
	
	
	/**
	*This it's the constructor if the user wants to set the owners users. For future versions.<br>
	*<b>pre: </b> the users and the playlist must be inicializated before.<br>
	*<b>post: </b> the playlist will have all the  owners users. <br>
	*@param ownerUser1, this User object will be saved to check who can acces the playlist.<br>
	*@param ownerUser2, this User object will be saved to check who can acces the playlist.<br>
	*@param ownerUser3, this User object will be saved to check who can acces the playlist.<br>
	*@param ownerUser4, this User object will be saved to check who can acces the playlist.<br>
	*@param ownerUser5, this User object will be saved to check who can acces the playlist.<br>
	*@return void. <br>
	*/
	public RestrictedPlaylist(User ownerUser1, User ownerUser2, User ownerUser3, User ownerUser4, User ownerUser5){
		super();
		 
		usersAllowed[0] = ownerUser1;
		usersAllowed[1] = ownerUser2;
		usersAllowed[2] = ownerUser3;
		usersAllowed[3] = ownerUser4;
		usersAllowed[4] = ownerUser5;
	}
	
	/**
	*This method displays the information of the playlist.<br>
	*<b>pre:</b> the playlist must be inicializated before, and the averageRate too.<br>
	*<b>post:</b> the user will see the information of the playlist.<br>
	*@return String, this method returns a String with the information of the playlist.<br>
	*/
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
		msg += "\n";
		msg += "********************************************* \n";
		return msg;
	}
}
