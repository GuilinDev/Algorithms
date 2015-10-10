package com.guilin.others;

/*
 * Implement a double LinkedList 
 */

public class ImplementLinkedListGuilinZhang {
	
	// Define a node class
	public static class Node {
		Object val;
		Node prev = this;
		Node next = this;
		
		Node(Object val) {
			this.val = val;
		}
	}
	
	// Define head - point to null
	private Node head = new Node(null);
	private int size;
	
	/*
	 * Add element as first
	 */
	public boolean addFirst (Object obj) {
		addAfter(new Node(obj), head);		
		return true;
	}
	
	/*
	 * Add element as last
	 */
	public boolean addLast(Object obj) {
		addBefore(new Node(obj), head);
		return true;
	}
	
	/*
	 * Default to add to last
	 */
	public boolean add(Object obj){
		return addLast(obj);
	}
	
	/*
	 * Add to particular postion
	 */
	public boolean add(int index, Object obj){
		addBefore(new Node(obj), getNode(index));
		return true;
	}
	
	/*
	 * Search the Node by index
	 */
	private Node getNode(int index) {
		if (index < 0 || index >= size){
			return null;
		}
		Node node = head.next;
		for (int i = 0; i <= index - 1; i++){
			node = node.next;
		}
		return node;
	}
	
	/*
	 * Add element before a node
	 */
	private void addBefore(Node newNode, Node node) {
		newNode.next = node;
		newNode.prev = node.prev;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		size++;
	}
	
	/*
	 * Add element after a node
	 */
	private void addAfter(Node newNode, Node node) {
		newNode.prev = node;
		newNode.next = node.next;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		size++;
	}
	
	/*
	 * Update a node
	 */
	public boolean revise(int index, Object obj){
		reviseNode(new Node(obj), getNode(index));
		return true;
	}

	private void reviseNode(Node newNode, Node node) {
		newNode.next = node.next;
		newNode.prev = node.prev;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
	}
	
	/*
	 * Remove a node
	 */
	public boolean remove(int index){
		removeNode(getNode(index));
		return true;
	}

	private void removeNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.prev = null;
		node.next = null;
		size--;
	}
	
	/*
	 * Remove first element
	 */
	public boolean removeFirst() {
		removeNode(head.next);
		return true;
	}
	
	/*
	 * Remove last element
	 */
	public boolean removeLast() {
		removeNode(head.prev);
		return true;
	}
	
	/*
	 * Get value with index
	 */
	public Object get(int index) {
		return getNode(index).val;
	}
	
	/*
	 * Size of LinkList
	 */
	public int size() {
		return size;
	}
	
	/*
	 * toString method
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node node = head;
		for (int i = 0; i <= size - 1; i++) {
			node = node.next;
			if (i > 0) {
				sb.append(" ");				
			}
			sb.append(node.val);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ImplementLinkedListGuilinZhang testLinkList = new ImplementLinkedListGuilinZhang();
		
		testLinkList.add("0");
		testLinkList.add("1");
		testLinkList.add("2");
		testLinkList.add("3");
		testLinkList.add("4");
		// Test add(), size(), get()
		for (int i = 0; i <= testLinkList.size() - 1; i++){
			System.out.println("Test add(), size(), get()===> " + testLinkList.get(i));
		}
		
		// Test addFirst(), addLast()
		testLinkList.addFirst("-1");
		testLinkList.addLast("5");
		for (int i = 0; i <= testLinkList.size() - 1; i++){
			System.out.println("Test addFirst(), addLast()===> " + testLinkList.get(i));
		}
		
		// Test removeFirst(), removeLast()
		testLinkList.removeFirst();
		testLinkList.removeLast();
		for (int i = 0; i <= testLinkList.size() - 1; i++){
			System.out.println("Test removeFirst(), removeLast()===> " + testLinkList.get(i));
		}
	}

}
