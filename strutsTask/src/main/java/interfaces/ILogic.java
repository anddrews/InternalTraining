package interfaces;

import models.User;

public interface ILogic {
	boolean checkLogin(User user);
	boolean isCanMove(boolean isUser, String refer);
}
