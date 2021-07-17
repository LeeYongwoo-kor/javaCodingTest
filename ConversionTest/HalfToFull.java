package ConversionTest;

import java.lang.reflect.Field;

public class HalfToFull<T> {
    private T obj;

    public HalfToFull(T obj) {
        this.obj = obj;
    }

    public T getDtoValue() {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(obj) instanceof String) {
                    String value = ((String) field.get(obj)).substring(0, 4);
                    field.set(obj, value);
                }
            }
        } catch (Exception e) {

        }
        return obj;
    }
}