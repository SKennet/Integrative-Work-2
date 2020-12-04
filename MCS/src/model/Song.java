package model;
import model.*;

public class Song{
	String title, artistName;
	int genreNum, minutes, seconds, totalDuration;
	Genres songGenre;
	String [] durationParts = new String [2];
	
	
	/**
	*This method it's the constructor of the songs.<br>
	*<b>pre: </b>the user must know the information of the song.<br>
	*<b>post: </b>the server will have another song.<br>
	*@param title, this String saves the name of the song.<br>
	*@param artistName, this String saves the name of the artist/s.<br>
	*@param duration, this String saves the duration with the format minutes:seconds .<br>
	*@param genreNum, this int saves the type of genre of the song.<br>
 	*@return void. <br>
	*/
	public Song(String title, String artistName, String duration, int genreNum){
		this.title = title;
		this.artistName = artistName;
		this.genreNum = genreNum;
		
		//this.duration = 
		durationParts = splitDuration(duration); //This will call the method "splitDuration".
		this.minutes = Integer.parseInt(durationParts[0]);
		this.seconds = Integer.parseInt(durationParts[1]);
		
		totalDuration = calculateTotalDuration();
		
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
	
	/**
	* This method calculates the duration in seconds of the song.<br>
	*<b>pre: </b> the song must be initializated.<br>
	*<b>post: </b> the user will know the duration in seconds.<br>
 	*@return int, this method returns the total duration in seconds.<br>
	*/
	public int calculateTotalDuration(){
		totalDuration = (minutes*60) + (seconds);
		return totalDuration;
	}
	

	/**
	*This method separates the duration in format minutes:seconds, and turn it into an array.<br>
	*<b>pre: </b> the song must be initializated with a duration in the format minutes:seconds. <br>
	*<b>post: </b> the user will get an array with the minutes and seconds.<br>
	*@param duration, this String has the duration with the format minutes:seconds.<br>
 	*@return String [], this method returns an array with the minutes and the seconds.<br>
	*/
	public String [] splitDuration(String duration){
		String [] durationParts = duration.split(":");
		return durationParts;
	}
	
	
	/**
	*This method shows the information of the song.<br>
	*<b>pre: </b> the song must be initializated.<br>
	*<b>post: </b> the user will know the information of the song.<br>
 	*@return String, this method returns a String with the information of the song.<br>
	*/
	public String displaySong(){
		String msg ="";
		
		msg +=  "**************  Song **************" + "\n";
		msg +=  "**Title: " + title + "\n";
		msg +=  "**Artist: " + artistName + "\n";
		msg +=	"**Duration: " + minutes + ":" + seconds + "\n";
		msg +=	"**Genre: " + songGenre + "\n";
		msg +=  "***********************************" + "\n";
		
		return msg;
	}
	
	//This are the getters.
	
	/**
	* This will get the title of the song.<br>
	*<b>pre: </b>the song must be initializated.<br>
	*<b>post: </b> the user will get the title of the song.<br>
 	*@return String, this method returns the title of the song.<br>
	*/
	public String getTitle(){
		return title;
	}
	
	/**
	* This will get the artist name.<br>
	*<b>pre: </b>the song must be initializated.<br>
	*<b>post: </b> the user will get the name of the artist.<br>
 	*@return String, this method returns the name of the artist.<br>
	*/
	public String getArtistName(){
		return artistName;
	}
	
	/**
	* This will get the duration in seconds.<br>
	*<b>pre: </b>the song must be initializated.<br>
	*<b>post: </b> the user will get the duration in seconds..<br>
 	*@return int, this method returns the duration in seconds.<br>
	*/
	public int getDuration(){
		return totalDuration;
	}
	
	/**
	* This will get the number of the genre.<br>
	*<b>pre: </b>the song must be initializated.<br>
	*<b>post: </b> the user will get the num of the genre.<br>
 	*@return int, this method returns the number of the genre of the song.<br>
	*/
	public int getGenreNum(){
		return genreNum;
	}
	
	/**
	* This will get the genre of the song.<br>
	*<b>pre: </b>the song must be initializated.<br>
	*<b>post: </b> the user will get the genre of the song.<br>
 	*@return Genre, this method returns the genre of the <br>
	*/
	public Genres getGenre(){
		return songGenre;
	}
	
	/**
	* This will get the minutes of the song.<br>
	*<b>pre: </b>the song must be initializated.<br>
	*<b>post: </b> the user will get the minutes of the songs.<br>
 	*@return int, this method returns the minutes.<br>
	*/
	public int getMinutes(){
		return minutes;
	}
	
	/**
	* This will get the seconds.<br>
	*<b>pre: </b>the song must be initializated.<br>
	*<b>post: </b> the user will get the seconds.<br>
 	*@return int, this method returns the seconds.<br>
	*/
	public int getSeconds(){
		return seconds;
	}
	
	///This are the setters.
	
	/**
	* This will change the title.<br>
	*<b>pre: </b>the song must be initializated.<br>
	*<b>post: </b> the user will change the title.<br>
	*@param newTitle, this String has the new title of the song.<br>
 	*@return void. <br>
	*/
	public void setTitle(String newTitle){
		this.title = newTitle;
	}
	
	/**
	* This will change the name of the artist.<br>
	*<b>pre: </b>the song must be initializated.<br>
	*<b>post: </b> the user will change the name of the artist.<br>
	*@param newArtistName, this String has the new name of the artist/s.<br>
 	*@return void. <br>
	*/
	public void setArtistName(String newArtistName){
		this.artistName = newArtistName;
	}
	
	/**
	* This will change the duration in seconds.<br>
	*<b>pre: </b>the song must be initializated.<br>
	*<b>post: </b> the user will change the duration in seconds.<br>
	*@param newDuration, this int has the new total of the duration in seconds.<br>
 	*@return void. <br>
	*/
	public void setDuration(int newDuration){
		this.totalDuration = newDuration;
	}
	
	/**
	* This will change the number of the genre.<br>
	*<b>pre: </b>the song must be initializated.<br>
	*<b>post: </b> the user will change the number of the genre.<br>
	*@param newGenreNum, this int has the new number of the genre.<br>
 	*@return void. <br>
	*/
	public void setGenreNum(int newGenreNum){
		this.genreNum = newGenreNum;
	}
	
	/**
	* This will change the genre.<br>
	*<b>pre: </b>the song must be initializated.<br>
	*<b>post: </b> the user will change the genre.<br>
	*@param newGenre, this Genre has the new genre of the song.<br>
 	*@return void. <br>
	*/
	public void setGenre(Genres newGenre){
		this.songGenre = newGenre;
	}
	
	
}