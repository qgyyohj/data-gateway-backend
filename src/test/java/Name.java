import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Name {
    @Test
    public void testStream(){
        System.out.println(Arrays.asList(1, 3, 5, 7).stream().filter(x -> x % 2 == 0).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        switch (c){
            case '1':
            case '2':
            case '3':
                System.out.println("这是数字");
                break;
            case 'a':
            case 'b':
                System.out.println("这是字母");
                break;
            default:
                System.out.println("啥都不是");
        }
    }
}
