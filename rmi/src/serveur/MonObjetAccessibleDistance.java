package serveur;

import java.rmi.RemoteException;
import java.util.HashMap;

public class MonObjetAccessibleDistance extends java.rmi.server.UnicastRemoteObject implements MonInterfaceDistant {

  HashMap<String, Integer> classement;

  public MonObjetAccessibleDistance() throws RemoteException {
    super();
    classement = new HashMap<String, Integer>();
    classement.put("La Rochelle", 4);
    classement.put("Raproc", 11);
    classement.put("NopesVille", 1);
    classement.put("Baraque of Bama", 3);
  }
  public String getCode() throws RemoteException { return "camarche"; }

  public Integer getClassement(String s) {
    if(classement.keySet().contains(s)) return classement.get(s);
    return -1;
  }
}
