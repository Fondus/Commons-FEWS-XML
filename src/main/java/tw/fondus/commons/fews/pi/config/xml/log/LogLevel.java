package tw.fondus.commons.fews.pi.config.xml.log;

/**
 * Log level Enum
 * 
 * @author Brad Chen
 *
 */
public enum LogLevel {
	DEBUG(4), INFO(3), WARN(2), ERROR(1), FATAL(0);

	private int value;

	private LogLevel(int value) {
		this.value = value;
	}

	public int value() {
		return this.value;
	}
}
