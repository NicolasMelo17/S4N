package sucorrientazo.deliveries;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import sucorrientazo.delivery.Delivery;
import sucorrientazo.exceptions.FileException;
import sucorrientazo.exceptions.MovementException;

public interface IDeliveries {
	
	public Map<String, List<Delivery>> getDeliveries() throws FileException, IOException, MovementException;

}
