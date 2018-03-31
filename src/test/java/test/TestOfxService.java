package test;

import com.webcohesion.ofx4j.io.OFXParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestOfxService {
	
	OfxService ofxService;
	OfxNode root;
	
	@Before
	public void setup() throws IOException, OFXParseException {
		ofxService = new OfxService();
		Path path = Paths.get("src/test/resources/sample.ofx");
		InputStream is = Files.newInputStream(path);
		
		OfxDataTree tree = new OfxParser().parse(is);
		root = tree.getRoot();
	}

	@Test
	public void testGetNodes() {
		
		List<OfxNode> nodes = ofxService.getNodes("ACCTINFO", root);
		Assert.assertEquals(2, nodes.size());
		
	}
}
