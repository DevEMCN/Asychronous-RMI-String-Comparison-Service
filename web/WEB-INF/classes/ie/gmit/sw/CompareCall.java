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
    
    private String jobNumber;
    private String a;
    private String b;
    private String algorithm;
    
    public CompareCall(String jobNumber, String a, String b, String algorithm){
        this.jobNumber = jobNumber;
        this.a = a;
        this.b = b;
        this.algorithm = algorithm;
    }

    /**
     * @return the jobNumber
     */
    public String getJobNumber() {
        return jobNumber;
    }

    /**
     * @return the a
     */
    public String getA() {
        return a;
    }

    /**
     * @return the b
     */
    public String getB() {
        return b;
    }

    /**
     * @return the algorithm
     */
    public String getAlgorithm() {
        return algorithm;
    }
    
}
