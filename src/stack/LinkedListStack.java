package stack;

import java.util.Scanner;

class LinkedListStack {
    int size; //스택에 들어있는 노드 개수
    Node top; //가장 위에 있는 노드
    class Node {
        int data;
        Node next;

        Node(int x){
            if(LinkedListStack.this.size == 0) //스택이 비어있을 경우
                next = null;
            else //스택이 비어있지 않을 경우
                next = top;
            data = x;
        }
    }
    void size() {//스택에 들어있는 정수의 개수 출력
        System.out.println(size);
    }
    void top() {//스택의 가장 위에 있는 정수 출력, 없으면 -1 출력
        if(size == 0)
            System.out.println(-1);
        else
            System.out.println(top.data);
    }
    void isEmpty() {//스택에 비어있으면 1, 아니면 0 출력
        if(size == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }
    //정수 x를 스택에 넣는 연산
    void push(int x) {
        top = new Node(x); //새로운 삽입된 노드가 top
        size++;
    }
    //스택에서 가장 위에 있는 정수 빼고,그 수 출력.//스택에 정수 없는 경우 -1 출력
    void pop() {
        if(size == 0)
            System.out.println(-1);
        else {
            Node tmp = top;
            System.out.println(tmp.data);
            top = tmp.next;
            tmp.next = null;
            size--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListStack stack = new LinkedListStack();
        int n = sc.nextInt();
        sc.nextLine(); //개행문자 제거
        for(int i = 0; i< n ; i++) {

            String input = sc.nextLine();//명령 입력
            if(input.contains("push")) {
                int x = Integer.parseInt(input.substring(5));
                stack.push(x);
            }
            else {
                switch(input) {
                    case "pop":
                        stack.pop();
                        break;
                    case "top":
                        stack.top();
                        break;
                    case "empty":
                        stack.isEmpty();
                        break;
                    case "size":
                        stack.size();
                        break;
                }
            }
        }
    }
}
