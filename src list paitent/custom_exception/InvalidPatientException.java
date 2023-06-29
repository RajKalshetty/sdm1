package custom_exception;

@SuppressWarnings("serial")
public class InvalidPatientException extends Exception {
	public InvalidPatientException(String mesg) {
		super(mesg);
	}
}
