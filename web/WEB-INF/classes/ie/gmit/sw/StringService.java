/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gmit.sw;

/**
 *
 * @author eamon
 */
import java.rmi.*;

public interface StringService extends Remote{
    public Resultator compare(String a, String b, String algorithm) throws RemoteException;
}
