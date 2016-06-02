package tags;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import fabrics.DaoObj;
import interfaces.IDao;
import models.Customer;
import models.FareFamily;
import models.Reservation;

@SuppressWarnings("serial")
public class TagReservation extends TagSupport {
	private String component;

	public void setComponent(String component) {
		this.component = component;
	}

	@Override
	public int doEndTag() throws JspException {
		IDao dao = new DaoObj().getDao();
		Reservation reservation = dao.getReservation();
		switch (component) {
			case "reservation": {
				pageContext.setAttribute("reservation", reservation);
				break;
			}
			case "customer": {
				Customer customer = reservation.getCustomer();
				pageContext.setAttribute("customer", customer);
			}
			case "fareFamily": {
				FareFamily fareFamilies = reservation.getFareFamily();
				pageContext.setAttribute("fareFamily", fareFamilies);
			}
		}
		return SKIP_BODY;
	}

	@Override
	public int doStartTag() throws JspException {
		return EVAL_PAGE;
	}

}
