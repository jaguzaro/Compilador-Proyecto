// ------------  Paquete e importaciones ------------
package source_compi; 

import java_cup.runtime.*;

%%	
//-------> Directivas (No tocar)

%public 
%class Lexer
%cup
%char
%column
%line
%unicode
%ignorecase

%{ 
%} 

// ------> Expresiones Regulares 


comment = ["!"][^\n]*[\n]
multiline_comment = \<\![A-Za-z0-9 \s*]* \!\>
number = \d+(\.\d{1,2})?
text = [\"][^\n\"]*[\"]
name_var = [a-zA-Z_][a-zA-Z0-9_]*






%%
// ------------  Reglas Lexicas -------------------

//Palabras reservadas
"var" { return new Symbol(sym.VRBL, yycolumn, yyline, yytext()); }
"arr" { return new Symbol(sym.ARR, yycolumn, yyline, yytext()); }
"double" { return new Symbol(sym.TYPED, yycolumn, yyline, yytext()); }
"char[]" { return new Symbol(sym.TYPEC, yycolumn, yyline, yytext()); }
"end" { return new Symbol(sym.END, yycolumn, yyline, yytext()); }
"sum" { return new Symbol(sym.WSUM, yycolumn, yyline, yytext()); }
"res" { return new Symbol(sym.WRES, yycolumn, yyline, yytext()); }
"mul" { return new Symbol(sym.WMUL, yycolumn, yyline, yytext()); }
"div" { return new Symbol(sym.WDIV, yycolumn, yyline, yytext()); }
"mod" { return new Symbol(sym.WMOD, yycolumn, yyline, yytext()); }
"media" { return new Symbol(sym.WMED, yycolumn, yyline, yytext()); }
"mediana" { return new Symbol(sym.WMEDN, yycolumn, yyline, yytext()); }
"moda" { return new Symbol(sym.WMDA, yycolumn, yyline, yytext()); }
"varianza" { return new Symbol(sym.WVRNZ, yycolumn, yyline, yytext()); }
"max" { return new Symbol(sym.WMX, yycolumn, yyline, yytext()); }
"min" { return new Symbol(sym.WMN, yycolumn, yyline, yytext()); }
"program" { return new Symbol(sym.PRGRM, yycolumn, yyline, yytext()); }
"end program" { return new Symbol(sym.ENDPRGRM, yycolumn, yyline, yytext()); }
"console" { return new Symbol(sym.CNSL, yycolumn, yyline, yytext()); }
"print" { return new Symbol(sym.PRNT, yycolumn, yyline, yytext()); }
"column" { return new Symbol(sym.CLMN, yycolumn, yyline, yytext()); }
"graphBar" { return new Symbol(sym.GBAR, yycolumn, yyline, yytext()); }
"graphPie" { return new Symbol(sym.GPIE, yycolumn, yyline, yytext()); }
"graphLine" { return new Symbol(sym.GLINE, yycolumn, yyline, yytext()); }
"histogram" { return new Symbol(sym.HSTGRM, yycolumn, yyline, yytext()); }
"exec" { return new Symbol(sym.EXEC, yycolumn, yyline, yytext()); }
"titulo" { return new Symbol(sym.TTL, yycolumn, yyline, yytext()); }
"ejeX" { return new Symbol(sym.AXISX, yycolumn, yyline, yytext()); }
"ejeY" { return new Symbol(sym.AXISY, yycolumn, yyline, yytext()); }
"tituloX" { return new Symbol(sym.TTLX, yycolumn, yyline, yytext()); }
"tituloY" { return new Symbol(sym.TTLY, yycolumn, yyline, yytext()); }
"label" { return new Symbol(sym.LBL, yycolumn, yyline, yytext()); }
"values" { return new Symbol(sym.VLS, yycolumn, yyline, yytext()); }


//Simbolos Reservados
":" { return new Symbol(sym.DPOINTS, yycolumn, yyline, yytext()); }
"@" { return new Symbol(sym.SAT, yycolumn, yyline, yytext()); }
"[" { return new Symbol(sym.LSBRCKT, yycolumn, yyline, yytext()); }
"]" { return new Symbol(sym.RSBRCKT, yycolumn, yyline, yytext()); }
"(" { return new Symbol(sym.LSPRTH, yycolumn, yyline, yytext()); }
")" { return new Symbol(sym.RSPRTH, yycolumn, yyline, yytext()); }
"," { return new Symbol(sym.CMM, yycolumn, yyline, yytext()); }
";" { return new Symbol(sym.SMCLN, yycolumn, yyline, yytext()); }
"=" { return new Symbol(sym.SEQLS, yycolumn, yyline, yytext()); }
"-" { return new Symbol(sym.SMINUS, yycolumn, yyline, yytext()); }
">" { return new Symbol(sym.RArrow, yycolumn, yyline, yytext()); }
"<" { return new Symbol(sym.LARROW, yycolumn, yyline, yytext()); }

//Expresiones

{number}  { return new Symbol(sym.NMBR, yycolumn, yyline, yytext()); }
{text} { return new Symbol(sym.STRNG, yycolumn, yyline, yytext()); }
{name_var} { return new Symbol(sym.NAMEVAR, yycolumn, yyline, yytext()); }



//------> Ingorados 

{comment} { }
{multiline_comment} { }
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}


//------> Errores Léxicos 
.           	{ System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); }
