package fabrics;

import bll.XMLDao;
import interfaces.IDao;

public class DaoObj {
	public IDao getDao(){
		return new XMLDao();
	}
}
