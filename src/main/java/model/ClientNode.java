/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Juliana
 */
public class ClientNode extends Node {
    private int timeOfArrival = -1; 
    private int burstNumber; // Contains the number of transactions the client needs the cashier to proces
    private int startTime; 
    private int finalTime; //startTime + burstNumber
    private int returnTime; // finalTime - startTime
    private int waitTime; // returnTime -  burstNumber
    
    
    public ClientNode(Object data, int timeOfArrival, int burstNumber) {
        super(data);
        this.burstNumber = burstNumber;
        this.timeOfArrival = timeOfArrival;
    }
    
    public int getTimeOfArrival() {
        return this.timeOfArrival;
    }

    public void setTimeOfArrival(int timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }    
    
    public int getBurstNumber() {
        return this.burstNumber;
    }

    public void setBurstNumber(int tranNum) {
        this.burstNumber = burstNumber;
    }
    
    public int getFinalTime() {
        return this.finalTime;
    }

    public void setFinalTime(int finalTime) {
        this.finalTime = finalTime;
    }
    
    public int getReturnTime() {
        return this.returnTime;
    }

    public void setReturnTime(int returnTime) {
        this.returnTime = returnTime;
    }    
    
    public int getWaitTime() {
        return this.returnTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    // Removes from the number of transactions the client needs the cashier to process
    public void removeTransactions(int num) {
        if (num <= 0)
            return;
        if (this.burstNumber <= num) {
            this.burstNumber = 0;
        } else {
            this.burstNumber -= num;
        }
    }

}
