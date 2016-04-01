package serveur;

import java.rmi.*;
import java.rmi.server.*;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.HashMap;

public interface MonInterfaceDistant extends Remote {
  public String getCode() throws RemoteException;
  public HashMap<String, Integer> getClassement() throws RemoteException;
  public Integer getClassement(String s) throws RemoteException,
                                                MalformedURLException,
                                                NotBoundException,
                                                UnknownHostException;
}
