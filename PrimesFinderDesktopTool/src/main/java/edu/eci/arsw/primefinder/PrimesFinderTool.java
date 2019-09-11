package edu.eci.arsw.primefinder;

//import edu.eci.arsw.mouseutils.MouseMovementMonitor;
//import java.io.IOException;
import java.math.BigInteger;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {

	public static void main(String[] args) {
		
			int numThreads=4;
		            
            int maxPrim=10000;
            
            PrimesResultSet prs=new PrimesResultSet("john");
             
            PrimeFinder[] finders=new PrimeFinder[numThreads];
            
            for(int i=0;i<finders.length;i++)
            	finders[i] = new PrimeFinder(new BigInteger(Integer.toString(i*maxPrim/finders.length))
            								, new BigInteger(Integer.toString((i+1)*maxPrim/finders.length))
            								, prs);
            
            for(PrimeFinder f:finders)
            	f.start();
            
              
            
            System.out.println("Prime numbers found:");
            
            System.out.println(prs.getPrimes());
            
            
            /*while(task_not_finished){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        System.out.println("Idle CPU ");
                    }
                    else{
                        System.out.println("User working again!");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
                        
            
            
            
            
	}
	
}


