package codeiq.ulsystems;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by @taiga_forest on 2014/04/07.
 */
public class GrepUtil {
    public static Stream<String> grep(Reader reader, String... words) {
        Iterator<Integer> indexIterator = Stream.iterate(1, x -> x++).iterator();
        Stream<String> lines = new BufferedReader(reader).lines()
                .map(line -> indexIterator.next() + ": " + line)
                //.filter(line -> Arrays.asList(words).stream().anyMatch(word -> line.matches(".*" + word + ".*"))); // この課題は正規表現不要
                .filter(line -> Arrays.asList(words).stream().anyMatch(line::contains));
        return lines;
    }
}
