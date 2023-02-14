import javax.naming.InvalidNameException;
import javax.naming.Name;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.jar.Attributes;

public class Main {
    public static void main(String[] args) {

        // Задарние 1

        List<Integer> numbers = Arrays.asList(1, 2, 3, -3, -4, 2, -2);

        Predicate<Integer> thePositivityOfTheNumber = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        for (Integer integer : numbers) {
            System.out.println(thePositivityOfTheNumber.test(integer));
        }

        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

        Predicate<Integer> thePositivityOfTheNumber2 = y -> y > 0;
        for (Integer integer : numbers) {
            System.out.println(thePositivityOfTheNumber2.test(integer));
        }
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

        // Задарние 2
        List<PersonName> nameList = Arrays.asList(
                new PersonName("Анатолий"),
                new PersonName("Ссанёк")
        );

        Consumer<PersonName> greeting = new Consumer<PersonName>() {
            @Override
            public void accept(PersonName personName) {
                System.out.println("Приветствую " + personName.getName());
            }
        };
        for (PersonName personName : nameList) {
            greeting.accept(personName);
        }
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

        Consumer<PersonName> greeting2 = s -> System.out.println("Приветствую другалёчек " + s.getName());
        for (PersonName personName : nameList) {
            greeting2.accept(personName);
        }
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

        // Задарние 3
        List<Double> numbers1 = Arrays.asList(1.2, 2.2, 3.3, 0.3, 4.4, 3.2, 45.2);

        Function<Double, Long> converter = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        for (Double aDouble : numbers1) {
        System.out.println(converter.apply(aDouble));
        }
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

        Function<Double, Long> converter2 = Math::round;

        for (Double aDouble : numbers1) {
            System.out.println(converter2.apply(aDouble));
        }
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

        // Задарние 4
        Random r = new Random();
        Supplier<Integer> theReturnee = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return r.nextInt(100);
            }
        };
        System.out.println(theReturnee.get());
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

        // Задарние 5
        Function<Integer, Integer> converter3 = Math::round;
        Function<Integer, Double> converter4 = g -> Math.abs(12.5);

        System.out.println(ternaryOperator(thePositivityOfTheNumber, converter3, converter4).apply(-4));
    }
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return h -> condition.test(h) ? ifTrue.apply(h) : ifFalse.apply(h);
    }
}