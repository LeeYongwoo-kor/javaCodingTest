package DTOTest.src.main;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTOTest.src.dto.Print;
import DTOTest.src.dto.PrintTo;

public class PrintTest {

    public static void main(String[] args) {
        // OVER HERE!
        String INPUT_INSTANCE_NAME = "i01";
        String OUTPUT_INSTANCE_NAME = "o01";

        Class<?> FROM = Print.class;
        Class<?> TO = PrintTo.class;
        // OVER HERE!

        List<String> print = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        for (Field f : FROM.getDeclaredFields()) { // Change fromMappingClassName
            map.put(f.getName(), f.getType());
        }

        int count = 0;
        int same = 0;
        for (Field f : TO.getDeclaredFields()) { // Change toMappingClassName
            if (map.containsKey(f.getName()) && map.get(f.getName()).equals(f.getType())) {
                print.add(String.format("%s.set%s(%s.get%s());", OUTPUT_INSTANCE_NAME,
                        f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1), INPUT_INSTANCE_NAME,
                        f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1)));
                same++;
            } else {
                print.add(String.format("%s.set%s(null);", OUTPUT_INSTANCE_NAME,
                        f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1)));
            }
            count++;
        }

        print.forEach((temp) -> {
            System.out.println(temp);
        });
        System.out.println("項目数：" + count);
        System.out.println("マッピング一致項目数：" + same);
    }

    public void instanceCheckTest() {
        Print i01 = new Print();
        PrintTo o01 = new PrintTo();

        o01.setAaaa(i01.getAaaa());
        o01.setBbbb(i01.getBbbb());
        o01.setCccc(i01.getCccc());
        o01.setDddd(i01.getDddd());
        o01.setEeee(i01.getEeee());
        o01.setFfff(i01.getFfff());
        o01.setGggg(i01.getGggg());
        o01.setHhhh(i01.getHhhh());
        o01.setIiii(i01.getIiii());
        o01.setJjjj(i01.getJjjj());
        o01.setKkkk(i01.getKkkk());
        o01.setLlll(i01.getLlll());
        o01.setMmmm(i01.getMmmm());
        o01.setNnnn(i01.getNnnn());
        o01.setOooo(i01.getOooo());
        o01.setPppp(i01.getPppp());
        o01.setQqqq(i01.getQqqq());
        o01.setRrrr(i01.getRrrr());
        o01.setSsss(i01.getSsss());
        o01.setTttt(i01.getTttt());
        o01.setUuuu(i01.getUuuu());
        o01.setVvvv(i01.getVvvv());
        o01.setWwww(i01.getWwww());
        o01.setXxxx(i01.getXxxx());
        o01.setYyyy(i01.getYyyy());
        o01.setZzzz(i01.getZzzz());
        o01.setQwer(null);
        o01.setAsdf(null);
        o01.setZxcv(null);
        o01.setSdfg(null);
        o01.setWert(null);
        o01.setXcvb(null);
    }
}
