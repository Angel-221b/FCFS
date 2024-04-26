/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Juliana
 */
public class Main {

  public static void main(String[] args) {
    CircularSinglyLinkedList csl = new CircularSinglyLinkedList();
    csl.insertAtEnd(Support.getNextLetter(), 0, 2);
    csl.insertAtEnd(Support.getNextLetter(), 1, 3);
    csl.insertAtEnd(Support.getNextLetter(), 2, 5);
    csl.insertAtEnd(Support.getNextLetter(), 3, 6);
    csl.insertAtEnd(Support.getNextLetter(), 4, 7);
    csl.insertAtEnd(Support.getNextLetter(), 5, 7);
    
    Support.processTransactionsWithDelay(csl);
  }
  

} // End of class

