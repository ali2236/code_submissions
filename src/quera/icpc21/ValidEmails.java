package quera.icpc21;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ValidEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<String> emails = new HashSet<>();
        ValidEmails c = new ValidEmails();
        for (int i = 0; i < n; i++) {
            String email = scanner.next();
            String normalized = c.validate(email);
            if(normalized!=null){
                emails.add(normalized);
            }
        }
        System.out.println(emails.size());
    }

    String validate(String email) {
        StringBuilder str = new StringBuilder();
        char last = 0;
        int l = email.length();
        for (int i = 0; i < l; i++) {
            char c = email.charAt(i);
            if(i==0 && c=='.'){
                return null;
            } else if(c=='.' && last=='.'){
                return null;
            } else if(c=='@'){
                if(last=='.') return null;
                if(str.length()<6 || str.length() > 30) return null;
                str.append(c);
                StringBuilder domain = validateDomain(email.substring(i+1));
                if(domain!=null) {
                    return str.append(domain).toString();
                } else {
                    return null;
                }
            } else if(isValidUsernameChar(c)){
                if(c!='.') str.append(Character.toLowerCase(c));
            } else {
                return null;
            }
            last = c;
        }
        return null;
    }

    StringBuilder validateDomain(String domain){
        StringBuilder str = new StringBuilder();
        char last = 0;
        int l = domain.length();
        if(l<3 || l>30) return null;
        for (int i = 0; i < l; i++) {
            char c = domain.charAt(i);
            if(i==0 && c=='.'){
                return null;
            } else if(i==l-1 && c=='.'){
                return null;
            } else if(c=='.' && last=='.'){
                return null;
            } if(isValidDomainNameChar(c)){
                str.append(Character.toLowerCase(c));
            } else if(c=='.'){
                //str.append(c);
            } else {
                return null;
            }
            last = c;
        }
        return str;
    }

    boolean isValidUsernameChar(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '1' && c <= '9') || c == '.' || c == '_';
    }

    boolean isValidDomainNameChar(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '1' && c <= '9') || c=='-';
    }
}
