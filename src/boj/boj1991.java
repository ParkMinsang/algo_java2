package boj;

import java.io.*;
import java.util.*;

public class boj1991 {
    static Node[] nodes;
    static StringBuilder prevsb, midsb, aftsb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nodes = new Node[n];
        for(int i=0; i<n; i++) nodes[i] = new Node();
        StringTokenizer st = null;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            char curr = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            nodes[curr-'A'].setNum(curr);
            if(left != '.'){
                nodes[curr-'A'].setLeft(nodes[left-'A']);
            }
            if(right != '.'){
                nodes[curr-'A'].setRight(nodes[right-'A']);
            }
        }

        prevsb = new StringBuilder();
        prev(nodes[0]);
        System.out.println(prevsb);
        midsb = new StringBuilder();
        mid(nodes[0]);
        System.out.println(midsb);
        aftsb = new StringBuilder();
        after(nodes[0]);
        System.out.println(aftsb);

    }
    static void after(Node node){
        if(node.left != null){
            after(node.left);
        }
        if(node.right != null){
            after(node.right);
        }
        aftsb.append(node.num);
    }
    static void mid(Node node){
        if(node.left != null){
            mid(node.left);
        }
        midsb.append(node.num);
        if(node.right != null){
            mid(node.right);
        }
    }
    static void prev(Node node){
        prevsb.append(node.num);
        if(node.left != null){
            prev(node.left);
        }
        if(node.right != null){
            prev(node.right);
        }
    }

    static class Node{
        public char num;
        public Node left, right;

        public void setNum(char num){
            this.num = num;
        }
        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
