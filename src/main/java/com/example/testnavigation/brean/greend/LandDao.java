package com.example.testnavigation.brean.greend;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class LandDao {
    @Id(autoincrement = true)
    Long id;
    String phone;
    @Generated(hash = 783685131)
    public LandDao(Long id, String phone) {
        this.id = id;
        this.phone = phone;
    }
    @Generated(hash = 1624412052)
    public LandDao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
