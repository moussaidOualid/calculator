import org.junit.jupiter.api.*;

public class CalculatorTest {

    Calculator calculator ;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Should Noot Add")
    public void shouldNotAddNoNumber(){
         //Given.
        String numbers = "" ;
        //When
        int result = calculator.add(numbers);
        //Then
        Assertions.assertEquals(0,result);
    }
    @Test
    @DisplayName("Should Add One Number")
    public void shouldAddOneNumber(){
        //Given.
        String numbers = "1" ;
        //When
        int result = calculator.add(numbers);
        //Then
        Assertions.assertEquals(1,result);
    }
    //Test Q 2 & 3
    @Test
    @DisplayName("Should Add Multiple Numbers")
    public void shouldAddMultipleNumbers(){
        //Given
        String numbers = "1\n2\n3" ;
        //When
        int result = calculator.add(numbers);
        //Then
        Assertions.assertEquals(6,result);
    }

    //Test Q 5
    @Test
    @DisplayName("Should Throw NegativeException")
    public void shouldThrowNegativeException(){
        //Given
        String numbers = "8,-3" ;
        //Then
        Assertions.assertThrows(NegativeNumberException.class,() -> calculator.add(numbers));
    }

    //Test Q 6 KO
    @Test
    @DisplayName("Should Not Concider 1000 and Bigger")
    public void shouldIgnore(){
        //Given
        String numbers = "//;3;1001;3" ;
        //When
        int result = calculator.add(numbers);
        //Then
        Assertions.assertEquals(6,result);
    }
    //Test Q 7
    @Test
    @DisplayName("Should Concider any Length of delimeter")
    public void shouldConciderAnyLengthOfDelimeter(){
        //Given
        String numbers = "//[***]\n3***10" ;
        //When
        int result = calculator.add(numbers);
        //Then
        Assertions.assertEquals(13,result);
    }


}
