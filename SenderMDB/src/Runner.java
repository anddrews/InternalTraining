import javax.jms.JMSException;
import javax.naming.NamingException;

import com.epam.by.bll.MDBSender;

public class Runner {
	public static void main(String args[] ){

		String factory="org.jnp.interfaces.NamingContextFactory";
		String providerURL="localhost:1099";
		try {
			MDBSender sender=new MDBSender(factory, providerURL);
			sender.sendMessage("second message");
			sender.sessionClose();
			System.out.println("lkjlkjlklklk");
		} catch (NamingException | JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
