# Compilers & Languages

This project contains a number of assessments from my Compilers and Languages course during University. The assessments are detailed  below.

#Ex1 - Parsers
###### Question
```
E ::= E + T | T

T ::= T * F | F

F ::= (E) | a
```

Implement a parser for this language, as a hand-coded recursive descent parser.  You can either use JFlex/flex as a tokeniser, or write a simple tokeniser yourself.  As a minimum, it should recognize valid strings and reject invalid ones.  For additional credit, extend the parser to either print the parse tree, or evaluate expressions (you may need to modify the grammar slightly in order to do this, replacing the rule for F with the rule for F from the next exercise).

###### Solution
My solution first tokenizes the input with a hand-coded lexer. The input should be separated with spaces between the various elements of the expression (e.g. `( 5 + 4 )` ).

The parser is then called on the tokenized input to parse the input according to the language definition. As the input language is left-recursive this meant that I had to use a modified version to remove the left recursion in order to build the parser.

```
E   ::= TE'
E'  ::= +TE' | e
T   ::= FT'
T'  ::= *FT' | e
F   ::= (E)  | a

*e = epsilon/empty
*a = numeric value
```
My program successfully parses the language and reports if the input is valid according to if the parser returns true. The parser also is able to print out a parse tree of the expression.

for input `( 5 + 4 )`
```
\-- F
    |-- (
    |-- E
    |   |-- T
    |   |   |-- F
    |   |   |   \-- a
    |   |   \-- T'
    |   |       \-- e
    |   \-- E'
    |       |-- +
    |       |-- T
    |       |   |-- F
    |       |   |   \-- a
    |       |   \-- T'
    |       |       \-- e
    |       \-- E'
    |           \-- e
    \-- )
```

Code for this is available [here](https://github.com/Mattie432/Compilers-and-Languages/tree/master/ProjectCode/src/ex1).

#Ex2 - Parser Generators
###### Question
```
E ::= E + T | E - T | T

T ::= T * F | T / F | F

F ::= (E) | INT | ID
```

Where INT and ID are integers and standard programming-language variable names respectively.   Using JCup, bison or similar, implement a parser for this language.  You can either use JFlex/flex to generate a lexical analyser, or use the one you wrote yourself in part 1 (note that interfacing a hand-written lexer to the parser may be more complex than using flex).  Again, as a minimum your parser should accept valid and reject invalid strings, but you can add other features as you wish (printing parse tree, evaluating expressions, etc).

###### Solution
I first used JFlex to create a lexer for the language. The lexers structure is specified in the 'lexer.flex' file which is passed to the jflex jar to create a java class file which will lex the input.

Next I used JCup to create a parser for the language. The parsers structure is specified in the 'parser.cup' file which is passed to the JCup jar to create a Java class file which will parse the input.

I also manually created the ParserToken classes which the parser interacts with in order to produce a tree node structure I could then parse and create a binary tree from. This is shown below.
```
 ( 4 / 3 +  ( 4 * 2 )  )

\-- E
    \-- T
        \-- F
            |-- (
            |-- E
            |   |-- E
            |   |   \-- T
            |   |       |-- T
            |   |       |   \-- F
            |   |       |       \-- INT
            |   |       \-- /
            |   |       \-- F
            |   |           \-- INT
            |   |-- +
            |   \-- T
            |       \-- F
            |           |-- (
            |           |-- E
            |           |   \-- T
            |           |       |-- T
            |           |       |   \-- F
            |           |       |       \-- INT
            |           |       \-- *
            |           |       \-- F
            |           |           \-- INT
            |           \-- )
            \-- )
```
Code for this is available [here](https://github.com/Mattie432/Compilers-and-Languages/tree/master/ProjectCode/src/ex2).
