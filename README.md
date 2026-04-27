# Scroll

An interpreter for **Scroll**, a custom programming language built in Java as part of a Programming Languages class.

---

## Overview

Scroll keeps all functions and variables together on a **linked list**. To use a function, you navigate to the correct node using `<n>` and `<m>`, then select it with `<h>`.

- If the selected node is a **custom function or variable**, `<h>` pushes it to the stack for use.
- Many **default functions** require variables or values to already be on the stack to operate correctly.

---

## Keywords

| Keyword | Description |
|---------|-------------|
| `n` | Move scroll pointer **up** |
| `m` | Move scroll pointer **down** |
| `h` | Use selected default scroll function / Push selected custom function or variable to stack |
| `r` | *(reset)* Set scroll pointer to beginning |
| `v` | *(comment)* Ignore the rest of the current line |
| `!` | Declare a function and push to scroll — `!<Custom Function>!` |
| `@` | Declare a Boolean and push to stack — `@<bool value>@` |
| `#` | Declare a string and push to stack — `#<string value>#` |
| `$` | Declare an integer and push to stack — `$<integer value>$` |
| `s` | Push top of stack to scroll |

---

## Supported Types

- `Int`
- `String`
- `Bool`
- `Function`
- Comments

---

## Default Scroll Functions

### I/O

| Function | Description |
|----------|-------------|
| `printScroll` | Prints all default functions, custom functions, and variables |
| `Print` | Prints top of stack |
| `Input` | Takes user input (string or integer) and pushes to stack |

### Control Flow

| Function | Usage | Description |
|----------|-------|-------------|
| `Call` | `<custom function> (call())h` | Executes the custom function on top of the stack |
| `Four` | `<custom function> <n> (four())h` | Executes function `n` times (for loop) |
| `Whale` | `<custom function> <condition function> (whale())h` | While loop — calls condition function; while it returns `true`, executes function |
| `Iff` | `<custom function> <condition function> (iff())h` | If statement — calls condition function; if `true`, executes function |

### Variables

| Function | Usage | Description |
|----------|-------|-------------|
| `Assign` | `<var> <value> (assign())h` | Assigns a value to a variable (`<var> = <value>`) |

### Arithmetic

| Function | Usage | Result |
|----------|-------|--------|
| `Add` | `<value1> <value2> (add())h` | `value1 + value2` (int or string) |
| `Subtract` | `<value1> <value2> (subtract())h` | `value1 - value2` |
| `Multiply` | `<value1> <value2> (multiply())h` | `value1 * value2` |
| `Divide` | `<value1> <value2> (divide())h` | `value1 / value2` |
| `Modulo` | `<value1> <value2> (modulo())h` | `value1 % value2` |

### Logic

| Function | Usage | Result |
|----------|-------|--------|
| `Not` | `<bool> (not())h` | `!bool` |
| `Or` | `<bool1> <bool2> (or())h` | `bool1 \|\| bool2` |
| `And` | `<bool1> <bool2> (and())h` | `bool1 && bool2` |
| `Equals` | `<bool1> <bool2> (equals())h` | `bool1 == bool2` |
| `Greater` | `<bool1> <bool2> (greater())h` | `bool1 > bool2` |
| `greaterEqual` | `<bool1> <bool2> (greaterEqual())h` | `bool1 >= bool2` |
| `Lesser` | `<bool1> <bool2> (lesser())h` | `bool1 < bool2` |
| `lesserEqual` | `<bool1> <bool2> (lesserEqual())h` | `bool1 <= bool2` |

### String Operations

| Function | Usage | Result |
|----------|-------|--------|
| `stringSize` | `<string> (stringSize())h` | `string.length()` |
| `stringIndex` | `<string> <indexVal> (stringIndex())h` | `string[indexVal]` (as string) |
| `subStr` | `<string> <startValue> <endValue> (subStr())h` | `string.substr(start, end)` |

---

## Example Programs

### 1. Hello World
```
#Hello World#mh
```

### 2. Cat — echoes user input
```
mmhnh
```

### 3. Multiply 2 Input Numbers — takes 2 numbers, multiplies them
```
mmh$3$hmmmmm mmmh rmh
```

### 4. Repeat Input N Times — takes a string and `n`, prints string `n` times
```
mmhs!rmmmmm mmmmm mmmmm mmmmm mmmmhrmh!rmmmmm mmmmm mmmmm mmmmm mmmmmhrmmhrmmmmh
```

### 5. reverseString() — takes a string, returns its reverse
```
mmhs                                                                                           v userString
##s                                                                                            v emptyString
!rmmmmm mmmmm mmmmm mmmmm mmmmh nnnh $0$ nnnnh!                                                v conditional
!rmmmmm mmmmm mmmmm mmmmm mmmmh nnnh$1$ rmmmmm mmmmh!                                          v lastIndex
!rmmmmm mmmmm mmmmm mmmmm mmmmh mmmh rmmmh rmmmmm mmmmm mmmmm mmmmm mmh!                       v lastChar
!rmmmmm mmmmm mmmmm mmmmm mmmmmhh mmmh rmmmh rmmmmmmmmh nh!                                    v move last char to n
!rmmmmm mmmmm mmmmm mmmmm mmmmhh$0$ mmmh rmmmh     rmmmmm mmmmm mmmmm mmmmm mmmh rmmmmmmmh!    v removechar from s
!rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmh rmmmh rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmmh rmmmh!       v moves last char, then deletes it from s
rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmm mh                                                        v find function to do
rmmmmm mmmmm mmmmm mmmmm mmmmm mh                                                              v find conditional
rmmmmmh                                                                                        v while loop
rmmmmm mmmmm mmmmm mmmmm mmmmmh rmh                                                            v prints result
```

### 6. isPalindrome() — checks if a string is a palindrome
```
@true@s                                                                                                         v new result bool
rmmhs                                                                                                           v user string
!#whileCondition# rmh rmmmmm mmmmm mmmmm mmmmm mmmmmh nnnnh rmmmh $1$ rmmmmm mmmmm mmmmm mmh!                  v whileConditional() - (inputLength() > 1)
!#firstChar# rmh rmmmmm mmmmm mmmmm mmmmm mmmmmh $0$ $1$ rmmmmm mmmmm mmmmm mmmmm mmmh!                        v firstChar()
!#lastChar# rmh rmmmmm mmmmm mmmmm mmmmm mmmmmh rmmmmm mmmmm mmmmm mmmmm mmmmmh nnnnh rmmmh
$1$ rmmmmmmmmmh rmmmmm mmmmm mmmmm mmmmm mmmmmh nnnnh rmmmh rmmmmm mmmmm mmmmm mmmmm mmmh!                      v lastChar()
!#ifCond# rmh rmmmmm mmmmm mmmmm mmmmm mmmmm mmh rmmmh rmmmmm mmmmm mmmmm mmmmm mmmmm mmmh
rmmmh rmmmmm mmmmm mmmmm mh nnnh!                                                                               v ifConditional - (not (firstIndex == lastIndex))
!#falsebool# rmh rmmmmm mmmmm mmmmm mmmmm mmmmh @false@ rmmmmmmmh!                                              v falsebool
!#ifStatement# rmh rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmmh nh rmmmmmmh
rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmm mmh rmmmh!                                                                 v ifStatement
!#deleteEnds# rmh rmmmmm mmmmm mmmmm mmmmm mmmmmhh $1$ rmmmmm mmmmm mmmmm mmmmm mmmmmh
nnnnh $1$ rmmmmmmmmmh rmmmmm mmmmm mmmmm mmmmm mmmh rmmmmmmmh!                                                  v delete ends
!#whileStatement# rmh rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmm mh nnnnnh rmmmmmh!                                   v whileStatement
rmmmmm mmmmm mmmmm mmmmm mmmmm mmmmm mmmh rmmmh                                                                 v callWhile
rmmmmm mmmmm mmmmm mmmmm mmmmh rmh                                                                              v print bool
```

### 7. isEven() — checks if a number is even
```
rmmhs                                                       v userNum
@false@s                                                    v bool false
!rmmmmm mmmmm mmmmm mmmmm mmmmmh @true@ rmmmmmmmh!          v setTrue
!rmmmmm mmmmm mmmmm mmmmm mmmmh $2$ rmmmmm mmmmm mmh $0$ mmmmh!  v ifCondition - (userNum % 2 == 0)
!rmmmmm mmmmm mmmmm mmmmm mmmmm mh mh rmmmmmmh!             v ifEven()
rmmmmm mmmmm mmmmm mmmmm mmmmm mmmh rmmmh                   v call isEven
rmmmmm mmmmm mmmmm mmmmm mmmmmh rmh                         v print bool
```
