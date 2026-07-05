package com.suso.enums;
import com.suso.interfaces.handling.IEnumH;
public enum LockAuth {
    UNDEFINED,SET,GET,LOCK,UNLOCK,CHANGE;
    public static LockAuth get(int index){return IEnumH.get(index, LockAuth.values(), UNDEFINED);};
}