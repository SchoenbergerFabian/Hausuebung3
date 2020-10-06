import java.util.stream.IntStream;

public class Beispiel4 {
    public static void main(String[] args) {
        final int result = IntStream.of(1,2,3,4,5,6,7,8,9,10)
                .filter(number -> number%2!=0)
                .map(number -> (int) Math.pow(number,2))
                .sum();

        System.out.println(result);
    }
}
