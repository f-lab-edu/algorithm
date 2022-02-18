package queue;

import java.util.Scanner;

class Node { // Node
    private int val = 0;
    private Node next = null;


    public Node(int val) {
        this.val = val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getVal() {
        return this.val;
    }

    public Node getNext() {
        return this.next;
    }

}

class Queue {
    private Node head = null;

    public Queue() {
        this.head = null;
    }

    public void push(int val) {
        if (this.head == null) { // 큐에 데이터가 없으면
            this.head = new Node(val); // node 생성
        } else {
            Node node = new Node(val);
            Node FirstNode = this.head;
            while (this.head.getNext() != null) { // 연결노드가 있는지 확인
                // -> 다음 노드에 이어 붙이기 위한 용도
                this.head = this.head.getNext();
            }
            this.head.setNext(node); // 입력값 이어 붙이기
            this.head = FirstNode;
        }
    }

    public int pop() { // Queue는 선입선출 구조로 맨 앞 데이터를 빼주면 pop
        if (this.head == null) {
            return -1;
        } else {
            int n = this.head.getVal(); // 처음 노드의 데이터 저장
            this.head = this.head.getNext(); // 헤더에 다음 노드를 저장하여 처음 노드로 변환
            return n; // 데이터 return
        }
    }

    public int front() { // Queue의 맨앞 value 출력
        if (this.head == null) {
            return -1;
        } else {
            return this.head.getVal();
        }
    }

    public int back(int pushN) { // Queue의 맨뒤 value 출력
//        if (this.head.getNext() == null) { // 다음 노드가 없을 때 = 맨뒤
        if (empty() == 1) {
            return -1;
        } else {
            return pushN;
        }
    }

    public int empty(){
        if(this.head == null)
            return 1;
        return 0;
    }


    public int size() { // 큐의 크기 측정
        int cnt = 0;
        if (this.head == null) {
            return cnt;
        } else {
            Node FirstNode = this.head;
            while (this.head.getNext() != null) {
                this.head = this.head.getNext();
                cnt++;
            }
            this.head = FirstNode;
            return cnt + 1;
        }

    }
}


public class LinkedListQueue {
    public static void main(String args[]) {
        Queue q = new Queue();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pushN = 0;
        while( n-- > 0 ) {
            String str = sc.next();

            switch (str) {
                case "push":
                    pushN = sc.nextInt();
                    q.push(pushN);
                    break;

                case "pop":
                    System.out.println(q.pop());
                    break;

                case "empty":
                    System.out.println(q.empty());
                    break;

                case "size":
                    System.out.println(q.size());
                    break;

                case "front":
                    System.out.println(q.front());
                    break;
                case "back":
                    System.out.println(q.back(pushN));
                    break;
            }

        }
    }
}
