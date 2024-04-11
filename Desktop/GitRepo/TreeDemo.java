class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      //pre order traversal method
      //node, left, right
      
      //if root is null, return
      if (root == null)
            return;
        
        //start at root value
        System.out.println(root.value);

        //traverse left
        preOrderTraversal(root.left);

        //traverse right
        preOrderTraversal(root.right);
    }

   
   
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      //in order traversal 
       //left, node, right
       
       //if root is null, return
       if (root == null)
           return;
   
       //traverse left subtree
       inOrderTraversal(root.left);
   
       //print root
       System.out.println(root.value);
   
       //traverse right subtree
       inOrderTraversal(root.right);
    
   }
   
   
   
   /*
   post-order traversal
   */
   public void postOrderTraversal(Node root){
      //post order traversal 
      //left, right, node
       
      //if root is null, return
      if (root == null)
           return;
   
      //traverse left subtree
      postOrderTraversal(root.left);
   
      //traverse right subtree
      postOrderTraversal(root.right);
      
      //print root
      System.out.println(root.value);
    
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
      //base case
      //if root is null, return false
      if (root == null)
          return false;
   
       //if=f the key == root, return true
       if (root.value == key)
           return true;
   
       //if key is less than root value, search in the left subtree
       if (key < root.value)
           return find(root.left, key);
   
       //if key is greater than root value, search in the right subtree
       return find(root.right, key);
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
   public int getMin(Node root){
      
      //base case
      //if the root is null, return (-1)
      if (root == null)
         return -1;
         
       //else, if root is not null
       //traverse the left subtree until you reach leaf node
       while (root.left != null) {
         root = root.left;
       }
   
       //return the value of the very left node, the minimum value in tree
       return root.value;
}
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	   
      //base case
      //if the root is null, return (-1)
      if (root == null)
         return -1;
         
       //else, if root is not null
       //traverse the right subtree until you reach leaf node
       while (root.right != null) {
         root = root.right;
       }
   
       //return the value of the very right node, the maximum value in tree
       return root.value;
}
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.root = t1.insert(t1.root, 24);
      t1.insert(t1.root,80);
      t1.insert(t1.root,18);
      t1.insert(t1.root,9);
      t1.insert(t1.root,90);
      t1.insert(t1.root,22);
            
      System.out.print("in-order :   \n");
      t1.inOrderTraversal(t1.root);
      System.out.println();
      
      System.out.print("pre-order :   \n");
      t1.preOrderTraversal(t1.root);
      System.out.println();
      
      System.out.print("post-order :   \n");
      t1.postOrderTraversal(t1.root);
      System.out.println();
      
      System.out.println(t1.find(t1.root, 24));
      
      System.out.println(t1.getMin(t1.root));
      
      System.out.println(t1.getMax(t1.root));
           
      
   }  
}