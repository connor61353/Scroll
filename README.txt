Intro:
This is an interpreter for my langauge "Scroll", which was made as part of my Programming Languages class
Built on Java

Scroll is a language that keeps all functions and variables together on a linked list.  
To use a function, you navigate to the correct node using <n> and <m>, and select it with <h>.  
If it is a custom function or variable, <h> will push it to the stack for use.
Many default functions require variables or values to be on the stack to function correctly

Example Programs:
1. Hello World
	#Hello World#mh            															
2. Cat							-	echos user input
	mmhnh                      															
3. Multiply 2 Input Numbers		-	takes 2 numbers, multiplies them
	mmh$3$hmmmmm mmmh rmh      															   
4. Repeats user input n times	-	takes string, n, prints string n times
	mmhs!rmmmmm mmmmm mmmmm mmmmm mmmmhrmh!rmmmmm mmmmm mmmmm mmmmm mmmmmhrmmhrmmmmh
5. reverseString()				-	takes string, returns reversed string
	mmhs                                                                                           vuserString
	##s                                                                                            vemptyString 
	!rmmmmm mmmmm mmmmm mmmmm mmmmh nnnh $0$ nnnnh!                                                vconditional
	!rmmmmm mmmmm mmmmm mmmmm mmmmh nnnh$1$ rmmmmm mmmmh!                                          vlastIndex
	!rmmmmm mmmmm mmmmm mmmmm mmmmh mmmh rmmmh rmmmmm mmmmm mmmmm mmmmm mmh!                       vlastChar
	!rmmmmm mmmmm mmmmm mmmmm mmmmmhh mmmh rmmmh rmmmmmmmmh nh!                                    vmove last char to n
	!rmmmmm mmmmm mmmmm mmmmm mmmmhh$0$ mmmh rmmmh     rmmmmm mmmmm mmmmm mmmmm mmmh rmmmmmmmh!    vremovechar from s  
	!rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmh rmmmh rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmmh rmmmh!       vmoves last char, then deletes it from s
	rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmm mh                                                        vfind function to do    
	rmmmmm mmmmm mmmmm mmmmm mmmmm mh                                                              vfind conditional
	rmmmmmh                                                                                        vwhile loop
	rmmmmm mmmmm mmmmm mmmmm mmmmmh rmh   														   vprints result
6. isPalindrome()	-	contains tags for debugging
	@true@s																							vnew result bool
	rmmhs																							vuser string
	!#whileCondition# rmh rmmmmm mmmmm mmmmm mmmmm mmmmmh nnnnh rmmmh $1$ rmmmmm mmmmm mmmmm mmh!	vwhileConditional() - (inputLength() > 1)
	!#firstChar# rmh rmmmmm mmmmm mmmmm mmmmm mmmmmh $0$ $1$ rmmmmm mmmmm mmmmm mmmmm mmmh!			vfirstChar()
	!#lastChar# rmh rmmmmm mmmmm mmmmm mmmmm mmmmmh rmmmmm mmmmm mmmmm mmmmm mmmmmh nnnnh rmmmh		
	$1$ rmmmmmmmmmh rmmmmm mmmmm mmmmm mmmmm mmmmmh nnnnh rmmmh rmmmmm mmmmm mmmmm mmmmm mmmh!		vlastChar()
	!#ifCond# rmh rmmmmm mmmmm mmmmm mmmmm mmmmm mmh rmmmh rmmmmm mmmmm mmmmm mmmmm mmmmm mmmh		
	rmmmh rmmmmm mmmmm mmmmm mh nnnh!																vifConditional - ( not (firstIndex == lastIndex))
	!#falsebool# rmh rmmmmm mmmmm mmmmm mmmmm mmmmh @false@ rmmmmmmmh!								vfalsebool
	!#ifStatement# rmh rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmmh nh rmmmmmmh 							
	rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmm mmh rmmmh!													vifStatement
	!#deleteEnds# rmh rmmmmm mmmmm mmmmm mmmmm mmmmmhh $1$ rmmmmm mmmmm mmmmm mmmmm mmmmmh			
	nnnnh $1$ rmmmmmmmmmh rmmmmm mmmmm mmmmm mmmmm mmmh rmmmmmmmh!									vdelete ends
	!#whileStatement# rmh rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmm mh nnnnnh rmmmmmh!					vwhileStatement
	rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmm mmmh rmmmh													vcallWhile
	rmmmmm mmmmm mmmmm mmmmm mmmmh rmh																vprint bool
7. isEven()
	rmmhs																vuserNum
	@false@s															vbool false
	!rmmmmm mmmmm mmmmm mmmmm mmmmmh @true@ rmmmmmmmh!					vsetTrue
	!rmmmmm mmmmm mmmmm mmmmm mmmmh $2$ rmmmmm mmmmm mmh $0$ mmmmh!		vifCondition - (userNum % 2 == 0)
	!rmmmmm mmmmm mmmmm mmmmm mmmmm mh mh rmmmmmmh!						vifEven()
	rmmmmm mmmmm mmmmm mmmmm mmmmm mmmh rmmmh							vcall isEven
	rmmmmm mmmmm mmmmm mmmmm mmmmmh rmh									vprint bool
	

Supports:
Variables
	Int
	String
	Bool
	Function 
Functions
Comments


Keywords:
n
	Move scroll pointer up
m
	Move scroll pointer down
h
	Use selected default scroll function
	Push selected custom function to stack
	Push selected scroll variable to stack
r
	(reset) Set scroll pointer to beginning
v
	(comment) Ignore rest of current line
!
	Declare function, push to scroll
	!<Custom Function>!
@
	Declare Boolean, push to stack
	@<bool value>@
#
	Declare string, push to stack
	#<string value>#
$
	Declare integer, push to stack
	#<integer value>#
s
	Push top of stack to scroll


Default Scroll Functions:
printScroll
	Prints default functions
	Prints custom functions and variables
Print
	Prints top of stack
Input
	Takes user input (string or integer), pushes to stack
Call
	Executes custom function on top of stack
	Use: <custom function> (call())h 		
	→ calls function
Four
	For loop
	Use: <custom function> <n> (four())h 	
	→ executes function n times
Whale
	While loop
	Requires condition function
	Use: <custom function> <condition function> (whale())h
	→ calls condition function which returns a boolean value
	→ while condition function returns true, executes function
Iff
	If statement
	Use: <custom function> <condition function> (iff())h
	→ calls condition function which returns boolean value
	→ if true, executes function
Assign (int, string, bool)
	Assigns value to variable
	Use: <var> <value> (assign())h
	→ <var> = <value>
Add (int or string)
	Adds value to value, pushes to stack
	Use: <value1> <value2> (add())h
	→ <newvalue> = <value1> + <value2>
Subtract
	Subtract value from value, pushes to stack
	Use: <value1> <value2> (subtract())h
	→ <newvalue> = <value1> - <value2>
Multiply
	Multiplies two values, pushes to stack
	Use: <value1> <value2> (multiply())h
	→ <newvalue> = <value1> * <value2>
Divide
	Divides two values, pushes to stack
	Use: <value1> <value2> (divide())h
	→ <newvalue> = <value1> / <value2>
Modulo
	Mods two values, pushes to stack
	Use: <value1> <value2> (modulo())h
	→ <newvalue> = <value1> % <value2>
Not
	Flips value of bool, pushes to stack
	Use: <bool> (not())h
	→ <newbool> = !<bool>
Or
	Performs or operation on two booleans, pushes to stack
	Use: <bool1> <bool2> (or())h
	→ <newBool> = <bool1> || <bool2>
And
	Performs and operation on two booleans, pushes to stack
	Use: <bool1> <bool2> (and())h
	→ <newBool> = <bool1> && <bool2>
Equals
	Performs equals operation on two booleans, pushes to stack
	Use: <bool1> <bool2> (equals())h
	→ <newBool> = <bool1> == <bool2>
Greater
	Performs greater than operation on two booleans, pushes to stack
	Use: <bool1> <bool2> (greater())h
	→ <newBool> = <bool1> > <bool2>
greaterEqual
	Performs greater than or equal to operation on two booleans, pushes to stack
	Use: <bool1> <bool2> (greaterEqual())h
	→ <newBool> = <bool1> >= <bool2>
Lesser
	Performs lesser than operation on two booleans, pushes to stack
	Use: <bool1> <bool2> (lesser())h
	→ <newBool> = <bool1> < <bool2>
lesserEqual
	Performs lesser than or equal to operation on two booleans, pushes to stack
	Use: <bool1> <bool2> (lesserEqual())h
	→ <newBool> = <bool1> <= <bool2>
stringSize
	Finds size of given string, pushes to stack
	Use: <string> (stringSize())h
	→<newInt> = <string>.length()
stringIndex
	Finds char at given index in string, pushes to stack (as string)
	Use: <string> <indexVal> (stringIndex())
	→ <newString> = <string>[<indexVal>]
subStr
	Given a string, a start value, and an end value, pushes substring to stack
	Use: <string> <startValue> <endValue> (subStr())h
	→ <newString> = <string>.substr(<startValue>, <endValue>)
