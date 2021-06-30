package tw.fondus.commons.fews.pi.config.xml.run;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.fondus.commons.fews.pi.config.xml.util.XMLUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Unit test serialization/deserialization with PiRunFile.
 * 
 * @author Brad Chen
 *
 */
public class PiRunTest {
	private Path path;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.path = Paths.get( "src/test/resources/AdapterRun.xml" );

		Assertions.assertTrue( Files.exists( this.path ) );
	}

	@Test
	public void test() throws Exception {
		Assertions.assertTrue( XMLUtils.validateXML( this.path, PiRunFile.class ) );
		
		PiRunFile piRunFile = XMLUtils.fromXML( this.path, PiRunFile.class );
		XMLUtils.printXML( piRunFile );

		Assertions.assertTrue( piRunFile.getProperties().getProperty( "NAME_PREFIX" ).isPresent() );
		Assertions.assertTrue( piRunFile.getProperties().getProperty( "START" ).isPresent() );
	}

}
