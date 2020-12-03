import java.io.IOException;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


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

	public String toString() {
		return line;
	}

}

class BookReader{
	private static Document doc;
	private static ArrayList<BookInfo> list = new ArrayList<BookInfo>();
	private static BookInfo bi;
	private static String out = "";
	private static Elements rank, title, author, price;
	public static ArrayList<BookInfo> readBooksJsoup(String url) {
		try {
			doc = Jsoup.connect(url).get();
			rank = doc.select("div.count");			
			title = doc.select("img").select(".Resolve.lp-lazy.full-shadow");
			author = doc.select("div.product-shelf-author.contributors").select("a[href]:first-child");
			price = doc.select("a").select(".current.link");
			for(int i=0; i<rank.size(); i++) {
				out = "#" +rank.get(i).text() + " " + title.get(i).attr("alt") + ", " + author.get(i).text() + ", " + price.get(i).text();
				bi = new BookInfo(out);
				list.add(bi);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}

public class Problem20 {
	public static void main(String[] args) {
		ArrayList<BookInfo> books;
		books = BookReader.readBooksJsoup("https://www.barnesandnoble.com/b/books/_/N-1fZ29Z8q8");
		Collections.sort(books);
		for(int i=0; i<books.size(); i++) {
			BookInfo book = books.get(i);
			System.out.println(book);
		}
	}
}