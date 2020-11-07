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
	public String addSong(Song songToAdd){
		String msg = super.addSong(songToAdd);
		return msg;
	}
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
