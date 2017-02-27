package com.bayviewglen.binarysearch;

public class BinarySearchTree {
	public static BinaryNode root = null;

	public BinarySearchTree() {
		this.root = null;
	}

	// checks if node can be root, or else calls recursive add function
	public void insert(Comparable key) {
		BinaryNode node = new BinaryNode(key);
		if (root == null) {
			root = node;
		} else {
			add(root, node);
		}
	}

	// accepts parent node and node to be added (recursive)
	private void add(BinaryNode parent, BinaryNode node) {
		if (node.getElement().compareTo(parent.getElement()) <= 0) {
			if (parent.getLeftChild() != null) {
				add(parent.getLeftChild(), node);
			} else {
				parent.setLeftChild(node);
			}
		} else if (node.getElement().compareTo(parent.getElement()) >= 0) {
			if (parent.getRightChild() != null) {
				add(parent.getRightChild(), node);
			} else {
				parent.setRightChild(node);
			}
		}
	}

	// traversal methods (recursive)
	public void preOrder(BinaryNode root) {
		System.out.println(root.getElement());
		if (root.getLeftChild() != null) {
			preOrder(root.getLeftChild());
		}
		if (root.getRightChild() != null) {
			preOrder(root.getRightChild());
		}
	}

	public void inOrder(BinaryNode root) {
		if (root.getLeftChild() != null) {
			inOrder(root.getLeftChild());
		}
		System.out.println(root.getElement());
		if (root.getRightChild() != null) {
			inOrder(root.getRightChild());
		}
	}

	public void postOrder(BinaryNode root) {
		if (root.getLeftChild() != null) {
			postOrder(root.getLeftChild());
		}
		if (root.getRightChild() != null) {
			postOrder(root.getRightChild());
		}
		System.out.println(root.getElement());
	}

	public BinaryNode find(Comparable search) {
		if (root != null) {
			BinaryNode node = new BinaryNode(search);
			return find(root, node);
		} else {
			return null;
		}
	}

	// recursive function, finds a node in tree
	private BinaryNode find(BinaryNode parent, BinaryNode node) {
		if (parent != null) {
			if (parent.getElement() == node.getElement()) {
				return parent;
			} else {
				// left subtree search
				BinaryNode searchTree = find(parent.getLeftChild(), node);

				if (searchTree == null) {
					// if not found in left subtree recursively search right
					searchTree = find(parent.getRightChild(), node);
				}
			}
		}
		return node;
	}

	public void remove(Comparable e, BinaryNode node, BinaryNode parent) {
		// check if node is actually in tree
		if (node == null || node.getElement() == null) {
			System.out.println("Element is not in tree");
		}
		if (node.getElement().compareTo(e) == 0) {
			if (node.equals(parent)) {
				removeWithChild(e, node);
			} else if (node.getLeftChild() == null && node.getRightChild() == null) {
				// deleting leaf from tree
				if (parent.getRightChild().getElement().equals(node.getElement())) {
					parent.setRightChild(null);
				} else {
					parent.setLeftChild(null);
				}
			} else if (node.getLeftChild() == null) {
				if (parent.getLeftChild().getElement().equals(node.getElement())) {
					parent.setLeftChild(node.getRightChild());
				} else {
					parent.setRightChild(node.getRightChild());
				}
			} else if (node.getRightChild() == null) {
				if (parent.getLeftChild().getElement().equals(node.getElement())) {
					parent.setLeftChild(node.getLeftChild());
				} else {
					parent.setRightChild(node.getLeftChild());
				}

			} else {
				BinaryNode temp = minValue(node.getRightChild());
				remove(temp.getElement(), node, node);
				node.setElement(temp.getElement());
			}
		} else {
			if (e.compareTo(node.getElement()) <= 0) {
				remove(e, node.getLeftChild(), node);
			} else {
				remove(e, node.getRightChild(), node);
			}
		}

	}

	private void removeWithChild(Comparable e, BinaryNode node) {
		if(node.getLeftChild() == null && node.getRightChild() == null){
			root = null;
		} else if (node.getLeftChild() == null){
			node = node.getRightChild();
		} else if (node.getRightChild() == null){
			node = node.getLeftChild();
		} else {
			BinaryNode temp = node.getLeftChild();
			node = node.getRightChild();
			node.setLeftChild(temp);
		}
	}

	private BinaryNode minValue(BinaryNode node) {
		BinaryNode min = node;
		
		while(min.getLeftChild() != null){
			min = min.getLeftChild();
		} return (min);
	}

}
