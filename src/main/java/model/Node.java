/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package model;

/**
 *
 * @author Juliana
 */
/*
class Node {
    constructor(data) {
        this.data = data; //data that the node contains
        this.next = null; //pointer to the next node
    }
    getNext() {
        return this.next;
    }
    setNext(next) {
        this.next = next;
    }
    getData() {
        return this.data;
    }
}


*/

public class Node {
    private Object data; // Data that the node contains
    private Node next; // Pointer to the next node
    
    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public Object getData() {
        return this.data;
    }
}

