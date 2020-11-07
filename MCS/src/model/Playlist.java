package model;

public abstract class Playlist{
	
	String name;
	int durationInSeconds, playlistDuration;
	int	MAXIMUM_SONGS = 30, MAXIMUM_GENRES = 7;
	Genres [] hasGenres;
	
	int playlistGenres [];	
	Song playlistSongs []; 
	
	public Playlist(){
		durationInSeconds = 0;
		name = "Música para programar.";
		playlistSongs = new Song [MAXIMUM_SONGS];
		playlistGenres = new int [MAXIMUM_SONGS];	
		hasGenres = new Genres [MAXIMUM_GENRES];
		hasGenres[0] = Genres.DESCONOCIDO;
	}
	
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
	
	public void addRate(double rate){
		;
	}
	
	public double getRate(){
		double rate = 0;
		return rate;
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public String getName(){
		return name;
	}
	
	public void setDuration(int newDuration){
		this.durationInSeconds = newDuration;
	}
	
	public int getDuration(){
		return durationInSeconds;
	}
	
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
	
	public String addOwnerUser(User newOwner){
		String msg = "";
		return msg;
	}
}