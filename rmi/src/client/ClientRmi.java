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
    try {
      Remote monStub = Naming.lookup("rmi://"+
      java.net.InetAddress.getLocalHost()+":1099"+"/TestSRVTPrmi");
      if (monStub instanceof MonInterfaceDistant) {
        String lecode = ((MonInterfaceDistant) monStub).getCode();
        System.out.println("code recupere ="+lecode);
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
