/*
* Copyright (C) 2019 BlackRock.
*
* Created on Nov 28, 2019
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.alds.others;

import sun.awt.DisplayChangedListener;

/**
 * @author rohsingh
 *
 */
public class RemoveFromCircularLinkedList {

    class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            super();
            this.val = val;
            this.next = next;
        }
        
        public Node copy(Node n) {
            Node t = new Node(n.val);
            return t;
        }
    }

    Node head = null;
    Node tail = null;

    public void create(int data) {
        // Create new node
        Node newNode = new Node(data);
        // Checks if the list is empty.
        if (head == null) {
            // If list is empty, both head and tail would point to new node.
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            // tail will point to new node.
            tail.next = newNode;
            // New node will become new tail.
            tail = newNode;
            // Since, it is circular linked list tail will point to head.
            tail.next = head;
        }
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            System.out.println("Nodes of the circular linked list: ");
            do {
                // Prints each node by incrementing pointer.
                System.out.print(" " + current.val);
                current = current.next;
            } while (current != head);
            System.out.println();
        }
    }
    
    public int length(Node head) {
        // get the length first
        int n = 1;
        Node current = head;
        while (current.next != current) {
            current.next = current.next.next;
            n++;
        }
        return n;
    }

    public void delete(int index) {
        if (head != null) {
 
            int n = 1;
            Node current = null;
            while (head.next != head) {
                current = new Node(head.val);
                current.next = head.next;
                head = head.next;
                head.next = head.next.next;
                n++;
            }

            // two pointer to maintain direction
            Node n1 = null, n2 = null;
            int i = 0;
            while (i < n) {
                if (i != 2) {
                    n1 = current;
                    n2 = current.next;
                } else {
                    n1.next = n2.next;
                    n2.next = null;
                }
                i++;
            }
        }
    }
    
    public static void main(String[] args) {
        RemoveFromCircularLinkedList r = new RemoveFromCircularLinkedList();
        r.create(1);
        r.create(2);
        r.create(3);
        r.create(4);
        
        r.display();
        
        r.delete(1);
        
        r.display();
    }
}
