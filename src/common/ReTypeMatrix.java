package common;

import lte.r11.L1.ReType;

public class ReTypeMatrix extends BasicBaseClass {

	private ReType[][]	m;
	private int			rowDimension;
	private int			columnDimension;

	public ReTypeMatrix(int N_RB, int N_RB_sc, int symbolPerSlot,
			int subframeNum) {
		this.rowDimension = N_RB * N_RB_sc;
		this.columnDimension = symbolPerSlot * 2 * subframeNum;
		this.m = new ReType[this.rowDimension][this.columnDimension];
		for (int row = 0; row < this.rowDimension; row++) {
			for (int column = 0; column < this.columnDimension; column++) {
				this.m[row][column] = ReType.AVAILABLE;
			}
		}
	}

	public int getColumnDimension() {
		return this.columnDimension;
	}

	public ReType getEntry(int row, int column) throws Exception {
		garantee(row >= 0 && row < this.rowDimension, "row index: " + row
				+ " is out of range!");
		garantee(column >= 0 && column < this.columnDimension, "column index: "
				+ column + " is out of range!");
		return this.m[row][column];
	}

	public int getRowDimension() {
		return this.rowDimension;
	}

	public void setEntry(int row, int column, ReType type) throws Exception {
		garantee(row >= 0 && row < this.rowDimension, "row index: " + row
				+ " is out of range!");
		garantee(column >= 0 && column < this.columnDimension, "column index: "
				+ column + " is out of range!");
		this.m[row][column] = type;
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
