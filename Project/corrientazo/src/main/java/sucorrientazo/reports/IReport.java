package sucorrientazo.reports;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IReport {
	
	public void generateReports(Map<String, List<String>> dronesPositions) throws IOException;

}
