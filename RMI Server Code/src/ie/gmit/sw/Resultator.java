/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author eamon
 */
public interface Resultator extends Remote{
    public String getResult() throws RemoteException;
    public void setResult(String result) throws RemoteException;
    public boolean isProcessed() throws RemoteException;
    public void setProcessed() throws RemoteException;
}
