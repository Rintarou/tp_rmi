package serveur;

import java.rmi.RemoteException;

public class MonObjetAccessibleDistance extends java.rmi.server.UnicastRemoteObject implements MonInterfaceDistant {
  public MonObjetAccessibleDistance() throws RemoteException { super();}
  public String getCode() throws RemoteException { return "camarche"; }
}
