package pack;

public class ProjDate {

	private int date;
	private int month;
	private int year;

	public ProjDate(int d1, int m1, int y1) {
		this.setdate(d1);
		this.setmonth(m1);
		this.setyear(y1);
	}

	public ProjDate() {
	}

	public ProjDate(String s) {
		String[] str = s.split("-");
		int i1 = Integer.parseInt(str[2]);
		this.setdate(i1);

		int i2 = Integer.parseInt(str[1]);
		this.setmonth(i2);

		int i3 = Integer.parseInt(str[0]);
		this.setyear(i3);

	}

	public void setyear(int year) {
		this.year = year;
	}

	public boolean setmonth(int month) {
		boolean r = true;
		if (month > 0 && month < 13) {
			this.month = month;
			r = false;
		} else {
			System.out.println("*** month should be between 1 and 12 ***");

		}
		return r;
	}

	public boolean setdate(int date) {
		boolean r = true;
		if (this.month != 4 && this.month != 6 && this.month != 9 && this.month != 11 && this.month != 2) {
			if (date > 0 && date < 32) {
				this.date = date;
				r = false;
			} else {
				System.out.println("***date should be between 1 and 31 ***");
				r = true;
			}
		} else if (this.month != 2) {
			if (date > 0 && date < 31) {
				this.date = date;
				r = false;
			} else {
				System.out.println("***date should be between 1 and 30 ***");
				r = true;
			}
		} else if (this.month == 2) {
			if (date > 0 && date < 29) {
				this.date = date;
				r = false;
			} else {
				System.out.println("***date should be between 1 and 28 ***");
				r = true;
			}
		}
		return r;
	}

	public int getdate() {
		return date;

	}

	public int getmonth() {
		return month;

	}

	public int getyear() {
		return year;

	}

	@Override
	public String toString() {
		return this.getyear() + "-" + this.getmonth() + "-" + this.getdate();
	}

}
