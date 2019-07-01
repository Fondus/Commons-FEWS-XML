package tw.fondus.commons.fews.pi.config.xml.mapstacks;

import org.simpleframework.xml.Element;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * POJO Include File Name pattern of Two-dimensional datas.
 * 
 * @author Brad Chen
 *
 */
@Data
@AllArgsConstructor
public class FileNamePattern {
	@Element(name = "ascii")
	private Pattern pattern;
	
	public FileNamePattern() {
		this.pattern = new Pattern();
	}
	
	/**
	 * The static constructor.
	 * 
	 * @param pattern
	 * @return
	 * @since 0.9.0
	 */
	public static FileNamePattern of( Pattern pattern ) {
		return new FileNamePattern( pattern );
	}
}
