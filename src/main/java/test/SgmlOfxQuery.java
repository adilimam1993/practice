package test;

import java.util.Stack;

// IGNORE THIS FILE FOR NOW
public class SgmlOfxQuery {
	
	public OfxNode get(String query) {
		
		query = "ACCTINFO.DESC=INVESTMENT";
		
		Stack<OfxNode> stack = new Stack<OfxNode>();
		
		return null;
	}
	
	private QueryPart parseQuery(String query) {
		QueryPart dummyHead = new QueryPart("");
		QueryPart tail = dummyHead;
		
		for(String part : query.split(".")) {
			if(part.contains("=")) {
				String[] split=part.split("=");
				tail.next = new QueryPart(split[0], split[1]);
			} else {
				tail.next = new QueryPart(part);
			}
			
			tail = tail.next;
		}
		
		return dummyHead.next;
	}
	
	private class QueryPart{
		String name;
		String value;
		QueryPart next;
		
		public QueryPart(String name, String value) {
			this.name = name;
			this.value = value;
		}
		
		public QueryPart(String name) {
			this.name=name;
			this.value= null;
		}
	}

}
