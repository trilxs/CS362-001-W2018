package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {


	  @Test
	  public void test01()  throws Throwable  {
		int day = 12;
		int month = 2;
		int year = 2017;
		GregorianCalendar cal = new GregorianCalendar(year, month, day);

		CalDay calday = new CalDay(cal);
		assertTrue(calday.isValid());

		int startHour=10;
		int startMinute=10;
		int startDay=20;
		int startMonth=02;
		int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		
		Appt appt = new Appt(startHour,
			startMinute,
			startDay,
			startMonth,
			startYear,
			title,
			description);
		
		calday.addAppt(appt);
		assertNotEquals(null, calday.toString());

	}

	 @Test
	  public void test02()  throws Throwable  {
		int day = 12;
		int month = 2;
		int year = 2017;
		GregorianCalendar cal = new GregorianCalendar(year, month, day);

		CalDay calday = new CalDay(cal);
		assertTrue(calday.isValid());

		int startHour=10;
		int startMinute=10;
		int startDay=20;
		int startMonth=02;
		int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		
		Appt appt = new Appt(startHour,
			startMinute,
			startDay,
			startMonth,
			startYear,
			title,
			description);
		
		calday.addAppt(appt);
		calday.iterator();
		assertEquals(1, calday.getSizeAppts());
		assertNotEquals(2, calday.getSizeAppts());



	 }

	 @Test 
	 public void test03() throws Throwable {
		 int day3 = 05;
		 int month3 = 12;
		 int year3 = 2016;

		 GregorianCalendar cal = new GregorianCalendar(year3, month3, day3);

		 CalDay calday = new CalDay(cal);

		 assertEquals(05, calday.getDay());
		 assertEquals(0, calday.getMonth());
		 assertEquals(2017, calday.getYear());

		 int startHour=10;
		 int startMinute=10;
		 int startDay=20;
		 int startMonth=02;
		 int startYear=2018;
		 int startHour2=10;
		 int startMinute2=10;
		 int startDay2=20;
		 int startMonth2=02;
		 int startYear2=2018;
		 String title="Birthday Party";
		 String title2="Pool Party";
		 String description="This is my birthday party."; 
		 String description2="This is my pool party.";
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);


		Appt appt2 = new Appt(startHour2,
				 startMinute2 ,
				 startDay2 ,
				 startMonth2 ,
				 startYear2 ,
				 title2,
				 description2);

		 //Add Appointment
		 calday.addAppt(appt);
		 calday.addAppt(appt2);
		 assertNotEquals(1, calday.getSizeAppts());
		 assertEquals(2, calday.getSizeAppts());
		 calday.iterator();

		 int day2 = 02;
		 int month2 = 06;
		 int year2 = 2017;

		 StringBuilder sb = new StringBuilder();
		 Iterator<Appt> itr = calday.appts.iterator();

		 sb.append("\t --- 0/5/2017 --- \n --- -------- Appointments ------------ --- \n");

		 while(itr.hasNext()) {
			 Object element = itr.next();
			 sb.append(element + " ");
			 }
		 sb.append("\n");

		 assertEquals( sb.toString(), calday.toString());

	 
	 }

	@Test 
	public void test04() throws Throwable {		 
		 int day = 05;
		 int month = 12;
		 int year = 2016;

		 GregorianCalendar Day = new GregorianCalendar(year, month, day);

		 CalDay calday = new CalDay(Day);

		 assertEquals(05, calday.getDay());
		 assertEquals(0, calday.getMonth());
		 assertEquals(2017, calday.getYear());

		 int startHour=10;
		 int startMinute=10;
		 int startDay=20;
		 int startMonth=02;
		 int startYear=2018;
		 int startHour2=10;
		 int startMinute2=10;
		 int startDay2=20;
		 int startMonth2=02;
		 int startYear2=2018;
		 String title="Birthday Party";
		 String title2="Pool Party";
		 String description="This is my birthday party."; 
		 String description2="This is my pool party.";
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);


		Appt appt2 = new Appt(startHour2,
				 startMinute2 ,
				 startDay2 ,
				 startMonth2 ,
				 startYear2 ,
				 title2,
				 description2);

		 //Add Appointment
		 calday.addAppt(appt);
		 calday.addAppt(appt2);
		 assertNotEquals(1, calday.getSizeAppts());
		 assertEquals(2, calday.getSizeAppts());
		 calday.iterator();

		 int day2 = 02;
		 int month2 = 06;
		 int year2 = 2018;

		 GregorianCalendar cal2 = new GregorianCalendar(year2, month2, day2);

		 CalDay calday2 = new CalDay(cal2);
		 calday2.addAppt(appt);
		 calday2.addAppt(appt2);
		 assertEquals(calday2.getAppts(), calday.getAppts());
		 //null
		CalDay calday3 = new CalDay();

		assertEquals(true, calday2.isValid());
		assertNotEquals("java.util.LinkedList$ListItr@c0c2f8d", calday2.iterator());
		assertNotEquals("", calday2.toString());
	}
//add more unit tests as you needed	
public void test05()  throws Throwable  {
		 int startHour=10;
		 int startMinute=10;
		 int startDay=20;
		 int startMonth=02;
		 int startYear=2018;
		 int startHour2=10;
		 int startMinute2=10;
		 int startDay2=20;
		 int startMonth2=02;
		 int startYear2=2018;
		 int startHour3=10;
		 int startMinute3=10;
		 int startDay3=20;
		 int startMonth3=02;
		 int startYear3=2018;
		 int startHour4=10;
		 int startMinute4=10;
		 int startDay4=20;
		 int startMonth4=02;
		 int startYear4=2018;	
		 String title="Birthday Party";	 
		 String description="This is my birthday party."; 
		 String title2="Birthday Party";	 
		 String description2="This is my birthday party."; 
		 String title3="Birthday Party";	 
		 String description3="This is my birthday party."; 
		 String title4="Birthday Party";	 
		 String description4="This is my birthday party."; 
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 Appt appt2 = new Appt(startHour2,
				 startMinute2 ,
				 startDay2 ,
				 startMonth2 ,
				 startYear2 ,
				 title2,
				 description2);
		 Appt appt3 = new Appt(startHour3,
				 startMinute3 ,
				 startDay3 ,
				 startMonth3 ,
				 startYear3 ,
				 title3,
				 description3);
		 Appt appt4 = new Appt(startHour4,
				 startMinute4 ,
				 startDay4 ,
				 startMonth4 ,
				 startYear4 ,
				 title4,
				 description4);

		GregorianCalendar today = new GregorianCalendar(2018,01,01);

		CalDay calday = new CalDay(today);

		calday.addAppt(appt);
		calday.addAppt(appt2);
		calday.addAppt(appt3);
		calday.addAppt(appt4);

		assertEquals(true,calday.isValid());
		assertEquals(true, calday.iterator().hasNext());
		assertEquals("	 --- 2/20/2018 --- \n --- -------- Appointments ------------ --- \n\t2/20/2018 at 10:10am ,Birthday Party, This is my birthday party.\n \t2/20/2018 at10:10am ,title, description\n \t2/20/2018 at 10:10am ,Birthday Party, This is my birthday party.\n \n", calday.toString());
	}

}

