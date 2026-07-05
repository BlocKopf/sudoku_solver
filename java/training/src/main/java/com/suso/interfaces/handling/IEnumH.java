package com.suso.interfaces.handling;

public interface IEnumH<EType> {
    public static <EType> EType get(int index,EType[] OPTIONS,EType defaultVal){
        if(index>=0 && index<OPTIONS.length){return OPTIONS[index];}
        else{return defaultVal;}
    };
}
