package eg.edu.alexu.csd.filestructure.avl.cs37;

import eg.edu.alexu.csd.filestructure.avl.IAVLTree;
import eg.edu.alexu.csd.filestructure.avl.INode;

public class AVL<T extends Comparable<T>> implements IAVLTree<T>{
private Node<T> root;

	private void rotateLeft(Node<T> midNode){
		Node<T> parent =(Node<T>) midNode.getParent();
		midNode.setParent(parent.getParent());
		parent.setRightChild(midNode.getLeftChild());
		midNode.setLeftChild(parent);
		parent.setParent(midNode);
	}
	private void rotateRight(Node<T> midNode){
		Node<T> parent =(Node<T>) midNode.getParent();
		midNode.setParent(parent.getParent());
		parent.setLeftChild(midNode.getRightChild());
		midNode.setRightChild(parent);
		parent.setParent(midNode);
	}
	private void rotateLeftRight(Node<T> midNode){
		Node<T>rightChild = (Node<T>) midNode.getRightChild();
		rotateLeft(rightChild);
		rotateRight(rightChild);
	}
	private void rotateRightLeft(Node<T> midNode){
		Node<T>leftChild = (Node<T>) midNode.getLeftChild();
		rotateRight(leftChild);
		rotateLeft(leftChild);
	}
	public AVL(){
		root=new Node<T>();
	}
	@Override
	public void insert(T key) {
		if(root.getValue()==null){
			root.setValue(key);
			return;
		}
		Node<T> current = root;
		while(current!=null){
		int comparasion =	key.compareTo(current.getValue());
		if(comparasion>0){
			Node<T> temp = (Node<T>) current.getRightChild();
			if(temp!=null){
				current =temp;
			}else{
				current.setRightChild(new Node<T>(current,key));
				return;
			}
		}else if (comparasion <0){
			Node<T> temp =(Node<T>) current.getLeftChild();
			if(temp!=null){
			current =  temp;
			}else{
				current.setLeftChild(new Node<T>(current,key));
				return;
			}
		}else{
			current.setValue(key);
			return;
		}
		}
		
	}

	@Override
	public boolean delete(T key) {
		return false;
	}

	@Override
	public boolean search(T key) {
		return false;
	}

	@Override
	public int height() {
		return root.height();
	}

	@Override
	public INode<T> getTree() {
		return root;
	}

}
