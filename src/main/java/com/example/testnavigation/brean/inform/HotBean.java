package com.example.testnavigation.brean.inform;

import java.util.List;

public class HotBean {

    /**
     * code : 0
     * data : {"searchList":[{"content":"无人机","searchId":"69c463f7e6904da389fb8adc13916b71"},{"content":"机场","searchId":"104a985934444db9be4cddae4d7b6eb9"},{"content":"飞机","searchId":"1164648ca42f4fb3a0058706aed192db"},{"content":"中国造","searchId":"eb5606b7d4e94af6b2b168f2369c0e65"},{"content":"无","searchId":"2d6c9669f444499cac678cca3702d2a3"}]}
     * message : 成功
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private List<SearchListBean> searchList;

        public List<SearchListBean> getSearchList() {
            return searchList;
        }

        public void setSearchList(List<SearchListBean> searchList) {
            this.searchList = searchList;
        }

        public static class SearchListBean {
            /**
             * content : 无人机
             * searchId : 69c463f7e6904da389fb8adc13916b71
             */

            private String content;
            private String searchId;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getSearchId() {
                return searchId;
            }

            public void setSearchId(String searchId) {
                this.searchId = searchId;
            }
        }
    }
}
