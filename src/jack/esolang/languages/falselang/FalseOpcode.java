package jack.esolang.languages.falselang;

public interface FalseOpcode
{
	public static class VarRefLoad implements FalseOpcode
	{
		char var;
		
		VarRefLoad()
		{
			
		}
	}
}
