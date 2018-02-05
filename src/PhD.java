/** NetID: mxz4, tcc78. Time spent: 
 * An instance maintains info about the PhD of a person. */
public class PhD {
	private String name; // name of person with a PhD, String of length > 0
	private int month; // month PhD was awarded, range 1..12, 1 means Jan, etc.
	private int year; // year PhD was awarded
	private PhD fadvisor; // first PhD advisor of person
	private PhD sadvisor; // second PhD advisor of person
	private int advisees; // number of PhD advisees of person
}
