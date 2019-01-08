package com.github.jakz.esolang.cellular.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.junit.Test;

import com.github.jakz.esolang.cellular.lang.parsers.CellularLanguageBaseVisitor;
import com.github.jakz.esolang.cellular.lang.parsers.CellularLanguageLexer;
import com.github.jakz.esolang.cellular.lang.parsers.CellularLanguageParser;

public class CellularLanguageTests
{
  private CellularLanguageParser setup(String text)
  {
    CharStream stream = CharStreams.fromString(text);
    CellularLanguageLexer lexer = new CellularLanguageLexer(stream);
    TokenStream tokens = new CommonTokenStream(lexer);
    CellularLanguageParser parser = new CellularLanguageParser(tokens);
    return parser;
  }
  
  @Test
  public void testColor()
  {
    CellularLanguageParser parser = setup("rgb(128,0,160)");
    CellularLanguage.ColorVisitor visitor = new CellularLanguage.ColorVisitor();
    Color c = visitor.visit(parser.color());
    assertEquals(new Color(128,0,160), c);
  }
  
  @Test
  public void testBooleanConstants()
  {
    
  }
}
