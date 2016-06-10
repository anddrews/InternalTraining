package interfaces;

import com.epam.by.pojo.model.LoginInformation;

public interface ILogic {
	LoginInformation checkLogin(String login, String passw);
}
