package tw.fondus.commons.fews.pi.config.xml.mapstacks;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tw.fondus.commons.fews.pi.config.xml.PiConfigNameSpace;

/**
 * POJO Two-dimensional Metadata Data of Delft-FEWS XML configuration.
 * 
 * @author Brad Chen
 *
 */
@Data
@EqualsAndHashCode( callSuper=false )
@Root(name = "MapStacks")
public class MapStacks extends PiConfigNameSpace {
	@Attribute(name = "schemaLocation")
	@Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance")
	private String schemaLocation;

	@Element
	private String geoDatum;

	@Element
	private String timeZone;

	@ElementList(inline = true)
	private List<MapStack> mapStacks;

	public MapStacks() {
		this( "TWD 1997", "0.0", new ArrayList<>() );
	}
	
	public MapStacks( String geoDatum, String timeZone, List<MapStack> mapStacks ) {
		super();
		this.geoDatum = geoDatum;
		this.timeZone = timeZone;
		this.mapStacks = mapStacks;
		this.schemaLocation = "http://www.wldelft.nl/fews/PI http://fews.wldelft.nl/schemas/version1.0/pi-schemas/pi_mapstacks.xsd";
	}
	
	public MapStack get( int index ) {
		return this.mapStacks.get( index );
	}
	
	public void add( MapStack mapStack ) {
		this.mapStacks.add( mapStack );
	}
	
	public void clear() {
		this.mapStacks.clear();
	}
	
	/**
	 * The static constructor.
	 * 
	 * @param geoDatum
	 * @param timeZone
	 * @param mapStacks
	 * @return
	 * @since 0.9.0
	 */
	public static MapStacks of( String geoDatum, String timeZone, List<MapStack> mapStacks ) {
		return new MapStacks( geoDatum, timeZone, mapStacks );
	}
}
