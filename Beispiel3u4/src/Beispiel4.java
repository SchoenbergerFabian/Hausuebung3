import java.util.stream.IntStream;

public class Beispiel4 {
    public static void main(String[] args) {
        IntStream.range(1,10)
                .filter(number -> number%2!=0)
                .map(number -> (int) Math.pow(number,2))
                .reduce(Integer::sum)
                .ifPresent(System.out::println);

    }
}
