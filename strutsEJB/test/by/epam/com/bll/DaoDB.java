package by.epam.com.bll;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.epam.by.pojo.IFaces.IDao;
import com.epam.by.pojo.bll.MySQLQueryMaker;
import com.epam.by.pojo.model.UserEntity;

public class DaoDB implements IDao {

	public UserEntity getUser(String login, String passw) {
		
		String problemWithDao = "databaseProblem";
		String incorrectLoginOrPassw = "incorrectData";
		String query = "Select * from USERS where login=? and passw=?";
		
		UserEntity result = new UserEntity();
		ResultSet resSet = null;		


		try {
			resSet = MySQLQueryMaker.exequteQuery(query, login, passw);
			while (resSet.next()) {
				result.setLogin(resSet.getString(2));
			}
			if ("".equals(result.getLogin())) {

				result.setAttachInformation(incorrectLoginOrPassw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result.setAttachInformation(problemWithDao);
		} catch (NamingException e) {
			result.setAttachInformation(problemWithDao);
			e.printStackTrace();
		} 

		return result;
	}

}
