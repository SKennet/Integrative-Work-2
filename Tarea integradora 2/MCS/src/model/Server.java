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
		String msg = "";
		
		User newUser = new User(userName, userPassword, age);
		
		for(int i = 0; i<MAXIMUM_USERS && space != true; i++){
			if(allUsers[i] == null){
				allUsers[i] = newUser;
				space = true;
				msg = "Usuario agregado correctamente.";
			}
			else{
				msg = "No se pudo agregar el usuario.";
			}
		}
		return msg;
	}
	
	public String addSong(String title, String artistName, String duration, int genreNum){
		
		boolean space = false;
		String msg = "";
		
		Song newSong = new Song(title, artistName, duration, genreNum);
		
		for(int i = 0; i<MAXIMUM_SONGS && space != true; i++){
			if(allSongs[i] == null){
				allSongs[i] = newSong;
				space = true;
				msg = "Canción agregada correctamente.";
			}
			else{
				msg = "No se pudo agregar la canción.";
			}
		}
		return msg;
	}
	
	public String addPrivatePlaylist(){
		
		boolean space = false;
		String msg = "";
		PrivatePlaylist newPlaylist = PrivatePlaylist();
		
		for(int i = 0; i<MAXIMUM_PLAYLISTS && space != true; i++){
			if(allPlaylists[i] == null){
				allPlaylists[i] = newPlaylist;
				space = true;
				msg = "Playlist agregada correctamente."
			}
			else{
				msg = "No se pudo agregar la playlist."
			}
		}
		return msg;
	}
	
	public String addPublicPlaylist(){
		
		boolean space = false;
		String msg = "";
		PublicPlaylist newPlaylist = PublicPlaylist();
		
		for(int i = 0; i<MAXIMUM_PLAYLISTS && space != true; i++){
			if(allPlaylists[i] == null){
				allPlaylists[i] = newPlaylist;
				space = true;
				msg = "Playlist agregada correctamente."
			}
			else{
				msg = "No se pudo agregar la playlist."
			}
		}
		return msg;
	}
	
	public String addRestrictedPlaylist(){
		
		boolean space = false;
		String msg = "";
		RestrictedPlaylist newPlaylist = RestrictedPlaylist();
		
		for(int i = 0; i<MAXIMUM_PLAYLISTS && space != true; i++){
			if(allPlaylists[i] == null){
				allPlaylists[i] = newPlaylist;
				space = true;
				msg = "Playlist agregada correctamente."
			}
			else{
				msg = "No se pudo agregar la playlist."
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
