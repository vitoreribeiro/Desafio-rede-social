package exceptions;

public class UserNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "\nUsu�rio n�o cadastrado!";
	}
}
