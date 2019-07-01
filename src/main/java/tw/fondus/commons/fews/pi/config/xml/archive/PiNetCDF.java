package tw.fondus.commons.fews.pi.config.xml.archive;

import org.simpleframework.xml.Element;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tw.fondus.commons.fews.pi.config.xml.PiDateTime;

/**
 * POJO Archive NetCDF of Delft-FEWS XML configuration.
 * 
 * @author Brad Chen
 * @since 0.9.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PiNetCDF {
	public static final String TYPE_VALUE_SCALAR = "scalar";
	public static final String TYPE_VALUE_GRID = "grid";
	public static final String TYPE_TIMESERIES_OBSERVED = "observed";
	
	@Element
	private String relativeFilePath;
	
	@Element
	private String valueType;
	
	@Element
	private String timeSeriesType;
	
	@Element
	private String areaId;
	
	@Element
	private String sourceId;
	
	@Element
	private PiDateTime creationTime;

	@Element
	private PiDateTime startTime;
	
	@Element
	private PiDateTime endTime;
	
	@Element
	private PiNetCDFHeader header;
	
	@Element( required = false )
	private String statistics;
}
