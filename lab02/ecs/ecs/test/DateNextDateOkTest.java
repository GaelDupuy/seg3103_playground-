public class DateNextDateOkTest
{
 @ParameterizedTest
    @CsvSource({
        "1700, 06, 20, 1700, 06, 21",
        "2005, 04, 15, 2005, 04, 16",
        "1901, 07, 20, 1901, 07, 21",
        "3456, 03, 27, 3456, 03, 28",
        "1500, 02, 17, 1500, 02, 18",
        "1700, 06, 29, 1700, 06, 30",
        "1800, 11, 29, 1800, 11, 30",
        "3453, 01, 29, 3453, 01, 30",
        "444, 02, 29, 444, 03, 01",
        "2005, 04, 30, 2005, 05, 01",
        "3453, 01, 30, 3453, 01, 31",
        "3456, 03, 30, 3456, 03, 31",
        "1901, 07, 31, 1901, 08, 01",
        "3453, 01, 31, 3453, 02, 01",
        "3456, 12, 31, 3457, 01, 01",


)}


void paratest(int year, int month, int day, int expectedYear, int expectedMonth, int expectedDay) {
        Date date = new Date(year, month, day);
        Date expectedNextDate = new Date(expectedYear, expectedMonth, expectedDay);
        assertEquals(expectedNextDate, date.nextDate());
    }
}