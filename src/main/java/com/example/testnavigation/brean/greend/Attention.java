package com.example.testnavigation.brean.greend;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class Attention {
    @Id (autoincrement = true)
    Long id;
    boolean boo;
    @Generated(hash = 1449910754)
    public Attention(Long id, boolean boo) {
        this.id = id;
        this.boo = boo;
    }
    @Generated(hash = 1876216524)
    public Attention() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean getBoo() {
        return this.boo;
    }
    public void setBoo(boolean boo) {
        this.boo = boo;
    }
}
