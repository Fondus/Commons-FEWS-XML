package tw.fondus.commons.fews.pi.config.xml;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.simpleframework.xml.Attribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import strman.Strman;

/**
 * POJO DateTime of Delft-FEWS XML configuration.
 * 
 * @author Brad Chen
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PiDateTime {
	private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	@Attribute
	private String date;

	@Attribute
	private String time;

	public DateTime getDateTime() {
		DateTimeFormatter formatter = DateTimeFormat.forPattern( FORMAT );
		return formatter.withZone( DateTimeZone.UTC ).parseDateTime( Strman.append( this.date, " ", this.time ) );
	}
	
	/**
	 * The static constructor.
	 * 
	 * @param date
	 * @param time
	 * @return
	 * @since 0.9.0
	 */
	public static PiDateTime of( String date, String time ) {
		return new PiDateTime( date, time );
	}
}
