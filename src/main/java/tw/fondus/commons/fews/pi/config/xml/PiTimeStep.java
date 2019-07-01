package tw.fondus.commons.fews.pi.config.xml;

import org.simpleframework.xml.Attribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * POJO TimeStep of Delft-FEWS XML configuration.
 * 
 * @author Brad Chen
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PiTimeStep {
	@Attribute
	private String unit;

	@Attribute( required = false )
	private int multiplier;
	
	/**
	 * The static constructor.
	 * 
	 * @param unit
	 * @param multiplier
	 * @return
	 * @since 0.9.0
	 */
	public static PiTimeStep of( String unit, int multiplier ){
		return new PiTimeStep( unit, multiplier );
	}
}
