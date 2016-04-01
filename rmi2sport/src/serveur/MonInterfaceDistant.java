package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface MonInterfaceDistant extends Remote {
  public String getCode() throws RemoteException;
  public HashMap<String, Integer> getClassement() throws RemoteException;
}
