package com.suso.Types;

public class ObjType{
    public enum CountType{
        UNDEFINED,SINGLE,SET;
        private static final CountType[] OPTIONS = values();
        public static CountType get(int index){
            if(index>=0 && index<OPTIONS.length){return OPTIONS[index];}
            else{return OPTIONS[0];}
        }
        public static String getString(int value){return get(value).toString();}
    }
    public enum SpecType{
        UNDEFINED,BOARD,BOX,ROW,COLUMN,FIELD,MARK;
        private static final SpecType[] OPTIONS = values();
        public static SpecType get(int index){
            if(index>=0 && index<OPTIONS.length){return OPTIONS[index];}
            else{return OPTIONS[0];}
        }
        public static String getString(int value){return get(value).toString();}
    }
}
