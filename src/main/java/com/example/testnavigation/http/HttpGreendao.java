package com.example.testnavigation.http;

import com.example.testnavigation.brean.greend.Attention;
import com.example.testnavigation.brean.greend.BottomNameId;
import com.example.testnavigation.brean.greend.LandDao;
import com.example.testnavigation.brean.greend.MyChannelDao;
import com.example.testnavigation.brean.greend.TopNameId;
import com.example.testnavigation.dao.AttentionDao;
import com.example.testnavigation.dao.BottomNameIdDao;
import com.example.testnavigation.dao.DaoMaster;
import com.example.testnavigation.dao.DaoSession;
import com.example.testnavigation.dao.LandDaoDao;
import com.example.testnavigation.dao.MyChannelDaoDao;
import com.example.testnavigation.dao.TopNameIdDao;
import com.example.testnavigation.global.App;

import java.util.List;

public class HttpGreendao {
    private static HttpGreendao httpGreendao;

    private final TopNameIdDao mTopNameIdDao;
    private final BottomNameIdDao mBottomNameIdDao;
    private final LandDaoDao mLandDaoDao;
    private final MyChannelDaoDao mMyChannelDaoDao;
    private final AttentionDao mAttentionDao;


    public HttpGreendao() {
        //初始化数据库
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(App.sApp, "mytonghang.db");
        //获取可读写数据库
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        //数据库表管理
        DaoSession daoSession = daoMaster.newSession();
        //获取当前实体类的操作对象
        mLandDaoDao = daoSession.getLandDaoDao();
        mTopNameIdDao = daoSession.getTopNameIdDao();
        mBottomNameIdDao = daoSession.getBottomNameIdDao();
        mMyChannelDaoDao = daoSession.getMyChannelDaoDao();
        mAttentionDao = daoSession.getAttentionDao();
    }

    public static HttpGreendao getInstance(){
        if (httpGreendao==null){
            synchronized (HttpGreendao.class){
                if (httpGreendao==null){
                    httpGreendao=new HttpGreendao();
                }
            }
        }
        return httpGreendao;
    }
    //开启app检测手机号是否登陆过
    //插入
    public void insert(LandDao landDao) {
        mLandDaoDao.insertInTx(landDao);
    }

    //删除
    public void delete(LandDao landDao) {
        mLandDaoDao.delete(landDao);
    }

    //修改
    public void updata(LandDao landDao) {
        mLandDaoDao.update(landDao);
    }

    //查询
    public List<LandDao> select() {
        return mLandDaoDao.queryBuilder().list();
    }
    //清空数据库
    public void empty(){
        mLandDaoDao.deleteAll();
    }


    //mMyChannelDaoDao

    //插入
    public void insertChanne(MyChannelDao list) {
        mMyChannelDaoDao.insertInTx(list);
    }

    //删除
    public void deleteChanne(MyChannelDao list) {
        mMyChannelDaoDao.delete(list);
    }
    //修改
    public void updataChanne(MyChannelDao list) {
        mMyChannelDaoDao.update(list);
    }
    //查询
    public List<MyChannelDao> selectChanne() {
        return mMyChannelDaoDao.queryBuilder().list();
    }

    //条件查询
    public List<MyChannelDao> selectChanne(boolean bo) {
        return mMyChannelDaoDao.queryBuilder().where(MyChannelDaoDao.Properties.Bo.eq(bo)).list();
    }

    //TopNameId  数据库
    //插入
    public void insert(TopNameId topNameId) {
        mTopNameIdDao.insertInTx(topNameId);
    }

    //删除
    public void delete(TopNameId topNameId) {
        mTopNameIdDao.delete(topNameId);
    }

    //修改
    public void update(TopNameId topNameId) {
        mTopNameIdDao.update(topNameId);
    }

    //查询
    public List<TopNameId> selectTop() {
        return mTopNameIdDao.queryBuilder().list();
    }

    //条件查询
    public List<TopNameId> selectTop(String title) {
        return mTopNameIdDao.queryBuilder().where(TopNameIdDao.Properties.ChannelName.eq(title)).list();
    }

    public List<TopNameId> selectTop(int id) {
        return mTopNameIdDao.queryBuilder().where(TopNameIdDao.Properties.ChannelId.eq(id)).list();
    }



    //BottomNameId  数据库
    //插入
    public void insert(BottomNameId bottomNameId) {
        mBottomNameIdDao.insertInTx(bottomNameId);
    }

    //删除
    public void delete(BottomNameId bottomNameId) {
        mBottomNameIdDao.delete(bottomNameId);
    }

    //修改
    public void update(BottomNameId bottomNameId) {
        mBottomNameIdDao.update(bottomNameId);
    }

    //查询
    public List<BottomNameId> selectBottom() {
        return mBottomNameIdDao.queryBuilder().list();
    }

    //条件查询
    public List<BottomNameId> selectBottom(String title) {
        return mBottomNameIdDao.queryBuilder().where(TopNameIdDao.Properties.ChannelName.eq(title)).list();
    }

    public List<BottomNameId> selectBottom(int id) {
        return mBottomNameIdDao.queryBuilder().where(TopNameIdDao.Properties.ChannelId.eq(id)).list();
    }

    //关注按钮状态
    //插入
    public void insertAtten(Attention attention) {
        mAttentionDao.insertInTx(attention);
    }

    //删除
    public void deleteAtten(Attention list) {
        mAttentionDao.delete(list);
    }
    //修改
    public void updataAtten(Attention list) {
        mAttentionDao.update(list);
    }
    //查询
    public List<Attention> selectAtten() {
        return mAttentionDao.queryBuilder().list();
    }

    //条件查询
    public List<Attention> selectAtten(boolean bo) {
        return mAttentionDao.queryBuilder().where(AttentionDao.Properties.Boo.eq(bo)).list();
    }
}
