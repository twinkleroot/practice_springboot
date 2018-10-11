package com.twinkleroot.javacodingstudy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class TreeTraversalMain {
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//        int i, n = Integer.parseInt(in.readLine());
//        Tree t = new Tree();
//        char data[];
//        for(i=0; i<n; i++) {
//            data = in.readLine().replaceAll(" ", "").toCharArray();
//            t.add(data[0], data[1], data[2]);
//        }
//
//        t.preorder(t.root);
//        System.out.println();
//        t.inorder(t.root);
//        System.out.println();
//        t.postorder(t.root);
//        in.close();
//    }
//}
//
//class Node {
//
//    char data;
//
//    Node left, right;
//
//    public Node(char data) {
//        this.data = data;
//    }
//}
//
//class Tree {
//    Node root;
//    // add() 메서드. 들어온 값이 '.'이 아닌 경우에만 삽입한다.
//    public void add(char data, char leftData, char rightData) {
//        if(root == null) {  // 루트 노드가 비어있으면 = 아무것도 집어넣지 않은 최초 상태면
//            if(data != '.') root = new Node(data);                  // '.'이 아니면 노드 생성 후 데이터 삽입
//            if(leftData != '.') root.left = new Node(leftData);     // 생성된 노드의 좌측도 동일
//            if(rightData != '.') root.right = new Node(rightData);  // 생성된 노드의 우측도 동일
//        } else {
//            // 만약 최초 상태가 아니면 -> 어디에 들어가야 하는지 찾는다.
//            search(root, data, leftData, rightData);
//        }
//    }
//
//    // search() 메서드. 아래에서 사용된 root는 매개변수로 들어온 로컬변수임에 유의한다.
//    public void search(Node root, char data, char leftData, char rightData) {
//        // 재귀를 사용하므로 도착한 노드가 null 이면 종료 = 삽입 위치를 찾지 못한 경우
//        if(root == null) return;
//        // 위치를 찾았으면
//        else if(root.data == data) {
//            // '.'이 아닌 경우에 한해서 좌, 우 노드 생성 후 데이터 삽입
//            if(leftData != '.') root.left = new Node(leftData);
//            if(rightData != '.') root.right = new Node(rightData);
//        } else {    // 아직 찾지 못했고, 탐색할 노드가 남아있는 경우
//            search(root.left, data, leftData, rightData);   // 왼쪽 재귀 탐색
//            search(root.right, data, leftData, rightData);  // 오른쪽 재귀 탐색
//        }
//    }
//
//    // 전위 순회. 순회순서: 중앙 > 좌 > 우
//    public void preorder(Node root) {
//        System.out.print(root.data);
//        if(root.left != null) preorder(root.left);
//        if(root.right != null) preorder(root.right);
//    }
//
//    // 중위 순회. 순회순서: 좌 > 중앙 > 우
//    public void inorder(Node root) {
//        if(root.left != null) inorder(root.left);
//        System.out.print(root.data);
//        if(root.right != null) inorder(root.right);
//    }
//
//    // 후위 순회. 순회순서: 좌 > 우 > 중앙
//    public void postorder(Node root) {
//        if(root.left != null) postorder(root.left);
//        if(root.right != null) postorder(root.right);
//        System.out.print(root.data);
//    }
//}