package Huffman;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

import basic.HuffmanNode;

public class HuffmanTreePriority extends HuffmanTree{
	
	
	public PriorityQueue<HuffmanNode> init2(String s)
	{
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(11,new Comparator<HuffmanNode>() {
			public int compare(HuffmanNode h1,HuffmanNode h2)
			{
				return h1.count-h2.count;
			}
		});
		HashMap<Character, Integer>  h =  this.converWord(s);
		for(Iterator<Character> i = h.keySet().iterator();i.hasNext();)
		{
			
			Character key =  i.next();
			int count = h.get(key);
			HuffmanNode hn = new HuffmanNode(Character.toString(key),count);
			pq.offer(hn);
		}
		return pq;
	}
	public void createTree2(PriorityQueue<HuffmanNode> words)
	{
		
		if(words.size()==1) return;
		HuffmanNode f = words.poll();
		HuffmanNode s = words.poll();
		HuffmanNode n =  new HuffmanNode("no", f.count+s.count);
		n.left = f;
		n.right = s;
		words.offer(n);
		createTree2(words);
	}
	public void prepareEncode(String s)
	{
		//input
		PriorityQueue<HuffmanNode> words = init2(s);
		//树的创建
		createTree2(words);
		HuffmanNode root =  words.poll();
		encodeChar(root, "");
		this.root = root;
	}
	public String encode(String s)
	{
		if(charList.isEmpty()) this.prepareEncode(s);
		String rt = "";
		for(int i=0;i<s.length();i++)
		{
			String key = Character.toString(s.charAt(i));
			rt += charList.get(key);
		}
		return rt;
	}
	public String res = "";
	public void clear()
	{
		res="";
	}
	public void decode(String code,HuffmanNode root)
	{
		if(code.length()==0) 
		{
			res += root.Value;return;
		}
		if(root.isLeaf())
		{
			res += root.Value;
			root = this.root;
		}
		if(code.charAt(0) == '0' ) 
		{
			decode(code.substring(1),root.left);
		}
		if(code.charAt(0) == '1' ) 
		{
			decode(code.substring(1),root.right);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuffmanTreePriority ht = new HuffmanTreePriority();
		String text = "beep boop beer!";
		
		ht.prepareEncode(text);
		ht.showCharList();
		
		//编码解码
		String code = ht.encode(text);		
		System.out.println(code);
		
		ht.clear();
		ht.decode(code,ht.root);
		System.out.println(ht.res);
	}
}
