package com.example.testnavigation.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.testnavigation.brean.greend.BottomNameId;
import com.example.testnavigation.brean.greend.LandDao;
import com.example.testnavigation.brean.greend.MyChannelDao;
import com.example.testnavigation.brean.greend.TopNameId;
import com.example.testnavigation.brean.greend.Attention;

import com.example.testnavigation.dao.BottomNameIdDao;
import com.example.testnavigation.dao.LandDaoDao;
import com.example.testnavigation.dao.MyChannelDaoDao;
import com.example.testnavigation.dao.TopNameIdDao;
import com.example.testnavigation.dao.AttentionDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bottomNameIdDaoConfig;
    private final DaoConfig landDaoDaoConfig;
    private final DaoConfig myChannelDaoDaoConfig;
    private final DaoConfig topNameIdDaoConfig;
    private final DaoConfig attentionDaoConfig;

    private final BottomNameIdDao bottomNameIdDao;
    private final LandDaoDao landDaoDao;
    private final MyChannelDaoDao myChannelDaoDao;
    private final TopNameIdDao topNameIdDao;
    private final AttentionDao attentionDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bottomNameIdDaoConfig = daoConfigMap.get(BottomNameIdDao.class).clone();
        bottomNameIdDaoConfig.initIdentityScope(type);

        landDaoDaoConfig = daoConfigMap.get(LandDaoDao.class).clone();
        landDaoDaoConfig.initIdentityScope(type);

        myChannelDaoDaoConfig = daoConfigMap.get(MyChannelDaoDao.class).clone();
        myChannelDaoDaoConfig.initIdentityScope(type);

        topNameIdDaoConfig = daoConfigMap.get(TopNameIdDao.class).clone();
        topNameIdDaoConfig.initIdentityScope(type);

        attentionDaoConfig = daoConfigMap.get(AttentionDao.class).clone();
        attentionDaoConfig.initIdentityScope(type);

        bottomNameIdDao = new BottomNameIdDao(bottomNameIdDaoConfig, this);
        landDaoDao = new LandDaoDao(landDaoDaoConfig, this);
        myChannelDaoDao = new MyChannelDaoDao(myChannelDaoDaoConfig, this);
        topNameIdDao = new TopNameIdDao(topNameIdDaoConfig, this);
        attentionDao = new AttentionDao(attentionDaoConfig, this);

        registerDao(BottomNameId.class, bottomNameIdDao);
        registerDao(LandDao.class, landDaoDao);
        registerDao(MyChannelDao.class, myChannelDaoDao);
        registerDao(TopNameId.class, topNameIdDao);
        registerDao(Attention.class, attentionDao);
    }
    
    public void clear() {
        bottomNameIdDaoConfig.clearIdentityScope();
        landDaoDaoConfig.clearIdentityScope();
        myChannelDaoDaoConfig.clearIdentityScope();
        topNameIdDaoConfig.clearIdentityScope();
        attentionDaoConfig.clearIdentityScope();
    }

    public BottomNameIdDao getBottomNameIdDao() {
        return bottomNameIdDao;
    }

    public LandDaoDao getLandDaoDao() {
        return landDaoDao;
    }

    public MyChannelDaoDao getMyChannelDaoDao() {
        return myChannelDaoDao;
    }

    public TopNameIdDao getTopNameIdDao() {
        return topNameIdDao;
    }

    public AttentionDao getAttentionDao() {
        return attentionDao;
    }

}
