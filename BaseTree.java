package com.btree.main;

import java.util.ArrayList;

public class BaseTree {
	
	Node root;
	
	int itteration = 2;
	ArrayList<Node> invertedValues = new ArrayList<Node>();
	ArrayList<Node> baseValues = new ArrayList<Node>();
	ArrayList<Node> flippedValues = new ArrayList<Node>();

	public void addNode(int key) {
		Node newNode = new Node(key);
		
		baseValues.add(newNode);
		
		if(root == null) {
			root = newNode;
		}
		else {
			Node focusNode = root;
			Node parent;
			
			while(true) {
				parent = focusNode;
				
				if(key < focusNode.key) {
					focusNode = focusNode.leftChild;
					
					if(focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
					
				}
				else {
					focusNode = focusNode.rightChild;
					
					if(focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
					
				}
			}
		}
		
	}
	
	public void inOrderTraverseTree(Node focusNode) {
		
		if(focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			
			inOrderTraverseTree(focusNode.rightChild);
		}
		
	}
	
	public void preOrderTraverseTree(Node focusNode) {
			
			if(focusNode != null) {
				System.out.println(focusNode);
				preOrderTraverseTree(focusNode.leftChild);
				
				preOrderTraverseTree(focusNode.rightChild);
			}
			
		}
	
	
	public void postOrderTraverseTree(Node focusNode) {
		
		if(focusNode != null) {
			postOrderTraverseTree(focusNode.leftChild);
			
			postOrderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
		
	}
	
	public Node invertTree(Node focusNode) {
	    if (focusNode == null) {
	        return null;
	    }
	    
	    Node left = invertTree(focusNode.leftChild);
	    Node right = invertTree(focusNode.rightChild);
	    
	    focusNode.leftChild = right;
	    focusNode.rightChild = left;
	    
	    invertedValues.add(right);
	    invertedValues.add(left);
	    return focusNode;
	}
	
	public Node flipTree(Node node) {
		if (node == null || node.leftChild == null) return node;

		Node newRoot = flipTree(node.leftChild);

		node.leftChild.leftChild = node.rightChild; // former right child becomes left child
		node.leftChild.rightChild = node; // current node becomes right child

		node.leftChild = null;
		node.rightChild = null;

		flippedValues.add(newRoot);
		return newRoot;
	}
	
	public Node findNode(int key) {
		Node focusNode = root;
		
		while(focusNode.key != key) {
			
			if(key < focusNode.key) {
				focusNode = focusNode.leftChild;
			}
			else {
				focusNode = focusNode.rightChild;
			}
			
			if(focusNode == null) {
				return null;
			}
			
		}
		return focusNode;
	}
	
	public Integer getNodeValue(int key) {
		Node focusNode = findNode(key);
		if(focusNode == null) {
			return null;
		}
		else {
			return focusNode.key;
		}
	}
	
	public void printBaseTree(Node focusNode) {
		System.out.println("Base Binary Tree");
		System.out.println("    " + baseValues.get(0));
		System.out.println("  " + baseValues.get(1) + "  " + baseValues.get(2));
		System.out.print("" + baseValues.get(3) + baseValues.get(4));
		System.out.println("" + baseValues.get(5) + baseValues.get(6));
		System.out.println();
	}
	
	public void printReversedBinaryTree(Node focusNode) {
		ArrayList<Node> nullEntries = new ArrayList<Node>();
		nullEntries.add(null);
		
		invertedValues.removeAll(nullEntries);
		invertedValues.add(root);
		
		System.out.println("Reversed Binary Tree");
		System.out.println("    " + invertedValues.get(6));
		System.out.println("  " + invertedValues.get(4) + "  " + invertedValues.get(5));
		System.out.print("" + invertedValues.get(2) + invertedValues.get(3));
		System.out.println("" + invertedValues.get(0) + invertedValues.get(1));
		System.out.println();
	}

   public void printFlippedBinaryTree() {
	System.out.println("Flipped Binary Tree (Upside Down)");
	inOrderTraverseTree(root);
	System.out.println("\n");
}

class Node {
	int key;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key) {
		this.key = key;
	}
	
	public String toString() {
		return " " + key + " ";
	}
	
 }
}
