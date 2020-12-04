package mx.uttt.edu.finalev.app.Exception;

public class CustomExceptionClass extends Exception{

	private static final long serialVersionUID = 3917477298120961723L;

	private String fieldName;
	
	public CustomExceptionClass(String message, String fieldName) {
		super(message);
		this.fieldName = fieldName;
	}
	
	public String getFieldName() {
		return this.fieldName;
	}
}
