package interfaces;


public interface ILogic {
	boolean checkLogin(String login, String passw);
	boolean isCanMove(boolean isUser, String refer);
}
