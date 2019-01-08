grammar CellularLanguage;

options 
{
  language = Java;
}

info : '{' NAME IDENTIFIER ';' DEFAULT IDENTIFIER ';' '}';
gfx: '{' gfx_entry+ '}'; 
tile: '{' tile_entry+ '}';

gfx_entry: IDENTIFIER '{' SYMBOL ':' CHARACTER ',' 'fg:' COLOR ',' 'bg:' COLOR ';' '}';
tile_entry: '{' single_rule+ '}';

single_rule : BECOMES IDENTIFIER WHEN condition ';';

condition: unary_condition | condition cbop condition;

unary_condition: term bop term | '!' condition | 'true' | 'false';

cbop: '&&' | '||';

term: NUMBER | NEIGHBORS '(' IDENTIFIER ')';
bop: '==' | '!=' | '>=' | '<=' | '>' | '<';

color: RGB '(' NUMBER ',' NUMBER ',' NUMBER ')';

/* tokens */
INFO : 'info';
TYPE : 'type';
WHEN: 'when';
BECOMES : 'becomes';
NEIGHBORS : 'neighbors';
DEFAULT: 'default';
NAME: 'name';
RGB: 'rgb';
SYMBOL: 'symbol';
GFX: 'gfx';

IDENTIFIER: ([a-z]|[A-Z]|'_')+;
NUMBER: '-'? [0-9]+;
CHARACTER: '\'' ([a-z][A-Z][0-9]) '\'';

WHITESPACE : (' ' | '\t' | '\n' | '\r')+ -> skip;
