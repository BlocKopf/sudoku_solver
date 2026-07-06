package com.subu.comp.gen;
import java.lang.reflect.Array;
public class List<DT> {
//FIELDS
    private DT[] _content;
//SHADOWS
    private void _initCont(){this._lengthInit(0);}
    private void _lengthInit(int size){
        Class<?>Type = this._content.getClass().getComponentType();
        this._classSet(Type, size);
    }
    @SuppressWarnings("unchecked")
    private void _classSet(Class<?> type, int size){
        this._content = (DT[]) Array.newInstance(type,size);
    }
    private boolean _chPos(int value){return (value>=0 && value<this._content.length);}
    @SuppressWarnings("unchecked")
    private DT[] _holder(int ext){
        return (
            (DT[]) Array.newInstance(
                this._content.getClass().getComponentType(), 
                this._content.length+ext
        ));
    }
//CONSTRUCTOR
    public List(){this._initCont();}
//SETTER
    public void set(DT[] input){this._content = input;}
    public void editPos(int pos, DT value){
        if(this._chPos(pos)){this._content[pos]=value;}
        else{throw new IndexOutOfBoundsException();}
    }
//GETTER
    public DT[] get(){return this._content;}
    public DT getPos(int pos){
        if(this._chPos(pos)){return this._content[pos];}
        else{throw new IndexOutOfBoundsException();}
    }
//ACTIONS
    public void add(DT value){
        @SuppressWarnings("unchecked")
        DT[] holder = this._holder(1);
        for(int index=0;index<this._content.length;index++){
            holder[index]=this._content[index];
        }
        this.set(holder);
        this.editPos(this._content.length-1, value);
    }
    public void insert(int pos, DT value){
        if(this._chPos(pos)){
            DT[] holder = this._holder(1);
            for(int index=0;index<this._content.length;index++){
                if(index<=pos){holder[index+1]=this._content[index];}
                else{holder[index]=this._content[index];}
            }
        }
        else{throw new IndexOutOfBoundsException();}
    }
}