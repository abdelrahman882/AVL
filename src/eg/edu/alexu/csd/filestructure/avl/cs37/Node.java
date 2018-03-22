package eg.edu.alexu.csd.filestructure.avl.cs37;

import eg.edu.alexu.csd.filestructure.avl.INode;

public class Node<T extends Comparable<T>> implements INode<T> {
	private T value ;
	private INode<T> leftChild;
	private INode<T> rightChild;
	private INode<T> parent;
	private int rightHeight;
	private int leftHeight;

	public Node(INode<T>parent ,T value){
		this.leftHeight=-1;
		this.rightHeight=-1;
		this.value = value;
		this.leftChild=null;
		this.rightChild=null;
		this.parent = parent;
	}
	public Node(){
		this.leftHeight=-1;
		this.rightHeight=-1;		
		this.value = null;
		this.leftChild=null;
		this.rightChild=null;
		this.parent=null;
		
	}
	public Node(INode<T>parent ,T value,Node<T> left,Node<T> right){
		this.leftHeight=left.height();
		this.rightHeight=right.height();
		this.value = value;
		this.leftChild=left;
		this.rightChild=right;
		this.parent=parent;
		
	}
	public void updateHeight(){
		if(rightChild!=null){
			rightHeight = ((Node<T>)rightChild).height();
		}else{
			rightHeight=-1;
		}
		
		
		if(leftChild != null){
			leftHeight = ((Node<T>)leftChild).height();
		}else{
			leftHeight=-1;
		}
	}
	public int height(){
		return (this.leftHeight > this.rightHeight ? (this.leftHeight+1) : (this.rightHeight+1)); 
	}
	public int LeftHeight(){
		return this.leftHeight ;
	}
	public int rightHeight(){
		return this.rightHeight ;
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
