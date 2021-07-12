package cse3040fp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


//book 정렬
class Book implements Comparable<Book>{
	private String title;
	private String author;
	private String borrower;
	Book(String title, String author, String borrower){
		this.title = title;
		this.author = author;
		this.borrower = borrower;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getBorrower() {
		return this.borrower;
	}
	public int compareTo(Book o) {
		return this.title.compareToIgnoreCase(o.getTitle());
	}
	
}
class BookStore{
	// Book 추가
	private static ArrayList<Book> list = null;
	private static ArrayList<Book> resultList = null;
	private static BufferedReader br = null;
	private static BufferedWriter fw = null;
	private static String str[];
	private static String line = "";
	private static Book item;
	private static Iterator<Book> it;
	private static File file = null, temp = null;

	public static ArrayList<Book> insertBook(String txt,String title, String author){
		list = null;
		item = null;
			try {
			file = new File(txt);
			if(file.exists() == false) {
				file.createNewFile();
			}
			br = new BufferedReader(new FileReader(file));
			list = new ArrayList<Book>();
			while(true) {
				line = br.readLine();
				if(line == null || line.length() == 0) {
					break;
				}else {
					str = line.split("\t");
					if( str[0].toLowerCase().equals(title.toLowerCase())) {
						list.clear();
						return null;
					}
					item = new Book(str[0], str[1],str[2]);
					list.add(item);
				}
			}
			if(file.exists()) {
				file.delete();				
			}	
		}catch(IOException e) {			
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		item = new Book(title, author, "-");
		list.add(item);
		try {
			temp = new File(txt);				
			fw = new BufferedWriter(new FileWriter(temp));
			if(!temp.exists()) {
				temp.createNewFile();
			}
			Collections.sort(list);
			
			line = "";
			it = list.iterator();
			while(it.hasNext()) {
				item = it.next();
				fw.write(item.getTitle() + "\t" + item.getAuthor() + "\t" + item.getBorrower() +"\r\n");
			}
			fw.flush();
			fw.close();
			temp.renameTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	// Book 대출
	public static ArrayList<Book> borrowBook(String txt, String id, String title){
		list = null;
		item = null;
		resultList = null;
		boolean flag = false;
		try {
			file = new File(txt);
			if(file.exists() == false) {
				file.createNewFile();
			}
			br = new BufferedReader(new FileReader(file));
			list = new ArrayList<>();
			resultList = new ArrayList<>();
			flag = false;
			while(true) {
				line = br.readLine();
				if(line == null || line.length() == 0) {
					break;
				}else {
					str = line.split("\t");
					if(str[0].toLowerCase().equals(title.toLowerCase())) {
						flag = true;
						if(str[2].equals("-")) {
							str[2] = id;
							Book item2 = new Book(str[0], str[1], str[2]);
							resultList.add(item2);
						}else {
							list.clear();
							return null;
						}
					}
					item = new Book(str[0], str[1],str[2]);	
					list.add(item);
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			if(list.isEmpty() || flag == false){
				return null;
			}
			if(file.exists()) {
				file.delete();				
			}
			it = list.iterator();
			temp = new File(txt);
			fw = new BufferedWriter(new FileWriter(temp));
			while(it.hasNext()) {
				item = it.next();
				fw.write(item.getTitle() + "\t" + item.getAuthor() + "\t" + item.getBorrower() +"\r\n");			
			}
			temp.renameTo(file);

			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultList;
	}
	// Book 반납
	public static ArrayList<Book> returnBook(String txt, String id, String title){
		list = null;
		item = null;
		resultList = null;
		boolean flag = false;
		try {
			file = new File(txt);
			if(file.exists() == false) {
				file.createNewFile();
			}
			br = new BufferedReader(new FileReader(file));
			list = new ArrayList<>();
			resultList = new ArrayList<>();
			flag = false;
			while(true) {
				line = br.readLine();
				if(line == null || line.length() == 0) {
					break;
				}else {
					str = line.split("\t");
					if(str[0].toLowerCase().equals(title.toLowerCase())) {
						flag = true;
						if(str[2].equals(id)) {
							str[2] = "-";
							Book item2 = new Book(str[0], str[1], str[2]);
							resultList.add(item2);
						}else {
							list.clear();
							return null;
						}
					}
					item = new Book(str[0], str[1],str[2]);	
					list.add(item);
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			if(list.isEmpty() || flag == false){
				return null;
			}
			if(file.exists()) {
				file.delete();				
			}
			it = list.iterator();
			temp = new File(txt);
			fw = new BufferedWriter(new FileWriter(temp));
			while(it.hasNext()) {
				item = it.next();
				fw.write(item.getTitle() + "\t" + item.getAuthor() + "\t" + item.getBorrower() +"\r\n");			
			}
			temp.renameTo(file);

			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultList;

	}
	//id의 빌린 Book List
	public static ArrayList<Book> infoBook(String txt, String id){
		list = null;
		item = null;
		boolean flag = false;
		try {
			file = new File(txt);
			if(file.exists() == false) {
				file.createNewFile();
			}
			br = new BufferedReader(new FileReader(file));
			list = new ArrayList<>();
			flag = false;
			while(true) {
				line = br.readLine();
				if(line == null || line.length() == 0) {
					break;
				}else {
					str = line.split("\t");
					if(str[2].equals(id)) {
						flag = true;
						item = new Book(str[0], str[1],str[2]);	
						list.add(item);
					}
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(list.isEmpty() || flag == false){
			return null;	
		}
			

		return list;

	}
	//word로 책, 작가 찾기
	public static ArrayList<Book> searchBook(String txt, String word){
		list = null;
		item = null;
		boolean flag = false;
		try {
			file = new File(txt);
			if(file.exists() == false) {
				file.createNewFile();
			}
			br = new BufferedReader(new FileReader(file));
			list = new ArrayList<>();
			while(true) {
				line = br.readLine();
				if(line == null || line.length() == 0) {
					break;
				}else {
					str = line.split("\t");
					if(word.length() > 2 && (str[0].toLowerCase().contains(word.toLowerCase()) || str[1].toLowerCase().contains(word.toLowerCase()))) {
						System.out.println("들어옴");
						item = new Book(str[0], str[1],str[2]);	
						list.add(item);
					}
				}
			}
			if(list.isEmpty() || list.size() == 0){
				return null;	
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

}

//For Multiple Client
class ServerThread extends Thread{
	private Socket socket;
	private InputStream in = null;
	private DataInputStream dis = null;
	private OutputStream out = null;
	private DataOutputStream dos = null;
	private String str = null, login = null, id = null , title = null, author = null, word = null;
	private ArrayList<Book> list = null;
	private char loginCk;
	private boolean ck = false;
	private Iterator<Book> it;
	private Book item;
	private int cnt=0;
	private boolean flag = false, flag2= false;
	ServerThread(Socket socket){
		this.socket = socket;
	}
	public void run() {
		try {
			in = socket.getInputStream();
			dis = new DataInputStream(in);
			out = socket.getOutputStream();
			dos = new DataOutputStream(out);
			flag = true;
		}catch(IOException e) {
			return;
		}
		while(flag) {
			try {
				login = dis.readUTF();
				if(login.length() == 0 || login == null) {
					dos.writeUTF("UserID must be a single word with lowercase alphabets and numbers.");
				}
				else {
					for(int i =0; i< login.length(); i++) {
						loginCk = login.charAt(i);
						if( (loginCk >= 0x61 && loginCk <= 0x7A) || (loginCk >= 0x30 && loginCk <= 0x39) && loginCk != ' ') {
							ck = true;
						}else {
							ck = false;
							dos.writeUTF("UserID must be a single word with lowercase alphabets and numbers.");	
							break;
						}
					}
				}
				
			}catch(IOException e) {
			}
			if(ck) {
				try {
					id = login;
					dos.writeUTF("Hello " + id + "!");
					System.out.println(id +"접속 성공");
					flag2 = true;
					while(flag2) {
						try {
							//쓰기
							if(str == null || str.length() == 0) {
								dos.writeUTF(id +">> ");
							}else {								
								dos.writeUTF(str + id +">> ");
							}
							str = dis.readUTF();
							if(str.equals("add")) {
								str = "";
								dos.writeUTF("add-title> ");
								title = dis.readUTF();
								if(title == null || title.length() == 0) {
									continue;
								}else {
									dos.writeUTF("add-author> ");
									author = dis.readUTF();
									if(author == null || author.length() == 0) {
										continue;
									}else {
										list = BookStore.insertBook("books.txt", title, author);
										if(list == null) {
											str = "The book already exists in the list.\r\n";
										}else {
											str = "A new book added to the list.\r\n";
											list = null;
										}
									}
								}
							}else if(str.equals("borrow")) {
								str = "";
								dos.writeUTF("borrow-title> ");
								title = dis.readUTF();
								if(title == null || title.length() == 0) {
									continue;
								}else {
									list = BookStore.borrowBook("books.txt", id ,title);
									if(list == null) {
										str = "The book is not available.\r\n";
									}else {
										it = list.iterator();
										while(it.hasNext()) {
											item = it.next();
											str = "You borrowed a book. - " + item.getTitle() + "\r\n";
										}
										list = null;
									}
								}
							}else if(str.equals("return")) {
								str = "";
								dos.writeUTF("return-title> ");
								title = dis.readUTF();
								if(title == null || title.length() == 0) {
									continue;
								}else {
									list = BookStore.returnBook("books.txt", id ,title);
									if(list == null) {
										str = "You did not borrow the book.\r\n";
									}else {
										it = list.iterator();
										while(it.hasNext()) {
											item = it.next();
											str = "You returned a book. - " + item.getTitle() + "\r\n";
										}
										list = null;
									}
								}
							}else if(str.equals("info")) {
								str = "";
								list = BookStore.infoBook("books.txt", id);
								cnt = 0;
								if(list == null) {
									str = "You are currently borrowing "+ cnt +" books:\r\n";
								}else {
									cnt=1;
									it = list.iterator();
									str = "You are currently borrowing "+list.size()+" books:\r\n";
									while(it.hasNext()) {
										item = it.next();
										str += cnt + ". " + item.getTitle() + ", " +item.getAuthor() +"\r\n";
										cnt++;
									}
									list = null;
								}
							}else if(str.equals("search")) {
								str = "";
								dos.writeUTF("search-string> ");
								word = dis.readUTF();
								if(word == null || word.length() == 0) {
									str = "You can print available prompt list.\r\n";
									continue;
								}else {
									while(true) {
										if(word.length() < 3) {
											str = "Search string must be longer than 2 characters.\r\n";
											dos.writeUTF(str + "search-string> ");
											word = dis.readUTF();
										}else {
											list = BookStore.searchBook("books.txt",word);
											cnt = 0;

											if(list == null) {
												str = "Your search matched "+ cnt +" results.\r\n";
												break;
											}else {
												cnt=1;
												it = list.iterator();
												str = "Your search matched "+list.size()+" results.\r\n";
												while(it.hasNext()) {
													item = it.next();
													str += cnt + ". " + item.getTitle() + ", " +item.getAuthor() +"\r\n";
													cnt++;
												}
												list = null;
												break;
											}
										}
									}
								}
							}else{
								str = "[available commands]\r\n"
									+ "add: add a new book to the list of books.\r\n"
									+ "borrow: borrow a book from the library.\r\n"
									+ "return: return a book to the library.\r\n"
									+ "info: show list of books I am currently borrowing.\r\n"
									+ "search: search for books.\r\n";
							}
						}catch(Exception e) {		
							flag2 = false;
						}
						
					}
				}catch(Exception e) {
				}finally {
					flag = false;
					System.out.println(id + "접속 종료");
				}
			}
		}
	}
}
public class Server {
	private static final int portNum = 7777;
	public static void main(String[] args) {
		if(args.length == 1) {
		ServerSocket serverSocket = null;
			if(portNum == Integer.parseInt(args[0])) {
				try {
					serverSocket = new ServerSocket(portNum);
				}catch(IOException e) {
					e.printStackTrace();
				}
				try {
					while(true) {
						Socket socket = serverSocket.accept();
						ServerThread st = new ServerThread(socket);
						st.start();
					}					
				}catch(IOException e) {	
					e.printStackTrace();
				}finally {
					try {
						serverSocket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}else {
				System.out.print("Server port number set 7777");
			}
		}else {
			System.out.print("Please give the port number as an argument.");
		}	
	}
}
