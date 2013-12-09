package common;

public class UuTime extends BasicBaseClass implements Comparable<UuTime> {

	private int		slot;
	private int		subframe;
	private long	frame;

	public UuTime() {
		slot = 0;
		subframe = 0;
		frame = 0;
	}

	public UuTime(long frame, int subframe, int slot) {
		this.frame = frame;
		this.subframe = subframe;
		this.slot = slot;
	}

	public UuTime(UuTime uuTime) {
		this.frame = uuTime.frame;
		this.subframe = uuTime.subframe;
		this.slot = uuTime.slot;
	}

	@Override
	public int compareTo(UuTime another) {
		long result = 0;
		result = this.frame - another.frame;
		if (result == 0) {
			result = this.subframe - another.subframe;
		}
		if (result == 0) {
			result = this.slot - another.slot;
		}
		return (int) result;
	}

	@Override
	public String toBinaryString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toReadableString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
