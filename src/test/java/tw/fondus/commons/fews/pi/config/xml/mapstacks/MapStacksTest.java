package tw.fondus.commons.fews.pi.config.xml.mapstacks;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tw.fondus.commons.fews.pi.config.xml.util.XMLUtils;

/**
 * Unit test serialization/deserialization with MapStacks.
 * 
 * @author Brad Chen
 *
 */
public class MapStacksTest {
	private Path path;
	
	@Before
	public void setUp() throws Exception {
		this.path = Paths.get( "src/test/resources/map.xml" );
		
		Assert.assertTrue( Files.exists( this.path ) );
	}

	@Test
	public void test() throws Exception {
		Assert.assertTrue( XMLUtils.validateXML( this.path, MapStacks.class ) );
		
		MapStacks mapstacks = XMLUtils.fromXML( this.path, MapStacks.class );
		Assert.assertTrue( mapstacks.getMapStacks().size() > 0 );
		XMLUtils.printXML( mapstacks );
	}

}
