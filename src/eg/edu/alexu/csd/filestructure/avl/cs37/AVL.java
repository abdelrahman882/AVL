package eg.edu.alexu.csd.filestructure.avl.cs37;

import eg.edu.alexu.csd.filestructure.avl.IAVLTree;
import eg.edu.alexu.csd.filestructure.avl.INode;

public class AVL<T extends Comparable<T>> implements IAVLTree<T>{
private Node<T> root;

	private void rotateLeft(Node<T> midNode){
		Node<T> parent =(Node<T>) midNode.getParent();
		if(parent==root){
			root = midNode;
		}else{
		if(((Node<T>)parent.getParent()).getLeftChild()==parent){
			((Node<T>)parent.getParent()).setLeftChild(midNode);
		}else{
			((Node<T>)parent.getParent()).setRightChild(midNode);
		}
		}
		midNode.setParent(parent.getParent());
		parent.setRightChild(midNode.getLeftChild());
		midNode.setLeftChild(parent);
		parent.setParent(midNode);
		parent.updateHeight();
	}
	private void rotateRight(Node<T> midNode){
		
		Node<T> parent =(Node<T>) midNode.getParent();
		if(parent==root){
			root = midNode;
		}else{
		if(((Node<T>)parent.getParent()).getLeftChild()==parent){
			((Node<T>)parent.getParent()).setLeftChild(midNode);
		}else{
			((Node<T>)parent.getParent()).setRightChild(midNode);
		}
		}
		midNode.setParent(parent.getParent());
		parent.setLeftChild(midNode.getRightChild());
		midNode.setRightChild(parent);
		parent.setParent(midNode);
		parent.updateHeight();
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
				break;
			}
		}else if (comparasion <0){
			Node<T> temp =(Node<T>) current.getLeftChild();
			if(temp!=null){
			current =  temp;
			}else{
				current.setLeftChild(new Node<T>(current,key));
				break;
			}
		}else{
			current.setValue(key);
			return;
		}
		
		}
		while(current!=null){
			current.updateHeight();
			int leftHeight,rightHeight;
			leftHeight =current.LeftHeight();
			rightHeight =current.rightHeight();
			if(leftHeight-rightHeight>=2){
				Node<T> temp = (Node<T>) current.getLeftChild();
				current = (Node<T>) current.getParent();
				if(temp.LeftHeight()>temp.rightHeight()){
					rotateRight(temp);
				}else {
					rotateLeftRight(temp);
				}
			}else if(rightHeight-leftHeight >=2){
				Node<T> temp = (Node<T>) current.getRightChild();
				current = (Node<T>) current.getParent();
				if(temp.LeftHeight()<temp.rightHeight()){
					rotateLeft(temp);
				}else {
					rotateRightLeft(temp);
				}
			}else{
				current = (Node<T>) current.getParent();
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

	public void printAVL (){
		print(root);
	}
	private void print (Node<T> x){
		System.out.println("Val:"+x.getValue() + " | LH:"+x.LeftHeight()+" | RH:"+x.rightHeight()+" | H:"+x.height());
		if(x.getLeftChild()!=null){
			print((Node<T>) x.getLeftChild());
		}
		if(x.getRightChild()!=null){
			print((Node<T>) x.getRightChild());
		}
	

	}
}
