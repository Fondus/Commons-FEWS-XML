package tw.fondus.commons.fews.pi.config.xml.archive;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.fondus.commons.fews.pi.config.xml.util.XMLUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Unit test of NetCDFMetaData.
 * 
 * @author Brad Chen
 *
 */
public class PiNetCDFMetaDataTest {
	private Path path;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.path = Paths.get( "src/test/resources/metaData.xml" );
		
		Assertions.assertTrue( Files.exists( this.path ) );
	}
	
	@Test
	public void test() throws Exception {
		Assertions.assertTrue( XMLUtils.validateXML( this.path, PiNetCDFMetaData.class ) );
		
		PiNetCDFMetaData metaData = XMLUtils.fromXML( this.path, PiNetCDFMetaData.class );
		XMLUtils.printXML( metaData );
	}
}
