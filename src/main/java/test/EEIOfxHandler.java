package test;

import com.webcohesion.ofx4j.io.OFXHandler;
import com.webcohesion.ofx4j.io.OFXSyntaxException;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EEIOfxHandler implements OFXHandler {
	
	private Map<String, String> headers;
	private Stack<OfxNode> stack;
	private OfxNode root;
	
	public EEIOfxHandler() {
		headers = new HashMap<String, String>();
		stack = new Stack<OfxNode>();
	}
	
	public void onHeader(String name, String value) throws OFXSyntaxException {
//		System.out.println(String.format("onheader: name:%s value:%s", name, value));
		headers.put(name, value);
	}

	public void onElement(String name, String value) throws OFXSyntaxException {
//		System.out.println(String.format("onElement: name:%s value:%s", name, value));
		OfxNode sgmlNode = new OfxNode(name, value);
		stack.peek().getChildren().add(sgmlNode);
	}

	public void startAggregate(String aggregateName) throws OFXSyntaxException {
//		System.out.println(String.format("startAggregate: aggregateName:%s", aggregateName));
		
		OfxNode sgmlNode = new OfxNode(aggregateName);
		if(!stack.empty()) {
			stack.peek().getChildren().add(sgmlNode);
		}
		stack.push(sgmlNode);
	}

	public void endAggregate(String aggregateName) throws OFXSyntaxException {
//		System.out.println(String.format("endAggregate: aggregateName:%s", aggregateName));
		OfxNode node = stack.pop();
		if(stack.isEmpty()) {
			root = node;
		}
	}

	public Map<String, String> getHeaders(){
		return headers;
	}
	
	public OfxNode getRoot() {
		return root;
	}
}
