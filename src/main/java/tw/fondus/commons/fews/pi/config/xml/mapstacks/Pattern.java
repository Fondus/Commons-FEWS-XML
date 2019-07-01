package tw.fondus.commons.fews.pi.config.xml.mapstacks;

import org.simpleframework.xml.Attribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * POJO Name pattern of Two-dimensional Metadata datas.
 * 
 * @author Brad Chen
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pattern {
	@Attribute
	private String file;
	
	/**
	 * The static constructor.
	 * 
	 * @param file
	 * @return
	 * @since 0.9.0
	 */
	public static Pattern of( String file ) {
		return new Pattern( file );
	}
}
