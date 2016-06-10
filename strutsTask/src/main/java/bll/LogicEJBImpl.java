package bll;

import javax.naming.Context;
import javax.rmi.PortableRemoteObject;

import com.epam.by.IFacesHome.LogicEJBHome;
import com.epam.by.IFacesRemote.LogicEJB;
import com.epam.by.pojo.model.LoginInformation;

import interfaces.ILogic;


public class LogicEJBImpl implements ILogic {

	@Override
	public LoginInformation checkLogin(String login, String passw) {
		LoginInformation result=new LoginInformation();
		try {
			Context jndiContext = new EjbContext().getContext();
			Object ref = jndiContext.lookup("LogicEJBName");
			LogicEJBHome home = (LogicEJBHome) PortableRemoteObject.narrow(ref,
					LogicEJBHome.class);
			LogicEJB logicEjb = home.create();
			result=logicEjb.checkLogin(login, passw);
			
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return result;
	}

}
