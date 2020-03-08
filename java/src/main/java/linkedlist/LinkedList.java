package linkedlist;

public class LinkedList {
  private Node head;

  public boolean isEmpty() {
    return (head == null);
  }

  public void addFirst(Node node) {
    node.next = head;
    head = node;  
  }

  public void addLast(Node node) {
    if (head == null) {
      head = node;
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = node;
    }
  }

  public Node deleteFirst() {
    Node temp = head;
    head = head.next;
    return temp;
  }

  public void deleteLast() {
    Node current = head;
    while (current.next != null) {
      current = current.next;
    }
    current = null;
  }

  public void deleteAfter(Node node) {
    Node current = head;
    while (current.next != null && current.data != node.data) {
      current = current.next;
    }
    if (current.next != null) {
      current.next = current.next.next;
    }
  }

  public void printLinkedList(Node head, String title) {
    System.out.println(title);
    Node current = head;
    while (current != null) {
      System.out.print("->" + current.data);
      current = current.next;
    }
    System.out.println("\n");
  }

//===Algorithms==========================================================
  // Link: https://leetcode.com/problems/reverse-linked-list/
  public Node reverseLinkedList(Node head) {
    Node prev = null;
    Node current = head;
    Node next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  // Link: https://leetcode.com/problems/middle-of-the-linked-list/
  public Node findMiddleNode(Node head) {
    Node slow, fast;
    slow = fast = head;
    while (fast != null) {
      fast = fast.next;
      if (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next;
      }
    }
    return slow;
  }

  // Link: 
  public Node findNNodeFromEnd(Node head, int n) {
    Node first, second; 
    first = second = head;
    int i = 0;
    while (first != null) {
      first = first.next;
      if (i >= n) {
        second = second.next;
      } 
      i++;
    }
    return second;
  }

  // Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
  public Node removeNNodeFromEnd(Node head, int n) {
    Node dummy = new Node(0);
    dummy.next = head;
    Node first, second;
    first = second = dummy;
    Node connector = null;
    int i = 0;
    while (first != null) {
      first = first.next;
      connector = second;
      if (i >= n) {
        second = second.next;
      }
      i++;
    }
    connector.next = null;//second.next;
    return dummy.next;
  }

  // Link: https://leetcode.com/problems/linked-list-cycle/
  public boolean hasCycle(Node head) {
    Node slow, fast;
    slow = fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) 
        return true;
    }
    return false;
  }

  public Node findStartNodeOfLoop(Node head) {
    Node slow, fast;
    slow = fast = head;
    boolean isLoop = false;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        isLoop = true;
        System.out.println("There is a loop.");
        break;
      }
    }
    if (isLoop) {
      slow = head;
      while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
      }
      System.out.println("Start Node: " + slow.data);
    } else {
      System.out.println("There is no loop.");
      slow = null;
    }
    return slow;
  }
//===algorithms==========================================================
}





















