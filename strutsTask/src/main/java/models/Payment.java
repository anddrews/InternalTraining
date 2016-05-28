package models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Payment")
public class Payment {
	@XmlAttribute(name="AmountPaid")
	private String amountPaid;
	@XmlAttribute(name="FormOfPaymentTypeCode")
	private String formOfPaymentTypeCode;
	@XmlAttribute(name="CurrencyCode")	
	private String currencyCode;

	public Payment() {
	}

	public Payment(String amountPaid, String formOfPaymentTypeCode, String currencyCode) {
		super();
		this.amountPaid = amountPaid;
		this.formOfPaymentTypeCode = formOfPaymentTypeCode;
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return "\nPayment [amountPaid=" + amountPaid + ", formOfPaymentTypeCode=" + formOfPaymentTypeCode
				+ ", currencyCode=" + currencyCode + "]";
	}
	
	
	
	
}
