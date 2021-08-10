package constTest;

import java.io.IOException;

public class MainClass {

    static private String propFileName = "defaultPath";

    private String keyId = "";
    // private HttpServletRequest request = null;

    public MainClass() {
        StackTraceElement[] ste = new Throwable().getStackTrace();
        for (int i = ste.length - 1; i > 0; i--) {
            System.out.println("Called from " + ste[i].getClassName() + " CLASS");
            System.out.println("Called from " + ste[i].getMethodName() + " METHOD");
        }

        try {
            loadFile(propFileName);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public MainClass(Object request) {
        // SQIDSParamMgr spmgr = new SQIDSParamMgr(request);
        // this.keyId = (String) spmgr.getValue("keySplCd1");
        setPropFileName(keyId);
    }

    public MainClass(String keyId) {
        this.keyId = keyId;
        setPropFileName(keyId);
    }

    public static void main(String[] args) {

    }

    public void loadFile(String fileName) {
        System.out.println("call loadFile" + fileName);
    }

    private void setPropFileName(String keyCd) {
        String path = "/SQIDS" + keyCd + "/properties/property.prop";
        try {
            if (propFileName.equals(path)) {
                loadFile(propFileName);
            } else {
                loadFile(path);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
