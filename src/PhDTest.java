import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PhDTest {

	@Test
	public void testConstructor1() {
		PhD doctor = new PhD("Bob", 3, 1979);
		assertEquals("Bob",doctor.name());
		assertEquals(3,doctor.month());
		assertEquals(1979,doctor.year());
		assertEquals(null, doctor.advisor1());
		assertEquals(null,doctor.advisor2());
		assertEquals(0,doctor.numAdvisees());
		
		/* testing assert statements in the first constructor */
		assertThrows(AssertionError.class, () -> new PhD(null,1,1950));
		assertThrows(AssertionError.class, () -> new PhD("",1,1950));
		assertThrows(AssertionError.class, () -> new PhD("Joe",13,1950));
		assertThrows(AssertionError.class, () -> new PhD("Bob", -3, 1950));
	}
	
	@Test
	public void testSetAdvisors() {		
		PhD doc = new PhD("Joe", 5, 1992);
		PhD doc2 = new PhD("Dave", 1, 1952);
		PhD newdoc = new PhD("Kyle", 12, 2013);
		PhD newdoc2 = new PhD("Rob", 10, 2013);
		
		assertEquals(null,newdoc.advisor1());
		assertEquals(null,newdoc.advisor2());
		
		newdoc.setAdvisor1(doc);
		assertEquals(doc,newdoc.advisor1());
		assertEquals(1,doc.numAdvisees());
		
		newdoc.setAdvisor2(doc2);
		assertEquals(doc2,newdoc.advisor2());
		assertEquals(1,doc2.numAdvisees());
		
		newdoc2.setAdvisor1(doc);
		assertEquals(doc,newdoc.advisor1());
		assertEquals(2,doc.numAdvisees());
		
		/* testing assert statements in the setter methods */
		assertThrows(AssertionError.class, () -> newdoc.setAdvisor1(doc));
		assertThrows(AssertionError.class, () -> newdoc.setAdvisor1(null));
		
		PhD test = new PhD("Alpha", 1, 2000);
		test.setAdvisor1(doc);
		assertThrows(AssertionError.class, () -> test.setAdvisor2(doc));
		
		PhD test2 = new PhD("Gamma", 3, 1995);
		assertThrows(AssertionError.class, () -> test2.setAdvisor2(doc2));
		
		assertThrows(AssertionError.class, () -> newdoc2.setAdvisor2(doc));
		assertThrows(AssertionError.class, () -> newdoc2.setAdvisor2(null));
	}
	
	@Test
	public void testConstructor2and3() {
		PhD doc = new PhD("Joe", 5, 1992);
		PhD doc2 = new PhD("Dave", 1, 1952);

		PhD docc = new PhD("Tom", 3, 2014, doc);
		assertEquals("Tom", docc.name());
		assertEquals(3,docc.month());
		assertEquals(2014,docc.year());
		assertEquals(doc, docc.advisor1());
		assertEquals(null, docc.advisor2());
		assertEquals(0,docc.numAdvisees());
		assertEquals(1,doc.numAdvisees());
		
		PhD docc2 = new PhD("Steve", 4, 2015, doc, doc2);
		assertEquals("Steve",docc2.name());
		assertEquals(4,docc2.month());
		assertEquals(2015,docc2.year());
		assertEquals(doc,docc2.advisor1());
		assertEquals(doc2,docc2.advisor2());
		assertEquals(0,docc2.numAdvisees());
		assertEquals(2,doc.numAdvisees());
		assertEquals(1,doc2.numAdvisees());
		
		/* testing assert statements for second and third constructors */
		assertThrows(AssertionError.class, () -> new PhD(null, 3, 1932, doc2));
		assertThrows(AssertionError.class, () -> new PhD("", 1, 2018, doc));
		assertThrows(AssertionError.class, () -> new PhD("Jon", 0, 2015, doc));
		assertThrows(AssertionError.class, () -> new PhD("Jane",13,2010,doc2));
		assertThrows(AssertionError.class, 
				() -> new PhD("Bob", 11, 1932, null));
		
		assertThrows(AssertionError.class, 
				() -> new PhD(null, 3, 2012, doc, doc2));
		assertThrows(AssertionError.class, 
				() -> new PhD("", 5, 2020, doc2, doc));
		assertThrows(AssertionError.class, 
				() -> new PhD("Steve", 0, 2011, doc, doc2));
		assertThrows(AssertionError.class, 
				() -> new PhD("Rex", 21, 2020, doc, doc2));
		assertThrows(AssertionError.class, 
				() -> new PhD("Matt", 5, 2020, null, doc2));
		assertThrows(AssertionError.class, () -> new PhD("Jerry", 5, 2020, doc,
				null));
		assertThrows(AssertionError.class, () -> new PhD("Sue", 5, 2020, doc,
				doc));
		assertThrows(AssertionError.class, () -> new PhD("Beta", 5, 2020, null,
				null));
	}
	
	@Test
	public void testGroupD() {
		PhD jul53 = new PhD("Ty", 7, 1953);
		PhD sep59 = new PhD("James", 9, 1959);
		PhD jan88 = new PhD("Jane", 1, 1988, sep59, jul53);
		PhD may75 = new PhD("Matt", 5, 1975, jul53);
		PhD may752 = new PhD("Mark", 5, 1975);
		PhD aug88 = new PhD("Jay", 8, 1988);
		
		assertEquals(false,jan88.hasAdvisee());
		assertEquals(false,may75.hasAdvisee());
		assertEquals(true,jul53.hasAdvisee());
		assertEquals(true,sep59.hasAdvisee());
		
		assertEquals(false,jul53.gotAfter(sep59));
		assertEquals(true,jan88.gotAfter(may75));
		assertEquals(false,sep59.gotAfter(jan88));
		assertEquals(false,may75.gotAfter(may75));
		assertEquals(false,may75.gotAfter(may752));
		assertEquals(true, aug88.gotAfter(jan88));
		
		assertEquals(true,jan88.areSiblings(may75));
		assertEquals(false,jul53.areSiblings(sep59));
		assertEquals(false,jul53.areSiblings(jan88));
		assertEquals(true,may75.areSiblings(jan88));
		assertEquals(false,sep59.areSiblings(sep59));
		
		/* testing assert statements for the three functions in Group D */
		assertThrows(AssertionError.class, () -> jul53.areSiblings(null));
		assertThrows(AssertionError.class, () -> may75.areSiblings(null));
	}

}
