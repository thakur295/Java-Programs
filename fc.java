import java.io.*;

import java.util.*;

import java.lang.*;

class BST

{
    
	private Node root;
 
   	int max;
    
	String MaxStr;

    	public class Node
    
	{
        
		String data;
        
		Node left;
        
		Node right;
        
		int N;
    
	}
    
	public void insert(String key)
    
	{
        
		root = insert(root,key);
    
	}
    
	private Node insert(Node root,String key)
    
	{
        
		if(root == null)
        
		{
           
			Node node = new Node();
            
			node.data = key;
            
			node.left = null;
            
			node.right = null;
            
			node.N = 1;
            
			return node;
        
		}
        
		if(root.data.equals( key )) 
        
		{
           
			root.N++;
            
			if(max < root.N)
            
			{
                
				max = root.N;
                
				MaxStr = root.data;
            
				}
        
		}
       
		if ( root.data.compareTo( key ) < 0) 
            
			root.left = insert(root.left,key);
       
		else
            
			root.right = insert(root.right,key);
       
		return root;
    }
    
		public void printWord()
    
		{
        
			System.out.print(MaxStr + " " + max);
    

		}

}

class Solution
{
	
	public static void main(String[] args)
	
	{
	
		int th = 10;
		BST b = new BST();
		
		try
		{
        		BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
		String str = reader.readLine() ;
		while ( str != null)
		{		 
           			for(String r : str.split(" "))
           			{
               				if(r.length() >= th )
               				{
                 			 b.insert(r);
               				}
           			}
         			str = reader.readLine() ;
        		}
        		reader.close();
    	}
    catch (IOException ex)
    {
            ex.printStackTrace();
    }               
    b.printWord();
    }
}