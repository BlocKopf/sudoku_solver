package com.suso.enums;
import com.suso.interfaces.handling.IEnumH;
public enum CountType {
    UNDEFINED,SINGLE,SET,LIST;
    public static CountType get(int index){return IEnumH.get(index, CountType.values(), UNDEFINED);};
}