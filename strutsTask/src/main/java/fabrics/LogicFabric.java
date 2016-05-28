package fabrics;

import bll.Logic;
import interfaces.ILogic;

public class LogicFabric {
	public ILogic getLogic(){
		return new Logic();
	}
}
