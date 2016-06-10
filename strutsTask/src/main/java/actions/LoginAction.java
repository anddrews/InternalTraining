package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.epam.by.pojo.model.LoginInformation;

import actionsForms.LoginForm;
import fabrics.LogicFabric;
import interfaces.ILogic;
import models.User;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors = new ActionErrors();
		try {
			LoginForm loginForm = (LoginForm) form;
			String login = loginForm.getLogin();
			String passw = loginForm.getPassw();
			ILogic logic = new LogicFabric().getLogic();
			LoginInformation loginInformation=logic.checkLogin(login, passw);
			if (loginInformation.isLogin()) {
				request.getSession().setAttribute("user", new User(login));
				return mapping.findForward("success");
			} else {
				if("databaseProblem".equals(loginInformation.getAttach())){
					
					errors.add("incorrectLogin", new ActionMessage("registration.error.databaseProblem"));					
				}
				else{
				errors.add("incorrectLogin", new ActionMessage("registration.error.incorrectLogin"));					
				}
				return mapping.findForward("back");
			}
		} finally {
			if (errors != null && !errors.isEmpty()) {
				saveErrors(request, errors);
			}
		}
	}
}
