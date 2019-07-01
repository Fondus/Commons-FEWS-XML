package tw.fondus.commons.fews.pi.config.xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;

import lombok.Data;

/**
 * POJO Parent class of Delft-FEWS XML configuration basic namespace.
 * 
 * @author Brad Chen
 *
 */
@Data
@NamespaceList({ @Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
		@Namespace(reference = "http://www.wldelft.nl/fews/PI") })
public abstract class PiConfigNameSpace {
	@Attribute
	protected String version;

	public PiConfigNameSpace() {
		this.version = "1.2";
	}
}
