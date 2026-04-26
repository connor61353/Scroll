package Pkg;
import java.util.Stack;
import java.util.Set;
import java.io.File;
import java.util.Scanner;

public class App {
    //key structures
    public static Scroll scroll = new Scroll();
    public static Stack<Node> stack = new Stack<Node>();
    public static Stack<Node> argStack = new Stack<Node>();
    public static String text = "";
    public static Set<String> defaultFunctions = 
    Set.of("printScroll", "print", "input",
    "call", "four", "whale", "iff", "assign", "add", "subtract", "multiply", "divide", "modulo",
    "not", "or", "and", "equals", "greater", "greaterEqual", "lesser", "lesserEqual", "stringSize", "stringIndex", "subStr");
    public static Boolean waitForText = false;
    public static Boolean waitForNum = false;
    public static Boolean waitForBool = false;
    public static Boolean waitForFunc = false;
    public static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        scroll.add("printScroll", true);    //0
        scroll.add("print", true);          //1
        scroll.add("input", true);          //2
        scroll.add("call", true);           //3
        scroll.add("four", true);           //4
        scroll.add("whale", true);          //5
        scroll.add("iff", true);            //6
        scroll.add("assign", true);         //7
        scroll.add("add", true);            //8
        scroll.add("subtract", true);       //9
        scroll.add("multiply", true);       //10
        scroll.add("divide", true);         //11
        scroll.add("modulo", true);         //12
        scroll.add("not", true);            //13
        scroll.add("or", true);             //14
        scroll.add("and", true);            //15
        scroll.add("equals", true);         //16
        scroll.add("greater", true);        //17
        scroll.add("greaterEqual", true);   //18
        scroll.add("lesser", true);         //19
        scroll.add("lesserEqual", true);    //20
        scroll.add("stringSize", true);     //21
        scroll.add("stringIndex", true);    //22
        scroll.add("subStr", true);         //23


        try {
            File myFile = new File("lib/scrollCode.txt");
            Scanner reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                //start of code interpretation
                String line = reader.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);

                    if (!waitForText && !waitForNum && !waitForBool && !waitForFunc) {
                        switch (c) {
                            case 'n':
                                scroll.prev();
                                break;
                            case 'm':
                                scroll.next();
                                break;
                            case 'h':
                                select(scroll);
                                break;
                            case 'r':
                                resetPointer();
                                break;
                            case 'v':
                                i = line.length();
                                break;
                            case '!':
                                waitForFunc = true;
                                break;
                            case '@':
                                waitForBool = true;
                                break;
                            case '#':
                                waitForText = true;
                                break;
                            case '$':
                                waitForNum = true;
                                break;
                            case 's':
                                //pushes stack item to scroll
                                if (!stack.isEmpty()) {
                                    scroll.add(stack.pop());
                                }
                                break;
                            default:
                                break;
                        }
                    } else if (waitForText) {
                        if (c == '#') {
                            waitForText = false;
                            Node textNode = new Node(text);
                            stack.push(textNode);
                            text = "";
                        } else {
                            text += c;
                        }
                    } else if (waitForNum) {
                        if (c == '$') {
                            waitForNum = false;
                            try {
                                int num = Integer.parseInt(text);
                                Node numNode = new Node(num);
                                stack.push(numNode);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number: " + text);
                            }
                            text = "";
                        } else {
                            text += c;
                        }
                    } else if (waitForBool) {
                        if (c == '@') {
                            waitForBool = false;
                            if (text.equals("true") || text.equals("false")) {
                                boolean bool = Boolean.parseBoolean(text);
                                Node boolNode = new Node(bool);
                                stack.push(boolNode);
                            } else {
                                System.out.println("Invalid boolean: " + text);
                            }
                            text = "";
                        } else {
                            text += c;
                        }
                    } else if (waitForFunc) {
                        if (c == '!') {
                            waitForFunc = false;
                            scroll.add(text, true);
                            text = "";
                        } else {
                            text += c;
                        }
                    }
                }
            }
            reader.close();
            iScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //EXECUTES FUNCTION
    public static void executeFunc(String code) {
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);

            if (!waitForText && !waitForNum && !waitForBool && !waitForFunc) {
                switch (c) {
                    case 'n':
                        scroll.prev();
                        break;
                    case 'm':
                        scroll.next();
                        break;
                    case 'h':
                        select(scroll);
                        break;
                    case 'r':
                        resetPointer();
                        break;
                    case 'v':
                        i = code.length();
                        break;
                    case '!':
                        waitForFunc = true;
                        break;
                    case '@':
                        waitForBool = true;
                        break;
                    case '#':
                        waitForText = true;
                        break;
                    case '$':
                        waitForNum = true;
                        break;
                    case 's':
                        //pushes stack item to scroll
                        if (!stack.isEmpty()) {
                            scroll.add(stack.pop().string);
                        }
                        break;
                    default:
                        break;
                }
            } else if (waitForText) {
                if (c == '#') {
                    waitForText = false;
                    Node textNode = new Node(text);
                    stack.push(textNode);
                    text = "";
                } else {
                    text += c;
                }
            } else if (waitForNum) {
                if (c == '$') {
                    waitForNum = false;
                    try {
                        int num = Integer.parseInt(text);
                        Node numNode = new Node(num);
                        stack.push(numNode);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number: " + text);
                    }
                    text = "";
                } else {
                    text += c;
                }
            } else if (waitForBool) {
                if (c == '@') {
                    waitForBool = false;
                    if (text.equals("true") || text.equals("false")) {
                        boolean bool = Boolean.parseBoolean(text);
                        Node boolNode = new Node(bool);
                        stack.push(boolNode);
                    } else {
                        System.out.println("Invalid boolean: " + text);
                    }
                    text = "";
                } else {
                    text += c;
                }
            } else if (waitForFunc) {
                if (c == '!') {
                    waitForFunc = false;
                    scroll.add(text, true);
                    text = "";
                } else {
                    text += c;
                }
            }
        }
    }

    //selects current node on scroll
    //if it's a function, executes it
    //if it's a variable, pushes it to the stack
    //if there is a variable on the stack, it is assigned to the seleceted variable
    public static void select(Scroll scroll){
        if (scroll.cur != null) {
            //default functions
            if (scroll.cur.isFunction && defaultFunctions.contains(scroll.cur.function)) {
                execute(scroll.cur.function);
            } 
            //variables
            else {
                stack.push(scroll.cur);
            }
        }
    }

    public static void execute(String s) {
        switch (s) {
            case "printScroll":
                printScroll();
                return;  
            case "print":
                print();
                return;
            case "input":
                input();
                return;
            case "call":
                call();
                return;
            case "four":
                four();
                return;
            case "whale":
                whale();
                return;
            case "iff":
                iff();
                return;
            case "assign":
                assign();
                return;
            case "add":
                add();
                return;
            case "subtract":
                subtract();
                return;
            case "multiply":
                multiply();
                return;
            case "divide":
                divide();
                return;
            case "modulo":
                modulo();
                return;
            case "not":
                not();
                return;
            case "or":
                or();
                return;
            case "and":
                and();
                return;
            case "equals":
                equals();
                return;
            case "greater":
                greater();
                return;
            case "greaterEqual":
                greaterEqual();
                return;
            case "lesser":
                lesser();
                return;
            case "lesserEqual":
                lesserEqual();
                return;
            case "stringSize":
                stringSize();
                return;
            case "stringIndex":
                stringIndex();
                return;
            case "subStr":
                subStr();
                return;
            default:
                executeFunc(s);
                return;
        }
    }
    
    public static void resetPointer() {
        while (scroll.cur.prev != null){
            scroll.prev();
        }
    }

//built-in scroll functions

    public static void printScroll() {
        Node temp = scroll.head;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public static void print() {
        if (!stack.isEmpty()) {
            System.out.println(stack.pop().toString());
        }
    }

    //takes string input
    public static void input() {
        String input = iScanner.nextLine();
        try {
            Node numNode = new Node (Integer.parseInt(input));
            stack.push(numNode);
        }
        catch(Exception e) {
            Node inputNode = new Node(input);
            stack.push(inputNode);
        }
        finally {
        }
    }

    public static void call(){
        if (!stack.empty() && stack.peek().isFunction){
            execute(stack.pop().function);
        }
    }

    public static void four() {
        if (stack.size() >= 2){
            Node num = stack.pop();
            Node func = stack.pop();
            for (int i = 0; i < num.num; i++) {
                executeFunc(func.function);
            }
        }
    }

    public static void whale(){
        if (stack.size() >= 2){
            Node cond = stack.pop();
            Node func = stack.pop();

            executeFunc(cond.function);
            Boolean condition = stack.pop().bool;
            while (condition) {
                executeFunc(func.function);
                executeFunc(cond.function);
                condition = stack.pop().bool;
            }
        }
    }

    public static void iff(){
        if (stack.size() >= 2){
            Node cond = stack.pop();
            Node func = stack.pop();

            if (cond.isBool) {
                if (cond.bool) {
                    executeFunc(func.function);
                }
            } else if (cond.isFunction){
                executeFunc(cond.function);
                if (stack.pop().bool) {
                    executeFunc(func.function);
                }
            }
        }
    }

    public static void assign() {
        if (stack.size() >= 2) {
            Node value = stack.pop();
            Node variable = stack.pop();
            if (variable.isString) {
                if (value.isString) {
                    variable.set(value.string);
                }
            } else if (variable.isNum) {
                if (value.isNum) {
                    variable.set(value.num);
                }
            } else if (variable.isBool) {
                if (value.isBool) {
                    variable.set(value.bool);
                }
            }
        }
    }

    public static void add() {
        if (stack.size() >= 2) {
            Node var2 = stack.pop();
            Node var1 = stack.pop();
            if (var1.isNum && var2.isNum) {
                Node result = new Node(var1.num + var2.num);
                stack.push(result);
            } else if (var1.isString && var2.isString) {
                Node result = new Node(var1.string + var2.string);
                stack.push(result);
            }
        }
    }

    public static void subtract() {
        if (stack.size() >= 2) {
            Node var2 = stack.pop(); 
            Node var1 = stack.pop(); 
            if (var1.isNum && var2.isNum) {
                Node result = new Node(var1.num - var2.num);
                stack.push(result);
            }
        }
    }

    public static void multiply() {
        if (stack.size() >= 2) {
            Node var2 = stack.pop();
            Node var1 = stack.pop();
            if (var1.isNum && var2.isNum) {
                Node result = new Node(var1.num * var2.num);
                stack.push(result);
            }
        }
    }

    public static void divide() {
        if (stack.size() >= 2) {
            Node var2 = stack.pop();
            Node var1 = stack.pop();
            if (var1.isNum && var2.isNum) {
                Node result = new Node(var1.num / var2.num);
                stack.push(result);
            }
        }
    }

    public static void modulo() {
        if (stack.size() >= 2) {
            Node var2 = stack.pop();
            Node var1 = stack.pop();
            if (var1.isNum && var2.isNum) {
                Node result = new Node(var1.num % var2.num);
                stack.push(result);
            }
        }
    }

    public static void not(){
        if (!stack.isEmpty()) {
            Node var = stack.pop();
            if (var.isBool) {
                Node result = new Node(!var.bool);
                stack.push(result);
            }
        }
    }

    public static void or(){
        if (stack.size() >= 2) {
            Node var2 = stack.pop();
            Node var1 = stack.pop();
            if (var1.isBool && var2.isBool) {
                Node result = new Node(var1.bool || var2.bool);
                stack.push(result);
            }
        }
    }

    public static void and(){
        if (stack.size() >= 2) {
            Node var2 = stack.pop();
            Node var1 = stack.pop();
            if (var1.isBool && var2.isBool) {
                Node result = new Node(var1.bool && var2.bool);
                stack.push(result);
            }
        }
    }

    public static void equals(){
        if (stack.size() >= 2) {
            Node var2 = stack.pop();
            Node var1 = stack.pop();
            if (var1.isNum && var2.isNum) {
                Node result = new Node(var1.num == var2.num);
                stack.push(result);
            } else if (var1.isString && var2.isString) {
                Node result = new Node(var1.string.equals(var2.string));
                stack.push(result);
            } else if (var1.isBool && var2.isBool) {
                Node result = new Node(var1.bool == var2.bool);
                stack.push(result);
            }
        }
    }

    public static void greater() {
        if (stack.size() >= 2) {
            Node var2 = stack.pop();
            Node var1 = stack.pop();
            if (var1.isNum && var2.isNum) {
                Node result = new Node(var1.num > var2.num);
                stack.push(result);
            }
        }
    }

    public static void greaterEqual() {
        if (stack.size() >= 2) {
            Node var2 = stack.pop();
            Node var1 = stack.pop();
            if (var1.isNum && var2.isNum) {
                Node result = new Node(var1.num >= var2.num);
                stack.push(result);
            }
        }
    }

    public static void lesser() {
        if (stack.size() >= 2) {
            Node var2 = stack.pop();
            Node var1 = stack.pop();
            if (var1.isNum && var2.isNum) {
                Node result = new Node(var1.num < var2.num);
                stack.push(result);
            }
        }
    }

    public static void lesserEqual() {
        if (stack.size() >= 2) {
            Node var2 = stack.pop();
            Node var1 = stack.pop();
            if (var1.isNum && var2.isNum) {
                Node result = new Node(var1.num <= var2.num);
                stack.push(result);
            }
        }
    }

    public static void stringSize(){
        if (!stack.isEmpty()) {
            Node var = stack.pop();
            if (var.isString) {
                Node result = new Node(var.string.length());
                stack.push(result);
            }
        }
    }

    public static void stringIndex(){
        if (stack.size() >= 2) {
            Node var2 = stack.pop();
            Node var1 = stack.pop();
            if (var1.isString && var2.isNum) {
                if (var2.num >= 0 && var2.num < var1.string.length()) {
                    Node result = new Node(Character.toString(var1.string.charAt(var2.num)));
                    stack.push(result);
                }
            }
        }
    }

    public static void subStr(){
        if (stack.size() >= 3) {
            Node var3 = stack.pop(); //length
            Node var2 = stack.pop(); //start
            Node var1 = stack.pop(); //string
            if (var1.isString && var2.isNum && var3.isNum) {
                if (var2.num >= 0 && var3.num >= var2.num && var3.num <= var1.string.length()) {
                    Node result = new Node(var1.string.substring(var2.num, var3.num));
                    stack.push(result);
                }
            }
        }
    }

}