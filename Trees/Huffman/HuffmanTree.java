package Huffman;
import java.util.*;

import basic.HuffmanNode;
public class HuffmanTree {
	HashMap<String,String> charList= new HashMap<String,String>();
	HuffmanNode root;
	public void encodeChar(HuffmanNode root,String Code)
	{
		if(root.isLeaf())
		{
			charList.put(root.Value, Code);
			return;
		}
		encodeChar(root.left,Code+"0");
		encodeChar(root.right,Code+"1");
	}
	public void showCharList()
	{
		for(Iterator<String> i = charList.keySet().iterator();i.hasNext();)
		{
			String key = i.next();
			String Value = charList.get(key);
			System.out.println(key+"  "+Value);
		}
	}
 
	public void createTree(ArrayList<HuffmanNode> words)
	{
		 if (words.size()==1) return;
		 HuffmanNode f = findMin(words);
		 HuffmanNode s = findMin(words);
		 HuffmanNode n = new HuffmanNode("no",f.count+s.count);
		 n.left  = f;
		 n.right = s;
		 words.add(n);
		 createTree(words);
	}
	
	protected HuffmanNode findMin(ArrayList<HuffmanNode> words)
	{
		int i=1;
		int j = 0;
		while(i<words.size())
		{
			if (words.get(j).count>words.get(i).count)
			{
				j = i;
			}
			i++;
		}
		HuffmanNode hmf = words.get(j);
		words.remove(j);
		return hmf;
	}
	public HashMap<Character, Integer> converWord(String s)
	{
		HashMap<Character, Integer>  h = new HashMap<Character, Integer>();
			
		for(int i=0;i<s.length();i++)
		{
			char temp = s.charAt(i);
			if(h.containsKey(temp))
			{
				int v = h.get(temp)+1;
//				System.out.println(temp+" "+v);
				h.put(temp, v) ;
				
			}else{
			h.put(temp, 1);}
		}
		
		return h;
	}

	public ArrayList<HuffmanNode> init(String s)
	{
		HashMap<Character, Integer>  h =  this.converWord(s);
		ArrayList<HuffmanNode>  rt = new ArrayList<HuffmanNode> ();
		for(Iterator<Character> i = h.keySet().iterator();i.hasNext();)
		{
			
			Character key =  i.next();
			int count = h.get(key);
//			System.out.println(key+"   "+count);
			HuffmanNode hn = new HuffmanNode(Character.toString(key),count);
			rt.add(hn);
		}
		return rt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuffmanTree ht = new HuffmanTree();
		
		//input
		ArrayList<HuffmanNode> words = ht.init("beep boop beer!");
		
		//树的创建
		ht.createTree(words);
		HuffmanNode root =  words.get(0);
		ht.encodeChar(root, "");
		ht.showCharList();
		String text = "BADCADFEED";
		
	}

}
