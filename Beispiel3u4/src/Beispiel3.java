import java.util.function.Predicate;

public class Beispiel3 {

    public static void main(String[] args) {
        final Predicate<Integer> isEven = number -> number%2==0;
        final Predicate<Integer> isPositive = number -> number>=0;
        final Predicate<Integer> isZero = number -> number==0;
        final Predicate<Integer> isNull = number -> number==null;

        final Predicate<String> isShortWord = word -> word.length()<4;

        System.out.println("isEven");
        System.out.println("2: "+isEven.test(2));
        System.out.println("3: "+isEven.test(3));

        System.out.println("\nisPositive");
        System.out.println("1: "+isPositive.test(1));
        System.out.println("0: "+isPositive.test(0));
        System.out.println("-1: "+isPositive.test(-1));

        System.out.println("\nisZero");
        System.out.println("1: "+isZero.test(1));
        System.out.println("0: "+isZero.test(0));

        System.out.println("\nisNull");
        System.out.println("1: "+isNull.test(1));
        System.out.println("null: "+isNull.test(null));

        System.out.println("\nisShortWord");
        System.out.println("and: "+isShortWord.test("and"));
        System.out.println("tree: "+isShortWord.test("tree"));
        System.out.println("pneumonoultramicroscopicsilicovolcanoconiosis: "+isShortWord.test("pneumonoultramicroscopicsilicovolcanoconiosis"));

        System.out.println("\nisPositve and isEven");
        System.out.println("2: "+isPositive.and(isEven).test(2));
        System.out.println("-4: "+isPositive.and(isEven).test(4));

        System.out.println("\nisPositve and !isEven");
        System.out.println("-3: "+isPositive.and(isEven.negate()).test(-3));
        System.out.println("5: "+isPositive.and(isEven.negate()).test(5));
    }
}
