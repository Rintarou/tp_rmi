package serveur;

import java.rmi.*;
import java.rmi.server.*;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import serveur.*;
import java.util.HashMap;

public class MonObjetAccessibleDistance extends java.rmi.server.UnicastRemoteObject implements MonInterfaceDistant {
  HashMap<String, Integer> classement;
  boolean available;
  long actual;
  int num;
  int numserv;
  public MonObjetAccessibleDistance(HashMap<String, Integer> map, int num, int numserv) throws RemoteException {
    super();
    classement= map;
    available = true;
    this.num = num;
    this.numserv = numserv;
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

  public Integer getClassement(String s) throws RemoteException,
                                                MalformedURLException,
                                                NotBoundException,
                                                UnknownHostException
  {
    if (classement.keySet().contains(s)) return classement.get(s);
    int i = num;
    try {
      Remote monStub = Naming.lookup("rmi://"+
          java.net.InetAddress.getLocalHost()+":1099"+"/TestSRVTPrmi"+i); //ce lookup plante
      if (monStub instanceof MonInterfaceDistant) {
        String lecode = ((MonInterfaceDistant) monStub).getCode();
        HashMap<String, Integer> classmt = ((MonInterfaceDistant) monStub).getClassement();
        classement.putAll(classmt);
        if (classmt.keySet().contains(s)) return classmt.get(s);
      }
    }
    catch (NotBoundException e) {
      e.printStackTrace();
      throw new NotBoundException("Pbm de liaison");
    }
    catch (UnknownHostException e) {
      throw new UnknownHostException("Pbm d'host");
    }
    return -1;
  }
}
