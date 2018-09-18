package util.net.http.ibm_point_download;

public class TestMethod {
    public TestMethod() { ///xx/weblogic60b2_win.exe
        try {
            SiteInfoBean bean = new SiteInfoBean("http://localhost/xx/weblogic60b2_win.exe", "E:\\temp", "weblogic60b2_win.exe", 5);
//            domain = new SiteInfoBean("http://127.0.0.1:8080/test/download", "E:\\temp", "qq.exe", 1);
            bean = new SiteInfoBean("http://47.97.171.45:8282/apk/1519914274964.apk", "E:\\temp", "qq.exe", 1);

            SiteFileFetch fileFetch = new SiteFileFetch(bean);
            fileFetch.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TestMethod();
    }
}