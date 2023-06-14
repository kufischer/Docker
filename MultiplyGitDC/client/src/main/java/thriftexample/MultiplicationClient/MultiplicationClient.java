import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.util.concurrent.TimeUnit;

public class MultiplicationClient {

    public static void main(String [] args) {
	   
	try {
	    
	    TTransport transport;
    
		// transport = new TSocket("host.docker.internal", 9090);
	    // transport = new TSocket("localhost", 9090);
	    transport = new TSocket("multserver", 9090);
	    transport.open();

	    TProtocol protocol = new  TBinaryProtocol(transport);
	    tutorial.MultiplicationService.Client client = new tutorial.MultiplicationService.Client(protocol);

	    int n = 1000 ;
	  
	    perform( client , n );

	    performMethod ( n );

	    transport.close();
	    
	} catch ( TException x ) {
	    x.printStackTrace();
	}
    }

    private static void perform ( tutorial.MultiplicationService.Client client , int n ) throws TException {
   
	int product = 0;
	long startTime = System.nanoTime();

	for ( int i = 1 ; i <= n ; i++ ) {
	    product = client.multiply ( i , 5 );
	    System.out.println ( i + "*5=" + product );
	}

	printTime ( startTime );
      
    }

    private static void performMethod ( int n ) {

	int product = 0;
	long startTime = System.nanoTime();

	for ( int i = 1 ; i <= n ; i++ ) {
	    product = i * 5 ;
	    // System.out.println ( i + "*5=" + product );
	}

	printTime ( startTime );
 
    }

    private static void printTime ( long startTime ) {

	long endTime = System.nanoTime();
	
	long timeElapsed = endTime - startTime;

	System.out.println("Execution time in nanoseconds  : " + timeElapsed);

	System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);

    }
    
}
