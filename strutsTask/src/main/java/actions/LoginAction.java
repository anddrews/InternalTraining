package actions;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;


import actionsForms.LoginForm;
import fabrics.LogicFabric;
import interfaces.ILogic;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionErrors errors=new ActionErrors();
		try{
			
			LoginForm loginForm=(LoginForm)form;
//			if("login".equals(loginForm.getAction())){
				String login=loginForm.getLogin();
				String passw=loginForm.getPassw();
				ILogic logic=new LogicFabric().getLogic();
				if(logic.checkLogin(login, passw)){
					request.setAttribute("user", login);
					return mapping.findForward("success");
				}
				else{
					errors.add(ActionErrors.GLOBAL_MESSAGE,new ActionMessage("error.login.incorrectLoginOrPassword"));
					return mapping.findForward("back");
				}
//			}
//			else{
//				return mapping.findForward("back");
//			}
		}
		finally{
			if(errors!=null && !errors.isEmpty()){
				saveErrors(request,errors);
			}
		}		
	}
}
