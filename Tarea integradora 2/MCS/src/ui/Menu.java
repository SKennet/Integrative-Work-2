package ui;
import model.*;
import java.util.Scanner;

public class Menu{
	
	Scanner input = new Scanner(System.in);
	int optionChoosed;
	boolean finished = false;
	
	String userName, userPassword;
	int userAge;
	
	String songName, songDuration, songArtist;
	int songGenreNum;
	
	//This it's the server with the arrays. It stores all the users, songs, and playlists.
	Server newServer = new Server();
	
	public Menu(){
		while(finished != true){
				
			System.out.println("¿Qué deseas hacer?");
			System.out.println("Para crear un usuario, digite 1. Para añadir una canción, digite 2. Para añadir una playlist pública, digite 3");
			System.out.println("Para añadir una playlist privada, digite 4. Para añadir una playlist restringida, digite 5.");
			System.out.println("Para listar las canciones agregadas, digite 6. Para listar los usuarios digite 7. Para listar las playlists, digite 8.");
			System.out.println("Para cerrar la aplicación, digite 9.");
			switch(optionChoosed){
								
				case 1: 
						System.out.println("Por favor introduzca el nombre de usuario. Una sola palabra.");
						userName = input.nextLine();
						System.out.println("Por favor introduzca la contraseña de la cuenta.");
						userPassword = input.nextLine();
						System.out.println("Por favor introduzca la edad en años.");
						userAge = input.nextInt();
						input.nextLine();
						
						System.out.println(newServer.addUser(userName, userPassword, userAge));
						break;
								
				case 2: 
						System.out.println("Por favor ingrese el titulo de la canción a añadir.");
						songName = input.nextLine();
						System.out.println("Por favor ingrese el artista de la canción.");
						songArtist = input.nextLine();
						System.out.println("Por favor ingrese la duración de la canción de la siguiente forma ->  minutos:segundos");
						songDuration = input.nextLine();
						System.out.println("Por favor ingrese el número correspondiente al género de la canción.");
						System.out.println("Si es rock dígite 1, si es hip hop digite 2, si es música clásica digite 3.");
						System.out.print("Si es reggae digite 4, si es salsa digite 5, o si es metal digite 6 .");
						songGenreNum = input.nextInt();
						input.nextLine();
				
						System.out.println(newServer.addSong(songName, songArtist, songDuration, songGenreNum));
						break;
				
				case 3: 
						System.out.println(newServer.addPublicPlaylist());
						break;		
						
				case 4:
						System.out.println(newServer.addPrivatePlaylist());
						break;
						
				case 5: 
						System.out.println(newServer.addRestricteedPlaylist());
						break;
						
				case 6:
						System.out.println(newServer.displaySongs());
						break;
				
				case 7:
						System.out.println(newServer.displayUsers());
						break;
						
				case 8: 
						System.out.println(newServer.displayPlaylists());
						break;
				case 9:
						finished = true;
						break;
			}
		}
		System.exit.(0);
	}
}
