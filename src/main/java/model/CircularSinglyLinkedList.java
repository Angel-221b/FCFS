/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashSet;

/**
 *
 * @author Juliana
 */
public class CircularSinglyLinkedList {
    private CashierNode head; // Represents the head of the linked list
    private ClientNode tail; // Represents the tail of the linked list
    private int processTransactionscounter = 5; // This number must be changed if the initial number of nodes is changed in main
    
    public int getProcessTransactionscounter() {
        return this.processTransactionscounter;
    }

    public CircularSinglyLinkedList() {
        this.head = new CashierNode("Cashier", 5); // Max number of transactions per client
        this.tail = null;
    }

    // Method to check if the queue is empty (No clients)
    public boolean isEmpty() {
        return this.tail == null;
    }

    public void processTransactions() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            ClientNode client = (ClientNode) this.head.getNext();
            int burstNumber = client.getBurstNumber();
            Object actualClient = client.getData();
            int maxBurstNumber = this.head.getMaxBurstNumber();
            
            if(client.getTimeOfArrival() == -1){
                processTransactionscounter++;
                client.setTimeOfArrival(processTransactionscounter);   
            }else{
                processTransactionscounter++;
            }
            System.out.println("current time: " + processTransactionscounter);
            if (burstNumber > maxBurstNumber) {
                client.removeTransactions(maxBurstNumber);
                burstNumber -= maxBurstNumber;
                this.moveFirstToEnd();
            } else {
                client.removeTransactions(burstNumber);
                this.deleteAtStart();
            }
        }
    }

    public void insertAtEnd(Object data, int arrivalTime, int burstNumber) {
        ClientNode newNode = new ClientNode(data, arrivalTime, burstNumber);
        if (this.isEmpty()) {
            this.tail = newNode;
            this.head.setNext(newNode);
            newNode.setNext(this.head);
        } else {
            ClientNode current = (ClientNode) this.head.getNext();
            while (current.getNext() != this.head) { // Before the tail
                current = (ClientNode) current.getNext();
            }
            this.tail = newNode;
            current.setNext(newNode);
            newNode.setNext(this.head);
        }
    }

    public void deleteAtStart() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        ClientNode firstNode = (ClientNode) this.head.getNext();
        if (firstNode.getNext() == this.head) {
            this.tail = null;
            
        }
        Node nextNode = firstNode.getNext();
        firstNode.setNext(null);
        this.head.setNext(nextNode);
    }

    public void moveFirstToEnd() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        ClientNode firstNode = (ClientNode) this.head.getNext();
        if (firstNode.getNext() == this.head) {
            // There's only one node in the list
            System.out.println("Only one node in the list. No need to move.");
            return;
        }
        // Remove from first position
        Node nextNode = firstNode.getNext();
        this.head.setNext(nextNode);
        // Insert into last position
        Node prevNode = this.tail;
        ((ClientNode) prevNode).setNext(firstNode);
        firstNode.setNext(this.head);
        this.tail = firstNode;
    }

    // Method to display the queue in console - (debugging tool)
    public void display() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node current = this.head.getNext();
        do {
            if (current instanceof ClientNode) {
                System.out.println(((ClientNode) current).getData() + ": " + ((ClientNode) current).getTimeOfArrival() + "; " + ((ClientNode) current).getBurstNumber());
                current = current.getNext();
            }
        } while (current != this.head);
    }

    // Not used
    public int nodeCount() {
        int nodesNumber = 0;
        Node current = this.head;
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return 0;
        }
        do {
            nodesNumber++;
            current = current.getNext();
        } while (current != this.head);
        return nodesNumber;
    }
    
}

