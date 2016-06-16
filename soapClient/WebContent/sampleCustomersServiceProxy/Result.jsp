<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleCustomersServiceProxyid" scope="session" class="by.epam.interfaces.CustomersServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleCustomersServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleCustomersServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleCustomersServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        by.epam.interfaces.CustomersService getCustomersService10mtemp = sampleCustomersServiceProxyid.getCustomersService();
if(getCustomersService10mtemp == null){
%>
<%=getCustomersService10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String eMail_2id=  request.getParameter("eMail20");
            java.lang.String eMail_2idTemp = null;
        if(!eMail_2id.equals("")){
         eMail_2idTemp  = eMail_2id;
        }
        String phone_3id=  request.getParameter("phone22");
            java.lang.String phone_3idTemp = null;
        if(!phone_3id.equals("")){
         phone_3idTemp  = phone_3id;
        }
        String name_4id=  request.getParameter("name24");
            java.lang.String name_4idTemp = null;
        if(!name_4id.equals("")){
         name_4idTemp  = name_4id;
        }
        String id_5id=  request.getParameter("id26");
        int id_5idTemp  = Integer.parseInt(id_5id);
        %>
        <jsp:useBean id="by1epam1interfaces1Customer_1id" scope="session" class="by.epam.interfaces.Customer" />
        <%
        by1epam1interfaces1Customer_1id.setEMail(eMail_2idTemp);
        by1epam1interfaces1Customer_1id.setPhone(phone_3idTemp);
        by1epam1interfaces1Customer_1id.setName(name_4idTemp);
        by1epam1interfaces1Customer_1id.setId(id_5idTemp);
        boolean addNewCustomer15mtemp = sampleCustomersServiceProxyid.addNewCustomer(by1epam1interfaces1Customer_1id);
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addNewCustomer15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
break;
case 28:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg031");
        int arg0_6idTemp  = Integer.parseInt(arg0_6id);
        String arg1_7id=  request.getParameter("arg133");
            java.lang.String arg1_7idTemp = null;
        if(!arg1_7id.equals("")){
         arg1_7idTemp  = arg1_7id;
        }
        String arg2_8id=  request.getParameter("arg235");
            java.lang.String arg2_8idTemp = null;
        if(!arg2_8id.equals("")){
         arg2_8idTemp  = arg2_8id;
        }
        String arg3_9id=  request.getParameter("arg337");
            java.lang.String arg3_9idTemp = null;
        if(!arg3_9id.equals("")){
         arg3_9idTemp  = arg3_9id;
        }
        boolean updateCustomer28mtemp = sampleCustomersServiceProxyid.updateCustomer(arg0_6idTemp,arg1_7idTemp,arg2_8idTemp,arg3_9idTemp);
        String tempResultreturnp29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateCustomer28mtemp));
        %>
        <%= tempResultreturnp29 %>
        <%
break;
case 39:
        gotMethod = true;
        String arg0_10id=  request.getParameter("arg050");
        int arg0_10idTemp  = Integer.parseInt(arg0_10id);
        by.epam.interfaces.Customer getCustomerById39mtemp = sampleCustomersServiceProxyid.getCustomerById(arg0_10idTemp);
if(getCustomerById39mtemp == null){
%>
<%=getCustomerById39mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">eMail:</TD>
<TD>
<%
if(getCustomerById39mtemp != null){
java.lang.String typeeMail42 = getCustomerById39mtemp.getEMail();
        String tempResulteMail42 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeeMail42));
        %>
        <%= tempResulteMail42 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">phone:</TD>
<TD>
<%
if(getCustomerById39mtemp != null){
java.lang.String typephone44 = getCustomerById39mtemp.getPhone();
        String tempResultphone44 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typephone44));
        %>
        <%= tempResultphone44 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">name:</TD>
<TD>
<%
if(getCustomerById39mtemp != null){
java.lang.String typename46 = getCustomerById39mtemp.getName();
        String tempResultname46 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename46));
        %>
        <%= tempResultname46 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getCustomerById39mtemp != null){
%>
<%=getCustomerById39mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 52:
        gotMethod = true;
        by.epam.interfaces.Customer[] getAllCustomer52mtemp = sampleCustomersServiceProxyid.getAllCustomer();
if(getAllCustomer52mtemp == null){
%>
<%=getAllCustomer52mtemp %>
<%
}else{
        String tempreturnp53 = null;
        if(getAllCustomer52mtemp != null){
        java.util.List listreturnp53= java.util.Arrays.asList(getAllCustomer52mtemp);
/*         tempreturnp53 = listreturnp53.toString(); */
        tempreturnp53 = java.util.Arrays.toString(getAllCustomer52mtemp);
        }
        %>
        <%=tempreturnp53%>
        <%
}
break;
case 55:
        gotMethod = true;
        String arg0_11id=  request.getParameter("arg058");
        int arg0_11idTemp  = Integer.parseInt(arg0_11id);
        boolean removeCustomerById55mtemp = sampleCustomersServiceProxyid.removeCustomerById(arg0_11idTemp);
        String tempResultreturnp56 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(removeCustomerById55mtemp));
        %>
        <%= tempResultreturnp56 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>