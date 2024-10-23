import java.util.*;
class Node{
    int data;
    Node leftlink;
    Node rightlink;
}
public class singlylist{
    Node node;
    Node first,last;
    public Node createNode(int data){
        node= new Node();
        node.data=data;
        node.leftlink=null;
        node.rightlink=null;
        return node;
    }
    public void InsertFront(int data){
        node= createNode(data);
        if(first==null){
            first=last=node;
            
        }else{
          node.rightlink=first;
          first.leftlink=node;
          first=node;
        }
    }

    public void InsertEnd(int data){
        node = createNode (data);
        if(last==null){
            first=last=node;
        }else{
            node.leftlink=last;
            last.rightlink=node;
            last=node;
        }
    }
    public void InsertingAtspec(int data , int pos){
        node = createNode(data);
            if(pos<1){
               System.out.println("Ente the Valid Position");
            }else if(pos==1){
              first=last=node;
            }else if(pos==1){
               node.rightlink=first;
                first.leftlink=node;
                first=node;
            }else{
                Node temp=first;
                int cnt=1;
                while(temp!=null && cnt<pos){
                    temp=temp.rightlink;
                    cnt++;
                }
                 if(temp==null){
                    System.out.println("List is Empty");
                }
                node.rightlink=first;
                node.leftlink=temp.rightlink;
                if(temp.rightlink!=null){
                    temp.rightlink.leftlink=node;
                }else{
                    last=node;
                }
                temp.rightlink=node;
               
            }
    }
    public void DeleteFrot(){
        if(first==null){
            System.out.println("List is Empty");
        }else{
           Node temp=first;
           System.out.println("Deleted Dta "+temp.data);
           temp=temp.rightlink;
           if(temp!=null){
              temp.leftlink=null;
           }else{
               last=null;
           }
        }
    }
    public void DeleteEnd(){
       if(last==null){
           System.out.println("List is Null");
       }else {
           Node temp=last;
           System.out.println("Dleted data "+last.data);
           temp=temp.leftlink;
           if(temp!=null){
               temp.rightlink=null;
           }else{
               first=null;
           }
       }
    }
    public void DeleteAtSpecifc(int pos){
        if(pos<1){
            System.out.println("Ente the Valid One");
           }else if(pos==1){
            System.out.println("Deleted data "+first.data);
            first=first.rightlink;
            if(first!=null){
                first.leftlink=null;
            }else{
                last=null;
            }
           }else{
        Node temp=first;
        int cnt=1;
        while(temp!=null && cnt<pos){
            temp=temp.rightlink;
            cnt++;
        }
        if(temp==null){
            System.out.println("No data in list");
        }
        System.out.println("Deleted  data " +temp.data);
        if(temp.leftlink!=null){
            temp.leftlink.rightlink=temp.rightlink;
        }
        if(temp.rightlink!=null){
            temp.rightlink.leftlink=temp.leftlink;
        }
        if(temp==last){
            last=last.leftlink;
        }
    }
    }
public void display(){
    if(first==null){
        System.out.println("Null");
    }else{
     Node temp=first;
     while(temp!=null){
         System.out.println("Data in the Node " +temp.data);
         temp=temp.rightlink;
     }
    }
}
    public static  void main(String [] args){
        Scanner sc= new Scanner(System.in);
        singlylist sl = new singlylist();
        int choice;
        
        do{
             System.out.println("Enter thr choice \n1. InsertFront \n 2. InsertEnd  \n3. InserAt specific \n 4.Delete Front \n 5.DeleteEnd \n 6.DeleteAtSpecifc");
             choice=sc.nextInt();
        switch(choice){
            case 1:
            System.out.println("Enter the Data");
            int data1=sc.nextInt();
            sl.InsertFront(data1);
            break;
            case 2 :
            System.out.println("Enter the Data");
            int data2= sc.nextInt();
            sl.InsertEnd(data2);
            break;
            case 3:
            System.out.println("Enter the Data");
            int data3= sc.nextInt();
            int pos=sc.nextInt();
            sl.InsertingAtspec(data3,pos);
            case 4:
            sl.DeleteFrot();
            break;
            case 5:
            sl.DeleteEnd();
            break;
            case 6:
            System.out.println("Enter the psition");
            int po= sc.nextInt();
            sl.DeleteAtSpecifc(po);
            break;
            case 7:
            sl.display();
            break;
        }
        
        }while(choice<=10);
    }
}
