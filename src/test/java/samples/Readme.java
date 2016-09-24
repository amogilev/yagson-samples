package samples;

/**
 * Describes samples residing in this package.
 */
public class Readme {

    Object[] samples = {

            // 1) Mapping of a simple POJO class, with a known de-serialziation type
            new Sample_POJOPerson(),

            // 2) Mapping of a simple POJO class, with an unknown de-serialziation type
            new Sample_POJOPerson_TypeUnknown()
    };
}
