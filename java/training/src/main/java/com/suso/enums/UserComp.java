package com.suso.enums;
import com.suso.interfaces.handling.IEnumH;
public enum UserComp {
    UNDEFINED,NAME,MAIL,KEY,CERT,ADDRESS;
    public static UserComp get(int index){return IEnumH.get(index, UserComp.values(), UNDEFINED);};
}
