package model;

public class User{
	String nickName, password;
	int age;
	
	//This variable will check how many songs has donated the user, to determinate his category.
	int songsDonated = 0;
	Category userCategory = Category.NEWBIE;
	
	/**
	*This method it's the constructor of the users.<br>
	*<b>pre: </b>the user  must know the information, and the package model must be imported in the class that it's going to use this method.<br>
	*<b>post: </b>the method will create a new user.<br>
	*@param nickName, this String has the name of the new user.<br>
	*@param password, this String has the password of the new user.<br>
	*@param age, this int has the age of the user.<br>
 	*@return void.<br>
	*/
	public User(String nickName, String password, int age){
		this.nickName = nickName;
		this. password = password;
		this.age = age;
	}
	
	//
	/**
	*This displays the user information.<br>
	*<b>pre: </b>the user must be initializated.<br>
	*<b>post: </b> the user will see the information of this user.<br>
	*@return String, this method returns a String with the information of the user. <br>
	*/
	public String displayUser(){
		String msg = "";
		
		checkCategory();
		
		msg += "*************  User **************" + "\n";
		msg += "** UserName: "+ nickName + "\n";
		msg += "**Age: " + age +"\n";
		msg += "**Category: " + userCategory+ "\n";
		msg += "***********************************" + "\n";
		
		return msg;
	}
	
	//This will create the new song.
	
	/**
	*This method increase the songs donated for the user.<br>
	*<b>pre: </b>the user must be initializated.<br>
	*<b>post: </b>the user will update his donated songs. <br>
	*@return void.<br>
	*/
	public void increaseDonatedSongs(){
		songsDonated++;
	} 
	
	//this works as a "setCategory", but it does by itself.
	
	/**
	*This method checks the category of the user.<br>
	*<b>pre: </b>the user must be initializated. <br>
	*<b>post: </b>the user will know the category of this user.<br>
	*@return void.<br>
	*/
	public void checkCategory(){
		
		if(songsDonated >3 && songsDonated<10){
			userCategory = Category.LITTLE_CONTRIBUITOR;
		}
		else if(songsDonated>10 && songsDonated<30){
			userCategory = Category.MILD_CONTRIBUITOR;
		}
		else if(songsDonated>=30){
			userCategory = Category.STAR_CONTRIBUITOR;
		}	
	}

	//this are the getters.
	
	/**
	*This method gets the nick-name of the user.<br>
	*<b>pre: </b>the user must be initializated.<br>
	*<b>post: </b>the user will get the nick-name of the user.<br>
	*@return String, this method returns the nick-name of the user.<br>
	*/
	public String getNickName(){
		return nickName;
	}
	
	/**
	*This method gets the password.<br>
	*<b>pre: </b>the user must be initializated.<br>
	*<b>post: </b>the user will get the password.<br>
	*@return String, this method returns the password of the user.<br>
	*/
	public String getPassword(){
		return password;
	}
	
	/**
	*This method gets the age of the user.<br>
	*<b>pre: </b>the user must be initializated.<br>
	*<b>post: </b>the user will get the age.<br>
	*@return int, this method returns the age of the user.<br>
	*/
	public int getAge(){
		return age;
	}
	
	/**
	*This method gets the category.<br>
	*<b>pre: </b>the user must be initializated.<br>
	*<b>post: </b>the user will get the category.<br>
	*@return Category, this method returns the category of the user.<br>
	*/
	public Category getCategory(){
		return userCategory;
	}
	
	//This are the setters.
	
	/**
	*This method changes the nick-name.<br>
	*<b>pre: </b>the user must be initializated. <br>
	*<b>post: </b>the user will change the nick-name.<br>
	*@param	newName, this String has the new name of the user.<br>
	*@return void.<br>
	*/
	public void setNickName(String newName){
		this.nickName = newName;
	}
	
	/**
	*This method changes the password.<br>
	*<b>pre: </b>the user must be initializated. <br>
	*<b>post: </b>the user will change the password.<br>
	*@param	newPassword, this String has the new password.<br>
	*@return void.<br>
	*/
	public void setPassword(String newPassword){
		this.password = newPassword;
	}
	
	/**
	*This method changes the age.<br>
	*<b>pre: </b>the user must be initializated. <br>
	*<b>post: </b>the user will change the age.<br>
	*@param	newAge, this int has the new age of the user.<br>
	*@return void.<br>
	*/
	public void setAge(int newAge){
		this.age = newAge;
	}
}