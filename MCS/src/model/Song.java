package model;
import model.*;

public class Song{
	String title, artistName;
	int genreNum, minutes, seconds, totalDuration;
	Genres songGenre;
	String [] durationParts = new String [2];
	
	
	
	public Song(String title, String artistName, String duration, int genreNum){
		this.title = title;
		this.artistName = artistName;
		this.genreNum = genreNum;
		
		//this.duration = 
		durationParts = splitDuration(duration); //This will call the method "splitDuration".
		this.minutes = Integer.parseInt(durationParts[0]);
		this.seconds = Integer.parseInt(durationParts[1]);
		
		calculateTotalDuration();
		
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
	
	public int calculateTotalDuration(){
		totalDuration = (minutes*60) + (seconds);
		return totalDuration;
	}
	
	//This separates the duration in minutes and seconds.
	public String [] splitDuration(String duration){
		String [] durationParts = duration.split(":");
		return durationParts;
	}
	
	//This will display the song information.
	public String displaySong(){
		String msg ="";
		
		msg +=  "**************  Song **************" + "\n";
		msg +=  "**  Title: " + title + "\n";
		msg +=  "**  Artist: " + artistName + "\n";
		msg +=	"**  Duration: " + minutes + ":" + seconds + "\n";
		msg +=	"**Genre: " + songGenre + "\n";
		msg +=  "***********************************" + "\n";
		
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
		return totalDuration;
	}
	public int getGenreNum(){
		return genreNum;
	}
	public Genres getGenre(){
		return songGenre;
	}
	
	///This are the setters.
	public void setTitle(String newTitle){
		this.title = newTitle;
	}
	public void setArtistName(String newArtistName){
		this.artistName = newArtistName;
	}
	public void setDuration(int newDuration){
		this.totalDuration = newDuration;
	}
	public void setGenreNum(int newGenreNum){
		this.genreNum = newGenreNum;
	}
	public void setGenre(Genres newGenre){
		this.songGenre = newGenre;
	}
	
	
}