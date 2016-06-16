/**
 * CustomersService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package by.epam.interfaces;

public interface CustomersService extends java.rmi.Remote {
    public boolean addNewCustomer(by.epam.interfaces.Customer arg0) throws java.rmi.RemoteException;
    public boolean updateCustomer(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public by.epam.interfaces.Customer getCustomerById(int arg0) throws java.rmi.RemoteException;
    public by.epam.interfaces.Customer[] getAllCustomer() throws java.rmi.RemoteException;
    public boolean removeCustomerById(int arg0) throws java.rmi.RemoteException;
}
