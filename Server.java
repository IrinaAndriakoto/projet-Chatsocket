package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import affichage.*;
import inc.*;

public class Server {

 public static void main(String[] args) throws Exception {
 
	 final ServerSocket serveurSocket ;
	 final Socket socket ;
	 final BufferedReader in;
	 final PrintWriter out;
	 final Scanner sc=new Scanner(System.in);
	 
	 try {
		 serveurSocket = new ServerSocket(5000);
		 socket = serveurSocket.accept();
		 out = new PrintWriter(socket.getOutputStream());
		 in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		 Thread envoi= new Thread(new Runnable() {
			 String msg;
			 public void run() {
				 while(true){
					 msg = sc.nextLine();
					 out.println(msg);
					 out.flush();
				 }
			 }
		 });
		 envoi.start();
		 
		 Thread recevoir= new Thread(new Runnable() {
			 String msg ;
			 public void run() {
			 try {
				System.out.println("Connexion etablie.");
				System.out.println("En attente de message...");
				 msg = in.readLine();
				 while(msg!=null){
				 System.out.println("Client : "+msg);
				 msg = in.readLine();
				 }
				 out.close();
				 socket.close();
				 serveurSocket.close();
			 	} catch (IOException e) {
				 e.printStackTrace();
				 }
			 }
		 });
		 recevoir.start();
	 		 }
			 catch (Exception e) {
	 			throw new Exception("client deconnecte");
	 		 }
	 }
}