package com.suso.enums;
import com.suso.interfaces.handling.IEnumH;
public enum UserType {
    UNDEFINED,NAME,MAIL,KEY,CERT;
    public static UserType get(int index){return IEnumH.get(index, UserType.values(), UNDEFINED);};
}
