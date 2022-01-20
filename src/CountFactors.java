import java.util.*;
import java.util.stream.Collectors;

public class CountFactors {
    public static void main(String[] args) {
        Integer[] a = {1,2,3,4,5,1};
//        Map<Object, Long> map = Arrays.asList(a).stream().collect(
//                Collectors.groupingBy(c -> c, Collectors.counting())
//        );
//        map.forEach((k, v) -> System.out.println(k + " / " + v));
        List<Integer> input = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584,
                4181, 6765);
        final Map<Integer, Integer> result = new HashMap<>();
        input.forEach(in -> result.merge(in, 1, Integer::sum));
        result.forEach((k, v) -> System.out.println(k + " / " + v));
    }

    public int solution(Integer[] a) {
        //if snt => 2
        Map<Object, Long> map = Arrays.asList(a).stream().collect(
                Collectors.groupingBy(c -> c, Collectors.counting())
        );
        map.forEach((k, v) -> System.out.println(k + " / " + v));
        return 1;
    }
}
