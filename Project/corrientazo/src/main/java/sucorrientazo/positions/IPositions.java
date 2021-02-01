package sucorrientazo.positions;

import java.util.List;
import java.util.Map;

import sucorrientazo.delivery.Delivery;
import sucorrientazo.exceptions.MovementException;

public interface IPositions {
	public Map<String, List<String>> updatePosition(Map<String, List<Delivery>> deliveries) throws MovementException;
}
