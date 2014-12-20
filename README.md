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
#Ex3 - Garbage Collectors

###### Question

The task is to model the way in which a system which supports dynamic allocation of objects would garbage collect unused objects in a binary tree.

Represent the memory the system can allocate from as an array of structures, where each element in the array represents one node in a binary tree. Each element should contain a piece of data (an int is fine) and two "pointers", which are just indexes into the same array. So the tuple (423, 19, 27) would represent a element in a binary tree whose value is 423 and whose "left" pointer is 19 and whose "right" pointer is 27. You might need to add additional fields to the elements to handle the state of the node (in use, not in use) or to operate a free list of some sort (a pointer to the next unused node).

The functionality you need to provide is as follows: + You should be able to insert a new item into the tree. + You should be able to check whether or not an item is present in the tree. + You should be able to delete an item from the tree

###### Solution

I have incorporated a garbage collector into the delete method of the binary tree. When a node is deleted is is not removed from the array of nodes which make up the tree. Instead, all pointers to this node are adjusted so that the tree ignores that value and the indexes the deleted node pointed to are copied across. There is a 'freeIndex' list which is maintained which is a list of the indexes in the array that are free and can be overwritten.

New items are dynamically allocated to the next free position in the tree.

The program initially runs a trio of tests to demonstate these features and then allows the user to enter input and interact with the tree.

Commands:
```
add X      - adds an element with int value X
del X      - deletes element with value X
check X    - is element in the tree? true/false
printTree  - prints the tree
printArray - prints the array
newTree    - creates a new empty tree
help       - prints list of commands
exit       - Exit the program
```
