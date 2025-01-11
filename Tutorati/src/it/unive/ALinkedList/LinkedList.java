package it.unive.ALinkedList;

class LinkedList {
    int value;
    LinkedList next;

    public LinkedList(int value){
        this.value=value;
        this.next=null;
    }

    /*funzione ricorsiva*/
    void add(int value){
        if(this.next==null)
            this.next=new LinkedList(value);
        else
            this.next.add(value);
    }

    static void printList(LinkedList head){
        LinkedList iter=head;
        while(iter!=null) {
            System.out.printf("%d ", iter.value);
            iter = iter.next;
        }
    }
}
