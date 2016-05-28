package test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import models.Reservation;

public class Runner {

	public static void main(String[] args) {
		 try {

			 	File file = new File("D:\\epam\\InternalTraining\\Reservation.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Reservation.class);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Reservation customer = (Reservation) jaxbUnmarshaller.unmarshal(file);
				System.out.println(customer);

			  } catch (JAXBException e) {
				e.printStackTrace();
			  }
	}

}
