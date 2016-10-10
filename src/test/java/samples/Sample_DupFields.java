package samples;

import com.gilecode.yagson.YaGson;
import org.junit.Before;
import org.junit.Test;

class BaseStringHolder {
    String str = "baseStr";
}

class OverrideStringHolder extends BaseStringHolder {
    String str = "overrideStr";
}

public class Sample_DupFields {

    @Before
    public void printTestName() {
        System.out.println("\n===\n" + getClass().getSimpleName());
    }

    @Test
    public void testYagson() {
        System.out.println("YaGson\n===");
        YaGson mapper = new YaGson();

        String objJson = mapper.toJson(new OverrideStringHolder(), OverrideStringHolder.class);
        System.out.println("objJson = " + objJson);

        OverrideStringHolder deserisalizedObj = mapper.fromJson(objJson, OverrideStringHolder.class);
        System.out.println("deserisalizedObj = " + deserisalizedObj);
    }
}
