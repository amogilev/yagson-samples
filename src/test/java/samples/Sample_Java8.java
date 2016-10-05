package samples;

import com.gilecode.yagson.YaGson;
import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author Andrey Mogilev
 */
public class Sample_Java8 {

    @Test
    public void testLambdas() {
        YaGson mapper = new YaGson();
        Supplier<String> func = () -> "foo";

        String json = mapper.toJson(func);
        System.out.println("json = " + json);

        func = (Supplier<String>)mapper.fromJson(json, Object.class);

        System.out.println("func = " + func);
        System.out.println("func() = " + func.get());

    }
}
