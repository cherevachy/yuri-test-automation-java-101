package by.epam.tat.cherevach.module3.lecture3.task1.exceptions;

public class PriceIsNullExc extends RuntimeException {
    
	private String excMessage;
	
	public PriceIsNullExc (String excMessage) {
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
