package com.suso;

import com.suso.DataSet;

public class DataList<Typ1,Typ2>{
//------------------------------------------------------------------------------------------------------------
//  FIELDS
//------------------------------------------------------------------------------------------------------------
    /**
     *  CATAGORY    :   FIELD
     *  NAME        :   SIZE_LOCK
     *  DATATYPE    :   BOOLEAN
     *  FUNCTION    :   IF ENABLED THIS FIELD LOCKS THE SIZE OF THE ARRAY OF THE FIELD "LIST"
    */
    private boolean _sizeLock;
    /**
     *  CATEGORY    :   FIELD
     *  NAME        :   LIST
     *  DATATYPE    :   GENERIC DATA_SET ARRAY
     *  FUNCTION    :   CONTAINS THE CONTENTS OF THE OBJECT IN FORM OF AN GENERIC DATA_SET ARRAY.
     *                  THE GENERIC DATATYPES OF THE DATA_SET ARRAY ARE DETERMINED BY THE GENERIC
     *                  DATATYPES GIVEN INTO THE OBJECT. 
    */
    private DataSet<Typ1,Typ2>[] _list;
//------------------------------------------------------------------------------------------------------------
//  CONSTRUCTOR
//------------------------------------------------------------------------------------------------------------
    /**
     *  CATEGORY   :   CONSTRUCTOR
     *  INPUT      :   LENGTH(INTEGER)
    */
    public DataList(int length){this._init(length);}
//------------------------------------------------------------------------------------------------------------
//  REPETETIVE PROCESSING
//------------------------------------------------------------------------------------------------------------
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   SIZE(INTEGER)
    */
    private void _init(int size){
        this._list = new DataSet[size];
        for(int index=0;index<this._list.length;index++){
            this._list[index] = new DataSet<Typ1,Typ2>(index+1, null, null);
        }
    }
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   GENERIC DATA_SET
     *  INPUT       :   EXT(INTEGER)
    */
    private DataSet<Typ1,Typ2>[] _extCopyList(int ext){return new DataSet[this._list.length+ext];}
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   MODEL_LIST(GENERIC DATA_SET)
    */
    private void _overwrite(DataSet<Typ1,Typ2>[] modelList){this._list=modelList;}
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   ARRAY(INTEGER)
     *  INPUT       :   SHIFT_COUNT(INTEGER)
    */
    private int[] _posList(int shiftCount){return new int[shiftCount];}
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   SIZE(INTEGER)
    */
    private int[] _plcSwitch(int[] posList){
        int[] placeholder = this._posList(posList.length+1);
        for(int index=0;index<posList.length;index++){placeholder[index]=posList[index];}
        return placeholder;
    }
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   NONE
    */
    private void reIndex(){
        for(int index=0;index<this._list.length;index++){this._list[index].setIndex(index+1);}
    }
//------------------------------------------------------------------------------------------------------------
//  SHADOW ACTIONS
//------------------------------------------------------------------------------------------------------------
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   DEC(GENERIC_1),VAL(GENERIC_2)
    */
    private void sAdd(Typ1 dec,Typ2 val){
        if(!this._sizeLock){
            DataSet<Typ1,Typ2>[]placeholder = this._extCopyList(1);
            for(int index=0;index<this._list.length;index++){placeholder[index]=this._list[index];}
            placeholder[placeholder.length-1] = new DataSet<Typ1,Typ2>(
                placeholder.length,
                dec,
                val
            );
            this._overwrite(placeholder);
        }
    }
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   POS(INTEGER)
    */
    private void sRemByPos(int pos){
        if(pos>=0 && pos<this._list.length){
            int ext;
            if(this._sizeLock){ext=0;}else{ext=1;}
            DataSet<Typ1,Typ2>[]placeholder = this._extCopyList(-ext);
            boolean shift=false;
            for(int index=0;index<this._list.length;index++){
                if(this._list[index].getIndex()==pos+1){shift=!shift;}
                else{
                    if(shift){placeholder[index-1]=this._list[index];}
                    else{placeholder[index]=this._list[index];}
                }
            }
            this._overwrite(placeholder);
        }
    }
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   DEC(GENERIC_1)
    */
    private void sRemByDec(Typ1 dec){
        int detectCount=0;
        int[] posList=this._posList(detectCount);
        for(int index=0;index<this._list.length;index++){
            if(this._list[index].getDeclaration().equals(dec)){
                detectCount++;
                posList=this._plcSwitch(posList);
                posList[detectCount-1]=this._list[index].getIndex();
            }
        }
        for(int index=0;index<posList.length;index++){this.sRemByPos(posList[index]);}
    }
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   VAL(GENERIC_2)
    */
    private void sRemByVal(Typ2 val){
        int detectCount=0;
        int[] posList=this._posList(detectCount);
        for(int index=0;index<this._list.length;index++){
            if(this._list[index].getValue().equals(val)){
                detectCount++;
                posList=this._plcSwitch(posList);
                posList[detectCount-1]=this._list[index].getIndex();
            }
        }
        for(int index=0;index<posList.length;index++){this.sRemByPos(posList[index]);}
    }
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   POS(INTEGER)
    */
    private void sPrint(int pos){this._list[pos].print();}
//------------------------------------------------------------------------------------------------------------
//  OPEN ACTIONS
//------------------------------------------------------------------------------------------------------------
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   DATA_LIST
     *  INPUT       :   POS(INTEGER)
    */
    public DataList remByPos(int pos){this.sRemByPos(pos);this.reIndex();return this;}
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   DATA_LIST
     *  INPUT       :   POS(ARRAY(INTEGER))
    */
    public DataList remByPos(int[] pos){
        for(int index=0;index<pos.length;index++){this.sRemByPos(pos[index]);}
        this.reIndex();
        return this;
    }
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   DATA_LIST
     *  INPUT       :   DEC(GENERIC_1)
    */
    public DataList remByDec(Typ1 dec){this.sRemByDec(dec);this.reIndex();return this;}
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   DATA_LIST
     *  INPUT       :   DEC(ARRAY(GENERIC_1))
    */
    public DataList remByDec(Typ1[] dec){
        for(int index=0;index<dec.length;index++){this.sRemByDec(dec[index]);}
        this.reIndex();
        return this;
    }
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   DATA_LIST
     *  INPUT       :   VAL(GENERIC_2)
    */
    public DataList remByVal(Typ2 val){this.sRemByVal(val);this.reIndex();return this;}
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   DATA_LIST
     *  INPUT       :   VAL(ARRAY(GENERIC_2))
    */
    public DataList remByVal(Typ2[] val){
        for(int index=0;index<val.length;index++){this.sRemByVal(val[index]);}
        this.reIndex();
        return this;
    }
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   DATA_LIST
     *  INPUT       :   POS(ARRAY(INTEGER)),DEC(ARRAY(GENERIC_1)),VAL(ARRAY(GENERIC_2))
    */
    public DataList clean(int[] pos, Typ1[] dec, Typ2[] val){return this.remByPos(pos).remByDec(dec).remByVal(val);}
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   DATA_LIST
     *  INPUT       :   NONE
    */
    public DataList clear(){this._init(0);return this;}
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   DATA_LIST
     *  INPUT       :   DEC(GENERIC_1),VAL(GENERIC_2)
    */
    public DataList add(Typ1 dec,Typ2 val){
        this.sAdd(dec,val);
        this.reIndex();
        return this;
    }
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   POS(INTEGER),DEC(GENERIC_1),VAL(GENERIC_2)
    */
    public void editPos(int pos,Typ1 dec,Typ2 val){
        if(pos>0 && pos<=this._list.length){
            for(int index=0;index<this._list.length;index++){
                if(this._list[index].getIndex()==pos){
                    this._list[index].rSetDeclaration(dec).setValue(val);
                    break;
                }
            }
        }
    }
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   NONE
    */
    public void print(){for(int index=0;index<this._list.length;index++){this.sPrint(index);}}
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   NONE
    */
    public void lockSize(){this._sizeLock=true;}
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   NONE
    */
    public void unlockSize(){this._sizeLock=false;}
    /**
     *  CATEGORY    :   METHOD
     *  RETURN VALUE:   VOID
     *  INPUT       :   NONE
    */
    public void changeLock(){this._sizeLock=!this._sizeLock;}
//------------------------------------------------------------------------------------------------------------
}