package samples;

import com.gilecode.yagson.YaGson;
import org.junit.Before;
import org.junit.Test;

class Outer  {
    class Inner {
        String str = "foo";
    }

    Inner inner;
}

public class Sample_InnerClass {

    @Before
    public void printTestName() {
        System.out.println("\n===\n" + getClass().getSimpleName());
    }

    @Test
    public void testYagson() {
        System.out.println("YaGson\n===");
        YaGson mapper = new YaGson();

        Outer obj = new Outer();
        obj.inner = obj.new Inner();

        String objJson = mapper.toJson(obj, Outer.class);
        System.out.println("objJson = " + objJson);

        String innerJson = mapper.toJson(obj.inner, Outer.Inner.class);
        System.out.println("innerJson = " + innerJson);

        Outer.Inner deserisalizedInner = mapper.fromJson(innerJson, Outer.Inner.class);
        System.out.println("deserisalizedInner = " + deserisalizedInner);
    }
}
