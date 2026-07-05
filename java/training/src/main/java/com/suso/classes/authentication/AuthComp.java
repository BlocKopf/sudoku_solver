package main.java.com.suso.classes.authentication;

import com.suso.enums.UserComp;

public class AuthComp {
//FIELDS
    private String _content;
    private UserComp _comp;
//SHADOWS
    protected void _init(){
        this.set(new String());
        this._comp = UserComp.get(null);
    }
//CONSTRUCTORS
    public User(){this._init();}
//SETTER
    public void set(String input){this._content = input;}
//GETTER
    public String get(){return this._content;}
}
