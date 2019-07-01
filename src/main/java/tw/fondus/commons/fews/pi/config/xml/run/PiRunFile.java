package tw.fondus.commons.fews.pi.config.xml.run;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import tw.fondus.commons.fews.pi.config.xml.PiConfigNameSpace;
import tw.fondus.commons.fews.pi.config.xml.PiDateTime;
import tw.fondus.commons.fews.pi.config.xml.property.PiProperties;

/**
 * POJO General Adapter PI-Run file of Delft-FEWS XML configuration.<br/>
 * It's use to pass environment variables and arguments to Adapter.
 * 
 * @author Brad Chen
 *
 */
@Data
@EqualsAndHashCode( callSuper=false )
@Root(name = "Run")
public class PiRunFile extends PiConfigNameSpace {
	@Getter( AccessLevel.PRIVATE )
	@Setter( AccessLevel.PRIVATE )
	@Attribute(name = "schemaLocation")
	@Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance")
	private String schemaLocation;

	@Element
	private String logLevel;

	@Element
	private String timeZone;

	@Element
	private PiDateTime startDateTime;

	@Element
	private PiDateTime endDateTime;

	@Element(name = "time0")
	private PiDateTime timeZero;

	@Element
	private PiDateTime lastObservationDateTime;

	@Element
	private String workDir;

	@ElementList(inline = true, entry = "inputTimeSeriesFile", required = false)
	private List<String> inputTimeSeriesFiles;

	@ElementList(inline = true, entry = "inputMapStackFile", required = false)
	private List<String> inputMapStackFiles;

	@Element(name = "outputDiagnosticFile")
	private String diagnosticFile;

	@ElementList(inline = true, entry = "outputTimeSeriesFile", required = false)
	private List<String> outputTimeSeriesFiles;

	@ElementList(inline = true, entry = "outputMapStackFile", required = false)
	private List<String> outputMapStackFiles;

	@Element
	private PiProperties properties;

	public PiRunFile() {
		super();
		this.schemaLocation = "http://www.wldelft.nl/fews/PI http://fews.wldelft.nl/schemas/version1.0/pi-schemas/pi_run.xsd";
	}
}
