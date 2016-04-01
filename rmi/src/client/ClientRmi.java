package client;

import java.rmi.*;
import java.rmi.server.*;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import serveur.*;

public class ClientRmi {
  public static void ClientRmi() throws RemoteException,
                                        UnknownHostException
  {

  }

  public static void main(String[] args) throws RemoteException,
                                                MalformedURLException,
                                                NotBoundException,
                                                UnknownHostException
  {
    if(args.length<1) {
      System.out.println("usage: ClientRmi <nom de la ville> (villes: La Rochelle)");
      System.exit(1);
    }
    try {
      Remote monStub = Naming.lookup("rmi://"+
      java.net.InetAddress.getLocalHost()+":1099"+"/TestSRVTPrmi");
      if (monStub instanceof MonInterfaceDistant) {
        Integer leclassement = ((MonInterfaceDistant) monStub).getClassement(args[0]);
        System.out.println("classement de "+args[0]+": "+leclassement);
      }
    }
    catch (NotBoundException e) {
      throw new NotBoundException("Pbm de liaison");
    }
    catch (UnknownHostException e) {
      throw new UnknownHostException("Pbm d'host");
    }
  }
}
