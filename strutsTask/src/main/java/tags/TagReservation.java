package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.epam.by.pojo.model.reservation.Customer;
import com.epam.by.pojo.model.reservation.FareFamily;
import com.epam.by.pojo.model.reservation.Reservation;

import fabrics.DaoObj;
import interfaces.IDao;

@SuppressWarnings("serial")
public class TagReservation extends TagSupport {
	private String component;
	private String var;

	public void setComponent(String component) {
		this.component = component;
	}
	

	public void setVar(String var) {
		this.var = var;
	}


	@Override
	public int doEndTag() throws JspException {
		IDao dao = new DaoObj().getDao();
		Reservation reservation = dao.getReservation();
		switch (component) {
			case "reservation": {
				pageContext.setAttribute(this.var, reservation);
				break;
			}
			case "customer": {
				Customer customer = reservation.getCustomer();
				pageContext.setAttribute(this.var, customer);
				break;
			}
			case "fareFamily": {
				FareFamily fareFamilies = reservation.getFareFamily();
				pageContext.setAttribute(this.var, fareFamilies);
				break;
			}
		}
		return SKIP_BODY;
	}

	@Override
	public int doStartTag() throws JspException {
		return EVAL_PAGE;
	}

}
