package bll;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.epam.by.pojo.model.reservation.Reservation;

import interfaces.IDao;
import models.Properties;

public class XMLDao implements IDao {
	
	public XMLDao() {
	}

	public Reservation getReservation() {
		Reservation result=new Reservation(); 
		try {

			 	File file = new File(Properties.getPathToXml());
				JAXBContext jaxbContext = JAXBContext.newInstance(Reservation.class);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				result = (Reservation) jaxbUnmarshaller.unmarshal(file);

			  } catch (JAXBException e) {
				e.printStackTrace();
			  }
		
		return result;
	}

}
