package sucorrientazo.deliveries;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sucorrientazo.delivery.Delivery;
import sucorrientazo.exceptions.FileException;
import sucorrientazo.exceptions.MovementException;
import sucorrientazo.movement.Movement;
import sucorrientazo.utilities.Config;
import sucorrientazo.utilities.FileUtilities;
import sucorrientazo.utilities.Messages;

public class Deliveries implements IDeliveries{
	
public Map<String, List<Delivery>> getDeliveries() throws FileException, IOException, MovementException {
		
		List<String> files;
		List<String> lines;
		List<Delivery> droneMoves;
		Map<String, List<Delivery>> deliveries = new HashMap<String, List<Delivery>>();
		Delivery deliver;
		
		FileUtilities fileUtilities = new FileUtilities();
		files = fileUtilities.getInputFiles();
        for(String file : files) {
        	droneMoves = new ArrayList<Delivery>();
        	lines = fileUtilities.obtainLines(file);
        	if(lines.size()>Config.MAX_DRONE_DELIVERIES) {
        		throw new FileException(Messages.MAX_DELIVERY);
        	}
        	for(String line : lines) {
        		deliver = new Delivery(obtainMoves(line));
        		droneMoves.add(deliver);
        	}
        	deliveries.put(obtainID(file), droneMoves);
        	
        }
        
        return deliveries;
	}
	
	public String obtainID(String name) {
		 
		String id= name.replaceAll("[^0-9]", "");
		return id;
	}
	
	public List<Movement> obtainMoves(String line) throws MovementException{

		List<Movement> moves = new ArrayList<Movement>();
		for (int i = 0; i < line.length(); i++) { 
			
			switch(line.charAt(i)) {
			case 'A':
				moves.add(Movement.A);
				break;
			case 'I':
				moves.add(Movement.I);
				break;
			case 'D':
				moves.add(Movement.D);
				break;
			default:
				throw new MovementException(Messages.MOVEMENT_INVALID+": "+line.charAt(i));
			}
        } 
		return moves;
	}

}
