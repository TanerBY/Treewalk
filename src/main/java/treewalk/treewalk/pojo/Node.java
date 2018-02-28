package treewalk.treewalk.pojo;

import java.util.ArrayList;
import java.util.List;

public class Node<String> {
	
	private List<Node<String>> children = new ArrayList<Node<String>>();
	private Node<String> parent = null;
	private String data = null;

	public Node(String data) {
		this.data = data;
	}

	public List<Node<String>> getChildren() {
		return children;
	}

	public void setParent(Node<String> parent) {
		this.parent = parent;
	}

	public void addChild(Node<String> child) {
		child.setParent(this);
		this.children.add(child);
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isRoot() {
		return (this.parent == null);
	}

	public boolean isLeaf() {
		if (this.children.size() == 0)
			return true;
		else
			return false;
	}

}
