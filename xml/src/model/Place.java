package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Place {
	private String name;
	private Date date;
	
	

	public Place() {
		this.name = "";
		this.date = null;
	}

	public Place(String name, Date date) {
		this.name = name;
		this.date = date;
	}
	public Place(String name) {
		this.name = name;
		this.date = null;
	}

	public Place(String name, String date) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");	
		this.name = name;
		this.date=format.parse(date);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", date=" + date + "]";
	}
	
	
	
}
