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
	double rate;
		
	//Playlist variables.
	String playlistName;
	int songNum, playChoosed, userToAdd;
	
	
	//This it's the server with the arrays. It stores all the users, songs, and playlists.
	Server newServer = new Server();
	
	public Menu(){
		
		System.out.println("�Bienvenido/a a MCS!");
		System.out.println(showLogo());
		while(finished != true){
				
			System.out.println("�Qu� deseas hacer?");
			System.out.println("Para crear un usuario, digite 1.");
			System.out.println("Para a�adir una canci�n, digite 2.");
			System.out.println("Para a�adir una playlist p�blica, digite 3.");
			System.out.println("Para a�adir una playlist privada, digite 4.");
			System.out.println("Para a�adir una playlist restringida, digite 5.");
			System.out.println("Para listar las canciones agregadas, digite 6.");
			System.out.println("Para listar los usuarios digite 7.");
			System.out.println("Para listar las playlists, digite 8.");
			System.out.println("Para agregar una canci�n a una playlist, digite 9.");
			System.out.println("Para calificar una playlist, ingrese 10");
			System.out.println("Para cambiar el nombre de una playlist, digite 11.");
			System.out.println("Para agregar un usuario con acceso a una playlist restringidad o privada, ingrese 12.");
			System.out.println("Para cerrar la aplicaci�n, digite 13.");
			System.out.println("");
			
			optionChoosed = input.nextInt();
			input.nextLine();
			
			switch(optionChoosed){
								
				case 1: 
						System.out.println("Por favor introduzca el nombre de usuario. Una sola palabra.");
						userName = input.nextLine();
						System.out.println("Por favor introduzca la contrase�a de la cuenta.");
						userPassword = input.nextLine();
						System.out.println("Por favor introduzca la edad en a�os.");
						userAge = input.nextInt();
						input.nextLine();
						
						System.out.println(newServer.addUser(userName, userPassword, userAge));
						break;
								
				case 2: 
						System.out.println("Por favor ingrese el nombre de usuario de quien quiere a�adir la canci�n.");
						userName = input.nextLine();
						System.out.println("Por favor ingrese el titulo de la canci�n a a�adir.");
						songName = input.nextLine();
						System.out.println("Por favor ingrese el artista de la canci�n.");
						songArtist = input.nextLine();
						System.out.println("Por favor ingrese la duraci�n de la canci�n de la siguiente forma ->  minutos:segundos");
						songDuration = input.nextLine();
						System.out.println("Por favor ingrese el n�mero correspondiente al g�nero de la canci�n.");
						System.out.println("Si es rock d�gite 1, si es hip hop digite 2, si es m�sica cl�sica digite 3.");
						System.out.println("Si es reggae digite 4, si es salsa digite 5, o si es metal digite 6 .");
						songGenreNum = input.nextInt();
						input.nextLine();
				
						System.out.println(newServer.addSong(songName, songArtist, songDuration, songGenreNum, userName));
						break;
				
				case 3: 
						System.out.println("�Desea ponerle nombre a la playlist? Si es as� escriba el nombre a asignar, de lo contrario escriba: *NO*");
						playlistName = input.nextLine();
						
						System.out.println(newServer.addPublicPlaylist(playlistName));
						break;		
						
				case 4:
						System.out.println("�Desea ponerle nombre a la playlist? Si es as� escriba el nombre a asignar, de lo contrario escriba: *NO*");
						playlistName = input.nextLine();
						System.out.println(newServer.addPrivatePlaylist(playlistName));
						break;
						
				case 5: 
						System.out.println("�Desea ponerle nombre a la playlist? Si es as� escriba el nombre a asignar, de lo contrario escriba: *NO*");
						playlistName = input.nextLine();
						System.out.println(newServer.addRestrictedPlaylist(playlistName));
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
						System.out.println("�Cu�l es el n�mero de la playlist a la que quieres agregar la canci�n? Por favor, digitalo.");
						playChoosed = input.nextInt();
						
						System.out.println("�Cu�l es el n�mero de la canci�n que quieres agregar a la playlist? Por favor, digitalo.");
						System.out.println(newServer.displaySongs());
						songNum = input.nextInt();
						System.out.println(newServer.addSongToPlaylist(songNum, playChoosed));
						break;
						
				case 10:
						System.out.println("�Cu�l es la playlist a la que desea agregar la calificaci�n? Asegurese de que la playlist seleccionada sea p�blica.");
						playChoosed = input.nextInt();
						System.out.println("�Cu�l calificaci�n quieres darle? Ingresa un n�mero de 1 a 5, siendo 1 la calificaci�n m�s baja, y 5 la m�s alta.");
						rate = input.nextDouble();
						input.nextLine();
						System.out.println(newServer.addRate(playChoosed, rate));
						break;
						
				case 11:
						System.out.println("�Cu�l es la playlist a la que le quieres cambiar el nombre? Por favor ingresa su n�mero.");
						System.out.println(newServer.displayPlaylists());
						playChoosed = input.nextInt();
						input.nextLine();
						System.out.println("�Cu�l es el nombre que le quieres poner?");
						playlistName = input.nextLine();
						System.out.println(newServer.changePlaylistName(playChoosed, playlistName));
						break;
						
				case 12:
						System.out.println("�A cu�l playlist quieres agregar el usuario con acceso?");
						System.out.println(newServer.displayPlaylists());
						playChoosed = input.nextInt();
						System.out.println("�Cu�l es el usuario que quieres agregar?");
						System.out.println(newServer.displayUsers());
						userToAdd = input.nextInt();
						input.nextLine();
						System.out.println(newServer.addOwner(playChoosed, userToAdd));
						break;
						
				case 13:
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
