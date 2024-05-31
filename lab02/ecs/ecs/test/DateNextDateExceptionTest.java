public class DateNextDateExceptionTest
{

    @ParameterizedTest
    @CsvSource({
        "1500, 02, 31",   
        "1500, 02, 29",  
        "-1, 10, 20",    
        "1458, 15, 12",   
        "1975, 6, -50"    
    })
    void testThrowsException(int year, int month, int day) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Date(year, month, day);
        });
    }
}