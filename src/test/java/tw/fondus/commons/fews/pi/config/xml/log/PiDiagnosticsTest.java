package tw.fondus.commons.fews.pi.config.xml.log;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.fondus.commons.fews.pi.config.xml.util.XMLUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Unit test serialization/deserialization with PiDiagnostics.
 * 
 * @author Brad Chen
 *
 */
public class PiDiagnosticsTest {
	private Path path;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.path = Paths.get( "src/test/resources/Diagnostics.xml" );

		Assertions.assertTrue( Files.exists( this.path ) );
	}

	@Test
	public void test() throws Exception {
		Assertions.assertTrue( XMLUtils.validateXML( this.path, PiDiagnostics.class ) );
		
		PiDiagnostics logMessages = XMLUtils.fromXML( this.path, PiDiagnostics.class );
		Assertions.assertTrue( logMessages.getMessages().size() > 0 );
		XMLUtils.printXML( logMessages );
	}
}
