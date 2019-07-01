package tw.fondus.commons.fews.pi.config.xml.log;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import tw.fondus.commons.fews.pi.config.xml.PiConfigNameSpace;

/**
 * POJO Log message interface of Delft-FEWS XML configuration.
 * 
 * @author Brad Chen
 *
 */
@Data
@EqualsAndHashCode( callSuper=false )
@Root(name = "Diag")
public class PiDiagnostics extends PiConfigNameSpace {
	@Getter( AccessLevel.PRIVATE )
	@Setter( AccessLevel.PRIVATE )
	@Attribute(name = "schemaLocation")
	@Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance")
	private String schemaLocation;

	@ElementList(inline = true, entry = "line")
	private List<PiMessage> messages;

	public PiDiagnostics() {
		this( new ArrayList<>() );
	}
	
	public PiDiagnostics( List<PiMessage> messages ) {
		super();
		this.messages = messages;
		this.schemaLocation = "http://fews.wldelft.nl/schemas/version1.0/pi-schemas/pi_diag.xsd";
	}
	
	/**
	 * The static constructor.
	 * 
	 * @param messages
	 * @return
	 * @since 0.9.0
	 */
	public static PiDiagnostics of( List<PiMessage> messages ) {
		return new PiDiagnostics( messages );
	}

	/**
	 * Clear all log message.
	 */
	public void clearMessages() {
		this.messages.clear();
	}

	public void addMessage( PiMessage line ) {
		this.messages.add(line);
	}

	public void addMessage( int level, String description ) {
		this.messages.add( PiMessage.of( level, description ) );
	}
}
