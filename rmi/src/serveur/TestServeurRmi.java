package serveur;

import java.net.MalformedURLException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.*;

public class TestServeurRmi {
  public static void main(String[] args) throws RemoteException,
                                                MalformedURLException,
                                                UnknownHostException
  {
    MonObjetAccessibleDistance testSRVTPrmi = new MonObjetAccessibleDistance();
    try{
      Naming.rebind("rmi://"+InetAddress.getLocalHost()+":1099"+"/TestSRVTPrmi", testSRVTPrmi);
    }
    catch (MalformedURLException ee) {
      throw new MalformedURLException("Pbm de URL");
    }
    catch (RemoteException ee) {
//      throw new RemoteException("Pbm Remote");
	System.err.println(ee);
    }
    catch (UnknownHostException ee) {
      throw new UnknownHostException("Pbm de bound");
    }
  }
}
