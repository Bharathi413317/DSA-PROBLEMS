// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    static Node head;
    public static Node addatbeg(Node newnode){
        newnode.next=head;
        head=newnode;
       return head;
    }public static void deleteatstart(){
        head=head.next;
    }public static void deleteatend(){
        Node temp=head;
        while(temp.next!=null && temp.next.next!=null){
            temp=temp.next;
            
        }temp.next=null;
        
    }public static void deleteatindex(int index){
        if(index==0){
            deleteatstart();
            return;
        }if(head==null || index<0){
            return;
        }
        Node temp=head;
        for(int  i=0;i<index-1;i++){
            temp=temp.next;
            if(temp==null){
                System.out.println("no reyyyy");
                return;
            }
        }
        temp.next=temp.next.next;
        
    }public static void deletebyvalue(String s){
        Node temp=head;
        if(head.data.equals(s)){
            deleteatstart();
            return;
        }if(head==null){
            return;
        }while(!temp.next.data.equals(s)){
            temp=temp.next;
        }temp.next=temp.next.next;
    }public static void reverse(){
        Node curr=head;
        Node prev=null;+
        while(curr!=null){
            Node nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
            
        }head=prev;

    public static void printlinkedlist(){
       Node temp=head ;
       
       while(temp!=null){
           if(temp.next==null){
                System.out.print(temp.data);
           }else{
           System.out.print(temp.data+"->");}
           temp=temp.next;
       }System.out.println();
    }
    public static void main(String[] args) {
        Node node1=new Node("A");
        Node node2=new Node("B");
        Node node3=new Node("c");
        Node node4=new Node("D");
        node1.next=node2;
        node2.next=node3;
        head=node1;
        //addatbeg(node4,head);
         addatbeg(node4);
        // deleteatstart();
        //  deleteatend();
      //  deletebyvalue("B");
         reverse();
        printlinkedlist();
        addatbeg(node4);
                
    }
}
class Node{
    String data;
    Node next;
    Node(String data){
        this.data=data;
        this.next=next;
    }
}
