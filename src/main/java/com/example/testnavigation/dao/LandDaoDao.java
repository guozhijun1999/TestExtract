package com.example.testnavigation.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.testnavigation.brean.greend.LandDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LAND_DAO".
*/
public class LandDaoDao extends AbstractDao<LandDao, Long> {

    public static final String TABLENAME = "LAND_DAO";

    /**
     * Properties of entity LandDao.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Phone = new Property(1, String.class, "phone", false, "PHONE");
    }


    public LandDaoDao(DaoConfig config) {
        super(config);
    }
    
    public LandDaoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LAND_DAO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PHONE\" TEXT);"); // 1: phone
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LAND_DAO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, LandDao entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(2, phone);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, LandDao entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String phone = entity.getPhone();
        if (phone != null) {
            stmt.bindString(2, phone);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public LandDao readEntity(Cursor cursor, int offset) {
        LandDao entity = new LandDao( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // phone
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, LandDao entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPhone(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(LandDao entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(LandDao entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(LandDao entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
