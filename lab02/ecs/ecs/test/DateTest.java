import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

  @Test
  void nextDate_sample() {
    Date d = new Date(1700,6,20);
    assertEquals(new Date(1700,6,21), d.nextDate());
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(2005,4,15);
    assertEquals(new Date(2005,4,16), d.nextDate());
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(1901,7,20);
    assertEquals(new Date(1901,7,21), d.nextDate());
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(3456,3,27);
    assertEquals(new Date(3456,3,28), d.nextDate());
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(1500,2,17);
    assertEquals(new Date(1500,2,18), d.nextDate());
  }

@Test
  void nextDate_sample2() {
    Date d = new Date(1500,2,17);
    assertEquals(new Date(1500,2,18), d.nextDate());
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(1700,6,29);
    assertEquals(new Date(1700,6,30), d.nextDate());
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(1800,11,29);
    assertEquals(new Date(1800,11,30), d.nextDate());
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(3453,1,29);
    assertEquals(new Date(3453,1,30), d.nextDate());
  }

@Test
  void nextDate_sample2() {
    Date d = new Date(444,2,29);
    assertEquals(new Date(444,2,30), d.nextDate());
 @Test
  void nextDate_sample2() {
    Date d = new Date(2005,4,30);
    assertEquals(new Date(2005,5,1), d.nextDate());
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(3453,1,30);
    assertEquals(new Date(3453,1,31), d.nextDate());
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(3456,3,30);
    assertEquals(new Date(3456,3,31), d.nextDate());
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(1901,7,31);
    assertEquals(new Date(1901,8,1), d.nextDate());
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(3453,1,31);
    assertEquals(new Date(3453,2,1), d.nextDate());
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(3456,12,31);
    assertEquals(new Date(3457,1,1), d.nextDate());
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(1500,2,31);
     throw new IllegalArgumentException("Invalid number");
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(1500,2,29);
     throw new IllegalArgumentException("Invalid number");
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(-1,10,20);
     throw new IllegalArgumentException("Invalid number");
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(1458,15,12);
     throw new IllegalArgumentException("Invalid number");
  }
@Test
  void nextDate_sample2() {
    Date d = new Date(1975,6,-50);
     throw new IllegalArgumentException("Invalid number");
  }





}