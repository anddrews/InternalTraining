package bll;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Book;

public class XmlUtil {
	
	private static final String XSI_NAMESPACE ="http://www.w3.org/2001/XMLSchema-instance";
	private static final String TNS_NAMESPACE ="http://www.example.org/books";
	private static final String SHEME_LOCATION ="books.xsd";
	
	public static List<Book> readPassengersFromFile(String fileName) {
		List<Book> books = new ArrayList<>();
		Document doc = null;
		DocumentBuilder docBuilder;
		
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			docBuilder = dbFactory.newDocumentBuilder();
			doc = docBuilder.parse(fileName);
			XmlTransformator transformator=new XmlTransformator(doc);
			Element root = doc.getDocumentElement();
			NodeList nList = root.getElementsByTagName("book");
			
			for (int i = 0; i < nList.getLength(); i++){
				Element bookElement = (Element) nList.item(i);
				Book book = transformator.buildBook(bookElement);
				books.add(book);
			}
			
		} catch (IOException e) {
			System. err.println("File error or I/O error: " + e);
		}catch (ParserConfigurationException e) {
			System. err.println("Parsing failure: " + e);
		} catch (SAXException e) {
			System. err.println("SAX failure: " + e);
		}
		return books;
		
	}
	
	public static void exportCatalogToXML(String fileName, List<Book> books) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = documentBuilder.newDocument();
			Element rootElement = doc.createElement("psg:books");
			rootElement.setAttribute("xmlns:xsi",XSI_NAMESPACE);
			rootElement.setAttribute("xmlns:psg",TNS_NAMESPACE);
			rootElement.setAttribute("xsi:noNamespaceSchemaLocation",SHEME_LOCATION);
			XmlTransformator transformator=new XmlTransformator(doc);
			for (Book tmp:books){				
				rootElement.appendChild(transformator.bookToXml(tmp));				
			}
			doc.appendChild(rootElement);
			TransformerFactory transformerFactory = TransformerFactory. newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new FileWriter(fileName));
			transformer.transform(source, result);			
			
		} catch (ParserConfigurationException | IOException | TransformerException e) {
			e.printStackTrace();
		} 

	}	
		
}

	

