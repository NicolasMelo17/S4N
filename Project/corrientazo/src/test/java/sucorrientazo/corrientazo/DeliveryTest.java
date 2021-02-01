package sucorrientazo.corrientazo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import sucorrientazo.deliveries.Deliveries;

/**
 * Unit test for simple App.
 */
public class DeliveryTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DeliveryTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DeliveryTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testName()
    {
    	Deliveries delivery = new Deliveries();
    	String result = delivery.obtainID("ads353as");
    	assertEquals("353",result );
    }
    
    
}
