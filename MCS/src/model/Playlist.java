package model;

public abstract class Playlist{
	
	String name;
	int durationInSeconds, playlistDuration;
	private static final int MAXIMUM_SONGS = 30, MAXIMUM_GENRES = 7;
	Genres [] hasGenres;
	
	int playlistGenres [];	
	Song playlistSongs []; 
	
	/**
	*This method creates an object of the class playlist. <br>
	*<b> pre: </b> the package model must be imported in the class who it's going to create the object.<br>
	*<b> post: </b> the method will create an object.<br>
	*@return void <br>
	*/
	public Playlist(){
		durationInSeconds = 0;
		name = "Música para programar.";
		playlistSongs = new Song [MAXIMUM_SONGS];
		playlistGenres = new int [MAXIMUM_SONGS];	
		hasGenres = new Genres [MAXIMUM_GENRES];
		hasGenres[0] = Genres.DESCONOCIDO;
	}
	
	/**
	*This method displays the information of the playlist.<br>
	*<b>pre: </b> the playlist must be initializated before. <br>
	*<b>post </b>  the user will know the information of the playlist. <br>
	*@return String, this method returns a message with the information of the playlist. <br>
	*/
	public String displayPlaylist(){
		
		hasGenres = checkGenres();
		String duration = calculateDuration();
		
		boolean space = false;
		String genres = "";
		
		for(int i = 0; i<MAXIMUM_GENRES && space != true; i++){
			if(hasGenres[i] != null){
				genres += hasGenres[i] + ", ";				
			}
		}
		
		if(duration.equals("00:0")){
			duration = "00:00";
		}
		String msg = "";
	
			msg += "**************  Playlist **************" + "\n";
			msg += "*Title: " + name + "\n";
			msg += "*Duration: " + duration + "\n";
			msg += "*Genre: " + genres + "\n";
		
		return msg;
	}
	
	/**
	*This method will add the rate in a public playlist.<br>
	*<b>pre: </b> the method must be override and implemented in other class. <br>
	*<b>post </b>  when the method get override it will add a rate to a public playlist. <br>
	*@param rate, this double will save the new rate to add. <br>
	*@return void <br>
	*/
	public void addRate(double rate){
		;
	}
	
	/**
	*This method will get the rate of the playlist. <br>
	*<b> pre: </b> the playlist must be initializated. <br>
	*<b> post: </b>the user will get the rate of the playlist. <br>
	*@return double, this methods returns the rate of the playlist.<br>
	*/
	public double getRate(){
		double rate = 0;
		return rate;
	}
	
	/**
	*This method will set a different name to the playlist. <br>
	*<b> pre: </b> the playlist must be initializated. <br>
	*<b> post: </b>the playlist will change it's name. <br>
	*@param newName, this Strings saves the new name of the playlist. <br>
	*@return void<br>
	*/
	public void setName(String newName){
		this.name = newName;
	}
	
	/**
	*This method will get the name of the playlist. <br>
	*<b> pre: </b> the playlist must be initializated. <br>
	*<b> post: </b>the user will get the name of the playlist. <br>
	*@return String, this methods returns the name of the playlist.<br>
	*/
	public String getName(){
		return name;
	}
	
	/**
	*This method will set a different duration to the playlist. <br>
	*<b> pre: </b> the playlist must be initializated. <br>
	*<b> post: </b>the playlist will change it's duration. <br>
	*@param newDuration, this int saves the new duration of the playlist. <br>
	*@return void<br>
	*/
	public void setDuration(int newDuration){
		this.durationInSeconds = newDuration;
	}
	
	/**
	*This method will get the duration of the playlist in seconds. <br>
	*<b> pre: </b> the playlist must be initializated. <br>
	*<b> post: </b>the user will get the duration of the playlist in seconds. <br>
	*@return int, this methods returns the duration of the playlist in seconds.<br>
	*/
	public int getDuration(){
		return durationInSeconds;
	}
	
	/**
	*This method calculates the duration of the playlist. <br>
	*<b> pre: </b> the playlist must be initializated.<br>
	*<b> post: </b> the user will know the duration of the playlist. <br>
	*@return String, this method returns the duration of the playlist with the formar minutes:seconds .<br>
	*/
	public String calculateDuration(){
		String playlistDuration = "";
		boolean space = false;
		int minutes = 0, seconds = 0, extraMinutes = 0; //Variable extraminutes it's used to save the minutes if the total seconds are more than 59
		for(int i=0; space != true; i++){
			if(playlistSongs[i] != null){
				playlistGenres [i] = playlistSongs[i].getGenreNum();
				minutes += playlistSongs[i].getMinutes();
				seconds += playlistSongs[i].getSeconds();
			}
			else{
				space = true;
			}
		}
		
		durationInSeconds = (minutes*60) + (seconds);
		
		if(durationInSeconds<60){
			playlistDuration = "00:" + seconds;
		}
		else if(durationInSeconds==0){
			playlistDuration = "00:00";
		}
		else{
			
			if(seconds>59){
				extraMinutes = (int)(seconds/60);
				minutes = minutes + extraMinutes;
				seconds = seconds- (extraMinutes*60);
			}
			
			playlistDuration = minutes + ":" + seconds;
		}
		return playlistDuration;
	}
	
	/**
	*This method check the genres in the playlist. <br>
	*<b> pre: </b>the playlist must be initializated.<br>
	*<b> post: </b>the user will know the differents genres in the playlist. <br>
	*@return Genres[], this method returns an array of the class Genre, with the differents genres that are in the playlist.<br>
	*/
	public Genres [] checkGenres(){
		boolean space = false;
		Genres [] hasGenres = new Genres[MAXIMUM_GENRES];
	
		for(int i= 0; i<MAXIMUM_SONGS; i++){
			if(playlistGenres[i] == 1){
				hasGenres[0] = Genres.ROCK; 
			}
			else if(playlistGenres[i] == 2){
				hasGenres[1] = Genres.HIP_HOP; 
			}
			else if(playlistGenres[i]== 3){
				hasGenres[2] = Genres.CLASSIC_MUSIC; 
			}
			else if(playlistGenres[i] == 4){
				hasGenres[3] = Genres.REGGAE; 
			}
			else if(playlistGenres[i] == 5){
				hasGenres[4] = Genres.SALSA; 
			}
			else if(playlistGenres[i] == 6){
				hasGenres[5] = Genres.METAL; 
			}
			else{
				hasGenres[6] = Genres.DESCONOCIDO;
			}
		}
		return hasGenres;
	}
	
	/**
	*This method add a song to the playlist. <br>
	*<b> pre: </b>the playlist must be initializated before, and the song too. <br>
	*<b> post: </b> the user will know if the song was added, and the method will save it.<br>
	*@param songToAdd, this object will be added to the array with all the songs.<br>
	*@return String, this method returns a message to let the user know if the song was added. <br>
	*/
	public String addSong(Song songToAdd){
		
		boolean space = false;
		int i= 0;
		String msg = "";
		
		while(space != true){
			msg = "No se pudo añadir la canción.";
			
			if(playlistSongs[i] == null){
				space = true;
				playlistSongs[i] = songToAdd;
				playlistGenres[i] = songToAdd.getGenreNum(); //This has all the genres of the playlist.
				msg = "Canción añadida correctamente.";
			}
			else{
				i++;				
			}
		}
		calculateDuration(); //This updates the duration automatically.
		checkGenres();  //This checks what genres has the playlist.
		
		return msg;
	}
	
	/**
	*This method adds an owner user to the playlist. Will be override in the restricted and private playlist. <br>
	*<b> pre: </b>the playlist must be initializated and the user too. <br>
	*<b> post: </b> the method doesn't do anything yet. It will be override to let the user know if the owner user was added or not.<br>
	*@param newOwner, this object will be added to an array when the method gets override.<br>
	*@return String, this method returns an empty String, when it gets override will let the user know if the owner user was added or nor.<br>
	*/
	public String addOwnerUser(User newOwner){
		String msg = "";
		return msg;
	}
}