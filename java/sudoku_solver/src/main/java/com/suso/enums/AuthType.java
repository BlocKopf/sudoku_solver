package com.suso.enums;
import com.suso.interfaces.handling.IEnumH;
public enum AuthType{
    UNDEFINED,LOCK,KEY,USER,ADDRESS;
    public static AuthType get(int index){return IEnumH.get(index, AuthType.values(), UNDEFINED);};
}