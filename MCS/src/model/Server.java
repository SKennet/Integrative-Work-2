package model;
import model.*;

public class Server{
	
	private final static int MAXIMUM_USERS = 10, MAXIMUM_SONGS = 30, MAXIMUM_PLAYLISTS = 20;	
	
	User [] allUsers;
	Song [] allSongs;
	Playlist [] allPlaylists;
	
	public Server(){
		allUsers = new User [MAXIMUM_USERS];
		allSongs = new Song[MAXIMUM_SONGS];
		allPlaylists = new Playlist [MAXIMUM_PLAYLISTS];
	}
	
	//Add methods.
	
	public String addUser(String userName, String userPassword, int age){
		
		boolean space = false;
		String msg = "No se pudo agregar el usuario.";
		
		User newUser = new User(userName, userPassword, age);
		
		for(int i = 0; i<MAXIMUM_USERS && space != true; i++){
			if(allUsers[i] == null){				
				allUsers[i] = newUser;
				space = true;
				msg = "Usuario agregado correctamente.";				
			}
		}
		return msg;
	}
	
	public String addSong(String title, String artistName, String duration, int genreNum, String userName){
		
		boolean space = false, userFounded = false;
		String msg = "";
		int userNum = 0;
		
		
		//This checks if the user exist.
		for(int i = 0; i<MAXIMUM_USERS && userFounded != true; i++){
			if(allUsers[i] != null){
				if(allUsers[i].getNickName().equals(userName)){
					userFounded = true;
					userNum = i;
				
					msg = "Usuario encontrado.";
				}
			}			
		}
		
		Song newSong = new Song(title, artistName, duration, genreNum);
		
		for(int i = 0; i<MAXIMUM_SONGS && space != true; i++){
			if(allSongs[i] == null && userFounded == true){
				allSongs[i] = newSong;
				space = true;
				allUsers[userNum].increaseDonatedSongs();
				msg += "Canción agregada correctamente.";
			}
			else{
				msg = "No se pudo agregar la canción. Usuario no encontrado, o límite de canciones excedido.";
			}
		}
		return msg;
	}
	
	public String addPrivatePlaylist(){
		
		boolean space = false;
		String msg = "";
		PrivatePlaylist newPlaylist = new PrivatePlaylist();
		
		for(int i = 0; i<MAXIMUM_PLAYLISTS && space != true; i++){
			if(allPlaylists[i] == null){
				allPlaylists[i] = newPlaylist;
				space = true;
				msg = "Playlist agregada correctamente.";
			}
			else{
				msg = "No se pudo agregar la playlist.";
			}
		}
		return msg;
	}
	
	public String addPublicPlaylist(){
		
		boolean space = false;
		String msg = "";
		PublicPlaylist newPlaylist = new PublicPlaylist();
		
		for(int i = 0; i<MAXIMUM_PLAYLISTS && space != true; i++){
			if(allPlaylists[i] == null){
				allPlaylists[i] = newPlaylist;
				space = true;
				msg = "Playlist agregada correctamente.";
			}
			else{
				msg = "No se pudo agregar la playlist.";
			}
		}
		return msg;
	}
	
	public String addRestrictedPlaylist(){
		
		boolean space = false;
		String msg = "";
		RestrictedPlaylist newPlaylist = new RestrictedPlaylist();
		
		for(int i = 0; i<MAXIMUM_PLAYLISTS && space != true; i++){
			if(allPlaylists[i] == null){
				allPlaylists[i] = newPlaylist;
				space = true;
				msg = "Playlist agregada correctamente.";
			}
			else{
				msg = "No se pudo agregar la playlist.";
			}
		}
		return msg;
	}
	
	//Display methods.
	
	public String displayUsers(){
		String msg = "";
		boolean space = false;
		
		for(int i = 0; i<MAXIMUM_USERS && space != true; i++){
			if(allUsers[i] != null){
				msg += allUsers[i].displayUser() + "\n";
			}
			else{
				space = true;
			}
		}
		return msg;
	}
	
	public String displaySongs(){
		String msg = "";
		boolean space = false;
		
		for(int i = 0; i<MAXIMUM_SONGS && space != true; i++){
			if(allSongs[i] != null){
				msg += allSongs[i].displaySong() + "\n";
			}
			else{
				space = true;
			}
		}
		return msg;
	}
	
	public String displayPlaylists(){
		String msg = "";
		boolean space = false;
		
		for(int i = 0; i<MAXIMUM_PLAYLISTS && space != true; i++){
			if(allSongs[i] != null){
				msg += allPlaylists[i].displayPlaylist() + "\n";
			}
			else{
				space = true;
			}
		}
		return msg;
	}
}
