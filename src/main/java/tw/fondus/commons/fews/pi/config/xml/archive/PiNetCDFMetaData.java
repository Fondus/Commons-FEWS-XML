package tw.fondus.commons.fews.pi.config.xml.archive;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * POJO Archive NetCDF meta-data of Delft-FEWS XML configuration.
 * 
 * @author Brad Chen
 * @since 0.9.0
 */
@Data
@Root(name = "netcdfMetaData")
@NamespaceList({ 
	@Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
	@Namespace(reference = "http://www.wldelft.nl/fews/archive")
	})
public class PiNetCDFMetaData {
	@Getter( AccessLevel.PRIVATE )
	@Setter( AccessLevel.PRIVATE )
	@Attribute(name = "schemaLocation")
	@Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance")
	private String schemaLocation;
	
	@ElementList( inline = true, entry = "netcdf" )
	private List<PiNetCDF> netCDFs;
	
	public PiNetCDFMetaData() {
		this( new ArrayList<>() );
	}
	
	public PiNetCDFMetaData( List<PiNetCDF> netCDFs ) {
		this.schemaLocation = "http://fews.wldelft.nl/schemas//version1.0/archive-schemas/netcdfMetaData.xsd";
		this.netCDFs = netCDFs;
	}
	
	/**
	 * The static constructor.
	 * 
	 * @param netCDFs
	 * @return
	 */
	public static PiNetCDFMetaData of( List<PiNetCDF> netCDFs ) {
		return new PiNetCDFMetaData( netCDFs );
	}
	
	public void clear() {
		this.netCDFs.clear();
	}
}
