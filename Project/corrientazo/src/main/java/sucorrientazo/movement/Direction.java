package sucorrientazo.movement;

public enum Direction {
	
	N(1,"Norte"),
	E(2,"Oriente"),
	S(3,"Sur"),
    W(4,"Occidente");
    
    private int id;
	private String orientation;
    
    Direction(int id, String orientation){
    	this.id = id;
        this.orientation = orientation;
    }
    
    @Override
    public String toString() {
        return orientation;
    }
    
    public int getId() {
    	return this.id;
    }
    
    public Direction getDirection(int id) {
    	
    	for(Direction e : values()) {
            if(e.id == id) return e;
        }
    	return null;
    }
}
