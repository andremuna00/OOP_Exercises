package it.unive.ALinkedList;

public class Main{
    public static void main(String[] args){
        LinkedList head = new LinkedList(0);
        for(int i=1;i<11;i++)
            head.add(i);
        LinkedList.printList(head);

        float sum=MyMath.sum(2.2f,MyMath.PI);
        System.out.println(sum);
    }
}