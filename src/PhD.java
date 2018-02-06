/** NetIds: mxz4, tcc78. Time spent: 5 hours 15 minutes.
 * An instance maintains info about the PhD of a person. 
 * Checked Javadoc output -- OK */
public class PhD {
	private String name; // name of person with a PhD, String of length > 0
	private int month; // month PhD was awarded, range 1..12, 1 means Jan, etc.
	private int year; // year PhD was awarded
	private PhD advisor1; // first PhD advisor of person
	private PhD advisor2; // second PhD advisor of person
	private int advisees; // number of PhD advisees of person
	
	/** 
	 * Constructor: an instance for a person with name n, PhD month m, PhD year 
	 * y. Its advisors are unknown, and it has no advisees.
	 * Precondition: n has at least 1 char and m is in 1..12.
	 */
	public PhD(String n, int m, int y) {
		assert n.length() > 0;
		assert m >= 1 && m <= 12;
		
		this.name = n;
		this.month = m;
		this.year = y;
	}
	
	/**
	 * Return the name of this person.
	 */
	public String name() {
		return this.name;
	}
	
	/**
	 * Return the month this person got their PhD.
	 */
	public int month() {
		return this.month;
	}
	
	/**
	 * Return the year this person got their PhD.
	 */
	public int year() {
		return this.year;
	}
	
	/**
	 * Return the first advisor of this PhD (null if unknown).
	 */
	public PhD advisor1() {
		return this.advisor1;
	}
	
	/**
	 * Return the second advisor of this PhD (null if unknown or non-existent).
	 */
	public PhD advisor2() {
		return this.advisor2;
	}
	
	/**
	 * Return the number of PhD advisees of this person.
	 */
	public int numAdvisees() {
		return this.advisees;
	}
	
	/**
	 * Add p as the first advisor of this person.
	 * Precondition: the first advisor is unknown and p is not null.
	 */
	public void setAdvisor1(PhD p) {
		assert this.advisor1 == null;
		assert p != null;
		
		this.advisor1 = p;
		p.advisees++;
	}
	
	/**
	 * Add p as the second advisor of this person. 
	 * Precondition: The first advisor (of this person) is known, the second 
	 * advisor is unknown, p is not null, and p is different from the first 
	 * advisor.
	 */
	public void setAdvisor2(PhD p) {
		assert this.advisor1 != null;
		assert this.advisor2 == null;
		assert p != null;
		assert p != this.advisor1;
		
		this.advisor2 = p;
		p.advisees++;
	}
	
	/**
	 * Constructor: a PhD with name n, PhD month m, PhD year y, first advisor 
	 * adv1, and no second advisor. 
	 * Precondition: n has at least 1 char, m is in 1..12, and adv is not null.
	 */
	public PhD(String n, int m, int y, PhD adv1) {
		assert n.length() > 0;
		assert m >= 1 & m <= 12;
		assert adv1 != null;
		
		this.name = n;
		this.month = m;
		this.year = y;
		this.advisor1 = adv1;
		adv1.advisees++;
	}
	
	/**
	 * Constructor: a PhD with name n, PhD month m, PhD year y, first advisor 
	 * adv1, and second advisor adv2. 
	 * Precondition: n has at least 1 char, m is in 1..12, adv1 and adv2 are 
	 * not null, and adv1 and adv2 are different.
	 */
	public PhD(String n, int m, int y, PhD adv1, PhD adv2) {
		assert n.length() > 0;
		assert m >= 1 && m <= 12;
		assert adv1 != null && adv2 != null;
		assert adv1 != adv2;
		
		this.name = n;
		this.month = m;
		this.year = y;
		this.advisor1 = adv1;
		adv1.advisees++;
		this.advisor2 = adv2;
		adv2.advisees++;
	}
	
	/** 
	 * Return value of "this PhD has at least one advisee", i.e. true if this 
	 * PhD has at least one advisee and false otherwise
	 */
	public boolean hasAdvisee() {
		return this.advisees > 0;
	}
	
	/**
	 * Return value of "p is not null and this person got the PhD after p."
	 */
	public boolean gotAfter(PhD p) {
		return p != null && (p.year < this.year || 
				(p.year == this.year && p.month < this.month));
	}
	
	/**
	 * Return value of "this person and p are intellectual siblings." 
	 * Precondition: p is not null.
	 */
	public boolean areSiblings(PhD p) {
		assert p != null;
		
		return (this.advisor1 == p.advisor1 || this.advisor1 == p.advisor2 || 
				this.advisor2 == p.advisor2 || this.advisor2 == p.advisor1) && 
				this != p && (this.advisor1 != null || this.advisor2 != null ||
				p.advisor1 != null || p.advisor2 != null);
	}
}
