package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MonInterfaceDistant extends Remote {
  public String getCode() throws RemoteException;
  public Integer getClassement(String s) throws RemoteException;
}
