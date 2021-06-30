package tw.fondus.commons.fews.pi.config.xml.mapstacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.fondus.commons.fews.pi.config.xml.util.XMLUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Unit test serialization/deserialization with MapStacks.
 * 
 * @author Brad Chen
 *
 */
public class MapStacksTest {
	private Path path;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.path = Paths.get( "src/test/resources/map.xml" );

		Assertions.assertTrue( Files.exists( this.path ) );
	}

	@Test
	public void test() throws Exception {
		Assertions.assertTrue( XMLUtils.validateXML( this.path, MapStacks.class ) );
		
		MapStacks mapstacks = XMLUtils.fromXML( this.path, MapStacks.class );
		Assertions.assertTrue( mapstacks.getMapStacks().size() > 0 );
		XMLUtils.printXML( mapstacks );
	}

}
