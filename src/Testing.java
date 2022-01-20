import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
//        String
    }

    static void remove(List<String> strs) {
        for (int i = 0; i < strs.size(); i++) {
            if (strs.get(i).equals("B")) {
                strs.remove(i);
            }
        }
    }

//    public static void main(String[] args) {
//        int[] intArray = {5};
//
//        print(intArray);
//
//        print(intArray);
////        int i = 5;
////        print(i);
////        print(i);
//    }
//
//
//    private static void print(int i) {
//        i += 5;
//        System.out.println("i=" + i);
//    }
//
//    private static void print(int[] i) {
//
//        i[0] += 5;
//
//        System.out.println(i[0]);
//
//    }
}
