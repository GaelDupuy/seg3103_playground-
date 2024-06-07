Followed the steps to make the report. pictures of the report and code are in the asset folder. Wrote tests below, some aren’t code yet. 

TESTS FOR DATA 



public class DataTest {

    @Test
public void ValidDateTest() {
        Date date1 = new Date(2020, 2, 29); /// Test February leap year
        assertEquals(2020, date1.getYear());
        assertEquals(2, date1.getMonth());
        assertEquals(29, date1.getDay());

        Date date2 = new Date(2020, 1, 31); /// Test a 31 day month
        assertEquals(2020, date2.getYear());
        assertEquals(1, date2.getMonth());
        assertEquals(31, date2.getDay());

        Date date3 = new Date(2020, 2, 30); /// Test a 31 day month
        assertEquals(2020, date3.getYear());
        assertEquals(2, date3.getMonth());
        assertEquals(30, date3.getDay());
    }
    @Test
public void TestInvalidDates(){
    assertThrows(illegalArgumentException.class, () -> {
        new Date(2020,2,30); /// February error
    });
    assertThrows(illegalArgumentException.class, () -> {
            new Date(2020,2,30); // february error
        });
    assertThrows(illegalArgumentException.class, () -> {
            new Date(2020,4, 31); /// 31rst day error
        });
    assertThrows(illegalArgumentException.class, () -> {
            new Date(2020,6,31); /// 31rst day error
        });
    @Test
   /// test for valid month, what follows isnt code, did not have time to code it
        (2020, 15,1) give error

        (2020, 0,1) give error
    ///test foir valid year
        (-1, 1, 1) invalid year
      @test
      ///test for next dates
    Date date1 = new Date(2020, 1, 31);
    Date nextDate1 = date1.nextDate();
    assertEquals(2020, nextDate1.getYear());
    assertEquals(2, nextDate1.getMonth());
    assertEquals(1, nextDate1.getDay());

    Date date2 = new Date(2020, 2, 28);
    Date nextDate2 = date2.nextDate();
    assertEquals(2020, nextDate2.getYear());
    assertEquals(2, nextDate2.getMonth());
    assertEquals(1, nextDate2.getDay());
    
    // keep doing more tests 




