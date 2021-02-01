package sucorrientazo.exceptions;

public class FileException extends Exception{

	public FileException() {
    }
    
    public FileException(final String msg) {
        super(msg);
    }
    
    public FileException(final Throwable cause) {
        super(cause);
    }
    
    public FileException(final String message, final Throwable cause) {
        super(message, cause);
    }
	
}
