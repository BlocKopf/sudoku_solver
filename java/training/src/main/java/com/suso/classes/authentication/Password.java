package main.java.com.suso.classes.authentication;
public class Password {
//FIELDS
    private String _value;
//SHADOWS
    protected void _init(){this.set(new String());}
//CONSTRUCTORS
    public Password(){this._init();}
//SETTER
    public void set(String input){this._value = input;}
//GETTER
    public String get(){return this._value;}
}
