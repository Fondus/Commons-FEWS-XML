package tw.fondus.commons.fews.pi.config.xml.log;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tw.fondus.commons.fews.pi.config.xml.util.XMLUtils;

/**
 * Unit test serialization/deserialization with PiDiagnostics.
 * 
 * @author Brad Chen
 *
 */
public class PiDiagnosticsTest {
	private Path path;
	
	@Before
	public void setUp() throws Exception {
		this.path = Paths.get( "src/test/resources/Diagnostics.xml" );
		
		Assert.assertTrue( Files.exists( this.path ) );
	}

	@Test
	public void test() throws Exception {
		Assert.assertTrue( XMLUtils.validateXML( this.path, PiDiagnostics.class ) );
		
		PiDiagnostics logMessages = XMLUtils.fromXML( this.path, PiDiagnostics.class );
		Assert.assertTrue( logMessages.getMessages().size() > 0 );
		XMLUtils.printXML( logMessages );
	}
}
