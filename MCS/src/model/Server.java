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
				if(allUsers[i].getNickName().equalsIgnoreCase(userName)){
					userFounded = true;
					userNum = i;
				
					msg = "Usuario encontrado.";
				}
				else{
					msg = "No se pudo agregar la canción. Usuario no encontrado.";
				}
			}			
		}
		
		Song newSong = new Song(title, artistName, duration, genreNum);
		
		//This if verificates that the maximum of songs haven't been reached.
		if(allSongs[MAXIMUM_SONGS-1] == null){
			for(int i = 0; i<MAXIMUM_SONGS && space != true; i++){
				if(allSongs[i] == null && userFounded == true){
					allSongs[i] = newSong;
					space = true;
					allUsers[userNum].increaseDonatedSongs();
					msg += " Canción agregada correctamente.";
				}

			}
		}
		else{
			msg = "Límite de canciones excedido.";
		}
		return msg;
	}
	
	public String addPrivatePlaylist(String playlistName){
		
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
		
		//This changes the name of the playlist.
		if(playlistName.equalsIgnoreCase("*NO*") != true){
			newPlaylist.setName(playlistName);
		}
		else{
			newPlaylist.setName("Música para programar.");
		}
		
		return msg;
	}
	
	public String addPublicPlaylist(String playlistName){
		
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
		//This changes the name of the playlist.
		if(playlistName.equalsIgnoreCase("*NO*") != true){
			newPlaylist.setName(playlistName);
		}
		else{
			newPlaylist.setName("Música para programar.");
		}
		return msg;
	}
	
	public String addRestrictedPlaylist(String playlistName){
		
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
		
		//This changes the name of the playlist.
		if(playlistName.equalsIgnoreCase("*NO*") != true){
			newPlaylist.setName(playlistName);
		}
		else{
			newPlaylist.setName("Música para programar.");
		}
		
		return msg;
	}
	
	public String addSongToPlaylist(int songToAdd, int targetPlaylist){
		
		String msg = "";
		Song songWanted;
		targetPlaylist = targetPlaylist-1;
		songToAdd = songToAdd-1;
		
		if(allPlaylists[targetPlaylist] != null){
			songWanted = allSongs[songToAdd];
			allPlaylists[targetPlaylist].addSong(songWanted); 
			msg = "Canción agregada correctamente.";
		}
		else{
			msg = "Playlist inexistente. No se pudo agregar la canción.";
		}
		return msg;
	}
	
	public String addRate(int playlistTarget, double rate){
		String msg = "";
		playlistTarget = playlistTarget-1;
		
		if(allPlaylists[playlistTarget] instanceof PublicPlaylist){
			allPlaylists[playlistTarget].addRate(rate);
			msg = "Calificación añadida exitosamente. La calificación promedio actual es de: " + allPlaylists[playlistTarget].getRate();
		}
		else{
			msg = "La playlist escogida no es pública. Vuelva a intentar.";
		}
		
		return msg;
	}
	public String addOwner(int targetPlaylist, int targetUser){
		String msg = "";
		targetUser = targetUser-1;
		targetPlaylist = targetPlaylist-1;
		
		User ownerToAdd = allUsers[targetUser];
		
		if(allPlaylists[targetPlaylist] instanceof PublicPlaylist){
			msg = "No se pudo agregar el usuario dueño porque la playlist es pública.";
		}
		else{
			msg = allPlaylists[targetPlaylist].addOwnerUser(ownerToAdd);
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
			if(allPlaylists[i] != null){
				msg += allPlaylists[i].displayPlaylist() + "\n";
				msg += "\n";
			}
			else{
				space = true;
			}
		}
		return msg;
	}
	
	public String changePlaylistName(int targetPlaylist, String newName){
		String msg;
		targetPlaylist = targetPlaylist-1;
		allPlaylists[targetPlaylist].setName(newName);
		msg = "Nombre actualizado correctamente a: " + newName;
		return msg;
	}
}

