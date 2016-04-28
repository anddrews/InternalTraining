import java.util.List;

import bll.XmlUtil;
import model.Book;

public class Runner {

	public static void main(String[] args) {
		List<Book> books;
		
		books=XmlUtil.readPassengersFromFile("src/resources/books.xml");
		for(Book tmp:books){
			System.out.println(tmp);
		}
		
		XmlUtil.exportCatalogToXML("src/resources/books_new.xml", books);

	}

}
