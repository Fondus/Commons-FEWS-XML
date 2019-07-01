package tw.fondus.commons.fews.pi.config.xml.archive;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import lombok.Data;

/**
 * POJO Archive NetCDF Header of Delft-FEWS XML configuration.
 * 
 * @author Brad Chen
 * @since 0.9.0
 */
@Data
public class PiNetCDFHeader {
	public static final String ENSEMBLE_DEFAULT = "main";
	
	@Element
	private String parameterId;
	
	@ElementList( inline = true, entry = "locationId" )
	private List<String> locationIds;
	
	@Element
	private String ensembleId;
	
	public PiNetCDFHeader() {
		this( "", new ArrayList<>(), ENSEMBLE_DEFAULT );
	}
	
	public PiNetCDFHeader( String parameterId ) {
		this( parameterId, new ArrayList<>(), ENSEMBLE_DEFAULT );
	}
	
	public PiNetCDFHeader( String parameterId, List<String> locationIds ) {
		this( parameterId, locationIds, ENSEMBLE_DEFAULT );
	}
	
	public PiNetCDFHeader( String parameterId, List<String> locationIds, String ensembleId ) {
		this.parameterId = parameterId;
		this.locationIds = locationIds;
		this.ensembleId = ensembleId;
	}
	
	/**
	 * The static constructor.
	 * 
	 * @param parameterId
	 * @return
	 */
	public static PiNetCDFHeader of( String parameterId ) {
		return new PiNetCDFHeader( parameterId );
	}
	
	/**
	 * The static constructor.
	 * 
	 * @param parameterId
	 * @param locationIds
	 * @return
	 */
	public static PiNetCDFHeader of( String parameterId, List<String> locationIds ) {
		return new PiNetCDFHeader( parameterId, locationIds );
	}
	
	/**
	 * The static constructor.
	 * 
	 * @param parameterId
	 * @param locationIds
	 * @param ensembleId
	 * @return
	 */
	public static PiNetCDFHeader of( String parameterId, List<String> locationIds, String ensembleId ) {
		return new PiNetCDFHeader( parameterId, locationIds, ensembleId );
	}
	
	public void clear() {
		this.locationIds.clear();
	}
}
