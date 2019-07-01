package tw.fondus.commons.fews.pi.config.xml.property;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * POJO Property of Delft-FEWS XML configuration.
 * 
 * @author Brad Chen
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ElementUnion({ 
	@Element(name = "string", type = String.class), 
	@Element(name = "int", type = Integer.class),
	@Element(name = "float", type = String.class), 
	@Element(name = "double", type = Double.class),
	@Element(name = "bool", type = Boolean.class) })
public class PiProperty {
	@Attribute
	private String key;

	@Attribute
	private String value;

	public String getString() {
		return value;
	}

	public Integer getInt() {
		return Integer.valueOf(value);
	}

	public Float getFloat() {
		return Float.valueOf(value);
	}

	public Double getDouble() {
		return Double.valueOf(value);
	}

	public Boolean getBoolean() {
		return Boolean.valueOf(value);
	}
	
	/**
	 * The static constructor.
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @since 0.9.0
	 */
	public static PiProperty of( String key, String value ) {
		return new PiProperty( key, value );
	}
}
