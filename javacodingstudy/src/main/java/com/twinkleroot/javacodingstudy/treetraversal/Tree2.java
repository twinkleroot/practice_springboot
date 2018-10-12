package com.twinkleroot.javacodingstudy.treetraversal;

public class Tree2 {
    Node2 root;

    public void add(char data, char leftData, char rightData) {
        if(root == null) {
            if(data != '.') root = new Node2(data);
            if(leftData != '.') root.left = new Node2(leftData);
            if(rightData != '.') root.right = new Node2(rightData);
        } else {
            search(root, data, leftData, rightData);
        }
    }

    private void search(Node2 root, char data, char leftData, char rightData) {
        if(root == null) return;
        else if(root.data == data) {
            if(leftData != '.') root.left = new Node2(leftData);
            if(rightData != '.') root.right = new Node2(rightData);
        } else {
            search(root.left, data, leftData, rightData);
            search(root.right, data, leftData, rightData);
        }
    }

    public void preorder(Node2 root) {
        System.out.print(root.data);
        if(root.left != null) preorder(root.left);
        if(root.right != null) preorder(root.right);
    }

    public void inorder(Node2 root) {
        if(root.left != null) inorder(root.left);
        System.out.print(root.data);
        if(root.right != null) inorder(root.right);
    }

    public void postorder(Node2 root) {
        if(root.left != null) postorder(root.left);
        if(root.right != null) postorder(root.right);
        System.out.print(root.data);
    }
}
