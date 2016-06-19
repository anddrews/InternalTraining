package com.epam.by.pojo.fabric;

import com.epam.by.pojo.IFaces.IDao;
import com.epam.by.pojo.bll.DaoDB;

public class FabricDao{
	 public IDao getDao(){
		return new DaoDB();		
	}
}
