import java.io.*;
import java.util.*;

public class Trie{
	private int SIZE=26;
	private TrieNode root;
	private static boolean abc;
 
	Trie(){
		root=new TrieNode();
	}
 
	private class TrieNode{
		private TrieNode[]  son;
		private boolean isEnd;
		private char val;
 
		TrieNode(){
			son=new TrieNode[SIZE];
			isEnd=false;
		}
	}

	public void insert(String str){
		if(str==null||str.length()==0){
			return;
		}
		TrieNode node=root;
		char[]letters=str.toCharArray();
		for(int i=0,len=str.length();i<len;i++){
			int pos=letters[i]-'a';
			if(node.son[pos]==null){
				node.son[pos]=new TrieNode();
				node.son[pos].val=letters[i];
			}
			node=node.son[pos];
		}
		node.isEnd=true;
	}
 
	public boolean isWord(String str){
		if(str==null||str.length()==0){
			return false;
		}
		TrieNode node=root;
		char[]letters=str.toCharArray();
		for(int i=0,len=str.length();i<len;i++){
			int pos=letters[i]-'a';
			if(node.son[pos]!=null){
				node=node.son[pos];
			}else{
				return false;
			}
		}
		return node.isEnd;
	}
	
	public boolean startWith(String str){
		if(str==null||str.length()==0){
			return false;
		}
		TrieNode node=root;
		char[]letters=str.toCharArray();
		for(int i=0,len=str.length();i<len;i++){
			int pos=letters[i]-'a';
			if(node.son[pos]!=null){
				node=node.son[pos];
			}else{
				return false;
			}
		}
		return true;
	}
 
	public static void main(String[] args)throws Exception{
		Trie tree=new Trie();
		Scanner input = new Scanner(new FileReader("dict.txt"));
		while (input.hasNext()){
			String s = input.next();
			tree.insert(s);
		}
		input.close();
	
		Scanner check = new Scanner(new FileReader("hw7.dat"));
		while (check.hasNextLine()){
			String s = check.nextLine();
			System.out.print(s + " ");
			System.out.println(tree.isWord(s));
		}
		check.close();
		
		System.out.println(abc);
	}

}
