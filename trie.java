import java.util.*;
class TrieNode
{
	Integer val ;
	TrieNode[] node;
	TrieNode()
	{	
		node = new TrieNode[ 26 ] ; 
	}
}
class Trie
{
	TrieNode root ;
	Trie()
	{
		root = new TrieNode() ;
	}
	public void insert( String s, int n )
	{
		TrieNode t = root ;
		int l = s.length() ;
		for( int i = 0 ; i < l ; i++ )
		{
			int index = s.charAt( i ) - 'a' ;
			if( t.node[ index ] == null )
			{
				t.node[ index ] = new TrieNode() ; 
			}
			t = t.node[ index ] ;
		}
		t.val = n ;
	}
	public boolean search( String s )
	{
		TrieNode t = root ;
		int l = s.length() ;
		for( int i = 0 ; i < l ; i++ )
		{
			int index = s.charAt( i ) - 'a' ;
			if( t.node[ index ] == null )
				return false;
			t = t.node[ index ] ;
		}
		if( t.val != null)
			return true ;
		else
			return false ;
	}
}
class Solution
{
	public static void main( String args[] )
	{
		Trie t = new Trie();
		t.insert("word",26) ;
		t.insert("saurabh",10) ;
		t.insert("sun",20) ;
		System.out.println(t.search("sun"));
		System.out.println(t.search("wor"));
	}
	
}