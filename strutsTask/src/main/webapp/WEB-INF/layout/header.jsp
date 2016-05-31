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
		<div>
			<bean:message key="registration.jsp.login" />
			<html:text property="login" size="20" />
			<span class="error"><html:errors property="login" /></span>
		</div>
		<div>
			<bean:message key="registration.jsp.password" />
			<html:text property="passw" size="20" />
			<span class="error"><html:errors property="passw" /></span>
		</div>

		<html:submit property="submit">
			<bean:message key="registration.jsp.loginButton" />
		</html:submit>
		<span class="error"><html:errors property="incorrectLogin" /></span>

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
	<span class="nav-refer"> <html:link
			action="/registered/reservation">
		Reservation
	</html:link>
	</span>
	<span class="nav-refer"> <html:link
			action="/registered/customer">
		Customer
	</html:link>
	</span>
	<span class="nav-refer"> <html:link
			action="/registered/fareFamily">
		FairFamily
	</html:link>
	</span>
</logic:notEmpty>


