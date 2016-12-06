/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author eamon
 */
public class Servant {
    public static void main(String[] args) throws Throwable {
		StringService c = new StringServiceImpl();
		
		LocateRegistry.createRegistry(1099);
		Naming.bind("comparator-service", c);
		
		System.out.println("server ready...");
	}
}
