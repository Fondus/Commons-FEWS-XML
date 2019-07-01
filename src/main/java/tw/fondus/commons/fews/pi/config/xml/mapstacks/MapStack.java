package tw.fondus.commons.fews.pi.config.xml.mapstacks;

import org.simpleframework.xml.Element;

import lombok.AllArgsConstructor;
import lombok.Data;
import tw.fondus.commons.fews.pi.config.xml.PiDateTime;
import tw.fondus.commons.fews.pi.config.xml.PiTimeStep;

/**
 * POJO Two-dimensional Metadata Data of 2D Time Series Stack.
 * 
 * @author Brad Chen
 *
 */
@Data
@AllArgsConstructor
public class MapStack {
	@Element
	private String locationId;

	@Element
	private String parameterId;

	@Element
	private PiTimeStep timeStep;

	@Element
	private PiDateTime startDate;

	@Element
	private PiDateTime endDate;

	@Element
	private FileNamePattern file;
	
	public MapStack() {
		this.timeStep = new PiTimeStep();
		this.startDate = new PiDateTime();
		this.endDate = new PiDateTime();
		this.file = new FileNamePattern();
	}
	
	/**
	 * The static constructor.
	 * 
	 * @param locationId
	 * @param parameterId
	 * @param timeStep
	 * @param startDate
	 * @param endDate
	 * @param file
	 * @return
	 * @since 0.9.0
	 */
	public static MapStack of( String locationId, String parameterId, PiTimeStep timeStep,
			PiDateTime startDate, PiDateTime endDate, FileNamePattern file ) {
		return new MapStack( locationId, parameterId, timeStep, startDate, endDate, file );
	}
}
