package util.net.retrofit_xy.domain;

/**
 Created by catfaceWYH --> tel|wechat|qq 130 128 92925
 */
public class WriteSimCard {

    @Override
    public String toString() {
        return "WriteSimCard{" +
                "data=" + data +
                '}';
    }

    private Data data;

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public class Data {

        private CardInfo cardInfo;
        private TransCard transCard;

        public void setCardInfo(CardInfo cardInfo) {
            this.cardInfo = cardInfo;
        }

        public CardInfo getCardInfo() {
            return cardInfo;
        }

        public void setTransCard(TransCard transCard) {
            this.transCard = transCard;
        }

        public TransCard getTransCard() {
            return transCard;
        }

        public class TransCard {

            private String phone;
            private String acctidNo;
            private String simNo;
            private String imsiNo;
            private String kiNo;
            private String opcNo;
            private String pukNo1;
            private String pukNo2;
            private String pinNo1;
            private String pinNo2;
            private String smspNo;

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPhone() {
                return phone;
            }

            public void setAcctidNo(String acctidNo) {
                this.acctidNo = acctidNo;
            }

            public String getAcctidNo() {
                return acctidNo;
            }

            public void setSimNo(String simNo) {
                this.simNo = simNo;
            }

            public String getSimNo() {
                return simNo;
            }

            public void setImsiNo(String imsiNo) {
                this.imsiNo = imsiNo;
            }

            public String getImsiNo() {
                return imsiNo;
            }

            public void setKiNo(String kiNo) {
                this.kiNo = kiNo;
            }

            public String getKiNo() {
                return kiNo;
            }

            public void setOpcNo(String opcNo) {
                this.opcNo = opcNo;
            }

            public String getOpcNo() {
                return opcNo;
            }

            public void setPukNo1(String pukNo1) {
                this.pukNo1 = pukNo1;
            }

            public String getPukNo1() {
                return pukNo1;
            }

            public void setPukNo2(String pukNo2) {
                this.pukNo2 = pukNo2;
            }

            public String getPukNo2() {
                return pukNo2;
            }

            public void setPinNo1(String pinNo1) {
                this.pinNo1 = pinNo1;
            }

            public String getPinNo1() {
                return pinNo1;
            }

            public void setPinNo2(String pinNo2) {
                this.pinNo2 = pinNo2;
            }

            public String getPinNo2() {
                return pinNo2;
            }

            public void setSmspNo(String smspNo) {
                this.smspNo = smspNo;
            }

            public String getSmspNo() {
                return smspNo;
            }

        }

        public class CardInfo {

            private String seqNo;
            private String issueData;

            public void setSeqNo(String seqNo) {
                this.seqNo = seqNo;
            }

            public String getSeqNo() {
                return seqNo;
            }

            public void setIssueData(String issueData) {
                this.issueData = issueData;
            }

            public String getIssueData() {
                return issueData;
            }

        }
    }


}
