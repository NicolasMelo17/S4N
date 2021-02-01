package sucorrientazo.corrientazo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import sucorrientazo.delivery.Delivery;
import sucorrientazo.exceptions.MovementException;
import sucorrientazo.movement.Direction;
import sucorrientazo.movement.Movement;
import sucorrientazo.position.Position;
import sucorrientazo.positions.Positions;

/**
 * Unit test for simple App.
 */
public class PositionTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PositionTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PositionTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testAdjustPositionAdvance()
    {
    	Positions position = new Positions();
    	Position result = null;
		try {
			result = position.adjustPosition(Movement.A, new Position(0,0,Direction.N));
		} catch (MovementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(new Position(0,1,Direction.N).toString(), result.toString());
    }
    
    public void testAdjustPositionRight()
    {
    	Positions position = new Positions();
		Position result = null;
		try {
			result = position.adjustPosition(Movement.D, new Position(0,0,Direction.N));
		} catch (MovementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(new Position(0,0,Direction.E).toString(), result.toString());
    }
    public void testAdjustPositionLeft()
    {
    	Positions position = new Positions();
		Position result = null;
		try {
			result = position.adjustPosition(Movement.I, new Position(0,0,Direction.N));
		} catch (MovementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(new Position(0,0,Direction.W).toString(), result.toString());
    }
    public void testPosition1() {
    	Map<String, List<Delivery>> deliveries = new HashMap<String, List<Delivery>>();
		List<Delivery> deliveries1 = new ArrayList<Delivery>();
		List<Movement> moves1 = new ArrayList<Movement>(); 
		moves1.add(Movement.A);
		moves1.add(Movement.A);
		moves1.add(Movement.D);
		moves1.add(Movement.A);
		
		Delivery del1 = new Delivery(moves1);
		deliveries1.add(del1);
		deliveries.put("01", deliveries1);
		
		Map<String, List<String>> positions = new HashMap<String, List<String>>();
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		
		String st1= "(1, 2) dirección Oriente";//new Position(1,2, Direction.E);
		List<String> sl = new ArrayList<String>();
		sl.add(st1);
		positions.put("01", sl);
		Positions position = new Positions();
		try {
			result = position.updatePosition(deliveries);
		} catch (MovementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(positions, result);
    }
    
    public void testPosition2() {
    	Map<String, List<Delivery>> deliveries = new HashMap<String, List<Delivery>>();
		
    	List<Delivery> deliveries1 = new ArrayList<Delivery>();
		List<Movement> moves1 = new ArrayList<Movement>(); 
		moves1.add(Movement.I);
		moves1.add(Movement.A);
		moves1.add(Movement.A);
		moves1.add(Movement.D);
		
		Delivery del1 = new Delivery(moves1);
		
		List<Movement> moves2 = new ArrayList<Movement>(); 
		moves2.add(Movement.A);
		moves2.add(Movement.A);
		moves2.add(Movement.A);
		moves2.add(Movement.D);
		
		Delivery del2 = new Delivery(moves2);
		
		deliveries1.add(del1);
		deliveries1.add(del2);
		deliveries.put("01", deliveries1);
		
		Map<String, List<String>> positions = new HashMap<String, List<String>>();
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		
		String st1 = "(-2, 0) dirección Norte";
		String st2 = "(-2, 3) dirección Oriente";
		List<String> sl = new ArrayList<String>();
		sl.add(st1);
		sl.add(st2);
		positions.put("01", sl);
		Positions position = new Positions();
		try {
			result = position.updatePosition(deliveries);
		} catch (MovementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(positions, result);
    }
    
    public void testErrorEncabezado() {
    	Map<String, List<Delivery>> deliveries = new HashMap<String, List<Delivery>>();
		
    	List<Delivery> deliveries1 = new ArrayList<Delivery>();
		List<Movement> moves1 = new ArrayList<Movement>(); 
		moves1.add(Movement.A);
		moves1.add(Movement.A);
		moves1.add(Movement.A);
		moves1.add(Movement.A);
		moves1.add(Movement.I);
		moves1.add(Movement.A);
		moves1.add(Movement.A);
		
		Delivery del1 = new Delivery(moves1);
		
		List<Movement> moves2 = new ArrayList<Movement>(); 
		moves2.add(Movement.D);
		moves2.add(Movement.D);
		moves2.add(Movement.D);
		moves2.add(Movement.A);
		moves2.add(Movement.I);
		moves2.add(Movement.A);
		moves2.add(Movement.D);
		
		Delivery del2 = new Delivery(moves2);
		
		List<Movement> moves3 = new ArrayList<Movement>(); 
		moves3.add(Movement.A);
		moves3.add(Movement.A);
		moves3.add(Movement.I);
		moves3.add(Movement.A);
		moves3.add(Movement.D);
		moves3.add(Movement.A);
		moves3.add(Movement.D);
		
		Delivery del3 = new Delivery(moves3);
		
		deliveries1.add(del1);
		deliveries1.add(del2);
		deliveries1.add(del3);
		deliveries.put("01", deliveries1);
		
		Map<String, List<String>> positions = new HashMap<String, List<String>>();
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		
		String st1="(-2, 4) dirección Occidente";
		String st2="(-1, 3) dirección Sur";
		String st3="(0, 0) dirección Occidente";
		List<String> sl = new ArrayList<String>();
		sl.add(st1);
		sl.add(st2);
		sl.add(st3);
		positions.put("01", sl);
		Positions position = new Positions();
		try {
			result = position.updatePosition(deliveries);
		} catch (MovementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(positions, result);
    }
}
