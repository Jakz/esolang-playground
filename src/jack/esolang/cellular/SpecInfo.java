package jack.esolang.cellular;

import java.util.*;

public class SpecInfo
{
	public final String defaultType;
	public final String leftType, rightType;
	public final String name;
	
	
	public SpecInfo(String name, String defaultType, String leftType, String rightType)
	{
		this.name = name;
		this.defaultType = defaultType;
		this.leftType = leftType;
		this.rightType = rightType;
	}
}
