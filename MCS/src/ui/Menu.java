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
				
			System.out.println("�Qu� deseas hacer?");
			switch(optionChoosed){
				
				
				case 1: 
						System.out.println("Por favor introduzca el nombre de usuario. Una sola palabra.");
						userName = input.nextLine();
						System.out.println("Por favor introduzca la contrase�a de la cuenta.");
						userPassword = input.nextLine();
						System.out.println("Por favor introduzca la edad en n�meros.");
						userAge = input.nextInt();
						input,nextLine();
						
						User newUser = new User(userName, userPassword, userAge);
						System.out.println("Usuario agregado satisfactoriamente.");
						break;
								
				case 2: 
						System.out.println("Por favor ingrese el titulo de la canci�n a a�adir.");
						songName = input.nextLine();
						System.out.println("Por favor ingrese el artista de la canci�n.");
						songArtist = input.nextLine();
						System.out.println("Por favor ingrese la duraci�n de la canci�n en segundos.");
						songDuration = input.nextInt();
						System.out.println("Por favor ingrese el n�mero correspondiente al g�nero de la canci�n.");
						System.out.println("Si es rock d�gite 1, si es hip hop digite 2, si es m�sica cl�sica digite 3, ");
						System.out.print("si es reggae ingrese 4, si es salsa ingrese 5, o si es metal ingrese 6 .");
						songGenreNum = input.nextInt();
						input.nextLine();
				
						newUser.addSong(songName, songArtist, songDuration, songGenreNum);
						System.out.println("Canci�n agregada satisfactoriamente.");
						break;
				
				case 3: Playlist newPlaylist = new Playlist("", 0);
								
								
			}
		}	
	}
}
