package com.guilin.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leet257BinaryTreePaths {
	/*
	 * Given a binary tree, return all root-to-leaf paths.

		For example, given the following binary tree:

   		  1
 		/   \
	   2     3
 		\
  		 5
		All root-to-leaf paths are:

		["1->2->5", "1->3"]
	 */
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if (root == null) {
            return paths;
        }
        List<TreeNode> onePath = new LinkedList<TreeNode>();
        findAllPaths(root, onePath, paths);
        return paths;
    }
    
    // Solution1: A DFS solution from deep left to right
    private static void findAllPaths (TreeNode root, List<TreeNode> onePath, List<String> paths) {
        onePath.add(root);
        if (root.left != null) {
            findAllPaths(root.left, onePath, paths);
        }
        if (root.right != null) {
            findAllPaths(root.right, onePath, paths);
        }
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            // one path contains all values of one "path"
            for (int i = 0; i < onePath.size(); i++) {
                sb.append(onePath.get(i).val);
                if (i != onePath.size() - 1) { // do not append last "->"
                    sb.append("->");
                }
            }
            paths.add(sb.toString());
        }
        onePath.remove(onePath.size() - 1); // retreat one step to start another path
    }
    
    // Solution 2: Non helper solution
    public List<String> binaryTreePaths2(TreeNode root) {
    	List<String> paths = new ArrayList<String>();
    	
    	if (root == null) {
    		return paths;
    	}
    	if (root.left == null && root.right== null) {
    		paths.add(root.val + "");
    		return paths;
    	}
    	
    	for (String path : binaryTreePaths2(root.left)) {
    		paths.add(root.val + "->" + path);
    	}
    	
    	for (String path : binaryTreePaths2(root.right)) {
    		paths.add(root.val + "->" + path);
    	}
    	
    	return paths;
    }
}
