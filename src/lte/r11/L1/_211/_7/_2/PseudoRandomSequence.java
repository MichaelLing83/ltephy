package lte.r11.L1._211._7._2;

import common.BasicBaseClass;
import common.BitList;

public class PseudoRandomSequence extends BasicBaseClass {

	static private int	N__c	= 1600;
	private BitList		x1;
	private BitList		x2;

	public PseudoRandomSequence(long c__init) {
		x1 = new BitList();
		x1.set(0);
		x1.set(1, 31, false);
		x2 = new BitList();
		for (int i = 0; i < 31; i++) {
			x2.set(i, (c__init & (1 << i)) != 0);
		}
	}

	public int c(int n) throws Exception {
		int bit = 0;
		if (x1(n + N__c) ^ x2(n + N__c)) {
			bit = 1;
		}
		return bit;
	}

	@Override
	public String toBinaryString() {
		return toReadableString();
	}

	@Override
	public String toReadableString() {
		return PseudoRandomSequence.class.getName();
	}

	@Override
	public String toString() {
		return toReadableString();
	}

	private boolean x1(int n) throws Exception {
		boolean bit = false;
		if (n < x1.size()) {
			bit = x1.get(n);
		} else {
			for (int i = x1.size(); i < n + 1; i++) {
				x1.set(i, x1.get(i - 28) ^ x1.get(i - 31));
			}
			bit = x1.get(n);
		}
		return bit;
	}

	private boolean x2(int n) throws Exception {
		boolean bit = false;
		if (n < x2.size()) {
			bit = x2.get(n);
		} else {
			for (int i = x2.size(); i < n + 1; i++) {
				x2.set(i,
						x2.get(i - 28) ^ x2.get(i - 29) ^ x2.get(i - 30)
								^ x2.get(i - 31));
			}
			bit = x2.get(n);
		}
		return bit;
	}
}
