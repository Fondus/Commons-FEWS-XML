package tw.fondus.commons.fews.pi.config.xml.log;

import org.simpleframework.xml.Attribute;

import lombok.Data;

/**
 * POJO Log message of Delft-FEWS XML configuration.
 * 
 * @author Brad Chen
 *
 */
@Data
public class PiMessage {
	@Attribute
	private int level;

	@Attribute
	private String description;

	public PiMessage() {
		this( 4, "Default message!" );
	}

	public PiMessage( int level, String description ) {
		this.level = level;
		this.description = description;
	}
	
	/**
	 * The static constructor.
	 * 
	 * @param level
	 * @param description
	 * @return
	 * @since 0.9.0
	 */
	public static PiMessage of( int level, String description ) {
		return new PiMessage( level, description );
	}
}
