package cse3040fp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

class ClientThread extends Thread{
	private Socket socket = null;
	private InputStream in = null;
	private DataInputStream dis = null;
	private OutputStream out = null;
	private DataOutputStream dos = null;
	private String str = null, login=null;
	private Scanner sc = null;
	ClientThread(Socket socket){
		this.socket = socket;
	}
	public void run() {
		try {
			in = socket.getInputStream();
			dis = new DataInputStream(in);
			out = socket.getOutputStream();
			dos = new DataOutputStream(out);
			sc = new Scanner(System.in);
		}catch(IOException e) {
			
		}
		while(true) {
			try {
				System.out.print("Enter userID>> ");
				login = sc.nextLine();
				dos.writeUTF(login);
				login = dis.readUTF();
				if(login.contains("Hello")) {
					System.out.println(login);
					while(true) {
						try {
							//읽고
							str = dis.readUTF();
							System.out.print(str);
							//쓰고
							str = sc.nextLine();
							dos.writeUTF(str);
					
						}catch(Exception e) {
							
						}
					}
				}else {
					System.out.println(login);
					
				}
			}catch(IOException e) {
				
			}
		}
	}
}
public class Client {
	private static final String serverIp = "127.0.0.1";
	private static final int portNum = 7777;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length == 2) {
			Socket socket = null;
			if(serverIp.equals(args[0]) && portNum == Integer.parseInt(args[1])) {
				try {
					socket = new Socket(serverIp, portNum);
					if(socket.isConnected()){
						try {
							ClientThread ct = new ClientThread(socket);
							ct.start();
								
						} catch (Exception e) {
						}
					}
				}catch(ConnectException ce) {
					System.out.print("Connection establishment failed.");
					return;
				}catch(IOException ie) {
				}catch(Exception e) {
				}
			}else {	
				System.out.print("Connection establishment failed.");					
			}
		}
		else {
		System.out.print("Please give the IP address and port number as arguments.");
		}
	}
}
