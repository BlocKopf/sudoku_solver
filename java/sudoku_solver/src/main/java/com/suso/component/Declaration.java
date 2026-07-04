package com.suso.component;

import com.suso.Types.ObjType.CountType;
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
    public Declaration(){this._init();}
//IGNITOR
    private Declaration _initLocks(){this._locks = new LockMatrix();return this;}
    private Declaration _initIndex(){this._Index = new Index();return this;}
    private Declaration _initCntT(){this._cnt = CountType.get(0);return this;}
    private Declaration _initSpecT(){this._spc = SpecType.get(0);return this;}
    private void _initSize(){this._size = 0;}
    private void _init(){this._initLocks()._initIndex()._initCntT()._initSpecT()._initSize();}
//SETTER
    public void setSoftLock(boolean lock){this._locks.set_soft(lock);}
    public void setHardLock(boolean lock){this._locks.set_hard(lock);}
    public void setIndex(int value){this._Index.set(value);}
}
