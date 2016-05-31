<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="custom.tld" prefix="datalex"%>

<datalex:getReservation />

<div class="container">
	<div class="table-responsive">
		<bean:define id="cust" name="reservation" property="customer" />
		<bean:write name="cust" property="name" />
		<bean:write name="cust" property="email.email" />
		<bean:write name="cust" property="phone.phone" />
		<table class="table">
			<thead>
				<tr>
					<th>№</th>
					<th><bean:message key="customer.jsp.payment.amount" /></th>
					<th><bean:message key="customer.jsp.payment.formOfPayment" /></th>
					<th><bean:message key="customer.jsp.payment.currencyCode" /></th>
				</tr>
			</thead>
			<tbody>
				<logic:iterate name="cust" property="paiments" id="pay" indexId="index">
					<tr>
						<td><bean:write name="index" /></td>
						<td><bean:write name="pay" property="amountPaid" /></td>
						<td><bean:write name="pay" property="formOfPaymentTypeCode" /></td>
						<td><bean:write name="pay" property="currencyCode" /></td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>
	</div>
</div>