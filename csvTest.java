import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class csvTest {
    public static void main(String[] args) throws IOException {
        String file = "master\\userMaster.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                for (String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }
}
