import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class base36Test {

    private static final String AtoZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String filePath = "master\\user.csv";

    public static void main(String[] args) {
        String userId = "";
        String seqUserId = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("userId : ");
            userId = sc.nextLine();
        } while (userId.trim().length() != 4);
        try {
            seqUserId = getId(userId);
            System.out.println(seqUserId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    private static String getId(String userId) throws IOException {
        String returnId = "";
        boolean header = true;
        try {
            String line = "";
            String seqId = "0000";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                if (header) {
                    header = false;
                    continue;
                }

                String keyId = row[1];

                if (keyId.equals(userId)) {
                    returnId = row[0] + row[1];
                    break;
                }
                seqId = row[0];
            }
            reader.close();

            if (returnId.equals("")) {
                String firstIndexOfAtoZ = AtoZ.substring(0, 1);
                String lastIndexOfAtoZ = AtoZ.substring(AtoZ.length() - 1);

                String[] tmpId = seqId.split("");
                for (int i = seqId.length() - 1; i >= 0; i--) {
                    int pos = 0;
                    if (tmpId[i].equals(lastIndexOfAtoZ)) {
                        if (i != 0) {
                            tmpId[i] = firstIndexOfAtoZ;
                        } else {
                            System.out.println("ERROR!");
                            throw new Exception();
                        }
                    } else {
                        pos = AtoZ.indexOf(tmpId[i]) + 1;
                        tmpId[i] = AtoZ.substring(pos, pos + 1);
                        break;
                    }
                }

                seqId = String.join("", tmpId);

                String writeBuffer = seqId + "," + userId;

                FileOutputStream fos = new FileOutputStream(filePath, true);
                OutputStreamWriter osw = new OutputStreamWriter(fos, "MS949");
                BufferedWriter bw = new BufferedWriter(osw);

                bw.write(writeBuffer);
                bw.newLine();
                bw.flush();
                bw.close();
                fos.flush();
                fos.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnId;
    }
}