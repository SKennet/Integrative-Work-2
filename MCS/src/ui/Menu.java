package ui;
import model.*;
import java.util.Scanner;

public class Menu{
	
	Scanner input = new Scanner(System.in);
	int optionChoosed;
	boolean finished = false;
	
	//User variables.
	String userName, userPassword;
	int userAge;
	
	//Songs variables.
	String songName, songDuration, songArtist;
	int songGenreNum;
		
	//Playlist variables.
	String playlistName, wantsToAddSong;
	int songNum, playChoosed;
	
	
	//This it's the server with the arrays. It stores all the users, songs, and playlists.
	Server newServer = new Server();
	
	public Menu(){
		
		System.out.println("¡Bienvenido/a a MCS!");
		System.out.println(showLogo());
		while(finished != true){
				
			System.out.println("¿Qué deseas hacer?");
			System.out.println("Para crear un usuario, digite 1.");
			System.out.println("Para añadir una canción, digite 2.");
			System.out.println("Para añadir una playlist pública, digite 3.");
			System.out.println("Para añadir una playlist privada, digite 4.");
			System.out.println("Para añadir una playlist restringida, digite 5.");
			System.out.println("Para listar las canciones agregadas, digite 6.");
			System.out.println("Para listar los usuarios digite 7.");
			System.out.println("Para listar las playlists, digite 8.");
			System.out.println("Para agregar una canción a una playlist, digite 9.");
			System.out.println("Para cerrar la aplicación, digite 10.");
			System.out.println("");
			
			optionChoosed = input.nextInt();
			input.nextLine();
			
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
						System.out.println("Por favor ingrese el nombre de usuario de quien quiere añadir la canción.");
						userName = input.nextLine();
						System.out.println("Por favor ingrese el titulo de la canción a añadir.");
						songName = input.nextLine();
						System.out.println("Por favor ingrese el artista de la canción.");
						songArtist = input.nextLine();
						System.out.println("Por favor ingrese la duración de la canción de la siguiente forma ->  minutos:segundos");
						songDuration = input.nextLine();
						System.out.println("Por favor ingrese el número correspondiente al género de la canción.");
						System.out.println("Si es rock dígite 1, si es hip hop digite 2, si es música clásica digite 3.");
						System.out.println("Si es reggae digite 4, si es salsa digite 5, o si es metal digite 6 .");
						songGenreNum = input.nextInt();
						input.nextLine();
				
						System.out.println(newServer.addSong(songName, songArtist, songDuration, songGenreNum, userName));
						break;
				
				case 3: 
						System.out.println("¿Desea ponerle nombre a la playlist? Si es así escriba el nombre a asignar, de lo contrario escriba: *NO*");
						playlistName = input.nextLine();
						System.out.println("¿Desea agregar una canción a la playlist? Escriba " + "SÍ" + ". De lo contrario escriba " + "NO");
						wantsToAddSong = input.nextLine();
						
						System.out.println(newServer.displaySongs());
						
						System.out.println("¿Cuál es el número de la canción que desea agregar?");
						songNum = input.nextInt();
						input.nextLine(); 
						
						System.out.println(newServer.addPublicPlaylist(playlistName, wantsToAddSong, songNum));
						break;		
						
				case 4:
						System.out.println("¿Desea ponerle nombre a la playlist? Si es así escriba el nombre a asignar, de lo contrario escriba: *NO*");
						playlistName = input.nextLine();
						System.out.println("¿Desea agregar una canción a la playlist? Escriba " + "SÍ" + ". De lo contrario escriba " + "NO");
						wantsToAddSong = input.nextLine();
						
						System.out.println(newServer.displaySongs());
						
						System.out.println("¿Cuál es el número de la canción que desea agregar?");
						songNum = input.nextInt();
						input.nextLine(); 
						System.out.println(newServer.addPrivatePlaylist(playlistName, wantsToAddSong, songNum));
						break;
						
				case 5: 
						System.out.println("¿Desea ponerle nombre a la playlist? Si es así escriba el nombre a asignar, de lo contrario escriba: *NO*");
						playlistName = input.nextLine();
						System.out.println("¿Desea agregar una canción a la playlist? Escriba " + "SÍ" + ". De lo contrario escriba " + "NO");
						wantsToAddSong = input.nextLine();
						
						System.out.println(newServer.displaySongs());
						
						System.out.println("¿Cuál es el número de la canción que desea agregar?");
						songNum = input.nextInt();
						input.nextLine(); 
						System.out.println(newServer.addRestrictedPlaylist(playlistName, wantsToAddSong, songNum));
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
						optionChoosed = 0;
						System.out.println(newServer.displayPlaylists());
						System.out.println("¿Cuál es el número de la playlist a la que quieres agregar la canción? Por favor, digitalo.");
						playChoosed = input.nextInt();
						
						System.out.println("¿Cuál es el número de la canción que quieres agregar a la playlist? Por favor, digitalo.");
						System.out.println(newServer.displaySongs());
						songNum = input.nextInt();
						System.out.println(newServer.addSongToPlaylist(songNum, playChoosed));
						break;
				case 10:
						finished = true;
						break;
			}
			System.out.println();
		}
		
	}
	
	public String showLogo(){
		String msg = "";
		
		msg += "(((((((((((((((((((((((((((((((((((((((((((((((((" + "\n";
		msg += "((((((((((((((((/((((((((((((((((((((((((((((((((" + "\n";
		msg += "(((/  .(((((((*  .((((((*        (((((/      /(((" + "\n";
		msg += "(((/   .((((((.  .(((((   ,((((((((((*  .((((((((" + "\n";
		msg += "(((/    /((((/   .((((/  ,(((((((((((.  /((((((((" + "\n";
		msg += "(((/     ((((*   .((((*  ,(((((((((((/   ((((((((" + "\n";
		msg += "(((/  *  *(((     ((((*  ,((((((((((((,  .((((((("+ "\n";
		msg += "(((/  /.  ((*     ((((*  *(((((((((((((,   (((((("+ "\n";
		msg += "(((/  //  ,(  .   ((((*  *((((((((((((((/   /(((("+ "\n";
		msg += "(((/  *(*  ,  (   ((((*  *((((((((((((((((   /((("+ "\n";
		msg += "(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   ((("+ "\n";
		msg += "(((/  .((    ((   /((((  .(((((((((((((((((.  /(("+ "\n";
		msg += "(((/  .((.  .((.  *((((,  *((((((((((((((((   /(("+ "\n";
		msg += "(((/  .((((((((.  *(((((   *((((/,/(((((((/   ((("+ "\n";
		msg += "(((/  .((((((((.  *((((((.        *((   .   .(((("+ "\n";
		msg += "(((((((((((((((/*/((((((((((///(((((((////((((((("+ "\n";
		msg += "((((((((((((((((((((((((((((((((((((((((((((((((("+ "\n";
		msg += "               ./(###((///((###(*                "+ "\n";
		msg += "           *#(,                   *((,           "+ "\n";
		msg += "        ,#/                           ((         "+ "\n";
		msg += "      .#*          .**/////*,.          ((       "+ "\n";
		msg += "     *(.      .//////////////////*       *#      "+ "\n";
		msg += "    .#,     *///////////////////////,     /(     "+ "\n";
		msg += "    /(    *///////////////////////////    .#.    "+ "\n";
		msg += "  ,/////,*/////////////////////////////,*////*.  "+ "\n";
		msg += "  /////////////////////////*,...,/////////////,  "+ "\n";
		msg += "  //////*,,,********,,.............,,,,,//////,  "+ "\n";
		msg += "  //////*.........//*........//*.......,//////, "+ "\n";
		msg += "  //////*.........,,.........,,........,//////,  "+ "\n";
		msg += "  //////*..............................,//////,  "+ "\n";
		msg += "   *///*  ........,/.........**.......  .*///,  "+ "\n";
		msg += "            .......,/*.....,/*.......            "+ "\n";
		msg += "               ........,,,,.......               "+ "\n";
		msg += "                    .........                    "+ "\n";
		msg += ""+ "\n";
		msg += "*************************************************"+ "\n";
		msg += ""+ "\n";
		
		return msg;
	}
}
