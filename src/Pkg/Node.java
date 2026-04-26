package Pkg;

public class Node {
    public String function = null;
    public String string = null;
    public int num = -1;
    public Boolean bool = false;

    public Boolean isFunction = false;
    public Boolean isString = false;
    public Boolean isNum = false;
    public Boolean isBool = false;


    public Node prev = null;
    public Node next = null;

    public Node(String s, Boolean isFunction) {
        if (isFunction) {
            this.function = s;
            this.isFunction = true;
        } else {
            this.string = s;
            this.isString = true;
        }
    }

    public Node(String s) {
        this.string = s;
        this.isString = true;
    }

    public Node(int n) {
        this.num = n;
        this.isNum = true;
    }

    public Node(Boolean b) {
        this.bool = b;
        this.isBool = true;
    }

    public void set(String s){
        if (isString) {
            this.string = s;
        }
    }

    public void set(int n){
        if (isNum) {
            this.num = n;
        }
    }

    public void set(Boolean b){
        if (isBool) {
            this.bool = b;  
        }
    }

    public String toString() {
        if (isFunction) {
            return function;
        } else if (isString) {
            return string;
        } else if (isNum) {
            return Integer.toString(num);
        } else if (isBool) {
            return Boolean.toString(bool);
        } else {
            return "";
        }
    }
}
