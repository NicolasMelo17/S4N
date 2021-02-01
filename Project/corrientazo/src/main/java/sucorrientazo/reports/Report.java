package sucorrientazo.reports;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import sucorrientazo.position.Position;
import sucorrientazo.utilities.Config;
import sucorrientazo.utilities.FileUtilities;

public class Report implements IReport{

	public void generateReports(Map<String, List<Position>> dronesPositions) throws IOException {
		FileUtilities file = new FileUtilities();
		String fileName = "";
		for (Map.Entry<String, List<Position>> position : dronesPositions.entrySet()) {
			
			fileName= Config.DELIVERY_DIRECTORY+"/"+Config.OUTPUT_FILE+position.getKey()+Config.EXTENTION;
			file.generateReport(fileName, position.getValue());
			
		}
	}
	
}
