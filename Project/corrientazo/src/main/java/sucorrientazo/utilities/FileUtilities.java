package sucorrientazo.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sucorrientazo.exceptions.FileException;
import sucorrientazo.utilities.Config;

public class FileUtilities {

	public List<String> getInputFiles() throws FileException{
		
		List<String> files = new ArrayList<String>();
		File directory = new File(Config.DELIVERY_DIRECTORY);
        String[] inputFiles = directory.list();
        
        if (inputFiles == null || inputFiles.length == 0) {
            throw new FileException(Messages.NO_INPUT_FILES);
        
        }else{
            for (int i=0; i< inputFiles.length; i++) {
                if(validateName(inputFiles[i])) {
                	files.add(inputFiles[i]);
                }
                
            }
            
            if(files.isEmpty()) {
            	throw new FileException(Messages.NO_INPUT_FILES);
            }
            
            if(files.size() > Config.DRONES) {
            	throw new FileException(Messages.DRONES_MAX_NUM);
            }
        }
        return files;
	}
	
	public boolean validateName(String name) {
		
		Pattern p = Pattern.compile("in+(\\d){2}(.txt)");
		Matcher m = p.matcher(name);
		if(m.matches()) {
			return true;
		}
		return false;
	}
	
	
	public List<String> obtainLines(String fileName) throws FileException, IOException{
		fileName= Config.DELIVERY_DIRECTORY+"/"+fileName;
		File file = new File(fileName);
		List<String> lines = new ArrayList<String>();
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
		    fr = new FileReader(file);
		    br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			throw new FileException(Messages.NO_FILE_FOUND+file.getName());
		}

		String line;
		while(( line = br.readLine()) != null) {
		    lines.add(line);
		}
		fr.close();
		br.close();
		return lines;
		
	}
	
	public void generateReport(String fileName, List<String> positions) throws IOException {
		File file = new File(fileName);
		BufferedWriter bw = null;
		String linea="";
		bw = new BufferedWriter(new FileWriter(file));
		bw.write(Config.TITLE_REPORT);
		bw.newLine();
		for(String line:positions){
			linea = line;
			bw.write(linea);
			bw.newLine();
		}
		if(bw != null){
			bw.close();
		}
	
	}

}
