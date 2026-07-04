package com.suso.component;

import com.suso.Types.ObjType.CountType;
import com.suso.Types.ObjType.LockType;
import com.suso.Types.ObjType.SpecType;
import com.suso.lock.LockMatrix;;

public class Declaration {
//FIELDS
    private LockMatrix _locks;
    private int _size;
    private Index _Index;
    private CountType _cnt;
    private SpecType _spc;
//CONSTRUCTOR
    public Declaration(){this(0,false,false,0,0,0);}
    public Declaration(
        int size,boolean softLock,boolean hardLock,
        int index, int countType,int specType){
            this._init();
            this.setSize(size);
            this.setIndex(index);
            this.setCntType(countType);
            this.setSpecType(specType);
            this.setLock(1, softLock);
            this.setLock(2, hardLock);
        }
//IGNITOR
    private Declaration _initLocks(){this._locks = new LockMatrix();return this;}
    private Declaration _initIndex(){this._Index = new Index();return this;}
    private Declaration _initCntT(){this.setCntType(0);return this;}
    private Declaration _initSpecT(){this.setSpecType(0);;return this;}
    private void _initSize(){this._size = 0;}
    private void _init(){this._initLocks()._initIndex()._initCntT()._initSpecT()._initSize();}
//SHADOWS
//SETTER
    public void setLock(int type,boolean lock){
        LockType typeLock = LockType.get(type);
        switch (typeLock) {
            case SOFT:this._locks.set_soft(lock);break;
            case HARD:this._locks.set_hard(lock);break;
            default:break;
        }
    }
    public void setIndex(int value){if(!this._locks.get_soft()){this._Index.set(value);}}
    public void setCntType(int ref){if(!this._locks.get_soft()){this._cnt = CountType.get(ref);}}
    public void setSpecType(int ref){if(!this._locks.get_soft()){this._spc = SpecType.get(ref);}}
    public void setSize(int value){if(!this._locks.get_soft()){this._size = value;}}
//GETTER
    public int getIndex(){return this._Index.get();}
    public CountType getCntType(){return this._cnt;}
    public SpecType getSpecType(){return this._spc;}
}
