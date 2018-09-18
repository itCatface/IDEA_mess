package domain;

import java.util.List;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
/*
{
    "message": "操作成功",
    "code": "0",
    "data": {
        "cityInfo": {
        "provinceName":"浙江",
            "regionName": "杭州",
            "countyName": "上城"
        },
        "userInfo": {
                "":
                "resacct": "lumin1",
                "mainLoginName": "EB2745589FC1D7D1",
                "userNum": "13605710572"
                "opCountyCode": "5711",
                "opId": "10189988",
                "opRegionCode": "0"
                "rsp": "0",
                "orgId": "0",
                "sessId": "llvfa51q883nn9zooeut32w3gtt4y2y5"
            },
         "userExt": {
            "qrAlipay": "http://m.liantu.com/",
            "qrWx": "",
            "cardNo": "34012319920830111X",
            "name": "33333",
            "orgName": "yys下级"
        }
    }
}
 */


/*
{
    "message": "操作成功",
    "code": "0",
    "data": {
        "cityInfo": {
            "provinceName":"浙江",
            "regionName": "杭州",
            "countyName": "上城"
        },
        "userInfo": {
            "resacct": "lumin1",
            "mainLoginName": "EB2745589FC1D7D1",
            "userNum": "13605710572",
            "opCountyCode": "5711",
            "opId": "10189988",
            "opRegionCode": "0",
            "rsp": "0",
            "errDesc": "",
            "authenMode": "N",
            "orgId": "0",
            "sessId": "llvfa51q883nn9zooeut32w3gtt4y2y5"
        },
         "userExt": {
            "qrAlipay": "http://m.liantu.com/",
            "qrWx": "",
            "cardNo": "34012319920830111X",
            "name": "33333",
            "username": "33333"
        },
        "busiInfo": [{
            "busiId": "",
            "packageId": "",
            "brandCode": "",
            "busiName": "",
            "busiContent": "",
            "imgUrl": ""
        }]

    }
}
 */
/*public class ReposenBean<T>{
    T data;
    String message;

    public T getData(Class clazz){
        if (data==null){
            retur;
        }

    }
}*/

public class InitData {
    private String message;

    private String code;

    private Data data;

    private boolean isLeaf;

    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }
    public void setIsLeaf(boolean isLeaf){
        this.isLeaf = isLeaf;
    }
    public boolean getIsLeaf(){
        return this.isLeaf;
    }


    public class Data {
        private String activeCount; // 已激活量

        private UserInfo userInfo;

        private String rc;

        private List<BusiInfo> busiInfo ;

        private CityInfo cityInfo;

        private String active;

        private UserExt userExt;

        private String totalCount;  // 总量

        public void setActiveCount(String activeCount){
            this.activeCount = activeCount;
        }
        public String getActiveCount(){
            return this.activeCount;
        }
        public void setUserInfo(UserInfo userInfo){
            this.userInfo = userInfo;
        }
        public UserInfo getUserInfo(){
            return this.userInfo;
        }
        public void setRc(String rc){
            this.rc = rc;
        }
        public String getRc(){
            return this.rc;
        }
        public void setBusiInfo(List<BusiInfo> busiInfo){
            this.busiInfo = busiInfo;
        }
        public List<BusiInfo> getBusiInfo(){
            return this.busiInfo;
        }
        public void setCityInfo(CityInfo cityInfo){
            this.cityInfo = cityInfo;
        }
        public CityInfo getCityInfo(){
            return this.cityInfo;
        }
        public void setActive(String active){
            this.active = active;
        }
        public String getActive(){
            return this.active;
        }
        public void setUserExt(UserExt userExt){
            this.userExt = userExt;
        }
        public UserExt getUserExt(){
            return this.userExt;
        }
        public void setTotalCount(String totalCount){
            this.totalCount = totalCount;
        }
        public String getTotalCount(){
            return this.totalCount;
        }

        public class BusiInfo {
            private int id;

            private String busiId;

            private String packageId;

            private String brandCode;

            private String busiName;

            private String busiContent;

            private String imgUrl;

            public void setId(int id){
                this.id = id;
            }
            public int getId(){
                return this.id;
            }
            public void setBusiId(String busiId){
                this.busiId = busiId;
            }
            public String getBusiId(){
                return this.busiId;
            }
            public void setPackageId(String packageId){
                this.packageId = packageId;
            }
            public String getPackageId(){
                return this.packageId;
            }
            public void setBrandCode(String brandCode){
                this.brandCode = brandCode;
            }
            public String getBrandCode(){
                return this.brandCode;
            }
            public void setBusiName(String busiName){
                this.busiName = busiName;
            }
            public String getBusiName(){
                return this.busiName;
            }
            public void setBusiContent(String busiContent){
                this.busiContent = busiContent;
            }
            public String getBusiContent(){
                return this.busiContent;
            }
            public void setImgUrl(String imgUrl){
                this.imgUrl = imgUrl;
            }
            public String getImgUrl(){
                return this.imgUrl;
            }

        }

        public class UserExt {
            private String qrAlipay;

            private String qrWx;

            private String cardNo;

            private String username;

            private int status;

            private String name;

            private String orgId;

            private List<String> userCards ;

            public void setQrAlipay(String qrAlipay){
                this.qrAlipay = qrAlipay;
            }
            public String getQrAlipay(){
                return this.qrAlipay;
            }
            public void setQrWx(String qrWx){
                this.qrWx = qrWx;
            }
            public String getQrWx(){
                return this.qrWx;
            }
            public void setCardNo(String cardNo){
                this.cardNo = cardNo;
            }
            public String getCardNo(){
                return this.cardNo;
            }
            public void setUsername(String username){
                this.username = username;
            }
            public String getUsername(){
                return this.username;
            }
            public void setStatus(int status){
                this.status = status;
            }
            public int getStatus(){
                return this.status;
            }
            public void setName(String name){
                this.name = name;
            }
            public String getName(){
                return this.name;
            }
            public void setOrgId(String orgId){
                this.orgId = orgId;
            }
            public String getOrgId(){
                return this.orgId;
            }
            public void setString(List<String> userCards){
                this.userCards = userCards;
            }
            public List<String> getString(){
                return this.userCards;
            }

        }

        public class CityInfo {
            private String regionName;

            private String provinceName;

            private String countyName;

            public void setRegionName(String regionName){
                this.regionName = regionName;
            }
            public String getRegionName(){
                return this.regionName;
            }
            public void setProvinceName(String provinceName){
                this.provinceName = provinceName;
            }
            public String getProvinceName(){
                return this.provinceName;
            }
            public void setCountyName(String countyName){
                this.countyName = countyName;
            }
            public String getCountyName(){
                return this.countyName;
            }

        }

        public class UserInfo {
            private String resacct;

            private String mainLoginName;

            private String userNum;

            private boolean isSecret;

            private String opCountyCode;

            private String opId;

            private String opRegionCode;

            private String retinfo;

            private String rsp;

            private String orgId;

            private String sessId;

            private String retcode;

            public void setResacct(String resacct){
                this.resacct = resacct;
            }
            public String getResacct(){
                return this.resacct;
            }
            public void setMainLoginName(String mainLoginName){
                this.mainLoginName = mainLoginName;
            }
            public String getMainLoginName(){
                return this.mainLoginName;
            }
            public void setUserNum(String userNum){
                this.userNum = userNum;
            }
            public String getUserNum(){
                return this.userNum;
            }
            public void setIsSecret(boolean isSecret){
                this.isSecret = isSecret;
            }
            public boolean getIsSecret(){
                return this.isSecret;
            }
            public void setOpCountyCode(String opCountyCode){
                this.opCountyCode = opCountyCode;
            }
            public String getOpCountyCode(){
                return this.opCountyCode;
            }
            public void setOpId(String opId){
                this.opId = opId;
            }
            public String getOpId(){
                return this.opId;
            }
            public void setOpRegionCode(String opRegionCode){
                this.opRegionCode = opRegionCode;
            }
            public String getOpRegionCode(){
                return this.opRegionCode;
            }
            public void setRetinfo(String retinfo){
                this.retinfo = retinfo;
            }
            public String getRetinfo(){
                return this.retinfo;
            }
            public void setRsp(String rsp){
                this.rsp = rsp;
            }
            public String getRsp(){
                return this.rsp;
            }
            public void setOrgId(String orgId){
                this.orgId = orgId;
            }
            public String getOrgId(){
                return this.orgId;
            }
            public void setSessId(String sessId){
                this.sessId = sessId;
            }
            public String getSessId(){
                return this.sessId;
            }
            public void setRetcode(String retcode){
                this.retcode = retcode;
            }
            public String getRetcode(){
                return this.retcode;
            }

        }

    }

    @Override
    public String toString() {
        return "InitData{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                ", isLeaf=" + isLeaf +
                '}';
    }
}



//public class InitData {
//    private String message;
//
//    private String code;
//
//    private Data data;
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getMessage() {
//        return this.message;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//
//    public void setData(Data data) {
//        this.data = data;
//    }
//
//    public Data getData() {
//        return this.data;
//    }
//
//
//    public class Data {
//        private CityInfo cityInfo;
//
//        private UserInfo userInfo;
//
//        private UserExt userExt;
//
//        private List<BusiInfo> busiInfo;
//
//        public void setCityInfo(CityInfo cityInfo) {
//            this.cityInfo = cityInfo;
//        }
//
//        public CityInfo getCityInfo() {
//            return this.cityInfo;
//        }
//
//        public void setUserInfo(UserInfo userInfo) {
//            this.userInfo = userInfo;
//        }
//
//        public UserInfo getUserInfo() {
//            return this.userInfo;
//        }
//
//        public void setUserExt(UserExt userExt) {
//            this.userExt = userExt;
//        }
//
//        public UserExt getUserExt() {
//            return this.userExt;
//        }
//
//        public void setBusiInfo(List<BusiInfo> busiInfo) {
//            this.busiInfo = busiInfo;
//        }
//
//        public List<BusiInfo> getBusiInfo() {
//            return this.busiInfo;
//        }
//
//
//        public class BusiInfo {
//            private String busiId;
//
//            private String packageId;
//
//            private String brandCode;
//
//            private String busiName;
//
//            private String busiContent;
//
//            private String imgUrl;
//
//            public void setBusiId(String busiId) {
//                this.busiId = busiId;
//            }
//
//            public String getBusiId() {
//                return this.busiId;
//            }
//
//            public void setPackageId(String packageId) {
//                this.packageId = packageId;
//            }
//
//            public String getPackageId() {
//                return this.packageId;
//            }
//
//            public void setBrandCode(String brandCode) {
//                this.brandCode = brandCode;
//            }
//
//            public String getBrandCode() {
//                return this.brandCode;
//            }
//
//            public void setBusiName(String busiName) {
//                this.busiName = busiName;
//            }
//
//            public String getBusiName() {
//                return this.busiName;
//            }
//
//            public void setBusiContent(String busiContent) {
//                this.busiContent = busiContent;
//            }
//
//            public String getBusiContent() {
//                return this.busiContent;
//            }
//
//            public void setImgUrl(String imgUrl) {
//                this.imgUrl = imgUrl;
//            }
//
//            public String getImgUrl() {
//                return this.imgUrl;
//            }
//
//        }
//
//        public class UserExt {
//            private String qrAlipay;
//
//            private String qrWx;
//
//            private String cardNo;
//
//            private String name;
//
//            private String username;
//
//            public void setQrAlipay(String qrAlipay) {
//                this.qrAlipay = qrAlipay;
//            }
//
//            public String getQrAlipay() {
//                return this.qrAlipay;
//            }
//
//            public void setQrWx(String qrWx) {
//                this.qrWx = qrWx;
//            }
//
//            public String getQrWx() {
//                return this.qrWx;
//            }
//
//            public void setCardNo(String cardNo) {
//                this.cardNo = cardNo;
//            }
//
//            public String getCardNo() {
//                return this.cardNo;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public String getName() {
//                return this.name;
//            }
//
//            public void setUsername(String username) {
//                this.username = username;
//            }
//
//            public String getUsername() {
//                return this.username;
//            }
//
//        }
//
//        public class UserInfo {
//            private String resacct;
//
//            private String mainLoginName;
//
//            private String userNum;
//
//            private String opCountyCode;
//
//            private String opId;
//
//            private String opRegionCode;
//
//            private String rsp;
//
//            private String errDesc;
//
//            private String authenMode;
//
//            private String orgId;
//
//            private String sessId;
//
//            public void setResacct(String resacct) {
//                this.resacct = resacct;
//            }
//
//            public String getResacct() {
//                return this.resacct;
//            }
//
//            public void setMainLoginName(String mainLoginName) {
//                this.mainLoginName = mainLoginName;
//            }
//
//            public String getMainLoginName() {
//                return this.mainLoginName;
//            }
//
//            public void setUserNum(String userNum) {
//                this.userNum = userNum;
//            }
//
//            public String getUserNum() {
//                return this.userNum;
//            }
//
//            public void setOpCountyCode(String opCountyCode) {
//                this.opCountyCode = opCountyCode;
//            }
//
//            public String getOpCountyCode() {
//                return this.opCountyCode;
//            }
//
//            public void setOpId(String opId) {
//                this.opId = opId;
//            }
//
//            public String getOpId() {
//                return this.opId;
//            }
//
//            public void setOpRegionCode(String opRegionCode) {
//                this.opRegionCode = opRegionCode;
//            }
//
//            public String getOpRegionCode() {
//                return this.opRegionCode;
//            }
//
//            public void setRsp(String rsp) {
//                this.rsp = rsp;
//            }
//
//            public String getRsp() {
//                return this.rsp;
//            }
//
//            public void setErrDesc(String errDesc) {
//                this.errDesc = errDesc;
//            }
//
//            public String getErrDesc() {
//                return this.errDesc;
//            }
//
//            public void setAuthenMode(String authenMode) {
//                this.authenMode = authenMode;
//            }
//
//            public String getAuthenMode() {
//                return this.authenMode;
//            }
//
//            public void setOrgId(String orgId) {
//                this.orgId = orgId;
//            }
//
//            public String getOrgId() {
//                return this.orgId;
//            }
//
//            public void setSessId(String sessId) {
//                this.sessId = sessId;
//            }
//
//            public String getSessId() {
//                return this.sessId;
//            }
//
//        }
//
//        public class CityInfo {
//            private String provinceName;
//
//            private String regionName;
//
//            private String countyName;
//
//            public void setProvinceName(String provinceName) {
//                this.provinceName = provinceName;
//            }
//
//            public String getProvinceName() {
//                return this.provinceName;
//            }
//
//            public void setRegionName(String regionName) {
//                this.regionName = regionName;
//            }
//
//            public String getRegionName() {
//                return this.regionName;
//            }
//
//            public void setCountyName(String countyName) {
//                this.countyName = countyName;
//            }
//
//            public String getCountyName() {
//                return this.countyName;
//            }
//
//        }
//    }
//}


//public class InitData {
//
//    private String message;
//    private String code;
//    private Data data;
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setData(Data data) {
//        this.data = data;
//    }
//
//    public Data getData() {
//        return data;
//    }
//
//    public class Data {
//
//        private CityInfo cityInfo;
//        private UserInfo userInfo;
//        private UserExt userExt;
//
//        public void setCityInfo(CityInfo cityInfo) {
//            this.cityInfo = cityInfo;
//        }
//
//        public CityInfo getCityInfo() {
//            return cityInfo;
//        }
//
//        public void setUserInfo(UserInfo userInfo) {
//            this.userInfo = userInfo;
//        }
//
//        public UserInfo getUserInfo() {
//            return userInfo;
//        }
//
//        public void setUserExt(UserExt userExt) {
//            this.userExt = userExt;
//        }
//
//        public UserExt getUserExt() {
//            return userExt;
//        }
//
//        public class CityInfo {
//
//            private String provinceName;
//            private String regionName;
//            private String countyName;
//
//            public void setProvinceName(String provinceName) {
//                this.provinceName = provinceName;
//            }
//
//            public String getProvinceName() {
//                return provinceName;
//            }
//
//            public void setRegionName(String regionName) {
//                this.regionName = regionName;
//            }
//
//            public String getRegionName() {
//                return regionName;
//            }
//
//            public void setCountyName(String countyName) {
//                this.countyName = countyName;
//            }
//
//            public String getCountyName() {
//                return countyName;
//            }
//
//        }
//
//
//        public class UserInfo {
//
//            private String resacct;
//            private String mainLoginName;
//            private String userNum;
//            private String opCountyCode;
//            private String opId;
//            private String opRegionCode;
//            private String rsp;
//            private String orgId;
//            private String sessId;
//
//            public void setResacct(String resacct) {
//                this.resacct = resacct;
//            }
//
//            public String getResacct() {
//                return resacct;
//            }
//
//            public void setMainLoginName(String mainLoginName) {
//                this.mainLoginName = mainLoginName;
//            }
//
//            public String getMainLoginName() {
//                return mainLoginName;
//            }
//
//            public void setUserNum(String userNum) {
//                this.userNum = userNum;
//            }
//
//            public String getUserNum() {
//                return userNum;
//            }
//
//            public void setOpCountyCode(String opCountyCode) {
//                this.opCountyCode = opCountyCode;
//            }
//
//            public String getOpCountyCode() {
//                return opCountyCode;
//            }
//
//            public void setOpId(String opId) {
//                this.opId = opId;
//            }
//
//            public String getOpId() {
//                return opId;
//            }
//
//            public void setOpRegionCode(String opRegionCode) {
//                this.opRegionCode = opRegionCode;
//            }
//
//            public String getOpRegionCode() {
//                return opRegionCode;
//            }
//
//            public void setRsp(String rsp) {
//                this.rsp = rsp;
//            }
//
//            public String getRsp() {
//                return rsp;
//            }
//
//            public void setOrgId(String orgId) {
//                this.orgId = orgId;
//            }
//
//            public String getOrgId() {
//                return orgId;
//            }
//
//            public void setSessId(String sessId) {
//                this.sessId = sessId;
//            }
//
//            public String getSessId() {
//                return sessId;
//            }
//
//        }
//
//        public class UserExt {
//
//            private String qrAlipay;
//            private String qrWx;
//            private String cardNo;
//            private String name;
//            private String orgName;
//
//            public void setQrAlipay(String qrAlipay) {
//                this.qrAlipay = qrAlipay;
//            }
//
//            public String getQrAlipay() {
//                return qrAlipay;
//            }
//
//            public void setQrWx(String qrWx) {
//                this.qrWx = qrWx;
//            }
//
//            public String getQrWx() {
//                return qrWx;
//            }
//
//            public void setCardNo(String cardNo) {
//                this.cardNo = cardNo;
//            }
//
//            public String getCardNo() {
//                return cardNo;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public void setOrgName(String orgName) {
//                this.orgName = orgName;
//            }
//
//            public String getOrgName() {
//                return orgName;
//            }
//
//        }
//
//
//    }
//}
