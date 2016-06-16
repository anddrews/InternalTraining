/**
 * CustomerServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package by.epam.bll;

public class CustomerServiceImplServiceLocator extends org.apache.axis.client.Service implements by.epam.bll.CustomerServiceImplService {

    public CustomerServiceImplServiceLocator() {
    }


    public CustomerServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CustomerServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CustomerServiceImplPort
    private java.lang.String CustomerServiceImplPort_address = "http://localhost:8080/soapServer/service";

    public java.lang.String getCustomerServiceImplPortAddress() {
        return CustomerServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CustomerServiceImplPortWSDDServiceName = "CustomerServiceImplPort";

    public java.lang.String getCustomerServiceImplPortWSDDServiceName() {
        return CustomerServiceImplPortWSDDServiceName;
    }

    public void setCustomerServiceImplPortWSDDServiceName(java.lang.String name) {
        CustomerServiceImplPortWSDDServiceName = name;
    }

    public by.epam.interfaces.CustomersService getCustomerServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CustomerServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCustomerServiceImplPort(endpoint);
    }

    public by.epam.interfaces.CustomersService getCustomerServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            by.epam.bll.CustomerServiceImplPortBindingStub _stub = new by.epam.bll.CustomerServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getCustomerServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCustomerServiceImplPortEndpointAddress(java.lang.String address) {
        CustomerServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (by.epam.interfaces.CustomersService.class.isAssignableFrom(serviceEndpointInterface)) {
                by.epam.bll.CustomerServiceImplPortBindingStub _stub = new by.epam.bll.CustomerServiceImplPortBindingStub(new java.net.URL(CustomerServiceImplPort_address), this);
                _stub.setPortName(getCustomerServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CustomerServiceImplPort".equals(inputPortName)) {
            return getCustomerServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bll.epam.by/", "CustomerServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bll.epam.by/", "CustomerServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CustomerServiceImplPort".equals(portName)) {
            setCustomerServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
