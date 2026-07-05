package com.suso.enums;
import com.suso.interfaces.handling.IEnumH;
public enum PlayObjType {
    UNDEFINED,BOARD,BOX,ROW,COLUMN,MARK;
    public static PlayObjType get(int index){return IEnumH.get(index, PlayObjType.values(), UNDEFINED);};
}