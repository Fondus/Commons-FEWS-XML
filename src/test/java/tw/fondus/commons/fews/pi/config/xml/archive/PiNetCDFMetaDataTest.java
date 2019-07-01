package tw.fondus.commons.fews.pi.config.xml.archive;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tw.fondus.commons.fews.pi.config.xml.util.XMLUtils;

/**
 * Unit test of NetCDFMetaData.
 * 
 * @author Brad Chen
 *
 */
public class PiNetCDFMetaDataTest {
	private Path path;
	
	@Before
	public void setUp() throws Exception {
		this.path = Paths.get( "src/test/resources/metaData.xml" );
		
		Assert.assertTrue( Files.exists( this.path ) );
	}
	
	@Test
	public void test() throws Exception {
		Assert.assertTrue( XMLUtils.validateXML( this.path, PiNetCDFMetaData.class ) );
		
		PiNetCDFMetaData metaData = XMLUtils.fromXML( this.path, PiNetCDFMetaData.class );
		XMLUtils.printXML( metaData );
	}
}
