/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author eamon
 */
public class ResultatorImpl extends UnicastRemoteObject implements Resultator {
    
    private static final long serialVersionUID = 1L;
    private String result;
    private boolean processed = false;
    
    public ResultatorImpl() throws RemoteException{
        this.result = "";
        this.processed = false;
    }

    @Override
    public String getResult() throws RemoteException {
        return this.result;
    }

    @Override
    public void setResult(String result) throws RemoteException {
        this.result = result;
    }

    @Override
    public boolean isProcessed() throws RemoteException {
        return this.processed;
    }

    @Override
    public void setProcessed() throws RemoteException {
        this.processed = true;
    }
    
}
