package serveur;

import java.net.MalformedURLException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.*;
import java.util.HashMap;

public class TestServeurRmi {
  public static void main(String[] args) throws RemoteException,
                                                MalformedURLException,
                                                UnknownHostException
  {
    HashMap<String, Integer> datMap = new HashMap<String, Integer>();
    datMap.put("La Rochelle", 4);
    datMap.put("Raproc", 11);
    datMap.put("NopesVille", 1);
    datMap.put("Baraque of Bama", 3);
    MonObjetAccessibleDistance testSRVTPrmi = new MonObjetAccessibleDistance(datMap);
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
