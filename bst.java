package uca;
public class BST {
    class Node{
        int key;
        Node right;
        Node left;    
        public Node( int key )
        {
            this.key = key;
            this.left = null;
            this.right = null;
        }        
    }
    Node root;
    public void insert( int key )
    {
       this.root = this.insert( root , key ); 
    }
    public boolean search( int key )
    {
        return search( root , key );
    }
    public int getmin()
    {
        return getmin( root ).key;
    }
    public int getmax()
    {
        return getmax( root ).key;
    }
    public void delmin()
    {
        root = delmin( root );
    }
    public void delmax()
    {
        root = delmax( root );
    }
    public void del( int key )
    {
        root = del( root , key );
    }
    private Node del( Node n , int key )
    {
        if( n == null ) return n;
        if( key < n.key )
        {
            n.left = del( n.left , key );
        }
        else if( key > n.key )
        {
            n.right = del( n.right , key );
        }
        else
        {
            if( n.left == null ) return n.right;
            if( n.right == null ) return n.left;
            Node min = getmin( n.right );
            n.key = min.key;
            n.right = delmin( n.right );
        }    
        return n;
    }        
    private Node delmax( Node n )
    {
        if( n == null ) return n;
        if( n.right == null )
        {
            return n.left;
        }
        n.right = delmax( n.right );
        return n;
    }        
    private Node delmin( Node n )
    {
        if( n == null ) return n;
        if( n.left == null )
        {
            return n.right;
        }
        n.left = delmin( n.left );
        return n;
    }        
    private Node getmax( Node n )
    {
        if( n == null ) return n;
        if( n.right == null ) return n;
        return getmax( n.right );
    }
    private Node getmin( Node n )
    {
        if( n == null ) return n;
        if( n.left == null ) return n;
        return getmin( n.left );
    }
    private boolean search( Node n , int key )
    {
        if( n == null ) return false;
        else if( n.key == key ) return true;
        else if( key < n.key ) return search( n.left , key );
        return search( n.right , key );
    }        
    private Node insert( Node n , int key )
    {
        if( n == null ) return new Node( key );
        if( n.key == key ) ;//Updation and all......
        else if( key < n.key ) n.left = insert( n.left , key );
        else n.right = insert( n.right , key );
        return n;
    }
    public static void main(String[] args) {
        BST b  = new BST();
        b.insert( 5 );
        b.insert( 3 );
        b.insert( 4 );
        b.insert( 2 );
        b.insert( 7 );
        b.insert( 8 );
        b.insert( 6 );
       // b.del( 5 );
       System.out.println( b.search( 5 ) );
        
    }
}