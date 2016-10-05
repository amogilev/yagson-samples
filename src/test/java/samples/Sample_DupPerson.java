package samples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gilecode.yagson.YaGson;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class Sample_DupPerson {

    @Before
    public void printTestName() {
        System.out.println("\n===\n" + getClass().getSimpleName());
    }

    @Test
    public void testYagson() {
        System.out.println("YaGson\n===");

        Person p = new Person("John", "Doe");
        Person[] obj = new Person[]{p, p};

        YaGson mapper = new YaGson();
        String objJson = mapper.toJson(obj, Person[].class);
        Person[] deserisalizedObj = mapper.fromJson(objJson, Person[].class);

        System.out.println("objJson = " + objJson);
        System.out.println("deserisalizedObj = " + Arrays.deepToString(deserisalizedObj));
    }
}
