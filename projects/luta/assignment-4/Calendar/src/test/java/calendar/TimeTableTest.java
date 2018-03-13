package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 int day = 05;
		 int month = 12;
		 int year = 2016;
		 int day2 = 06;
		 int month2 = 12;
		 int year2=2016;

		GregorianCalendar caltoday = new GregorianCalendar(year, month, day);
		  
		GregorianCalendar caltomorrow = new GregorianCalendar(year2, month2, day2);
		LinkedList<CalDay> caldays = new LinkedList<CalDay>();

	    CalDay calday = new CalDay(caltoday);
		CalDay calday2 = new CalDay(caltomorrow);

	 	int startHour1 = 8;
		 int startMinute1 = 20;
		 int startDay1 = 4;
		 int startMonth1 = 1;
		 int startYear1 = 2018; 
		 int startHour2 = 9;
		 int startMinute2 = 30;
		 int startDay2 = 6;
		 int startMonth2 = 1;
		 int startYear2 = 2018;
		 int startHour3 = 10;
		 int startMinute3 = 20;
		 int startDay3 = 4;
		 int startMonth3 = 1;
		 int startYear3 = 2018;

		 String title1="Pool party";
		 String description1="This is my pool party";
		 String title2="Birthday party";
		 String description2="This is my birthday party";
		 String title3="Concert";
		 String description3="This is my concert";

 		Appt appt1 = new Appt(startHour1,
		          startMinute1 ,
		          startDay1 ,
		          startMonth1 ,
		          startYear1 ,
		          title1,
		         description1);
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
		 LinkedList<Appt> Appts = new LinkedList<Appt>();
		 Appts.add(appt1);
		 Appts.add(appt2);
		 Appts.add(appt3);

	 	TimeTable timetable = new TimeTable();
	 	caldays=timetable.getApptRange(Appts, caltoday, caltomorrow);

		LinkedList<Appt> nullListAppts = null;

		assertEquals(null, timetable.deleteAppt(nullListAppts, appt1));

		assertEquals(true, appt1.getValid());
		assertEquals(null, timetable.deleteAppt(Appts, appt1));

		assertEquals(true, appt3.getValid());
		assertEquals(null, timetable.deleteAppt(Appts, appt3));
	 }

	 //test recur
	 @Test
	  public void test02()  throws Throwable  {

		 int[] recurDays = new int[3];
		 GregorianCalendar today = new GregorianCalendar(2018,01,01);
		 GregorianCalendar tomorrow = new GregorianCalendar(2018,01,10);
		 GregorianCalendar today2 = new GregorianCalendar(2018,01,01);
		 GregorianCalendar tomorrow2 = new GregorianCalendar(2018,01,02);

	 	int startHour1 = 8;
		 int startMinute1 = 20;
		 int startDay1 = 4;
		 int startMonth1 = 1;
		 int startYear1 = 2018; 
		 int startHour2 = 9;
		 int startMinute2 = 30;
		 int startDay2 = 6;
		 int startMonth2 = 1;
		 int startYear2 = 2018;
		 int startHour3 = 10;
		 int startMinute3 = 20;
		 int startDay3 = 4;
		 int startMonth3 = 1;
		 int startYear3 = 2018;


		 String title = "Pool party";
		 String description = "This is my pool party.";

			Appt appt1 = new Appt(startHour1,
		          startMinute1 ,
		          startDay1 ,
		          startMonth1 ,
		          startYear1 ,
		          title,
		         description);
		Appt appt2 = new Appt(startHour2,
		          startMinute2 ,
		          startDay2 ,
		          startMonth2 ,
		          startYear2 ,
		          title,
		         description);
		Appt appt3 = new Appt(startHour3,
		          startMinute3 ,
		          startDay3 ,
		          startMonth3 ,
		          startYear3 ,
		          title,
		         description);
		 appt1.setRecurrence(recurDays, 1, 1, 1000);
		 appt2.setRecurrence(null, 1, 1, 1000);
		 appt3.setRecurrence(null, 1, 1, 1000);
		 assertEquals(true,appt3.getValid());
	 }
	 @Test
	public void test03()  throws Throwable  {
		 TimeTable timetable = new TimeTable();
		 TimeTable timetable2 = new TimeTable();
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 LinkedList<Appt> listAppts2 = new LinkedList<Appt>();

		 int[] recurarr = new int[]{4};
		 GregorianCalendar today = new GregorianCalendar(2018,01,01);
		 GregorianCalendar tomorrow = new GregorianCalendar(2018,01,10);
		 GregorianCalendar today2 = new GregorianCalendar(2018,01,01);
		 GregorianCalendar tomorrow2 = new GregorianCalendar(2018,01,02);

	 	int startHour1 = 8;
		 int startMinute1 = 20;
		 int startDay1 = 4;
		 int startMonth1 = 1;
		 int startYear1 = 2018; 
		 int startHour2 = 9;
		 int startMinute2 = 30;
		 int startDay2 = 6;
		 int startMonth2 = 1;
		 int startYear2 = 2018;
		 int startHour3 = 10;
		 int startMinute3 = 20;
		 int startDay3 = 4;
		 int startMonth3 = 1;
		 int startYear3 = 2018;


		 String title = "Pool party";
		 String description = "This is my pool party.";

			Appt appt1 = new Appt(startHour1,
		          startMinute1 ,
		          startDay1 ,
		          startMonth1 ,
		          startYear1 ,
		          title,
		         description);
		Appt appt2 = new Appt(startHour2,
		          startMinute2 ,
		          startDay2 ,
		          startMonth2 ,
		          startYear2 ,
		          title,
		         description);
		Appt appt3 = new Appt(startHour3,
		          startMinute3 ,
		          startDay3 ,
		          startMonth3 ,
		          startYear3 ,
		          title,
		         description);

		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt3);

		 timetable.getApptRange(listAppts, today, tomorrow);

		 timetable2.getApptRange(listAppts2, today, tomorrow);
		 appt2.setStartHour(25);
		 assertEquals(false, appt2.getValid());
		 listAppts.add(appt2);
		 timetable2.getApptRange(listAppts2, today, tomorrow);
		 appt3.setRecurrence(null,0,0,1000);
		 timetable.getApptRange(listAppts, today, tomorrow);
	}
}