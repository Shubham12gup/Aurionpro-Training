package com.aurionpro.model;

public class CustomLinkedList {

	static class Node {

		private int data;
		private Node nextNode;

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
	}

	private Node head;

	public void insert(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node currentNode = head;
			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(newNode);
		}
	}

	public void insertNodeAt(int index, int data) {
		Node newNode = new Node(data);
		Node node = head;
		Node temp = null;
		if (index == 0) {
			newNode.setNextNode(head);
			head = newNode;
		} else {
			for (int i = 1; i < index; i++) {
				node = node.getNextNode();
			}
			temp = node.getNextNode();
			node.setNextNode(newNode);
			newNode.setNextNode(temp);
		}
	}

	public void insertHead(int data) {
		Node newNode = new Node(data);
		newNode.setNextNode(head);
		head = newNode;
	}

	public void remove(int key) {
		Node currNode = head, prev = null;

		if (currNode != null && currNode.data == key) {
			head = currNode.getNextNode(); // Changed head
			System.out.println(key + " found and deleted");
		} else {

			while (currNode != null && currNode.data != key) {
				prev = currNode;
				currNode = currNode.getNextNode();
			}

			if (currNode != null) {
				prev.nextNode = currNode.getNextNode();
				System.out.println(key + " found and deleted");
			}

			if (currNode == null) {
				System.out.println(key + " not found");
			}
		}
	}

	public void removeNodeAt(int index) {
		Node node = head;
		if (index == 0) {
			head = node.getNextNode();
		} else {
			for (int i = 0; i < index - 1; i++) {
				node = node.getNextNode();
			}
		}
		node.setNextNode(node.getNextNode().getNextNode());
	}

	public void display() {
		if (head != null) {
			Node currentNode = head;
			while (currentNode.getNextNode() != null) {
				System.out.println(currentNode.getData());
				currentNode = currentNode.getNextNode();
			}
			System.out.println(currentNode.getData());
		}
	}

}
