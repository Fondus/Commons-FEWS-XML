package tw.fondus.commons.fews.pi.config.xml.util;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;

import strman.Strman;

/**
 * A Simple XML library to serialization/deserialization to convert Java Objects
 * into Delft-FEWS XML Config and back base on Simple XML.<br/>
 * 
 * @author Brad Chen
 *
 */
public class XMLUtils {
	private static Persister persister;

	static {
		persister = new Persister( new Format( "<?xml version=\"1.0\" encoding= \"UTF-8\"?>" ) );
	}
	
	/**
	 * Deserialization XML into Java Objects.
	 * 
	 * @param xml
	 * @param classOfT
	 * @return
	 * @throws Exception
	 */
	public static <T> T fromXML( Path xml, Class<T> classOfT ) throws Exception {
		return fromXML( xml.toFile(), classOfT );
	}

	/**
	 * Deserialization XML into Java Objects.
	 * 
	 * @param xml
	 * @param classOfT
	 * @return
	 * @throws Exception
	 */
	public static <T> T fromXML( File xml, Class<T> classOfT ) throws Exception {
		Objects.requireNonNull( xml, "XMLUtils: xml" );
		return persister.read( classOfT, xml );
	}

	/**
	 * Deserialization XML into Java Objects.
	 * 
	 * @param xml
	 * @param classOfT
	 * @return
	 * @throws Exception
	 */
	public static <T> T fromXML( String xml, Class<T> classOfT ) throws Exception {
		if ( Strman.isBlank( xml ) ) {
			throw new IllegalStateException( "'value' should be not null." );
		}
		return persister.read( classOfT, xml );
	}
	
	/**
	 * Serialization to XML and write to target path.
	 * 
	 * @param xml
	 * @param instance
	 * @throws Exception
	 */
	public static <T> void toXML( Path xml, T instance ) throws Exception {
		toXML( xml.toFile(), instance );
	}

	/**
	 * Serialization to XML and write to target path.
	 * 
	 * @param xml
	 * @param instance
	 * @throws Exception
	 */
	public static <T> void toXML( File xml, T instance ) throws Exception {
		Objects.requireNonNull( xml, "XMLUtils: xml" );
		Objects.requireNonNull( instance, "XMLUtils: instance" );
		persister.write( instance, xml );
	}
	
	/**
	 * Validate the contents of the XML document against the specified XML class schema.
	 * 
	 * @param xml
	 * @param classOfT
	 * @return
	 * @throws Exception
	 */
	public static <T> boolean validateXML( String xml, Class<T> classOfT ) throws Exception {
		return validateXML( xml, classOfT, false );
	}
	
	/**
	 * Validate the contents of the XML document against the specified XML class schema.
	 * 
	 * @param xml
	 * @param classOfT
	 * @param strict
	 * @return
	 * @throws Exception
	 */
	public static <T> boolean validateXML( String xml, Class<T> classOfT, boolean strict ) throws Exception {
		Objects.requireNonNull( xml, "XMLUtils: xml" );
		return persister.validate( classOfT, xml, strict );
	}
	
	/**
	 * Validate the contents of the XML document against the specified XML class schema.
	 * 
	 * @param xml
	 * @param classOfT
	 * @return
	 * @throws Exception
	 */
	public static <T> boolean validateXML( Path xml, Class<T> classOfT ) throws Exception {
		return validateXML( xml.toFile(), classOfT, false );
	}
	
	/**
	 * Validate the contents of the XML document against the specified XML class schema.
	 * 
	 * @param xml
	 * @param classOfT
	 * @param strict
	 * @return
	 * @throws Exception
	 */
	public static <T> boolean validateXML( Path xml, Class<T> classOfT, boolean strict ) throws Exception {
		return persister.validate( classOfT, xml.toFile(), strict );
	}
	
	/**
	 * Validate the contents of the XML document against the specified XML class schema.
	 * 
	 * @param xml
	 * @param classOfT
	 * @return
	 * @throws Exception
	 */
	public static <T> boolean validateXML( File xml, Class<T> classOfT ) throws Exception {
		return validateXML( xml, classOfT, false );
	}
	
	/**
	 * Validate the contents of the XML document against the specified XML class schema.
	 * 
	 * @param xml
	 * @param classOfT
	 * @param strict
	 * @return
	 * @throws Exception
	 */
	public static <T> boolean validateXML( File xml, Class<T> classOfT, boolean strict ) throws Exception {
		Objects.requireNonNull( xml, "XMLUtils: xml" );
		return persister.validate( classOfT, xml, strict );
	}

	/**
	 * Print Java Objects as XML with System.out.
	 * 
	 * @param instance
	 * @throws Exception
	 */
	public static <T> void printXML( T instance ) throws Exception {
		Objects.requireNonNull( instance, "XMLUtils: instance" );
		persister.write( instance, System.out );
	}
}
