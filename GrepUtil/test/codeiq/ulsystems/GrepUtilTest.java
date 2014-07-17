package codeiq.ulsystems;

import org.junit.Test;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static codeiq.ulsystems.GrepUtil.grep;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GrepUtilTest {

    @Test
    public void testGrep() {
        String input = "Java 1 is nice.\n" +
                "Java 2 is fine.\n" +
                "Java 3 is good.\n" +
                "Java 4 is good.\n" +
                "Java 5 is fine.\n" +
                "Java 6 is good.\n" +
                "Java 7 is good.\n" +
                "Java 8 is marvelous.\n";

        try(StringReader sr = new StringReader(input)){

            List<String> result = grep(sr, "fine", "marvelous").collect(Collectors.toList());
            assertThat(result.size(), is(3));
            assertThat(result, is(Arrays.asList(
                    "2: Java 2 is fine.",
                    "5: Java 5 is fine.",
                    "8: Java 8 is marvelous.")));
        }
    }
}
