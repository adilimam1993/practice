package test;

import java.util.ArrayList;
import java.util.List;

public class OfxNode {
	enum OfxNodeType {
		AGGREGATE, ELEMENT
	}
	private final String name;
	private final String value;
	private List<OfxNode> children;
	private final OfxNodeType type;
	
	public OfxNode(String name) {
		this.name = name;
		this.value = null;
		children = new ArrayList<OfxNode>();
		this.type = OfxNodeType.AGGREGATE;
	}
	
	public OfxNode(String name, String value) {
		this.name = name;
		this.value = value;
		children = new ArrayList<OfxNode>();
		this.type = OfxNodeType.ELEMENT;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public List<OfxNode> getChildren() {
		return children;
	}

	public OfxNodeType getType() {
		return type;
	}
}
