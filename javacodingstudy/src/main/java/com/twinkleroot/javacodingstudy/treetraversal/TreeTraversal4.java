package com.twinkleroot.javacodingstudy.treetraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeTraversal4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int i, numberOfNode = Integer.parseInt(bufferedReader.readLine());
        Tree tree = new Tree();
        char[] data;

        for(i=0; i<numberOfNode; i++) {
            data = bufferedReader.readLine().replaceAll(" ", "").toCharArray();
            tree.add(data[0], data[1], data[2]);
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);

        bufferedReader.close();
    }

}
