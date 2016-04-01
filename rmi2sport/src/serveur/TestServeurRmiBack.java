package serveur;

import java.net.MalformedURLException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.*;
import java.util.HashMap;

public class TestServeurRmiBack {
  public static void main(String[] args) throws RemoteException,
                                                MalformedURLException,
                                                UnknownHostException
  {
    if (args.length < 2) {
      System.out.println("usage: TestServeurRmi <number of the server> <number of servers>");
      System.exit(1);
    }
    int num = Integer.valueOf(args[0]);
    int numserv = Integer.valueOf(args[1]);
    HashMap<String, Integer> datMap = new HashMap<String, Integer>();
    datMap.put("Illinois", 7);
    datMap.put("ToadsVille", 12);
    datMap.put("village Lynna", 2);
    datMap.put("Bielorussie", 25);
    MonObjetAccessibleDistance testSRVTPrmi = new MonObjetAccessibleDistance(datMap, num, numserv);
    try{
      Naming.rebind("rmi://"+InetAddress.getLocalHost()+":1099"+"/TestSRVTPrmi"+num, testSRVTPrmi);
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
