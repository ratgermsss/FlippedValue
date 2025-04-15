/*	Program Name: Reverse and Flip a Binary Tree
 * 	Program Date: 4/10/25
 * 	Developers: Brian Eaton, Hailey Santander
 * 	Version: 1.1.0-Snapshot
 */

package com.btree.main;

public class ReverseAndFlipBinaryTree {
	
	public static void main(String[] args) {
		
		BaseTree base = new BaseTree();
		int[] treeValues = {4, 2, 7, 1, 3, 6, 9};
		
		for(int treeNodes : treeValues) {
			base.addNode(treeNodes);
		}
		
		base.printBaseTree(base.root);
		
		base.invertTree(base.root);
		
		base.printReversedBinaryTree(base.root);
		
		base.root = base.flipTree(base.root);
		base.printFlippedBinaryTree();
		
	}
	
}
