package test;

import com.webcohesion.ofx4j.io.OFXParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OfxService {

	public List<OfxNode> getNodes(String nodeName, String ofxString) throws IOException, OFXParseException{
		OfxParser parser = new OfxParser();
		OfxDataTree tree = parser.parse(ofxString);
		
		return getNodes(nodeName, tree.getRoot());
		
	}
	
	public List<OfxNode> getNodes(String nodeName, OfxNode root){
		
		final List<OfxNode> nodes = new ArrayList<OfxNode>();
		if(nodeName.equals(root.getName())) {
			return nodes;
		}
		
		// Depth first search
		Stack<OfxNode> stack = new Stack<OfxNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			OfxNode node =stack.pop();
		    node.getChildren().forEach(n -> {
				if(nodeName.equals(n.getName())) {
					nodes.add(n);
				}else {
					stack.push(n);
				}
			});
		}
		
		return nodes;
	}
}
