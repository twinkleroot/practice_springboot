package com.twinkleroot.javacodingstudy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class TreeTraversal2 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int i, n = Integer.parseInt(bufferedReader.readLine());
//        Tree tree = new Tree();
//        char data[];
//        for(i=0; i<n; i++) {
//            data = bufferedReader.readLine().replaceAll(" ", "").toCharArray();
//            tree.add(data[0], data[1], data[2]);
//        }
//
//        tree.preorder(tree.root);
//        System.out.println();
//        tree.inorder(tree.root);
//        System.out.println();
//        tree.postorder(tree.root);
//
//        bufferedReader.close();
//    }
//}
//
//class Node {
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
//
//    public void add(char data, char leftData, char rightData) {
//        if(root == null) {
//            if(data != '.') root = new Node(data);
//            if(leftData != '.') root.left = new Node(leftData);
//            if(rightData != '.') root.right = new Node(rightData);
//        } else {
//            search(root, data, leftData, rightData);
//        }
//
//    }
//
//    public void search(Node root, char data, char leftData, char rightData) {
//        if(root == null) return;
//        else if(root.data == data) {
//            if(leftData != '.') root.left = new Node(leftData);
//            if(rightData != '.') root.right = new Node(rightData);
//        } else {
//            search(root.left, data, leftData, rightData);
//            search(root.right, data, leftData, rightData);
//        }
//    }
//
//    public void preorder(Node root) {
//        System.out.print(root.data);
//        if(root.left != null) preorder(root.left);
//        if(root.right != null) preorder(root.right);
//    }
//
//    public void inorder(Node root) {
//        if(root.left != null) inorder(root.left);
//        System.out.print(root.data);
//        if(root.right != null) inorder(root.right);
//    }
//
//    public void postorder(Node root) {
//        if(root.left != null) postorder(root.left);
//        if(root.right != null) postorder(root.right);
//        System.out.print(root.data);
//    }
//}
//
//
