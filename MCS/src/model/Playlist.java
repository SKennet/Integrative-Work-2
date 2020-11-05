package model;

public abstract class Playlist{
	
	String name;
	int durationInSeconds;
	int	MAXIMUM_SONGS = 30, MAXIMUM_GENRES = 6;

	
	int playlistGenres [];	
	Song playlistSongs []; 
	
	public Playlist(){
		durationInSeconds = 0;
		name = "";
		playlistSongs = new Song [MAXIMUM_SONGS];
		playlistGenres = new int [MAXIMUM_GENRES];	
	}
	
	public String displayPlaylist(){
		boolean space = false;
		
		while( space != true){
			msg += "**************  Playlist **************" + \n";
			msg += "Title: " + +"\n";
			msg += "Duration: " "\n";
			msg += "Genre: " + hasGenres + "\n";
			msg += "***************************************" +"\n";
		}
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
	
	public void calculateDuration(){
		boolean space = false;
		int minutes = 0, seconds = 0;
		for(int i=0; space != true; i++){
			if(playlistSongs[i] != null){
				playlistGenres [i] = playlistSongs[i].getGenreNum();
				minutes += playlistSongs[i].minutes;
				seconds += playlistSongs[i].seconds;
			}
			else{
				space = true;
			}
		}
		
		durationInSeconds = (minutes/60) + (seconds);
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
			if(playlistGenres[i] == 6){
				hasGenres[5] = Genres.METAL; 
			}
		}
		return hasGenres;
	}
	
	public String addSong(String songName, String artistName, String duration, int genre){
		
		boolean space = false;
		int i= 0;
		String msg = "";
		
		while(space != true){
			msg = "No se pudo a�adir la canci�n.";
			
			if(playlistSongs[i] == null){
				space = true;
				Song newSong = new Song(songName, artistName, duration, genre);
				playlistGenres[i] = genre; //This has all the genres of the playlist.
				msg = "Canci�n a�adida correctamente.";
			}
			else{
				i++;				
			}
		}
		calculateDuration(); //This updates the duration automatically.
		checkGenres();  //This checks what genres has the playlist.
		
		return msg;
	}
	
}