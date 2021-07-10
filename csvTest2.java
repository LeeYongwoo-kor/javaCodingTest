import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class csvTest2 {

    private static String splCd = "";
    private static String masterFile = "master\\userMaster2.txt";
    private static String BASE_36 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int startUNIQUEID = 0;
    private static final int endUNIQUEID = 100;
    private static final int startSQIDSID = 100;
    private static final int endSQIDSID = 104;
    private static final int startUSERID = 104;
    private static final int endUSERID = 120;

    public static void main(String[] args) {
        // String file = "master\\asManager.csv";
        // String companyCode = "55555";

        try {
            // boolean bl = getSplCd(companyCode, file);
            // if (bl) {
            // System.out.println(splCd);
            // }

            String uId = "AAAA_TTTT@12312";
            String usrId = "AAAATTTT";

            String returnString = getId(uId, usrId);
            System.out.println(returnString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean getSplCd(String companyCode, String masterFile) throws IOException {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(new File(masterFile)), "SJIS"));

            String line = "";
            boolean headerLine = true;
            while ((line = br.readLine()) != null) {
                if (headerLine) {
                    headerLine = false;
                    continue;
                }

                System.out.println(line);

                String[] row = line.split(",");

                String keyId = row[0];
                if (keyId.equals(companyCode)) {
                    splCd = row[1];
                    return true;
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }

        return false;
    }

    private static String getId(String uniqueid, String usrid) throws IOException {
        String sqidsID = "";
        try {
            String seqID = "0000";
            String uniqueID = uniqueid.trim();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(new File(masterFile)), "SJIS"));

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().length() == 0 || line.startsWith("#")) {
                    continue;
                }
                String keyID = "";
                keyID = line.substring(startUNIQUEID, endUNIQUEID).trim();

                if (keyID.equals(uniqueID)) {
                    sqidsID = line.substring(startSQIDSID, endSQIDSID).trim();
                    break;
                }
                seqID = line.substring(startSQIDSID, endSQIDSID).trim();
            }
            br.close();

            if (sqidsID.equals("")) {
                String writeBuffer = "";

                writeBuffer = addSpace(uniqueID, endUNIQUEID - startUNIQUEID);

                String firstIndexOfBase36 = BASE_36.substring(0, 1);
                String lastIndexOfBase36 = BASE_36.substring(BASE_36.length() - 1);

                String[] tmpId = seqID.split("");
                for (int i = seqID.length() - 1; i >= 0; i--) {
                    int pos = 0;
                    if (tmpId[i].equals(lastIndexOfBase36)) { // 現在のインデックスが"Z"の場合
                        if (i != 0) {
                            tmpId[i] = firstIndexOfBase36;
                        } else { // 1桁目
                            System.out.println("ERROR---SQIDSuserMaster--- : Masterファイルが想定最大件数を超えました！");
                            throw new java.lang.ArrayIndexOutOfBoundsException();
                        }
                    } else {
                        pos = BASE_36.indexOf(tmpId[i]) + 1;
                        tmpId[i] = BASE_36.substring(pos, pos + 1);
                        break;
                    }
                }

                seqID = joinString(tmpId);

                // String wk1 = seqID.substring(0, 1);
                // String wk2 = seqID.substring(1, 4);
                // int cnt = Integer.parseInt(wk2);
                // cnt++;

                // if (cnt > 999) {
                // if (wk1.equals("9")) {
                // throw new java.lang.ArrayIndexOutOfBoundsException();
                // }
                // wk2 = "000";
                // String AtoZ = "0123456789";

                // int hKey = AtoZ.indexOf(wk1);
                // wk1 = AtoZ.substring(hKey + 1, hKey + 2);
                // seqID = wk1 + wk2;
                // } else {
                // seqID = wk1 + addZero(Integer.toString(cnt), 3);
                // }

                sqidsID = seqID;
                writeBuffer = writeBuffer + seqID + addSpace(usrid, endUSERID - startUSERID);

                FileOutputStream fos = new FileOutputStream(masterFile, true);
                OutputStreamWriter osw = new OutputStreamWriter(fos, "SJIS");
                BufferedWriter bw = new BufferedWriter(osw);

                bw.write(writeBuffer);
                bw.newLine();
                bw.flush();
                bw.close();
                fos.flush();
                fos.close();

            }
        } catch (Exception e) {
            e.toString();
            return null;
        }
        return usrid + sqidsID;
    }

    private static String addSpace(String str, int length) {
        StringBuffer strbf = new StringBuffer(str);
        for (; strbf.length() < length;) {
            strbf.append(" ");
        }
        return strbf.toString();
    }

    private static String addZero(String str, int length) {
        StringBuffer strbf = new StringBuffer(str);
        for (; strbf.length() < length;) {
            strbf.insert(0, '0');
        }
        return strbf.toString();
    }

    private static String joinString(String[] str) {
        StringBuffer strbf = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            strbf.append(str[i]);
        }
        return strbf.toString();
    }
}
