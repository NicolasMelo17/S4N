package sucorrientazo.position;

import sucorrientazo.exceptions.MovementException;
import sucorrientazo.movement.Direction;
import sucorrientazo.utilities.Config;
import sucorrientazo.utilities.Messages;

public class Position {
	
	private int X;
	private int Y;
	private Direction direction;
	
	public Position() {
		super();
		this.X = 0;
		this.Y = 0;
		this.direction = Direction.N;
	}
	
	public Position(int X, int Y, Direction direction) {
		this.X = X;
		this.Y = Y;
		this.direction = direction;
	}

	public String toString() {
		return "("+String.valueOf(X)+", "+String.valueOf(Y)+") dirección "+direction.toString();
	}
	
	public void advance() throws MovementException {
		switch(this.direction) {
			case N:
				this.Y+=1;
				break;
			case E:
				this.X+=1;
				break;
			case S:
				this.Y-=1;
				break;
			case W:
				this.X-=1;
				break;
		}
		validatePosition();
	}	
	
	public void validatePosition() throws MovementException {
		if(Math.abs(X)>Config.STREETS || Math.abs(Y)>Config.STREETS) {
			throw new MovementException(Messages.MAX_NUMBER_STREETS);
		}
	}
	
	public Direction toLeft() {
		int id = this.direction.getId();
	    if(this.direction.getId() == 1) {
	    	id = 4;
	    }else {
	    	id-=1;
	   	}
	    return getDirectionByID(id);
	}
	
	public Direction toRight() {
		int id = this.direction.getId();
	    if(this.direction.getId() == 4) {
	    	id = 1;
	    }else {
	    	id+=1;
	   	}
	    return getDirectionByID(id);
	}
	
	public Direction getDirectionByID(int id) {
		switch(id) {
	    case 1:
	    	return Direction.N;
	    case 2:
	    	return Direction.E;
	    case 3:
	    	return Direction.S;
	    case 4:
	    	return Direction.W;
	    }
		return null;
	}
	
	public Direction getDirection() {
		return direction;
	}
	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}
	
}