package sucorrientazo.delivery;

import java.util.List;

import sucorrientazo.movement.Movement;

public class Delivery{
	
	private List<Movement> movements;
	
	
	public Delivery(List<Movement> movements) {
		super();
		this.movements = movements;
	}
	
	public List<Movement> getMovements() {
		return movements;
	}
	
	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}
	
	
	
}
