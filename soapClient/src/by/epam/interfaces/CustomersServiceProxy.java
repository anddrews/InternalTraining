package by.epam.interfaces;

public class CustomersServiceProxy implements by.epam.interfaces.CustomersService {
  private String _endpoint = null;
  private by.epam.interfaces.CustomersService customersService = null;
  
  public CustomersServiceProxy() {
    _initCustomersServiceProxy();
  }
  
  public CustomersServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCustomersServiceProxy();
  }
  
  private void _initCustomersServiceProxy() {
    try {
      customersService = (new by.epam.bll.CustomerServiceImplServiceLocator()).getCustomerServiceImplPort();
      if (customersService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)customersService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)customersService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (customersService != null)
      ((javax.xml.rpc.Stub)customersService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public by.epam.interfaces.CustomersService getCustomersService() {
    if (customersService == null)
      _initCustomersServiceProxy();
    return customersService;
  }
  
  public boolean addNewCustomer(by.epam.interfaces.Customer arg0) throws java.rmi.RemoteException{
    if (customersService == null)
      _initCustomersServiceProxy();
    return customersService.addNewCustomer(arg0);
  }
  
  public boolean updateCustomer(int arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (customersService == null)
      _initCustomersServiceProxy();
    return customersService.updateCustomer(arg0, arg1, arg2, arg3);
  }
  
  public by.epam.interfaces.Customer getCustomerById(int arg0) throws java.rmi.RemoteException{
    if (customersService == null)
      _initCustomersServiceProxy();
    return customersService.getCustomerById(arg0);
  }
  
  public by.epam.interfaces.Customer[] getAllCustomer() throws java.rmi.RemoteException{
    if (customersService == null)
      _initCustomersServiceProxy();
    return customersService.getAllCustomer();
  }
  
  public boolean removeCustomerById(int arg0) throws java.rmi.RemoteException{
    if (customersService == null)
      _initCustomersServiceProxy();
    return customersService.removeCustomerById(arg0);
  }
  
  
}