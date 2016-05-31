package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import fabrics.DaoObj;
import interfaces.IDao;
import models.Reservation;

public class TagReservation extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		IDao dao=new DaoObj().getDao();		
		Reservation reservation = dao.getReservation();
		pageContext.setAttribute("reservation", reservation);
		return SKIP_BODY;
	}

	@Override
	public int doStartTag() throws JspException {
		return EVAL_PAGE;
	}

	
}
