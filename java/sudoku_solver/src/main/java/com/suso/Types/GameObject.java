package com.suso.Types;

public enum GameObject {
    UNDEFINED,BOARD,QUADRANT,ROW,COLUMN,FIELD,MARK_SET;
    public static GameObject get(int value){
        switch (value) {
            case 1: return BOARD;
            case 2: return QUADRANT;
            case 3: return ROW;
            case 4: return COLUMN;
            case 5: return FIELD;
            case 6: return MARK_SET;
            default:return UNDEFINED;
        }
    }
    public static String geString(int value){return this.get(value).toString();}
}