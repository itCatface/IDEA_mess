package net;

/**
 * Created by Administrator on 2017/4/26.
 */

public class PaperlessListing {

    private boolean isSecret;
    private String retinfo;
    private String retcode;
    private List list;

    public boolean isSecret() {
        return isSecret;
    }

    public void setSecret(boolean secret) {
        isSecret = secret;
    }

    public String getRetinfo() {
        return retinfo;
    }

    public void setRetinfo(String retinfo) {
        this.retinfo = retinfo;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

   public  class List {
        private String infoNo;
        private String createTime;
        private String dealTypeName;
        private String custOrderId;
        private String dealType;
        private String orgId;
        private String infoSino;

        public String getInfoNo() {
            return infoNo;
        }

        public void setInfoNo(String infoNo) {
            this.infoNo = infoNo;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDealTypeName() {
            return dealTypeName;
        }

        public void setDealTypeName(String dealTypeName) {
            this.dealTypeName = dealTypeName;
        }

        public String getCustOrderId() {
            return custOrderId;
        }

        public void setCustOrderId(String custOrderId) {
            this.custOrderId = custOrderId;
        }

        public String getDealType() {
            return dealType;
        }

        public void setDealType(String dealType) {
            this.dealType = dealType;
        }

        public String getOrgId() {
            return orgId;
        }

        public void setOrgId(String orgId) {
            this.orgId = orgId;
        }

        public String getInfoSino() {
            return infoSino;
        }

        public void setInfoSino(String infoSino) {
            this.infoSino = infoSino;
        }
    }




}
