package sucorrientazo.corrientazo;

import static sucorrientazo.corrientazo.SuCorrientazo.generateReports;
import static sucorrientazo.corrientazo.SuCorrientazo.loadDeliveries;
import static sucorrientazo.corrientazo.SuCorrientazo.updatePositions;


public class App 
{
    public static void main( String[] args )
    {
    	try {
    		loadDeliveries();
        	updatePositions();
        	generateReports();
    	}catch(Exception e) {
    		System.out.println("Error en la aplicación.");
    	}
    }
}