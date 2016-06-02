<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="custom.tld" prefix="datalex"%>

<datalex:getReservation component="fareFamily"/>

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
						<logic:iterate name="fareFamily" property="ancillaryComponents" id="comp" indexId="index">
						<tr>
							<td><bean:write name="index" /></td>
							<td><bean:write name="fareFamily" property="fareFamilyCode" /></td>
							<td><bean:write name="comp" property="ancillaryAirComponentCode" /></td>
						</tr>
						</logic:iterate>
				</tbody>
			</table>
		</div>
	</div>