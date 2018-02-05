/** NetID: mxz4, tcc78. Time spent: 
 * An instance maintains info about the PhD of a person. */
public class PhD {
	private String name; // name of person with a PhD, String of length > 0
	private int month; // month PhD was awarded, range 1..12, 1 means Jan, etc.
	private int year; // year PhD was awarded
	private PhD advisor1; // first PhD advisor of person
	private PhD advisor2; // second PhD advisor of person
	private int advisees; // number of PhD advisees of person
	
	/** 
	 * Precondition: n has at least 1 char and m is in 1..12
	 */
	public PhD(String n, int m, int y) {
		name = n;
		month = m;
		year = y;
	}
	
	public String name() {
		return name;
	}
	
	public int month() {
		return month;
	}
	
	public int year() {
		return year;
	}
	
	public PhD advisor1() {
		return advisor1;
	}
	
	public PhD advisor2() {
		return advisor2;
	}
	
	public int numAdvisees() {
		return advisees;
	}
}
