package tw.fondus.commons.fews.pi.config.xml.run;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tw.fondus.commons.fews.pi.config.xml.util.XMLUtils;

/**
 * Unit test serialization/deserialization with PiRunFile.
 * 
 * @author Brad Chen
 *
 */
public class PiRunTest {
	private Path path;
	
	@Before
	public void setUp() throws Exception {
		this.path = Paths.get( "src/test/resources/AdapterRun.xml" );
		
		Assert.assertTrue( Files.exists( this.path ) );
	}

	@Test
	public void test() throws Exception {
		Assert.assertTrue( XMLUtils.validateXML( this.path, PiRunFile.class ) );
		
		PiRunFile piRunFile = XMLUtils.fromXML( this.path, PiRunFile.class );
		XMLUtils.printXML( piRunFile );
		
		Assert.assertTrue( piRunFile.getProperties().getProperty( "NAME_PREFIX" ).isPresent() );
		Assert.assertTrue( piRunFile.getProperties().getProperty( "START" ).isPresent() );
	}

}
