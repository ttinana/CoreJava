package org.corejavatests.ttinana.linkedLisMmiddleEl;

class LinkedList_{
    /*private Node head;
    private Node tail;*/
	
	 Node head;
     Node tail;
 
    public LinkedList_(){
        this.head = new Node("head");
        tail = head;
    }
 
    public Node head(){
        return head;
    }
 
    public void add(Node node){
        tail.next = node;
        tail = node;
    }
 

}

