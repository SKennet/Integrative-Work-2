package model;

public class User{
	String nickName, password;
	int age;
	
	//This variable will check how many songs has donated the user, to determinate his category.
	int songsDonated = 0;
	Category userCategory = Category.NEWBIE;
	
	public User(String nickName, String password, int age){
		this.nickName = nickName;
		this. password = password;
		this.age = age;
	}
	
	//This displays the user information.
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
	public void increaseDonatedSongs(){
		songsDonated++;
	} 
	
	//this works as a "setCategory", but it does by itself.
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
	public String getNickName(){
		return nickName;
	}
	public String getPassword(){
		return password;
	}
	public int getAge(){
		return age;
	}
	public Category getCategory(){
		return userCategory;
	}
	
	//This are the setters.
	public void setNickName(String newName){
		this.nickName = newName;
	}
	public void setPassword(String newPassword){
		this.password = newPassword;
	}
	public void setAge(int newAge){
		this.age = newAge;
	}
	
	
}