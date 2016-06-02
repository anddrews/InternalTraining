<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="custom.tld" prefix="datalex"%>

<datalex:getReservation component="customer"/>

<div class="container">
	<div class="table-responsive">

		<div class="input-group col-lg-4">
			<div class="input-group-addon"><bean:message key="customer.jsp.code"/></div>
			<div class="input-group-addon"><bean:write name="customer" property="name"/></div>
		</div>
		<div class="input-group col-lg-4">
			<div class="input-group-addon"><bean:message key="customer.jsp.email"/></div>
			<div class="input-group-addon"><bean:write name="customer" property="email.email"/></div>
		</div>
		<div class="input-group col-lg-4">
			<div class="input-group-addon"><bean:message key="customer.jsp.phone"/></div>
			<div class="input-group-addon"><bean:write name="customer" property="phone.phone"/></div>
		</div>
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
				<logic:iterate name="customer" property="paiments" id="pay"
					indexId="index">
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