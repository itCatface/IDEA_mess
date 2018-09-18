package domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class No4ALogin implements Serializable {

    private String message;
    private String code;
    private Data data;
    private boolean isLeaf;
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

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
    public boolean getIsLeaf() {
        return isLeaf;
    }


    public class Data {

        private String rc;
        private UserInfo userInfo;
        private List<HomeBusType> homeBusType;
        private List<PackageList> packageList;
        private String token;
        public void setRc(String rc) {
            this.rc = rc;
        }
        public String getRc() {
            return rc;
        }

        public void setUserInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
        }
        public UserInfo getUserInfo() {
            return userInfo;
        }

        public void setHomeBusType(List<HomeBusType> homeBusType) {
            this.homeBusType = homeBusType;
        }
        public List<HomeBusType> getHomeBusType() {
            return homeBusType;
        }

        public void setPackageList(List<PackageList> packageList) {
            this.packageList = packageList;
        }
        public List<PackageList> getPackageList() {
            return packageList;
        }

        public void setToken(String token) {
            this.token = token;
        }
        public String getToken() {
            return token;
        }


        public class UserInfo {

            private String qdCode;
            private String region;
            private String username;
            private String orgId;
            private String orgName;
            public void setQdCode(String qdCode) {
                this.qdCode = qdCode;
            }
            public String getQdCode() {
                return qdCode;
            }

            public void setRegion(String region) {
                this.region = region;
            }
            public String getRegion() {
                return region;
            }

            public void setUsername(String username) {
                this.username = username;
            }
            public String getUsername() {
                return username;
            }

            public void setOrgId(String orgId) {
                this.orgId = orgId;
            }
            public String getOrgId() {
                return orgId;
            }

            public void setOrgName(String orgName) {
                this.orgName = orgName;
            }
            public String getOrgName() {
                return orgName;
            }

        }


        public class HomeBusType {

            private String busType;
            private boolean hidden;
            public void setBusType(String busType) {
                this.busType = busType;
            }
            public String getBusType() {
                return busType;
            }

            public void setHidden(boolean hidden) {
                this.hidden = hidden;
            }
            public boolean getHidden() {
                return hidden;
            }

        }


        public class PackageList {

            private int id;
            private String mainpriv;
            private String mainPrivName;
            private String gsm;
            private String gprs;
            private String package_message;
            private boolean package_flage;
            private String package_offering_list;
            public void setId(int id) {
                this.id = id;
            }
            public int getId() {
                return id;
            }

            public void setMainpriv(String mainpriv) {
                this.mainpriv = mainpriv;
            }
            public String getMainpriv() {
                return mainpriv;
            }

            public void setMainPrivName(String mainPrivName) {
                this.mainPrivName = mainPrivName;
            }
            public String getMainPrivName() {
                return mainPrivName;
            }

            public void setGsm(String gsm) {
                this.gsm = gsm;
            }
            public String getGsm() {
                return gsm;
            }

            public void setGprs(String gprs) {
                this.gprs = gprs;
            }
            public String getGprs() {
                return gprs;
            }

            public void setPackage_message(String package_message) {
                this.package_message = package_message;
            }
            public String getPackage_message() {
                return package_message;
            }

            public void setPackage_flage(boolean package_flage) {
                this.package_flage = package_flage;
            }
            public boolean getPackage_flage() {
                return package_flage;
            }

            public void setPackage_offering_list(String package_offering_list) {
                this.package_offering_list = package_offering_list;
            }
            public String getPackage_offering_list() {
                return package_offering_list;
            }

        }

    }

}
