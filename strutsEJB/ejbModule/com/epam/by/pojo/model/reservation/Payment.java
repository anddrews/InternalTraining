package com.epam.by.pojo.model.reservation;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="AmountPaid")
	private String amountPaid;
	@XmlAttribute(name="FormOfPaymentTypeCode")
	private String formOfPaymentTypeCode;
	@XmlAttribute(name="CurrencyCode")	
	private String currencyCode;

	public Payment() {
	}

	public Payment(String amountPaid, String formOfPaymentTypeCode, String currencyCode) {
		this.amountPaid = amountPaid;
		this.formOfPaymentTypeCode = formOfPaymentTypeCode;
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return "\nPayment [amountPaid=" + amountPaid + ", formOfPaymentTypeCode=" + formOfPaymentTypeCode
				+ ", currencyCode=" + currencyCode + "]";
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getFormOfPaymentTypeCode() {
		return formOfPaymentTypeCode;
	}

	public void setFormOfPaymentTypeCode(String formOfPaymentTypeCode) {
		this.formOfPaymentTypeCode = formOfPaymentTypeCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	
	
	
}
