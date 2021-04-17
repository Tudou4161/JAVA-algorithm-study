package chap01;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args) {
        UniqueEmailAddress a = new UniqueEmailAddress();
        String[] emails = {
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"
        };

        System.out.println(a.numUniqueEmails(emails));

    }

    public int numUniqueEmails(String[] emails) {
        //write your code.
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String localName = localName(email);
            String domainName = domainName(email);

            set.add(localName + "@" + domainName);
        }

        for (String s : set) {
            System.out.println("s = " + s);
        }

        return set.size();
    }

    private String localName(String email) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '.') {
                continue;  //출력결과에서 완전히 배제됨. (그냥 지워진다고 보면 됨.)
            }
            if (email.charAt(i) == '+') {
                break;
            }
            if (email.charAt(i) == '@') {
                break;
            }

            String str = String.valueOf(email.charAt(i)); //char 타입을 String 으로 변환
            sb.append(str); // String으로 변환한 원소를 빌더 객체에 담아줌.
        }
        return sb.toString(); // 빌더객체를 String으로 반환.

    }

    private String domainName(String email) {
        return email.substring(email.indexOf("@")+1); //indexOf는 char타입만 취급하나..?
    }
}