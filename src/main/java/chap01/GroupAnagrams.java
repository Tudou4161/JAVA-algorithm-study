package chap01;


import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] list = {"eat", "tea", "tan", "ate",
                    "nat", "bat"};
        System.out.println("solve(list) = " + solve(list));
    }

    public static List<List<String>> solve(String[] strs) {
        //1. ds
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        //2. loop
        for (int i = 0; i < strs.length; i++) {

            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);

            String key = String.valueOf(charArr);

            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }

        result.addAll(map.values());

        return result;
    }
}












//    public static List<List<String>> solve(String[] strs) {
//        //1. ds
//        List<List<String>> result = new ArrayList<>();
//        if(strs.length == 0 || strs == null) return result;
//
//        Map<String, List<String>> map = new HashMap<>();
//
//
//        //2. loop
//        for (String s : strs) {
//            System.out.println("s = " + s);
//            char[] charArr = s.toCharArray();
//            Arrays.sort(charArr); // 2-1. sort
//
//            String key = String.valueOf(charArr); //2-2 key settings
//
//            if (map.containsKey(key)) {
//                map.get(key).add(s);
//                //2-3. 키값을 이미 가지고 있다면, 해당 위치의 value 배열에 담는다.
//
//            } else {
//                List<String> list = new ArrayList<>();
//                list.add(s);
//                map.put(key, list);
//                //2-4. 키값을 갖지 않는다면, key와 value를 생성해준다.
//            }
//        }
//
//        result.addAll(map.values());
//        return result;
//    }