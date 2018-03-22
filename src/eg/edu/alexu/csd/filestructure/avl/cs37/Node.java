package eg.edu.alexu.csd.filestructure.avl.cs37;

import eg.edu.alexu.csd.filestructure.avl.INode;

public class Node<T extends Comparable<T>> implements INode<T> {
	private INode<T> leftChild;
	private INode<T> rightChild;
	private INode<T> parent;
	private T value ;
	private int rightHeight;
	private int leftHeight;

	public Node(INode<T>parent ,T value){
		this.leftHeight=0;
		this.rightHeight=0;
		this.value = value;
		this.leftChild=null;
		this.rightChild=null;
		this.parent = parent;
	}
	public Node(){
		this.leftHeight=0;
		this.rightHeight=0;		this.value = null;
		this.leftChild=null;
		this.rightChild=null;
		this.parent=null;
		
	}
	public Node(INode<T>parent ,T value,INode<T> left,INode<T> right){
		this.leftHeight=0;
		this.rightHeight=0;
		this.value = value;
		this.leftChild=left;
		this.rightChild=right;
		this.parent=parent;
		
	}
	public int height(){
		return this.leftHeight > this.rightHeight ? this.leftHeight : this.rightHeight; 
	}
	public void setLeftChild(INode<T> leftChild){
		this.leftChild = leftChild;
	}
	public void setRightChild(INode<T> rightChild){
		this.rightChild = rightChild;
	}
	public void setParent(INode<T> parent){
		this.parent = parent;
	}
	public INode<T> getParent(){
		return this.parent;
	}
	@Override
	public INode<T> getLeftChild() {
		return leftChild;
	}

	@Override
	public INode<T> getRightChild() {
		return rightChild;
	}

	@Override
	public T getValue() {
		return value;
	}

	@Override
	public void setValue(T value) {
		this.value =value;
	}

}
