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
		Type alive = new Type("alive", new GFXTemplate(java.awt.Color.WHITE));
		
		Condition sr1 = new ComparisonCondition<Integer>(new NeighborTerm(alive), new Number(3), ComparisonCondition.Op.EQ);
		Condition sr2 = new ComparisonCondition<Integer>(new NeighborTerm(dead), new Number(5), ComparisonCondition.Op.EQ);
		Rule r = new Rule(alive, new LogicCondition(sr1,sr2, LogicCondition.Op.AND));
		
		Condition dr1 = new ComparisonCondition<Integer>(new NeighborTerm(alive), new Number(4), ComparisonCondition.Op.EQ);
		Condition dr2 = new ComparisonCondition<Integer>(new NeighborTerm(dead), new Number(7), ComparisonCondition.Op.EQ);
		Rule r2 = new Rule(dead, new LogicCondition(dr1,dr2, LogicCondition.Op.OR));
		
		dead.addRule(r);
		alive.addRule(r2);
		
		a.addType(dead);
		a.addType(alive);
		
		a.reset(dead);
	}
}
