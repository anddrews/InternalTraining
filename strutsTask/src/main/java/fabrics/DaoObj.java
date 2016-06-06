package fabrics;

import bll.EJBDao;
import interfaces.IDao;

public class DaoObj {
	public IDao getDao(){
		return new EJBDao();
	}
}
