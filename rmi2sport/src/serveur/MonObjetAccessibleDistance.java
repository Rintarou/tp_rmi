package serveur;

import java.rmi.RemoteException;
import java.util.HashMap;

public class MonObjetAccessibleDistance extends java.rmi.server.UnicastRemoteObject implements MonInterfaceDistant {
  HashMap<String, Integer> classement;
  boolean available;
  long actual;
  public MonObjetAccessibleDistance(HashMap<String, Integer> map) throws RemoteException {
    super();
    classement= map;
    available = true;
  }
  public String getCode() throws RemoteException { return "camarche"; }

  public HashMap<String, Integer> getClassement() throws RemoteException
   {
    /*if(num==actual) {
      available = true;
      actual = System.nanoTime();
      return classement;
    }
    throw new RemoteException("not available");*/
    return classement;
    }
}
