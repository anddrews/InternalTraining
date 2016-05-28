<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>

    <head>
        <title><bean:message key="registration.jsp.title"/></title>
        <style type="text/css">
            .error { color: red; font-weight:bold }
        </style>
    </head>    
    <body>
        
        <h1><bean:message key="registration.jsp.heading"/></h1>
    
        <logic:present name="registration-successful" scope="request">
            <h2>    
                <bean:message key="registration.jsp.registration-successful"/>   
                <bean:write name="registration-successful" property="userid" />
            </h2>
        </logic:present>

        <logic:notPresent name="registration-successful" scope="request">
            <html:form action="login" focus="userid">

                <dl>
                    <dt><bean:message key="registration.jsp.prompt.userid"/></dt>            
                    <dd>
                        <html:text property="login" size="20" />
                        <span class="error"><html:errors property="login" /></span>
                    </dd>

                    <dt><bean:message key="registration.jsp.prompt.password"/></dt>            
                    <dd>
                        <html:text property="passw" size="20" />
                        <span class="error"><html:errors property="passw" /></span>    
                    </dd>                    

                    <dt><html:submit property="submit" value="Submit"/>
                        <html:reset/>
                    </dt>            
                </dl>
                        
            </html:form>
        </logic:notPresent>
    
    </body>
</html:html>

