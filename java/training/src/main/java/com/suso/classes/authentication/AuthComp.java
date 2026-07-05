package main.java.com.suso.classes.authentication;
public class AuthComp {
//FIELDS
    private String _content;
//SHADOWS
    protected void _init(){this.set(new String());}
//CONSTRUCTORS
    public User(){this._init();}
//SETTER
    public void set(String input){this._content = input;}
//GETTER
    public String get(){return this._content;}
}
