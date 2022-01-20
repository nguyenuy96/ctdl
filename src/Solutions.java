import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solutions {
    public static void main(String[] args) {
//        System.out.println(solution(new int[] {3,4,3,0,2,2,3,0,0}));
//        System.out.println(solution(new int[] {4,2,0}));
//        System.out.println(solution(new int[] {4,4,3,3,1,0}));
//        System.out.println(solution("my.song.mp3 11b" +
//                "\ngreateSong.flac 100b" +
//                "\nnot3.txt 5b" +
//                "\nvideo.mp4 200b" +
//                "\ngame.exe 100b" +
//                "\nmov!e.mkv 10000b"));
        System.out.println(solution(5, 8));
        System.out.println(solution(4, 10));
        System.out.println(solution(2, 4));
        System.out.println(solution(10, 5));
//        List<Integer> is = new ArrayList<>();
//        is.get(0) += 5;
    }

    static int solution(int N, int K) {

        if (K < N) return 1;

        int[] leftWater = {0};

        List<Integer> glasses = IntStream.range(0, N).map(capacityOfClass -> N - capacityOfClass).filter(descCapacityOfClass -> {
            if ((descCapacityOfClass + leftWater[0]) <= K) {
                leftWater[0] += descCapacityOfClass;
                return true;
            }
            return false;
        }).boxed().collect(Collectors.toList());

        Integer numberOfGlasses = glasses.size();

        if (leftWater[0] == K) return numberOfGlasses;

        if (leftWater[0] < K && numberOfGlasses == N)
            return -1;
        return numberOfGlasses + 1;
    }

    public static int solution1111(String s) {
        int strLen = s.length();
        if (strLen <= 1) {
            return strLen;
        }
        List<String> subList = new ArrayList<>();
        for (int i = 0; i < strLen; i++) {
            for (int j = i + 1; j <= strLen; j++) {
                subList.add(s.substring(i, j));
            }
        }
        List<String> uniqueList = findUniqueString(subList, s);
        if (uniqueList.size() > 0) {
            Collections.sort(uniqueList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });
            return uniqueList.get(0).length();
        } else {
            return 0;
        }
    }

    public static List<String> findUniqueString(List<String> stringList, String input) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String value = stringList.get(i);
            if (input.indexOf(value) == input.lastIndexOf(value)) {
                result.add(value);
            }
        }
        return result;
    }

    public static int solution(int[] ranks) {
        // write your code in Java SE 8
        List<Integer> list = IntStream.of(ranks).boxed().sorted().collect(Collectors.toList());
        int currentRank = list.get(0);
        int countCurrRank = 1;
        int count = 0;
        for (int i = 1; i < list.size(); i++) {
            if (currentRank == list.get(i)) {
                countCurrRank++;
            } else if (list.get(i) - currentRank == 1) {
                count += countCurrRank;
                currentRank = list.get(i);
                countCurrRank = 1;
            } else {
                currentRank = list.get(i);
                countCurrRank = 1;
            }
        }

        return count;
    }

    public static String solution(String S) {
        // write your code in Java SE 8

        String[] strs = S.split("\n");
        long musicCount = 0, imageCount = 0, movieCount = 0, otherCount = 0;
        for (String str : strs) {

            String[] fileInfo = str.split(" ");
            String fileName = fileInfo[0].trim();

            long fileSize = Long.parseLong(fileInfo[1].substring(0, fileInfo[1].length() - 1));

            if (fileName.endsWith(".mp3") || fileName.endsWith(".aac") || fileName.endsWith(".flac")) {
                musicCount += fileSize;
            } else if (fileName.endsWith(".jpg") || fileName.endsWith(".bmp") || fileName.endsWith(".gif")) {
                imageCount += fileSize;
            } else if (fileName.endsWith(".mp4") || fileName.endsWith(".avi") || fileName.endsWith(".mkv")) {
                movieCount += fileSize;
            } else {
                otherCount += fileSize;
            }
        }
        return "music" + " " + musicCount + "b" + "\n" +
                "images" + " " + imageCount + "b" + "\n" +
                "movies" + " " + movieCount + "b" + "\n" +
                "other" + " " + otherCount + "b";
    }

    public static int solution(String S, String T) {
        int first = convertToNumber(S);
        int last = convertToNumber(T);
        int result = 0;
        for (int i = first; i <= last; i++) {
            String time = convertToTime(i);
            int count = countDigits(time);
            if (count <= 2) {
                result++;
            }
        }
        return result;
    }
    public static int convertToNumber(String time) {
        String[] strings = time.split(":");
        return Integer.parseInt(strings[0]) * 3600 + Integer.parseInt(strings[1]) * 60 + Integer.parseInt(strings[2]);
    }
    public static String convertToTime(int secs) {
        return String.format("%02d:%02d:%02d", secs / 3600, (secs % 3600) / 60, secs % 60);
    }
    public static int countDigits(String string) {
        String remove = string.replace(":", "");
        String[] strings = remove.split("");
        Set<Integer> set = new HashSet<>();
        for (String s : strings) {
            set.add(Integer.valueOf(s));
        }
        return set.size();
    }

    public static boolean solution(int[] A, int[] B) {
        if (A.length != B.length || A.length < 2) {
            return false;
        }
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            listA.add(A[i]);
            listB.add(B[i]);
        }
        Integer firstIndex = null;
        ArrayList<Integer> arrayList = new ArrayList<Integer>() {{
            add(listA.get(0));
            add(listB.get(0));
        }};
        ArrayList<Integer> indexList = new  ArrayList<Integer>();
        for (int i = 0; i < A.length - 1; i++) {
            int pointB = listB.get(i);
            int possiblePoint;
            if (firstIndex != null) {
                possiblePoint = listA.indexOf(firstIndex);
            } else {
                possiblePoint = listA.indexOf(pointB);
            }
            if (possiblePoint > -1) {
                if (indexList.size() > 0 && indexList.contains(possiblePoint)) {
                    break;
                }
                arrayList.add(listA.get(possiblePoint));
                arrayList.add(listB.get(possiblePoint));
                firstIndex = listB.get(possiblePoint);
                indexList.add(possiblePoint);
            } else {
                break;
            }
        }
        if (arrayList.size() != listA.size() + listB.size()) {
            return false;
        }
        return Objects.equals(arrayList.get(0), arrayList.get(arrayList.size() - 1));
    }

}
