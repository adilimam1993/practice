package test;

import java.util.Map;

public class OfxDataTree {
	
	private Map<String, String> headers;
	private final OfxNode root;
	
	public OfxDataTree(Map<String, String> headers, OfxNode root) {
		this.headers = headers;
		this.root = root;
	}
	
	public Map<String, String> getHeaders() {
		return headers;
	}
	
	public OfxNode getRoot() {
		return root;
	}
	
	
}
