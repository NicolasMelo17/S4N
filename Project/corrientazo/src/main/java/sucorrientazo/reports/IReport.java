package sucorrientazo.reports;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import sucorrientazo.position.Position;

public interface IReport {
	
	public void generateReports(Map<String, List<Position>> dronesPositions) throws IOException;

}