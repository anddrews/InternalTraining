package fabrics;

import bll.Logic;
import bll.LogicEJBImpl;
import interfaces.ILogic;

public class LogicFabric {
	public ILogic getLogic(){
		return new LogicEJBImpl();
	}
}
