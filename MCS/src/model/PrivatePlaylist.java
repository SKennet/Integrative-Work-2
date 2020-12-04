package model;
import model.*;

public class PrivatePlaylist extends Playlist{
	
	String ownerUser; //This two variables are for user verification.
	boolean canAcces = false;
	User userOwner;
	
	/**
	*This method creates a private playlist.<br>
	*<b>pre:</b> the package model must be imported in the class that it's going to create the playlist.<br>
	*<b>post:</b> the method will create a private playlist.<br>
	*@return void.<br>
	*/
	public PrivatePlaylist(){
		super();		
	}
	
	/**
	*This method creates a private playlist if the user has the owner user.<br>
	*<b>pre:</b> the package model must be imported in the class that it's going to create the playlist. And the user must be created before.<br>
	*<b>post:</b> the method will create a private playlist.<br>
	*@param ownerUser, this String saves the name of the owner user to check if he can acces the playlist. It's for future versions. <br>
	*@return void.<br>
	*/
	public PrivatePlaylist(String ownerUser){
		super();
		this.ownerUser = ownerUser; //This its for future versions.
	}
	
	/**
	*This method adds a song to the playlist.<br>
	*<b>pre:</b> the playlist and song must be initializated before.<br>
	*<b>post:</b> the playlist will have another song. And the user will know if the song was added or not.<br>
	*@param songToAdd, this song it's going to be added to the playlist if it's possible.<br>
	*@return String, the method will let the user if the song was added or not.<br>
	*/
	@Override
	public String addSong(Song songToAdd){
		String msg = super.addSong(songToAdd);
		return msg;
	}
	
	/**
	*This method adds an owner user to the playlist.<br>
	*<b>pre:</b> the user and the playlist must be initializated.<br>
	*<b>post:</b> the playlist will has an ownerUser, so only he will be able to add songs.<br>
	*@param newOwner, this User it's going to be the owner and the only one who can acces the playlistc.<br>
	*@return String, this method returns a message to let the user knows if the owner was added or not.<br>
	*/
	@Override
	public String addOwnerUser(User newOwner){
		String msg = "";
		if(userOwner == null){
			userOwner = newOwner;
			msg = "Usuario con acceso agregado correctamente.";
		}
		else{
			msg = "No se pudo agregar el usuario porque esta playlist ya tiene dueño.";
		}
		return msg;
	}
	
	/**
	*This method shows the information of the playlist.<br>
	*<b>pre:</b> the playlist must be initializated.<br>
	*<b>post:</b> the user will see all the information of the playlist.<br>
	*@return String, this method returns a String with the information of the playlist.<br>
	*/
	@Override
	public String displayPlaylist(){
		
		if(userOwner != null){
			ownerUser = userOwner.getNickName();
		}
		else{
			ownerUser= "Aún no hay un usuario dueño.";
		}
		String msg = super.displayPlaylist();
		msg += "El usuario dueño de la playlist es: " + ownerUser;
		return msg;		
	}
}
