package com.suso;

import com.suso.DataSet;

public class DataList<Typ1,Typ2>{
//------------------------------------------------------------------------------------------------------------
//  FIELDS
//------------------------------------------------------------------------------------------------------------
    private boolean _sizeLock;
    private DataSet<Typ1,Typ2>[] _list;
//------------------------------------------------------------------------------------------------------------
//  CONSTRUCTOR
//------------------------------------------------------------------------------------------------------------
    public DataList(int length){
        this._init(length);
    }
//------------------------------------------------------------------------------------------------------------
//  REPETETIVE PROCESSING
//------------------------------------------------------------------------------------------------------------
    private void _init(int size){this._list = new DataSet[size];}
    private DataSet<Typ1,Typ2>[] _extCopyList(int ext){return new DataSet[this._list.length+ext];}
    private void _overwrite(DataSet<Typ1,Typ2>[] modelList){this._list=modelList;}
    private int[] _posList(int shiftCount){return new int[shiftCount];}
    private int[] _plcSwitch(int[] posList){
        int[] placeholder = this._posList(posList.length+1);
        for(int index=0;index<posList.length;index++){placeholder[index]=posList[index];}
        return placeholder;
    }
    private void reIndex(){
        for(int index=0;index<this._list.length;index++){this._list[index].setIndex(index+1);}
    }
//------------------------------------------------------------------------------------------------------------
//  SHADOW ACTIONS
//------------------------------------------------------------------------------------------------------------
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
    private void sRemByPos(int pos){
        if(pos>=0 && pos<this._list.length){
            int ext;
            if(this._sizeLock){ext=0;}else{ext=1;}
            DataSet<Typ1,Typ2>[]placeholder = this._extCopyList(-ext);
            boolean shift=false;
            for(int index=0;index<this._list.length;index++){
                if(this._list[index].getIndex()==pos){shift=!shift;}
                else{
                    if(shift){placeholder[index-1]=this._list[index];}
                    else{placeholder[index]=this._list[index];}
                }
            }
            this._overwrite(placeholder);
        }
    }
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
    private void sPrint(int pos){this._list[pos].print();}
//------------------------------------------------------------------------------------------------------------
//  OPEN ACTIONS
//------------------------------------------------------------------------------------------------------------
    public DataList remByPos(int pos){this.sRemByPos(pos);this.reIndex();return this;}
    public DataList remByPos(int[] pos){
        for(int index=0;index<pos.length;index++){this.sRemByPos(pos[index]);}
        this.reIndex();
        return this;
    }
    public DataList remByDec(Typ1 dec){this.sRemByDec(dec);this.reIndex();return this;}
    public DataList remByDec(Typ1[] dec){
        for(int index=0;index<dec.length;index++){this.sRemByDec(dec[index]);}
        this.reIndex();
        return this;
    }
    public DataList remByVal(Typ2 val){this.sRemByVal(val);this.reIndex();return this;}
    public DataList remByVal(Typ2[] val){
        for(int index=0;index<val.length;index++){this.sRemByVal(val[index]);}
        this.reIndex();
        return this;
    }
    public DataList clean(int[] pos, Typ1[] dec, Typ2[] val){
        return this.remByPos(pos).remByDec(dec).remByVal(val);
    }
    public DataList clear(){this._init(0);return this;}
    public DataList add(Typ1 dec,Typ2 val){
        this.sAdd(dec,val);
        this.reIndex();
        return this;
    }
    public void editPos(int pos,Typ1 dec,Typ2 val){
        if(pos>=0 && pos<this._list.length){
            for(int index=0;index<this._list.length;index++){
                if(this._list[index].getIndex()==pos){
                    this._list[index].rSetDeclaration(dec).setValue(val);
                    break;
                }
            }
        }
    }
    public void print(){for(int index=0;index<this._list.length;index++){this.sPrint(index);}}
    public void lockSize(){this._sizeLock=true;}
    public void unlockSize(){this._sizeLock=false;}
    public void changeLock(){this._sizeLock=!this._sizeLock;}
//------------------------------------------------------------------------------------------------------------
}