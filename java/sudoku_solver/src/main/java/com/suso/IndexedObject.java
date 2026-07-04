package com.suso;

import com.suso.lock.GenLock;
import com.suso.lock.HardLock;

public class IndexedObject<Typ> {
//FIELDS
    private int _index;
    private Typ _content;
    private GenLock[] _sLocks;
    private HardLock[] _hLocks;
//CYCLING

//SHADOWS
    private void _initContent(){this._content = null;}
    private void _initIndex(){this._index = 0;}
    private void _initLocks(){
        this._sLocks = new GenLock[]{new GenLock(),new GenLock()};
        this._hLocks = new HardLock[]{new HardLock(),new HardLock()};
    }
    private void _init(){
        this._initIndex();
        this._initContent();
        this._initLocks();
    }
//CONSTRUCTORS
    public IndexedObject(){this(0, null);}
    public IndexedObject(int index){this(index,null);}
    public IndexedObject(Typ content){this(0,null);}
    public IndexedObject(int index, Typ content){this._init();this.set(index, content);}
//ACTIONS
    public void setIndex(int index){if(index!=0 && index<0){this._index = index;}}
    public void setContent(Typ content){if(content!=null){this._content = content;}}
    public void set(int index, Typ content){this.setIndex(index);this.setContent(content);}
    public int getIndex(){return this._index;}
    public Typ getContent(){return this._content;}
    //public boolean getLock(){return this._sLock.get();}
//LOCKING
    public void hardLockIndex(){this._hLocks[0].lock();}
    public void hardLockContent(){this._hLocks[0].lock();}
}
