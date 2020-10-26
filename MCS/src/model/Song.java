package model;

public class Song{
	String title, artistName;
	int duration;
	Genres songGenre;
	
	public Song(String title, String artistName, int duration, int genreNum){
		this.title = title;
		this.artistName = artistName;
		this.duration = duration;
		
		switch(genreNum){
			case 1:	songGenre = Genres.ROCK;
					break;
			case 2: songGenre = Genres.HIP_HOP;
					break;
			case 3: songGenre = Genres.CLASSIC_MUSIC;
					break;
			case 4: songGenre = Genres.REGGAE;
					break;
			case 5: songGenre = Genres.SALSA;
					break;
			case 6: songGenre = Genres.METAL;
					break;
		}
	}
	
	//This will display the song information.
	public String displaySong(){
		String msg ="";
		
		msg +=  "**************  Song **************" + "\n";
		msg +=  "**  Title: " + title + "\n";
		msg +=  "**  Artist: " + artistName + "\n";
		msg +=	"**  Duration: " + duration + "\n";
		msg +=	"Genre: " + songGenre + "\n";
		msg +=  "***********************************"
		
		return msg;
	}
	
	//This are the getters.
	public String getTitle(){
		return title;
	}
	public String getArtistName(){
		return artistName;
	}
	public int getDuration(){
		return duration;
	}
	
	///This are the setters.
	public void setTitle(String newTitle){
		this.title = newTitle;
	}
	public void setArtistName(String newArtistName){
		this.artistName = newArtistName;
	}
	public void setDuration(int newDuration){
		this.duration = newDuration;
	}
	
	
}