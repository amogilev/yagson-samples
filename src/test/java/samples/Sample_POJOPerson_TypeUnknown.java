package samples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gilecode.yagson.YaGson;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Sample_POJOPerson_TypeUnknown {

    @Before
    public void printTestName() {
        System.out.println("\n===\n" + getClass().getSimpleName());
    }

    @Test
    public void testYagson() {
        System.out.println("YaGson\n===");

        POJOPerson obj = new POJOPerson("John", "Doe");

        YaGson mapper = new YaGson();
        String objJson = mapper.toJson(obj);
        Object deserisalizedObj = mapper.fromJson(objJson, Object.class);

        System.out.println("objJson = " + objJson);
        System.out.println("deserisalizedObj = " + deserisalizedObj);
        System.out.println("deserisalized class = " + deserisalizedObj.getClass().getName());

        assertEquals(obj, deserisalizedObj);
    }

    @Test
    public void testGson() {
        System.out.println("Gson\n===");

        POJOPerson obj = new POJOPerson("John", "Doe");

        Gson mapper = new Gson();
        String objJson = mapper.toJson(obj);
        Object deserisalizedObj = mapper.fromJson(objJson, Object.class);

        System.out.println("objJson = " + objJson);
        System.out.println("deserisalizedObj = " + deserisalizedObj);
        System.out.println("deserisalized class = " + deserisalizedObj.getClass().getName());

        assertEquals(obj, deserisalizedObj);
    }

    @Test
    public void testJackson() throws IOException {
        System.out.println("Jackson\n===");

        POJOPerson obj = new POJOPerson("John", "Doe");

        ObjectMapper mapper = new ObjectMapper();
        String objJson = mapper.writeValueAsString(obj);
        Object deserisalizedObj = mapper.readValue(objJson, Object.class);

        System.out.println("objJson = " + objJson);
        System.out.println("deserisalizedObj = " + deserisalizedObj);
        System.out.println("deserisalized class = " + deserisalizedObj.getClass().getName());

        assertEquals(obj, deserisalizedObj);
    }

    public static class POJOPerson {
        private String name;
        private String family;

        public POJOPerson() {
        }

        public POJOPerson(String name, String family) {
            this.name = name;
            this.family = family;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFamily() {
            return family;
        }

        public void setFamily(String family) {
            this.family = family;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            POJOPerson that = (POJOPerson) o;

            if (name != null ? !name.equals(that.name) : that.name != null) return false;
            return family != null ? family.equals(that.family) : that.family == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (family != null ? family.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "POJOPerson{" +
                    "name='" + name + '\'' +
                    ", family='" + family + '\'' +
                    '}';
        }
    }
}
