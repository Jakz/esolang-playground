package jack.esolang.exceptions;

public class UnsupportedOpcodeException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public UnsupportedOpcodeException(String languageName, String opcode)
	{
		super("Invalid opcode <"+opcode+"> for language"+languageName);
	}
}
