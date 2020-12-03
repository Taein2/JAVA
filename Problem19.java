import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

class BookInfo implements Comparable<BookInfo>{
	private String line;
	BookInfo(String line){
		this.line = line;
	}
	public int compareTo(BookInfo o) {
		return this.line.compareTo(o.getNum());
	}
	public String getNum() {
		return this.line.substring(1,2);
	}
	public String getLine() {
		return this.line;
	}
	public String toString() {
		return line;
	}
}

class BookReader{
	private static URL url = null;
	private static String line = "", out = "";
	private static BufferedReader input = null;
	private static BookInfo bi, bo;
	private static ArrayList<BookInfo> list = new ArrayList<BookInfo>();
	private static ArrayList<BookInfo> outList = new ArrayList<BookInfo>();
	private static int status = 0, begin , end;
	private static String author;
	public static ArrayList<BookInfo> readBooks(String address){
		try {
			url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			while((line = input.readLine()) != null) {
				if(line.trim().length() > 0) {
					bi = new BookInfo(line);
					list.add(bi);		
				}
			}
			input.close();
			for(int i=0; i < list.size(); i++) {
				bo = list.get(i);
				String l = bo.getLine();
				if(status == 0) {
					if(l.contains("div class=\"row topX-row\"")) status = 1;
				}else if(status ==1) {
					if(l.contains("div class=\"count\"")) {
						begin = l.indexOf("<div class=\"count\">") + "<div class=\"count\">".length();
						end = l.indexOf("</div>");
						out = "#" + l.substring(begin,end);
					}
					if(l.contains("class=\"full-shadow\" alt=\"")) {
						begin = l.indexOf("alt=\"") + "alt=\"".length();
						end = l.indexOf("\" />");
						out += " " + l.substring(begin,end).trim() +", ";
					}
					if(l.contains("div class=\"product-shelf-author contributors\"")) {
						begin = l.indexOf("\">") + "\">".length();
						end = l.indexOf("</a></div>");
						author = l.substring(begin).trim();
						begin = author.indexOf("\">") + "\">".length();
						end = author.indexOf("</a>");
						out += author.substring(begin, end).trim() + ", ";
					}
					if(l.contains("a title=\"\" class=\" current link\" onclick=\"set_cookie")) {
						begin = l.lastIndexOf("\">") + "\">".length();
						end = l.indexOf("</a></span>");
						out += l.substring(begin, end).trim();
						bo = new BookInfo(out);
						outList.add(bo);
					}
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
				return outList;
	}
}

public class Problem19 {
	public static void main(String[] args) {
		ArrayList<BookInfo> books;
		books = BookReader.readBooks("https://www.barnesandnoble.com/b/books/_/N-1fZ29Z8q8");
		Collections.sort(books);
		for(int i=0; i<books.size(); i++) {
			BookInfo book = books.get(i);
			System.out.println(book);
		}
	}
}

