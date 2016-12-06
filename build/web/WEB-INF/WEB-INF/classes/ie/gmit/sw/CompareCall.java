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
public class CompareCall { // step 2
    
    private long jobNumber;
    private String a;
    private String b;
    
    public CompareCall(long jobNumber, String a, String b){
        this.jobNumber = jobNumber;
        this.a = a;
        this.b = b;
    }
}
