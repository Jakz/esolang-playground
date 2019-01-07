package jack.esolang.cellular;

import jack.esolang.cellular.rules.*;
import jack.esolang.cellular.rules.terms.*;
import jack.esolang.cellular.rules.terms.Number;

import static jack.esolang.cellular.rules.Condition.*;
import static jack.esolang.cellular.rules.terms.Term.*;

import java.awt.Color;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Life
{
	public static Spec buildLife()
  	{
	  final SpecInfo info = new SpecInfo("Life", "dead");
  
      final Type dead = new Type("dead");
      final Type alive = new Type("alive");
      
      Rule aliveRule = Rule.changeType(dead, 
          or(
              geq(
                  neighborCount(alive), 
                  number(4)
              ),
              leq(
                  neighborCount(alive),
                  number(1)
              )
          )
      );
      
      Rule deadRule = Rule.changeType(alive, 
          eq(
              neighborCount(alive),
              number(3)
          )         
      );
      
      dead.addRule(deadRule);
      alive.addRule(aliveRule);
      
       return new Spec(
           info,
           new Type[] { dead, alive },
           new Category[] { },
           Map.of("dead", new GFXSpec(' ', new Color(255, 255, 255), new Color(30, 30, 30)),
                 "alive", new GFXSpec('*', new Color(255, 255, 255), new Color(220, 220, 0))
               
               )
           );
           
           
           
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
