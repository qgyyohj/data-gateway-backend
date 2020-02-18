import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Name {
    @Test
    public void testStream(){
        System.out.println(Arrays.asList(1, 3, 5, 7).stream().filter(x -> x % 2 == 0).collect(Collectors.toList()));
    }
}
