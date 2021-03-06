package domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class PhoneNumListBean implements Serializable {
    private String message;
    private String code;
    private Data data;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }


    public class Data {

        private List<PhoneNumList> phoneNumList;

        public void setPhoneNumList(List<PhoneNumList> phoneNumList) {
            this.phoneNumList = phoneNumList;
        }

        public List<PhoneNumList> getPhoneNumList() {
            return phoneNumList;
        }

    }


    public class PhoneNumList {

        @Override
        public String toString() {
            return "PhoneNumList{" +
                    "servNum='" + servNum + '\'' +
                    ", prepay='" + prepay + '\'' +
                    ", orgId='" + orgId + '\'' +
                    ", origion='" + region + '\'' +
                    ", seqnum='" + seqnum + '\'' +
                    ", minPrePay='" + minPrePay + '\'' +
                    ", minCost='" + minCost + '\'' +
                    '}';
        }

        private String servNum;
        private String prepay;
        private String orgId;
        private String region;
        private String seqnum;
        private String minPrePay;
        private String minCost;

        public void setServNum(String servNum) {
            this.servNum = servNum;
        }

        public String getServNum() {
            return servNum;
        }

        public void setPrepay(String prepay) {
            this.prepay = prepay;
        }

        public String getPrepay() {
            return prepay;
        }

        public void setOrgId(String orgId) {
            this.orgId = orgId;
        }

        public String getOrgId() {
            return orgId;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getRegion() {
            return region;
        }

        public void setSeqnum(String seqnum) {
            this.seqnum = seqnum;
        }

        public String getSeqnum() {
            return seqnum;
        }

        public void setMinPrePay(String minPrePay) {
            this.minPrePay = minPrePay;
        }

        public String getMinPrePay() {
            return minPrePay;
        }

        public void setMinCost(String minCost) {
            this.minCost = minCost;
        }

        public String getMinCost() {
            return minCost;
        }

    }
}

