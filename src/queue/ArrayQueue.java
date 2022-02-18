package queue;

import java.util.Scanner;

public class ArrayQueue {

    static int Queue[];
    static int rear;

    static void init(){
        rear=-1;
    }
    static int empty(){
        if(rear==-1)
            return 1;
        return 0;
    }

    static void push(int data){
        rear++;
        Queue[rear]=data;
        //System.out.println(data);
    }

    static int pop(){
        int tmp=Queue[0];
        if(rear<0)
            return -1;

        for(int i=0;i<rear;i++){
            Queue[i]=Queue[i+1];
        }

        rear--;

        return tmp;
    }

    static int size(){
        if(rear<0)
            return 0;
        return rear+1;
    }

    static int front(){
        if(empty()==1)
            return -1;
        return Queue[0];
    }

    static int back(){
        if(empty()==1 || rear == -1)
            return -1;
        return Queue[rear];
    }

    public static void main(String args[]){
        init();
        int N;
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        Queue= new int[N];
        //push(1);
        for(int i=0; i<N;i++){
            String s;
            s=sc.next();
            if(s.equals("push")){
                int t=sc.nextInt();
                push(t);
            }
            else if(s.equals("pop")){
                System.out.println(pop());
            }
            else if(s.equals("empty")){
                System.out.println(empty());
            }
            else if(s.equals("size")){
                System.out.println(size());
            }
            else if(s.equals("front")){
                System.out.println(front());
            }
            else if(s.equals("back")){
                System.out.println(back());
            }

        }

    }

}
