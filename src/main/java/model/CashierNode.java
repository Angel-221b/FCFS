/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Juliana
 */
public class CashierNode extends Node {

    private int maxBurstNumber; // The maximum number of transactions that can be processed per client each time

    public CashierNode(Object data, int maxBurstNumber) {
        super(data);
        this.maxBurstNumber = maxBurstNumber;
    }

    public int getMaxBurstNumber() {
        return this.maxBurstNumber;
    }
}
