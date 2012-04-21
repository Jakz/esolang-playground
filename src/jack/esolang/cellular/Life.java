package jack.esolang.cellular;

import jack.esolang.cellular.rules.*;
import jack.esolang.cellular.rules.terms.*;
import jack.esolang.cellular.rules.terms.Number;

public class Life
{
	public static void build()
	{
		Automaton a = new Automaton(Constants.WC,Constants.HC);
		
		Type dead = new Type("dead", new GFXTemplate(new java.awt.Color(30,30,30)));
		Type alive = new Type("alive", new GFXTemplate(new java.awt.Color(255,128,0)));
		
		Condition sr1 = new ComparisonCondition<Integer>(new NeighborTerm(alive), new Number(3), ComparisonCondition.Op.EQ);
		Rule r = new Rule(alive, sr1);
		
		Condition dr1 = new ComparisonCondition<Integer>(new NeighborTerm(alive), new Number(4), ComparisonCondition.Op.GEQ);
		Condition dr2 = new ComparisonCondition<Integer>(new NeighborTerm(alive), new Number(1), ComparisonCondition.Op.LEQ);
		Rule r2 = new Rule(dead, new LogicCondition(dr1,dr2, LogicCondition.Op.OR));
		
		dead.addRule(r);
		alive.addRule(r2);
		
		a.addType(dead);
		a.addType(alive);
		
		a.reset(dead);
	}
}
