package samples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gilecode.yagson.YaGson;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class Sample_SRArray {

    @Before
    public void printTestName() {
        System.out.println("\n===\n" + getClass().getSimpleName());
    }

    @Test
    public void testYagson() {
        System.out.println("YaGson\n===");

        Object[] obj = new Object[3];
        obj[0] = "foo";
        obj[1] = obj;
        obj[2] = "bar";

        YaGson mapper = new YaGson();
        String objJson = mapper.toJson(obj, Object[].class);
        Object[] deserisalizedObj = mapper.fromJson(objJson, Object[].class);

        System.out.println("objJson = " + objJson);
        System.out.println("deserisalizedObj = " + Arrays.deepToString(deserisalizedObj));
    }

    @Test
    public void testGson() {
        System.out.println("Gson\n===");

        Object[] obj = new Object[3];
        obj[0] = "foo";
        obj[1] = obj;
        obj[2] = "bar";

        Gson mapper = new Gson();
        String objJson = mapper.toJson(obj);
        Object[] deserisalizedObj = mapper.fromJson(objJson, Object[].class);

        System.out.println("objJson = " + objJson);
        System.out.println("deserisalizedObj = " + Arrays.deepToString(deserisalizedObj));
    }

    @Test
    public void testJackson() throws IOException {
        System.out.println("Jackson\n===");

        Object[] obj = new Object[3];
        obj[0] = "foo";
        obj[1] = obj;
        obj[2] = "bar";

        ObjectMapper mapper = new ObjectMapper();
        String objJson = mapper.writeValueAsString(obj);
//        Object[] deserisalizedObj = mapper.readValue(objJson, Object[].class);
//
//
//        System.out.println("objJson = " + objJson);
//        System.out.println("deserisalizedObj = " + Arrays.deepToString(deserisalizedObj));
    }
}
