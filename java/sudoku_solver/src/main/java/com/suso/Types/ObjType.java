package com.suso.Types;

public class ObjType{
    public static class HEnum{
        public static <EnumType> EnumType get(int index, EnumType[] OPTIONS){
            if(index>=0 && index<OPTIONS.length){return OPTIONS[index];}
            else{return OPTIONS[0];}
        }
    }
    public enum LockType{
        UNDEFINED,SOFT,HARD;
        private static final LockType[] OPTIONS = values();
        public static LockType get(int index){return HEnum.get(index,OPTIONS);}
    }
    public enum CountType{
        UNDEFINED,SINGLE,SET;
        private static final CountType[] OPTIONS = values();
        public static CountType get(int index){return HEnum.get(index,OPTIONS);}
        public static String getString(int value){return get(value).toString();}
    }
    public enum SpecType{
        UNDEFINED,BOARD,BOX,ROW,COLUMN,FIELD,MARK;
        private static final SpecType[] OPTIONS = values();
        public static SpecType get(int index){return HEnum.get(index,OPTIONS);}
        public static String getString(int value){return get(value).toString();}
    }
}
