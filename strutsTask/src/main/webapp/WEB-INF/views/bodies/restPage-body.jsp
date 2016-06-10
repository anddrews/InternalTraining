<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="custom.tld" prefix="datalex"%>


	        		<h2><bean:message key="datalex.jsp.rest.welcome"/></h2>
	        		<p> <bean:message key="datalex.jsp.rest.customerList" /></p>
	        		<table class="table table-hover table-rest">
	        			<tr>
	        				<th>id</th>
	        				<th>phone</th>
	        				<th>email</th>
	        			</tr>
	        			<logic:iterate name="allReservation" id="resComps">
	        				<tr>
        			        	<td><bean:write name="resComps" property="id" /></td>
        			        	<td><bean:write name="resComps" property="phone" /></td>
        			        	<td><bean:write name="resComps" property="email" /></td></td>
        					</tr>
	        			</logic:iterate>
	        		</table>
	        		<p> <bean:message key="datalex.jsp.rest.customerForId" />
	        		  <bean:write name="ReservationById" property="id" />
	        		  </p>
	        		<table class="table table-hover table-rest">
	        			<tr>
	        				<th>id</th>
	        				<th>phone</th>
	        				<th>email</th>
	        			</tr>
	        			
	        				<tr>
        			        	<td><bean:write name="ReservationById" property="id" /></td>
        			        	<td><bean:write name="ReservationById" property="phone" /></td>
        			        	<td><bean:write name="ReservationById" property="email" /></td></td>
        					</tr>
	        			
	        		</table>
	        		<p> <bean:message key="datalex.jsp.rest.customerAdd" /></p>
	        		<table class="table table-hover table-rest">
	        			<tr>
	        				<th>id</th>
	        				<th>phone</th>
	        				<th>email</th>
	        			</tr>
	        			<logic:iterate name="ReservationAdd" id="resAdd">
	        				<tr>
        			        	<td><bean:write name="resAdd" property="id" /></td>
        			        	<td><bean:write name="resAdd" property="phone" /></td>
        			        	<td><bean:write name="resAdd" property="email" /></td></td>
        					</tr>
	        			</logic:iterate>
	        		</table>
	        		<p> <bean:message key="datalex.jsp.rest.customerUpdate" />  <bean:write name="updateId" /></p>
	        		<table class="table table-hover table-rest">
	        			<tr>
	        				<th>id</th>
	        				<th>phone</th>
	        				<th>email</th>
	        			</tr>
	        			<logic:iterate name="ReservationAfterUpdate" id="resUp">
	        				<tr>
        			        	<td><bean:write name="resUp" property="id" /></td>
        			        	<td><bean:write name="resUp" property="phone" /></td>
        			        	<td><bean:write name="resUp" property="email" /></td></td>
        					</tr>
	        			</logic:iterate>
	        		</table>
	        		<p> <bean:message key="datalex.jsp.rest.customerDelete" />  <bean:write name="deleteId" /></p>
	        		<table class="table table-hover table-rest">
	        			<tr>
	        				<th>id</th>
	        				<th>phone</th>
	        				<th>email</th>
	        			</tr>
	        			<logic:iterate name="ReservationDelete" id="resDel" >
        			        	<td><bean:write name="resDel" property="id" /></td>
        			        	<td><bean:write name="resDel" property="phone" /></td>
        			        	<td><bean:write name="resDel" property="email" /></td></td>
        					</tr>
	        			</logic:iterate>
	        		</table>
