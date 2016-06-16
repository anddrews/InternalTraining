package messageDrive;

import javax.ejb.EJBException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MDBBean implements MessageDrivenBean, MessageListener{
	
	private MessageDrivenContext ctx = null;
	private QueueConnection conn;
	private QueueSession session;
	
	
	public void ejbCreate() {

		try {
			Context context = new InitialContext();
			QueueConnectionFactory qcf = (QueueConnectionFactory) context.lookup("java:comp/env/jms/QCF");
			conn = qcf.createQueueConnection();
			session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			conn.start();

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
	
	public void onMessage(Message arg0) {
		try {

			System.out.println("message received");
			System.out.println("-------------------The messege ->" + ((TextMessage) arg0).getText());

		} catch (JMSException e) {

			e.printStackTrace();

		}		
	}

	public void ejbRemove() throws EJBException {
		ctx = null;
		try {
			if (session != null) {
				session.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

	public void setMessageDrivenContext(MessageDrivenContext arg0) throws EJBException {
		this.ctx = arg0;		
	}

}
