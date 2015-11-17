package by.epam.tat.cherevach.module3.lecture3.task1.exceptions;

public class MainMenuUnsupportedOperationExc extends RuntimeException {
    
	private String excMessage;
	
	public MainMenuUnsupportedOperationExc (String excMessage) {
    	super(excMessage);
    	this.excMessage = excMessage;
	}

	public String getMessage() {
		return excMessage;
	}

	public void setMessage(String message) {
		this.excMessage = excMessage;
	} 
}
