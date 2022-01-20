import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws ParseException {
        BigDecimal a = new BigDecimal("10.2");
        printaaa(a);
//        System.out.println(String.valueOf(a));
//        System.out.println(solution(new int[]{1,2,3,4}, new int[]{2,1,4,1}));
    }

    private static void printaaa(Number number) {
        System.out.println(String.format("%.2f", number));
    }

    public static boolean solution(int[] A, int[] B) {
        if (A.length != B.length || A.length < 3)
            return false;
        ArrayList<String> edgeList = new ArrayList<String>();
        for (int i = 0; i < A.length; i++) {
            String edge = A[i] + ";" + B[i];
            String reverseEdge = B[i] + ";" + A[i];
            if (validateEdge(edge, reverseEdge, edgeList))
                edgeList.add(edge);
            else
                return false;
        }
        return true;
    }

    static boolean validateEdge(String edge, String reverseEdge, ArrayList<String> edgeList) {
        for (int i = 0; i < edgeList.size(); i++) {
            if (edgeList.get(i).compareTo(edge) == 0 || edgeList.get(i).compareTo(reverseEdge) == 0
                    || edgeList.get(i).substring(0, edgeList.get(i).indexOf(";"))
                    .compareTo(edge.substring(0, edge.indexOf(";"))) == 0
                    || edgeList.get(i).substring(edgeList.get(i).indexOf(";"))
                    .compareTo(edge.substring(edge.indexOf(";"))) == 0)
                return false;
        }
        return true;
    }
}
