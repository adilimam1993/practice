package test;

import com.webcohesion.ofx4j.io.OFXParseException;
import com.webcohesion.ofx4j.io.nanoxml.NanoXMLOFXReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


public class OfxParser {
	
	public OfxDataTree parse(String ofxString) throws IOException, OFXParseException {
		InputStream is = new ByteArrayInputStream(ofxString.getBytes());
		
		return parse(is);
	}
	
	public OfxDataTree parse(InputStream is) throws IOException, OFXParseException {
		NanoXMLOFXReader ofxReader = new NanoXMLOFXReader();
		EEIOfxHandler handler = new EEIOfxHandler();
		ofxReader.setContentHandler(handler);
		ofxReader.parse(is);
		
		return new OfxDataTree(handler.getHeaders(), handler.getRoot());
	}

}
