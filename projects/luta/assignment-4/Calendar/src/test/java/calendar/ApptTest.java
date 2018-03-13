package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

 @Test
	  public void test02()  throws Throwable  { 
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
	assertEquals("\t1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n", appt.toString());
	assertEquals(0, appt.compareTo(appt));
	}

	public void test03() throws Throwable {
		int startHour=10;
		int startMinute=20;
		int startDay=18;
		int startMonth= 02;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";

		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		assertTrue(appt.getValid());
		appt.setTitle(null);
		appt.setDescription(null);
		
		assertEquals(null, appt.getTitle());
		assertEquals(null, appt.getDescription());
		assertNotEquals(null, appt.toString());
	}

	@Test
	public void test04() throws Throwable {
		int startHour=10;
		int startMinute=20;
		int startDay=18;
		int startMonth= 02;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";

		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		assertNotEquals("", appt.getTitle());
		assertNotEquals("", appt.getDescription());
	}

	public void test05() throws Throwable {
		int[] arr={1,2,3};
		int startHour=10;
		int startMinute=20;
		int startDay=18;
		int startMonth= 02;
		int startYear=2018;

		String title="Birthday Party";
		String description="This is my birthday party.";

		Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);

	appt.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
	assertEquals(Appt.RECUR_NUMBER_FOREVER, appt.getRecurNumber());
	assertEquals(arr,appt.getRecurDays());
	assertEquals(Appt.RECUR_BY_WEEKLY,appt.getRecurBy());
	assertEquals(Appt.RECUR_BY_WEEKLY,appt.getRecurBy());
	assertTrue(appt.isRecurring());
	
	assertEquals("\t2/18/2018 at 10:20pm ,Birthday Party, This is my birthday party.\n", appt.toString());
	}

	@Test
	public void test06() throws Throwable {
		int startHour=10;
		int startMinute=20;
		int startDay=18;
		int startMonth= 02;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";

		Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);


//in the bottom range
	    appt.setStartHour(0);
		assertTrue(appt.getValid());
		appt.setStartMinute(0);
		assertTrue(appt.getValid());
//in the top range
	    appt.setStartHour(23);
		assertTrue(appt.getValid());
		appt.setStartMinute(59);
		assertTrue(appt.getValid());

	}


	@Test
	public void test07() throws Throwable {
		int startHour=10;
		int startMinute=20;
		int startDay=18;
		int startMonth= 02;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";

		Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		appt.setStartMinute(10);
		assertEquals(10, appt.getStartMinute());
		appt.setStartHour(10);
		assertEquals(10, appt.getStartHour());
		appt.setStartDay(10);
		assertEquals(10, appt.getStartDay());
		appt.setStartMonth(10);
		assertEquals(10, appt.getStartMonth());
		appt.setStartYear(2017);
		assertEquals(2017, appt.getStartYear());
		//comparing ^

		//test invalids
		appt.setStartDay(-1);
		assertEquals(false, appt.getValid());
		
		appt.setStartDay(32);
		assertEquals(false, appt.getValid());
		appt.setStartDay(0);
		assertEquals(false, appt.getValid());

		
		appt.setStartHour(25);
		assertEquals(false, appt.getValid());
		
		
		appt.setTitle("Titletest");
		assertEquals("Titletest", appt.getTitle());
		appt.setDescription("Descriptiontest");
		assertEquals("Descriptiontest", appt.getDescription());

	}

	@Test
	public void test08() throws Throwable {
		int startHour=10;
		int startMinute=20;
		int startDay=18;
		int startMonth= 02;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";

		Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);

		assertEquals(0, appt.getRecurIncrement());
		assertEquals(2, appt.getRecurBy());
		assertEquals(false, appt.isRecurring());
		assertNotEquals(null, appt.getRecurDays());
		assertEquals(0, appt.getRecurNumber());

		 

		 appt.setRecurrence(null, 2, 2, 2);
		 assertEquals(2, appt.getRecurIncrement());
		 assertEquals(2, appt.getRecurNumber());


	}


}
