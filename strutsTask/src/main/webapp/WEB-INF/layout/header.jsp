<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<span class="lockal-change"> <html:link action="/localRU">
		<bean:message key="registration.jsp.ru" />
	</html:link>
</span>
<span class="lockal-change"> <html:link action="/localENG">
		<bean:message key="registration.jsp.eng" />
	</html:link>
</span>
<logic:empty name="user" scope="session">
	<html:form action="login" focus="login">
		<div class="input-group col-lg-3">
			<span class="input-group-addon" id="sizing-addon2"> <bean:message
					key="registration.jsp.login" /></span>
			<html:text property="login" size="20" styleClass="form-control" />
		</div>
		<span class="error"><html:errors property="login" /></span>
		<div class="input-group col-lg-3">
			<span class="input-group-addon" id="sizing-addon2"> <bean:message
					key="registration.jsp.password" /></span>
			<html:text property="passw" size="20" styleClass="form-control" />

		</div>
		<span class="error"><html:errors property="passw" /></span>
		<span class="error"><html:errors property="incorrectLogin" /></span>

		<html:submit property="submit">
			<bean:message key="registration.jsp.loginButton" />
		</html:submit>

	</html:form>
</logic:empty>
<logic:notEmpty name="user" scope="session">
	<html:form action="logout">
		<html:submit property="submit">
			<bean:message key="registration.jsp.logoutButton" />
		</html:submit>
	</html:form>
	<h2>
		<bean:write name="user" property="login" scope="session" />
	</h2>
	<ul class="nav nav-pills">
		<li role="presentation" class="active"><html:link
			action="/registered/reservation">
		<bean:message key="menu.jsp.refer.reservation" />
	</html:link></li>
		<li role="presentation"><html:link
			action="/registered/customer">
		<bean:message key="menu.jsp.refer.customer" />
	</html:link></li>
		<li role="presentation"><html:link
			action="/registered/fareFamily">
		<bean:message key="menu.jsp.refer.farefamily" />
	</html:link></li>
	<li role="presentation"><html:link
			action="/registered/restService">
		<bean:message key="menu.jsp.refer.restPage" />
	</html:link></li>
	</ul>
</logic:notEmpty>


