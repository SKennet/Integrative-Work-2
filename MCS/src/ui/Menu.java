package ui;
import model.*;
import java.util.Scanner;

public class Menu{
	
	Scanner input = new Scanner(System.in);
	int optionChoosed;
	boolean finished = false;
	
	String userName, userPassword;
	int userAge;
	
	String songName, songArtist;
	int songDuration, songGenreNum;
	
	public Menu(){
		while(finished != true){
				
			System.out.println("¿Qué deseas hacer?");
			switch(optionChoosed){
				
				
				case 1: 
						System.out.println("Por favor introduzca el nombre de usuario. Una sola palabra.");
						userName = input.nextLine();
						System.out.println("Por favor introduzca la contraseña de la cuenta.");
						userPassword = input.nextLine();
						System.out.println("Por favor introduzca la edad en números.");
						userAge = input.nextInt();
						input,nextLine();
						
						User newUser = new User(userName, userPassword, userAge);
						System.out.println("Usuario agregado satisfactoriamente.");
						break;
								
				case 2: 
						System.out.println("Por favor ingrese el titulo de la canción a añadir.");
						songName = input.nextLine();
						System.out.println("Por favor ingrese el artista de la canción.");
						songArtist = input.nextLine();
						System.out.println("Por favor ingrese la duración de la canción en segundos.");
						songDuration = input.nextInt();
						System.out.println("Por favor ingrese el número correspondiente al género de la canción.");
						System.out.println("Si es rock dígite 1, si es hip hop digite 2, si es música clásica digite 3, ");
						System.out.print("si es reggae ingrese 4, si es salsa ingrese 5, o si es metal ingrese 6 .");
						songGenreNum = input.nextInt();
						input.nextLine();
				
						newUser.addSong(songName, songArtist, songDuration, songGenreNum);
						System.out.println("Canción agregada satisfactoriamente.");
						break;
				
				case 3: Playlist newPlaylist = new Playlist("", 0);
								
								
			}
		}	
	}
}
