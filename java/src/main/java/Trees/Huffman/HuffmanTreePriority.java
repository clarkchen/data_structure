package Trees.Huffman;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

import Trees.basic.HuffmanNode;

public class HuffmanTreePriority {
	
	HashMap<Character,String> charList= new HashMap<Character,String>();
	HuffmanNode root;
	//统计每个字符出现的次数
	public HashMap<Character, Integer> converWord(String s)
	{
		HashMap<Character, Integer>  h = new HashMap<Character, Integer>();
			
		for(int i=0;i<s.length();i++)
		{
			char temp = s.charAt(i);
			if(h.containsKey(temp))
			{
				int v = h.get(temp)+1;
				h.put(temp, v) ;
				
			}else{
			h.put(temp, 1);}
		}
		
		return h;
	}
	//插入优先队列
	public PriorityQueue<HuffmanNode> init(String s)
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
	//拿到两个最小的合成新的结点，加入到队列中去
	public void createTree(PriorityQueue<HuffmanNode> words)
	{
		
		if(words.size()==1) return;
		HuffmanNode f = words.poll();
		HuffmanNode s = words.poll();
		HuffmanNode n =  new HuffmanNode("no", f.count+s.count);
		n.left = f;
		n.right = s;
		words.offer(n);
		createTree(words);
	}
	//获取每个字符的编码
	public void encodeChar(HuffmanNode root,String Code)
	{
		if(root.isLeaf())
		{
			assert(root.Value.length()==1);
			charList.put(root.Value.toCharArray()[0], Code);
			return;
		}
		//向左添加0
		encodeChar(root.left,Code+"0");
		//向右添加1
		encodeChar(root.right,Code+"1");
	}
	public void prepareEncode(String s)
	{
		//input
		PriorityQueue<HuffmanNode> words = init(s);
		//树的创建，最后变为size为1的 队列，内容即为root
		createTree(words);
		HuffmanNode root =  words.poll();
		
		//给每一个元素赋值
		encodeChar(root, "");
		
		this.root = root;
	}
	public String encode(String s)
	{
		if(charList.isEmpty()) this.prepareEncode(s);
		StringBuffer rt = new StringBuffer();
		for(int i=0;i<s.length();i++)
		{
			rt.append(charList.get(s.charAt(i)));
		}
		return rt.toString();
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
	public void showCharList()
	{
		for(Iterator<Character> i = charList.keySet().iterator();i.hasNext();)
		{
			Character key = i.next();
			String Value = charList.get(key);
			System.out.println(key+"  "+Value);
		}
	}
	public static void main(String[] args) {
		
	}
}
