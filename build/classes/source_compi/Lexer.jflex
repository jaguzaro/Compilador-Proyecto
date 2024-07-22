// ------------  Paquete e importaciones ------------
package source_compi;
 

import java_cup.runtime.*;
import java.util.ArrayList;

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

    public ArrayList<Token> tokensTable = new ArrayList<Token>();
    public ArrayList<LexError> errorsTable = new ArrayList<LexError>();
    public int counter = 0;
    public int counterErrors = 0;
    public ArrayList<Token> getTokens(){
        System.out.println("Tokens");
        return tokensTable;
    }
    public ArrayList<LexError> getErrors(){
        System.out.println("Errores");
        return errorsTable;
    }
    

%} 

%init{
    yyline = 1;
    yycolumn = 1;
%init}

// ------> Expresiones Regulares 


comment = ["!"][^\n]*[\n]
multiline_comment = \<\!\s*[a-zA-ZÀ-ÖØ-öø-ÿ0-9\"\@\#\$\%\&\(\)\-\_\+\=\[\]\;\'\,\.\{\}\s*]*\s*\!\>
number = \d+(\.\d{1,2})?
text = [\"][^\n\"]*[\"]
name_var = [a-zA-Z_][a-zA-Z0-9_]*






%%
// ------------  Reglas Lexicas -------------------

//Palabras reservadas
"var" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.VRBL, yycolumn, yyline, yytext()); }
"arr" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.ARR, yycolumn, yyline, yytext()); }
"double" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.TYPED, yycolumn, yyline, yytext()); }
"char[]" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.TYPEC, yycolumn, yyline, yytext()); }
"end" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.END, yycolumn, yyline, yytext()); }
"sum" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.WSUM, yycolumn, yyline, yytext()); }
"res" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.WRES, yycolumn, yyline, yytext()); }
"mul" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.WMUL, yycolumn, yyline, yytext()); }
"div" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.WDIV, yycolumn, yyline, yytext()); }
"mod" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.WMOD, yycolumn, yyline, yytext()); }
"media" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.WMED, yycolumn, yyline, yytext()); }
"mediana" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.WMEDN, yycolumn, yyline, yytext()); }
"moda" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.WMDA, yycolumn, yyline, yytext()); }
"varianza" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.WVRNZ, yycolumn, yyline, yytext()); }
"max" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.WMX, yycolumn, yyline, yytext()); }
"min" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.WMN, yycolumn, yyline, yytext()); }
"program" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.PRGRM, yycolumn, yyline, yytext()); }
"end program" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.ENDPRGRM, yycolumn, yyline, yytext()); }
"console" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.CNSL, yycolumn, yyline, yytext()); }
"print" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.PRNT, yycolumn, yyline, yytext()); }
"column" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.CLMN, yycolumn, yyline, yytext()); }
"graphBar" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.GBAR, yycolumn, yyline, yytext()); }
"graphPie" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.GPIE, yycolumn, yyline, yytext()); }
"graphLine" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.GLINE, yycolumn, yyline, yytext()); }
"histogram" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.HSTGRM, yycolumn, yyline, yytext()); }
"exec" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.EXEC, yycolumn, yyline, yytext()); }
"titulo" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.TTL, yycolumn, yyline, yytext()); }
"ejeX" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.AXISX, yycolumn, yyline, yytext()); }
"ejeY" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.AXISY, yycolumn, yyline, yytext()); }
"tituloX" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.TTLX, yycolumn, yyline, yytext()); }
"tituloY" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.TTLY, yycolumn, yyline, yytext()); }
"label" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.LBL, yycolumn, yyline, yytext()); }
"values" { tokensTable.add(new Token(counter + 1, yytext(), "Palabra Clave", yyline, yycolumn)); return new Symbol(sym.VLS, yycolumn, yyline, yytext()); }


//Simbolos Reservados
":" { tokensTable.add(new Token(counter + 1, yytext(), "Operador", yyline, yycolumn)); return new Symbol(sym.DPOINTS, yycolumn, yyline, yytext()); }
"@" { tokensTable.add(new Token(counter + 1, yytext(), "Operador", yyline, yycolumn)); return new Symbol(sym.SAT, yycolumn, yyline, yytext()); }
"[" { tokensTable.add(new Token(counter + 1, yytext(), "Operador", yyline, yycolumn)); return new Symbol(sym.LSBRCKT, yycolumn, yyline, yytext()); }
"]" { tokensTable.add(new Token(counter + 1, yytext(), "Operador", yyline, yycolumn)); return new Symbol(sym.RSBRCKT, yycolumn, yyline, yytext()); }
"(" { tokensTable.add(new Token(counter + 1, yytext(), "Operador", yyline, yycolumn)); return new Symbol(sym.LSPRTH, yycolumn, yyline, yytext()); }
")" { tokensTable.add(new Token(counter + 1, yytext(), "Operador", yyline, yycolumn)); return new Symbol(sym.RSPRTH, yycolumn, yyline, yytext()); }
"," { tokensTable.add(new Token(counter + 1, yytext(), "Operador", yyline, yycolumn)); return new Symbol(sym.CMM, yycolumn, yyline, yytext()); }
";" { tokensTable.add(new Token(counter + 1, yytext(), "Operador", yyline, yycolumn)); return new Symbol(sym.SMCLN, yycolumn, yyline, yytext()); }
"=" { tokensTable.add(new Token(counter + 1, yytext(), "Operador", yyline, yycolumn)); return new Symbol(sym.SEQLS, yycolumn, yyline, yytext()); }
"-" { tokensTable.add(new Token(counter + 1, yytext(), "Operador", yyline, yycolumn)); return new Symbol(sym.SMINUS, yycolumn, yyline, yytext()); }
">" { tokensTable.add(new Token(counter + 1, yytext(), "Operador", yyline, yycolumn)); return new Symbol(sym.RArrow, yycolumn, yyline, yytext()); }
"<" { tokensTable.add(new Token(counter + 1, yytext(), "Operador", yyline, yycolumn)); return new Symbol(sym.LARROW, yycolumn, yyline, yytext()); }

//Expresiones

{number}  { tokensTable.add(new Token(counter + 1, yytext(), "Double", yyline, yycolumn)); return new Symbol(sym.NMBR, yycolumn, yyline, yytext()); }
{text} { tokensTable.add(new Token(counter + 1, yytext(), "String", yyline, yycolumn)); return new Symbol(sym.STRNG, yycolumn, yyline, yytext()); }
{name_var} { tokensTable.add(new Token(counter + 1, yytext(), "ID", yyline, yycolumn)); return new Symbol(sym.NAMEVAR, yycolumn, yyline, yytext()); }



//------> Ingorados 

{comment} { }
{multiline_comment} { }
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}


//------> Errores Léxicos 
.           	{ System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn);
                  errorsTable.add(new LexError(counterErrors + 1, "Lexico", "El caracter " + yytext() + " no pertenece al lenguaje", yyline, yycolumn ));}
