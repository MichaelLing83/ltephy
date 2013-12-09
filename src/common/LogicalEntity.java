package common;

/**
 * Base class for an abstract Service Access Point.
 * 
 * @author linggduo
 * 
 */
abstract public class LogicalEntity extends BasicBaseClass {

	abstract public void process(UuTime uuTime);

	@Override
	public String toBinaryString() {
		return toReadableString();
	}

	@Override
	public String toReadableString() {
		return LogicalEntity.class.getName();
	}

	@Override
	public String toString() {
		return toReadableString();
	}

}
