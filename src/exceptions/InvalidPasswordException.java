package exceptions;

public class InvalidPasswordException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "\nSenha inválida!";
	}

}
