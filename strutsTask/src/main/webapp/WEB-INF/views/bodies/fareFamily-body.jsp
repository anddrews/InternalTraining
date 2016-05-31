<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="custom.tld" prefix="datalex"%>

<datalex:getReservation />

<div class="container">
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th>№</th>
						<th><bean:message key="fareFamily.jsp.fareFamilyCode" /></th>
						<th><bean:message key="fareFamily.jsp.ancillaryAirComponentCode" /></th>
					</tr>
				</thead>
				<tbody>	
				<bean:define id="fare" name="reservation" property="fareFamily" />		
						<logic:iterate name="fare" property="ancillaryComponents" id="comp" indexId="index">
						<tr>
							<td><bean:write name="index" /></td>
							<td><bean:write name="fare" property="fareFamilyCode" /></td>
							<td><bean:write name="comp" property="ancillaryAirComponentCode" /></td>
						</tr>
						</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>