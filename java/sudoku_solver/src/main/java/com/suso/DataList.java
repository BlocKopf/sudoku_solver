package com.suso;

import com.suso.DataSet;

public class DataList<Typ1,Typ2>{
    private String _type;
    private int _nr;
    private DataSet<Typ1,Typ2>[] _list;
    
    public DataList(){}
    
    public void replace(int pos,String[] content){this.iReplace(pos, content);this.reIndex();}
    public void add(String[] content){this.iAdd(content);this.reIndex();}
    public void removeByPos(int pos){this.iRemoveByPos(pos);this.reIndex();}
    public void removeByDec(Typ1 dec){this.iRemoveByDec(dec);this.reIndex();}
    public void remoByVal(Typ2 val){this.iRemoByVal(val);this.reIndex();}

    private DataSet<Typ1,Typ2> _init(int size){this._list = new DataSet[size];return this._list;}
    
    private void fill(String[][] content){
        for(int index=0;index<content.length;index++){this.iAdd(content[index][0],content[index][1]);}
        this.reIndex();
    }
    
    private void reIndex(){
        for(int index=0;index<this._list.length;index++){
            this._list[index].setIndex(index+1);
        }
    }

    private void iReplace(int pos,String[] content){
        this._list[pos].rSetDeclaration((Typ1)content[0]).setValue((Typ2)content[1]);
    }

    private void iAdd(String[] content){
        DataSet<Typ1,Typ2>[] placeholder = this.getPlaceholder(1);
        for(int index=0;index<this._list.length;index++){
            placeholder=this.transferPlaceholder(placeholder,index,0);
        }
        this.replaceOriginal(placeholder);
        this.replace(
            this._list[this._list.length-1], 
            content
        );
    }

    private void iRemoveByPos(int pos){
        DataSet<Typ1,Typ2>[]placeholder=this.getPlaceholder(-1);
        int shift=0;
        for(int index=0;index<this._list.length;index++){
            if(this.checkPos(index, pos)){shift++;}
            else{placeholder=this.transferPlaceholder(placeholder, index, shift);}
        }
        this.replaceOriginal(placeholder);
    }

    private void iRemoveByDec(Typ1 dec){
        int count=0;
        int[] posList = new int[count];
        for(int index=0;index<this._list.length;index++){
            if(this._list[index].getDeclaration()==dec){
                int[]placeholder = new int[posList.length+1];
                for(int index2=0;index2<posList.length;index2++){placeholder[index2]=posList[index2];}
                posList=placeholder;
                posList[posList.length-1]=this._list[index].getIndex();
            }
        }
        for(int index=0;index<posList.length;index++){this.removeByPos(posList[index]);}
    }

    private void iRemoByVal(Typ2 val){
        int count=0;
        int[] posList = new int[count];
        for(int index=0;index<this._list.length;index++){
            if(this._list[index].getValue()==val){
                int[]placeholder = new int[posList.length+1];
                for(int index2=0;index2<posList.length;index2++){placeholder[index2]=posList[index2];}
                posList=placeholder;
                posList[posList.length-1]=this._list[index].getIndex();
            }
        }
        for(int index=0;index<posList.length;index++){this.removeByPos(posList[index]);}
    }

    private DataSet<Typ1,Typ2>[] transferPlaceholder(DataSet<Typ1,Typ2>[] placeholder,int index,int shift){
        if(shift>index){shift=index;}
        else if(shift>=this._list.length){shift=0;}
        placeholder[index-shift]=this._list[index];
        return placeholder;
    }

    private void replaceOriginal(DataSet<Typ1,Typ2>[] placeholder){this._list=placeholder;}
    private boolean checkPos(int index,int pos){return this._list[index].getIndex()==pos;}
    private DataSet<Typ1,Typ2>[] getPlaceholder(int ext){return new DataSet[this._list.length+ext];}
}