package samples;

import com.gilecode.yagson.YaGson;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Sample_PrimitiveTypes {

    @Before
    public void printTestName() {
        System.out.println("\n===\n" + getClass().getSimpleName());
    }

    @Test
    public void testYagson() {
        System.out.println("YaGson\n===");

        YaGson mapper = new YaGson();

        String objJson = mapper.toJson(2, Object.class);
        System.out.println(mapper.toJson(2.0, Object.class));
        System.out.println("objJson = " + objJson);
        long deserisalizedObj = mapper.fromJson(objJson, Long.class);

        System.out.println("deserisalizedObj = " + deserisalizedObj);
    }
}
