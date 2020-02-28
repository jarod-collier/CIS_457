import java.net.*;  // for InetAddress

public class IPFinder2 {

  public static void main(String[] args) {

    // Get name and IP address of the local host
    try {
      InetAddress address = InetAddress.getByName("localhost"); // the local host address
      System.out.println("Local Hostname and its IP address: "+ address.toString());//Gets the hostname and the IP address in string format

      System.out.println("Host IP address:");
      System.out.println("\t" + address.getHostAddress());//Gets the IP address string in textual presentation

      System.out.println("Local Host Name:");
      System.out.println("\t" + address.getHostName()); // Gets the host name for this IP address.


    } catch (UnknownHostException e) {
      System.out.println("Unable to determine this host's address");
    }

    for (int i = 0; i < args.length; i++) {
      // Get name(s)/address(es) of hosts given on command-line
      try {
        InetAddress[] addressList = InetAddress.getAllByName(args[i]);
       	 System.out.println(args[i] + ":");

      		  // Print the first name.  Assume array contains at least one entry.
      		  System.out.println("\t" + addressList[0].getHostName());
       		 for (int j = 0; j < addressList.length; j++)
         		 System.out.println("\t" + addressList[j].getHostAddress());


      } catch (UnknownHostException e) {
        System.out.println("Unable to find address for " + args[i]);
      }
    }
  }
}
