package model;
import model.*;

public class Server{
	
	private final static int MAXIMUM_USERS = 10, MAXIMUM_SONGS = 30, MAXIMUM_PLAYLISTS = 20;	
	
	User [] allUsers;
	Song [] allSongs;
	Playlist [] allPlaylists;
	
	/**
	*This method creates a server. <br>
	*<b>pre: </b>the package model must be imported in the class that it's going to use this method.<br>
	*<b>post: </b>the method will create an object type server<br>
	*@return void<br>
	*/	
	public Server(){
		allUsers = new User [MAXIMUM_USERS];
		allSongs = new Song[MAXIMUM_SONGS];
		allPlaylists = new Playlist [MAXIMUM_PLAYLISTS];
	}
	
	//Add methods.
	
	/**
	*This method creates an user to the array with all the users. <br>
	*<b>pre: </b> the user must have a name, password, and an age. userName != null, userPassword != null, age != null <br>
	*<b>post: </b>  the user will know if the new user was created or not, if it was created the method will save this user. <br>
	*@param	userName: this String saves the user's nick. userName != null<br>
	*@param userPassword: this String saves the user's password. userPassword != null <br>
	*@param age: this int saves the user's age. Must be only integers. age != null <br>
	*@return String, this method returns a message to confirm if the user was added or if there were an issue. <br>
	*/	
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
	
	/**
	*This method adds a song to the array with all the songs.<br>
	*<b>pre: the user must be created before, and must know the information of the song.</b>    <br>
	*<b>post: the user will know if the song was added because the program shows a message.</b>    <br>
	*@param title, this String saves the name of the song. <br>
	*@param artistName, this String saves the name of the artist/s. <br>
	*@param duration, this String saves the duration of the song with the format minutes:seconds. <br>
	*@param genreNum, this int saves the genre of the song. <br>
	*@param userName, this String it's used to check if the user who wants to save the song exist, or if it doesn't.
	*@return String, this method returns a message to confirm if the song was added, or if it wasn't possible. <br>
	*/
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
	
	/**
	*This method creates a private list and added it to the array.<br>
	*<b>pre: </b>the user must be created before he can creates a playlist.<br>
	*<b>post: </b>the user will know if he created the playlist, and the method will save the playlist if it was created. <br>
	*@param playlistName, this String saves the name of the playlist. If the user don't want to rename it, the default name it's "Música para programar." playlistName != null         <br>
	*@return String, the method returns a message to let the user know if the playlist was created or not.		  <br>
	*/
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
	
	/**
	*This method creates a public list and added it to the array.<br>
	*<b>pre: </b>the user must be created before he can creates a playlist.<br>
	*<b>post: </b>the user will know if he created the playlist, and the method will save the playlist if it was created. <br>
	*@param playlistName, this String saves the name of the playlist. If the user don't want to rename it, the default name it's "Música para programar.". playlistName != null         <br>
	*@return String, the method returns a message to let the user know if the playlist was created or not.		  <br>
	*/
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
	
	/**
	*This method creates a restricted list and added it to the array.<br>
	*<b>pre: </b>the user must be created before he can creates a playlist.<br>
	*<b>post: </b>the user will know if he created the playlist, and the method will save the playlist if it was created. <br>
	*@param playlistName, this String saves the name of the playlist. If the user don't want to rename it, the default name it's "Música para programar." playlistName != null         <br>
	*@return String, the method returns a message to let the user know if the playlist was created or not.		  <br>
	*/
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
	
	/**
	*This method adds songs to a playlist.<br>
	*<b>pre: </b> the playlist and song must be created before. <br>
	*<b>post: </b> the user will know if he the song was added, and the playlist will save the song if it was possible.   <br>
	*@param songToAdd, this int saves the index of the song that the user wants to add. songToAdd != null <br>
	*@param targetPlaylist, this int saves the index of the playlist objetive to add the song. playlistTarget != null <br>
	*@return String, the method return a message to let the user know if the song was addded or not to the playlist. <br>
	*/
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
	
	/**
	*This method adds a rate to a public playlist.<br>
	*<b>pre: </b> the playlist must be created before, and must be public.   <br>
	*<b>post: </b> the user will know if the rate was added, and wath it's the current rate.   <br>
	*@param  playlistTarget, this int saves the index of the playlist to add the rate. playlistTarget != null <br>
	*@param  rate, this double saves the rate that the user gives to the playlist. rate != null <br>
	*@return String, this method returns a message with the current rate if the user choose a public playlist, if he doesn't the message will ask for another playlist. <br>
	*/
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
	
	/**
	*This method adds an woner to a restricted or private playlist.<br>
	*<b>pre: </b>the playlist must be created before, and must be private or restricted.    <br>
	*<b>post: </b> the user will know if the owner was added or if there was an issue. Also the method will save the owner (if it's possible) in the playlist. <br>
	*@param targetPlaylist, this int saves the index of the playlist to add the owner. <br>
	*@param targetUser, this int saves the index of the user to add as owner of a playlist. <br>
	*@return String, this method returns a message to let the user know if the owner was added or not. <br>
	*/
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
	
	/**
	*This method shows all the users.<br>
	*<b>pre: </b>the server must be initializated. <br>
	*<b>post: </b> the user will see all the users registred in the server. <br>
	*@return String, this method returns a String with the information of all the users. <br>
	*/
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
	
	/**
	*This method displays all the songs.<br>
	*<b>pre: </b> the server must be initializated before. <br>
	*<b>post: </b> the user will see all the songs added to the server   <br>
	*@return String, this method returns a String with the information of all the songs. <br>
	*/
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
	
	/**
	*This method displaylis all the playlists.<br>
	*<b>pre: </b> the server must be initializated before. <br>
	*<b>post: </b> the user will see all the playlist created in the server. <br>
	*@return String, this method returns a String with the information of all the playlists. <br>
	*/
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
	
	
	//Changing name method.
	/**
	*This method changes the name of a playlist. <br>
	*<b>pre: </b> the playlist must be created before. <br>
	*<b>post: </b> the user will know the new name of the playlist. And it will be updated.<br>
	*@param targetPlaylist, this int saves the index of the playlist to change the name. <br>
	*@param newName, this String saves the new name of the playlist. <br>
	*@return String, this method returns a String to let the user know the new name.		  <br>
	*/
	public String changePlaylistName(int targetPlaylist, String newName){
		String msg;
		targetPlaylist = targetPlaylist-1;
		allPlaylists[targetPlaylist].setName(newName);
		msg = "Nombre actualizado correctamente a: " + newName;
		return msg;
	}
}

