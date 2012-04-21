package jack.esolang.cellular;

import jack.esolang.cellular.rules.*;
import jack.esolang.cellular.rules.terms.*;
import jack.esolang.cellular.rules.terms.Number;

public class Life
{
	public static void buildLife()
	{
		Automaton a = new Automaton(Constants.WC,Constants.HC);
		
		Type dead = new Type("dead", new GFXTemplate(new java.awt.Color(30,30,30)));
		Type alive = new Type("alive", new GFXTemplate(new java.awt.Color(255,128,0)));
		
		Condition sr1 = new ComparisonCondition<Integer>(new NeighborCountTerm(alive), new Number(3), ComparisonCondition.Op.EQ);
		Rule r = new Rule(alive, sr1);
		
		Condition dr1 = new ComparisonCondition<Integer>(new NeighborCountTerm(alive), new Number(4), ComparisonCondition.Op.GEQ);
		Condition dr2 = new ComparisonCondition<Integer>(new NeighborCountTerm(alive), new Number(1), ComparisonCondition.Op.LEQ);
		Rule r2 = new Rule(dead, new LogicCondition(LogicCondition.Op.OR, dr1,dr2));
		
		dead.addRule(r);
		alive.addRule(r2);
		
		a.addType(dead);
		a.addType(alive);
		
		a.reset(dead);
	}
	
	/*public static void buildRule30()
	{
		Automaton a = new Automaton(Constants.WC,Constants.HC);
		
		Type dead = new Type("dead", new GFXTemplate(new java.awt.Color(30,30,30)));
		Type alive = new Type("alive", new GFXTemplate(new java.awt.Color(255,128,0)));
		
		Condition s11 = new ComparisonCondition<Type>(new NeighborTerm(Constants.UP_LEFT), new TypeTerm(alive), ComparisonCondition.Op.EQ);
		Condition s12 = new ComparisonCondition<Type>(new NeighborTerm(Constants.UP), new TypeTerm(alive), ComparisonCondition.Op.EQ);
		Condition s13 = new ComparisonCondition<Type>(new NeighborTerm(Constants.UP_RIGHT), new TypeTerm(alive), ComparisonCondition.Op.EQ);
	}*/
}
