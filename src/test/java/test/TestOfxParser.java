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

public class TestOfxParser {
	
	OfxParser parser;
	
	@Before
	public void setup() {
		parser = new OfxParser();
	}
	
	@Test
	public void testParse() throws IOException, OFXParseException {
		Path path = Paths.get("src/test/resources/sample.ofx");
		InputStream is = Files.newInputStream(path);
		
		OfxDataTree tree = parser.parse(is);
		Assert.assertEquals("OFX", tree.getRoot().getName());
	}

}
