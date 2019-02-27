package com.example.testnavigation.brean.mine;

import java.util.List;

/**
 * Created by 88888 on 2019/2/3.
 */

public class FavouriteNewsBean {

    /**
     * cursor : 1546435772
     * favouritNewsList : [{"favouritId":"1ab127d178584103a5a87540306bdd90","newsId":"d52b14aa65df4833893e512f9bb8a139","title":"雄安航空要来了！南航拟出资100亿元设立子公司"},{"favouritId":"3afb5a3235664c7b9d9d7d6859694304","newsId":"80edd8bb70d94133ac8cab321c1c7a35","title":"关于航空工业对外开放有关政策解读"},{"favouritId":"60e042f172544bf891134c5f2466195c","newsId":"4593d24bdf2b4a799ad133a3744699a3","title":"观点｜中国通用航空产业政策质量绩效分析研究"},{"favouritId":"466ae45939e041b7bee3b8069286c711","newsId":"dd5cbfef9a204af38e04ef97a58e0c5a","title":"不看不知道，一看吓一跳的2018珠海航展又来了！！"},{"favouritId":"67ef39375e864186b6852925e6239344","newsId":"82a8dedf1b8042a5b8a7996903084cfe","title":"跳伞中低空跳伞死伤超记录"},{"favouritId":"10ec9b31f92e4e519e0d18264059dc4e","newsId":"cb4eea0d92fb43ebb9fe9306efae606f","title":"女子邂逅\"机长\"被骗60余万 意外怀孕要转3万作惩罚"},{"favouritId":"d54871114e164fc4a7d3c530b9333797","newsId":"42cd467f82d14d3a905686ea75e4362b","title":"镇雄通用机场空域使用方案军地协调会召开"},{"favouritId":"30e4ad02e5344d7dbec3a81268afa5e4","newsId":"03ca4730d3f349d1bee3a3b409f03bc8","title":"航空器国籍和适航证件系统5月7日起正式启用"},{"favouritId":"e66f2c385875472a93264a27a7a3c666","newsId":"9aa1e2e863974321b61535df1bfda2b9","title":"通航制造频传喜讯；中国无人机产业创新联盟即将成立"},{"favouritId":"5f1196760fb249af86da797319f9cc6e","newsId":"02c98bdb6db04b1e839c22d36ef19ca2","title":"美国加州野火失控延烧 超过100辆消防车和10多架直升机参与灭火"}]
     */

    private String cursor;
    private List<FavouritNewsListBean> favouritNewsList;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public List<FavouritNewsListBean> getFavouritNewsList() {
        return favouritNewsList;
    }

    public void setFavouritNewsList(List<FavouritNewsListBean> favouritNewsList) {
        this.favouritNewsList = favouritNewsList;
    }

    public static class FavouritNewsListBean {
        /**
         * favouritId : 1ab127d178584103a5a87540306bdd90
         * newsId : d52b14aa65df4833893e512f9bb8a139
         * title : 雄安航空要来了！南航拟出资100亿元设立子公司
         */

        private String favouritId;
        private String newsId;
        private String title;

        public String getFavouritId() {
            return favouritId;
        }

        public void setFavouritId(String favouritId) {
            this.favouritId = favouritId;
        }

        public String getNewsId() {
            return newsId;
        }

        public void setNewsId(String newsId) {
            this.newsId = newsId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
