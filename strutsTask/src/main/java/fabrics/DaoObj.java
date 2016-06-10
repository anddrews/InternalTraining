package fabrics;

import bll.EJBDao;
import bll.XMLDao;
import interfaces.IDao;

public class DaoObj {
	public IDao getDao(){
		return new EJBDao();
	}
}
