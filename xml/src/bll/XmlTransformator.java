package bll;

import java.text.SimpleDateFormat;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Book;
import model.Passendger;
import model.Place;

public class XmlTransformator {
	
	Document document;
	
	
	public XmlTransformator(Document document) {
		this.document = document;
	}

	public  Element bookToXml(Book book){
		Element result=document.createElement("book");
		result.setAttribute("id", Integer.toString(book.getId()));
		result.appendChild(passendgertToXml(book.getPassendger()));
		result.appendChild(placeToXml("origin",book.getOrigin()));
		result.appendChild(placeToXml("destination",book.getDestination()));		
		return result;
	}
	
	private  Element placeToXml(String tagName, Place place){
		SimpleDateFormat formatDate=new SimpleDateFormat("yyyy-MM-dd");	
		SimpleDateFormat formatTime=new SimpleDateFormat("hh:mm:ss");	

		
		Element result=document.createElement(tagName);
		Element placeXml=document.createElement("place");
		Element data=document.createElement("date");
		Element time=document.createElement("time");
		
		placeXml.appendChild(document.createTextNode(place.getName()));
		data.appendChild(document.createTextNode(formatDate.format(place.getDate())));
		time.appendChild(document.createTextNode(formatTime.format(place.getDate())));
		
		result.appendChild(placeXml);
		result.appendChild(data);
		result.appendChild(time);
		return result;
		
	}
	
	private  Element passendgertToXml(Passendger passendger){
		Element result=document.createElement("passendger");
		Element firstName=document.createElement("firstname");
		Element lastName=document.createElement("lastname");
		Element adress=document.createElement("adress");
		Element city=document.createElement("city");
		Element street=document.createElement("street");
		Element house=document.createElement("house");
		
		house.appendChild(document.createTextNode(Integer.toString(passendger.getHouse())));
		street.appendChild(document.createTextNode(passendger.getStreet()));
		city.appendChild(document.createTextNode(passendger.getCity()));
		adress.appendChild(city);
		adress.appendChild(street);
		adress.appendChild(house);
		firstName.appendChild(document.createTextNode(passendger.getFirstName()));
		lastName.appendChild(document.createTextNode(passendger.getLastName()));
		result.appendChild(firstName);
		result.appendChild(lastName);
		result.appendChild(adress);
		return result;
		
	}
	
	public Book buildBook(Element book){
		Book result=new Book();
		result.setId(Integer.parseInt(book.getAttribute("id")));
		Element passendger=(Element) book.getElementsByTagName("passendger").item(0);
		result.setFirstName(getElementTextContent(passendger, "firstname"));
		result.setLastName(getElementTextContent(passendger, "lastname"));
		Element adress=(Element) book.getElementsByTagName("adress").item(0);
		result.setCity(getElementTextContent(adress, "city"));
		result.setStreet(getElementTextContent(adress, "street"));
		result.setHouse(Integer.parseInt(getElementTextContent(adress, "house")));
		Element origin=(Element) book.getElementsByTagName("origin").item(0);
		String place=getElementTextContent(origin, "place");
		String date=getElementTextContent(origin, "date");
		String time=getElementTextContent(origin, "time");
		result.setOrigin(place, date+" "+time);
		Element destination=(Element) book.getElementsByTagName("destination").item(0);
		place=getElementTextContent(destination, "place");
		date=getElementTextContent(destination, "date");
		time=getElementTextContent(destination, "time");
		result.setDestination(place, date+" "+time);
		return result;
		
	}
	
	private static String getElementTextContent(Element element, String elementName) {
		 NodeList nList = element.getElementsByTagName(elementName);
		 Node node = nList.item(0);
		 String text = node.getTextContent();
		 return text;
	}

}
