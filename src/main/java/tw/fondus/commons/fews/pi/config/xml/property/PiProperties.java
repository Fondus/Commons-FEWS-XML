package tw.fondus.commons.fews.pi.config.xml.property;

import java.util.List;
import java.util.Optional;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * POJO Property collection of Delft-FEWS XML configuration.
 * 
 * @author Brad Chen
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PiProperties {
	@ElementListUnion({ 
		@ElementList(entry = "string", name = "string", type = PiProperty.class, inline = true),
		@ElementList(entry = "int", name = "int", type = PiProperty.class, inline = true),
		@ElementList(entry = "float", name = "float", type = PiProperty.class, inline = true),
		@ElementList(entry = "double", name = "double", type = PiProperty.class, inline = true),
		@ElementList(entry = "bool", name = "bool", type = PiProperty.class, inline = true) })
	private List<PiProperty> properties;
	
	public Optional<PiProperty> getProperty( String key ) {
		return this.properties.stream().filter( property -> property.getKey().equals( key ) ).findFirst();
	}
	
	/**
	 * The static constructor.
	 * 
	 * @param properties
	 * @return
	 * @since 0.9.0
	 */
	public static PiProperties of( List<PiProperty> properties ) {
		return new PiProperties( properties );
	}
}
