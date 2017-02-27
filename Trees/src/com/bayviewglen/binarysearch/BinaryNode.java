package com.bayviewglen.binarysearch;

public class BinaryNode {
	public BinaryNode leftChild;
	public BinaryNode rightChild;
	private Comparable element;

	public BinaryNode(Comparable value) {
		element = value;
	}

	public BinaryNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryNode rightChild) {
		this.rightChild = rightChild;
	}

	public BinaryNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryNode leftChild) {
		this.leftChild = leftChild;
	}

	public Comparable getElement() {
		return element;
	}

	public void setElement(Comparable comparable) {
		this.element = comparable;
	}

	public boolean remove(Comparable value, BinaryNode node) {
		if (value.compareTo(node.getElement()) == -1) {
			if (this.getLeftChild() != null) {
				return node.getLeftChild().remove(value, node);
			} else {
				return false;
			}
		} else if (value.compareTo(node.getElement()) == 1) {
			if (this.getRightChild() != null) {
				return node.getRightChild().remove(value, node);
			} else {
				return false;
			}
		}
		return false;
	}

	public boolean compareTo(Comparable value) {
		// TODO Auto-generated method stub
		return false;
	}

}
