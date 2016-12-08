/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gmit.sw;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eamon
 */
public class ServiceManager implements Runnable{ // this is the client class for step 5
    
    private BlockingQueue<CompareCall> inQueue;
    private HashMap<String, Resultator> outQueue;

    public ServiceManager(){
        inQueue = new ArrayBlockingQueue<>(10);
        outQueue = new HashMap<>();
    }
    
    public void newJob(CompareCall cc){
       inQueue.add(cc);
    }
    
    public String getJob(String taskNumber) throws RemoteException{
        
            return outQueue.get(taskNumber).getResult();
        
    }
    
    public boolean isComplete(String taskNumber) throws RemoteException{
        return outQueue.get(taskNumber).isProcessed();
    }
    
    public Resultator getResult(CompareCall cc) throws RemoteException{
        StringService ss = null;
        try {
            ss = (StringService) Naming.lookup("rmi://localhost:1099/comparator-service");
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ServiceManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        Resultator resultator = ss.compare(cc.getA(), cc.getB(), cc.getAlgorithm());
        return resultator;
    }
    
    //public 
    @Override
    public void run() {
        
        try {
            
            //StringService ss = (StringService) Naming.lookup("rmi://localhost:1099/comparator-service");
            
            while(true) // endless loop 
            {
                
                CompareCall cc = inQueue.poll(); // step 6
                if(cc != null){
                        
                if(/*resultator.*/this.getResult(cc) != null){
                    outQueue.put(cc.getJobNumber(), this.getResult(cc));
                }
                }

            }
        } catch(RemoteException ex){
        }
    }
    
}
