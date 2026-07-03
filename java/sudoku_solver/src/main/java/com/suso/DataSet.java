package com.suso;

public class DataSet<Typ1,Typ2>{
    private int _index;
    private Typ1 _declaration;
    private Typ2 _value;

    public DataSet(){}

    public void set(int index,Typ1 declaration,Typ2 value){
        this.rSetIndex(index).rSetDeclaration(declaration).setValue(value);
    }

    public DataSet<Typ1,Typ2> rSetIndex(int index){this.setIndex(index);return this;}
    public DataSet<Typ1,Typ2> rSetDeclaration(Typ1 declaration){
        this.setDeclaration(declaration);
        return this;
    }
    public DataSet<Typ1,Typ2> rSetValue(Typ2 value){this.setValue(value);return this;}

    public void setIndex(int index){this._index=index;}
    public void setDeclaration(Typ1 declaration){this._declaration=declaration;}
    public void setValue(Typ2 value){this._value=value;}

    public int getIndex(){return this._index;}
    public Typ1 getDeclaration(){return this._declaration;}
    public Typ2 getValue(){return this._value;}
}