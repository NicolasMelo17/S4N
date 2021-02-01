package sucorrientazo.positions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sucorrientazo.delivery.Delivery;
import sucorrientazo.exceptions.MovementException;
import sucorrientazo.movement.Movement;
import sucorrientazo.position.Position;

public class Positions implements IPositions {
	
	public Map<String, List<Position>> updatePosition(Map<String, List<Delivery>> deliveries) throws MovementException {
		List<Position> positions;
		Position position;
		Map<String, List<Position>> dronesPosition = new HashMap<String, List<Position>>();
		for (Map.Entry<String, List<Delivery>> delivery : deliveries.entrySet()) {
			
			positions = new ArrayList<Position>();
			position = new Position();
			
			for(Delivery del:delivery.getValue()) {
				for(Movement move : del.getMovements()) {
					position = adjustPosition(move, position);
				}
				positions.add(position);
			}
			
		    dronesPosition.put(delivery.getKey(), positions);	
		}
		
		return dronesPosition;
	}
	
	public Position adjustPosition(Movement move, Position position) throws MovementException{
		switch(move) {
			case A:
				position.advance();
				break;
			case D:
				position = new Position(position.getX(), position.getY(), position.toRight());
				break;
			case I:
				position = new Position(position.getX(), position.getY(), position.toLeft());
				break;
		}
		return position;
	}
}