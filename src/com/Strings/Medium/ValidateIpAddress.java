package com.Strings.Medium;

public class ValidateIpAddress {
    public static void main(String[] args) {
        String s1 = "172.16.254.1";
        String s2 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String s3 = "256.256.256.256";

        String result = solve(s3);
        System.out.println(result);
    }

    private static String solve(String str) {
        if (str.length() == 0) return "Neither";
        if (str.contains(".")) return validateIpV4(str);
        if (str.contains(":")) return validateIpV6(str);
        return "Neither";
    }

    private static String validateIpV6(String str) {
        if(str.charAt(0) == ':' || str.charAt(str.length()-1) == ':') return "Neither";

        String[] parts = str.split(":");
        if(parts.length != 8) return "Neither";

        for(String part: parts){
            if(part.length() == 0 || part.length() > 4) return "Neither";

            for(char ch: part.toLowerCase().toCharArray())
                if((ch < '0' || ch > '9') && (ch != 'a' && ch != 'b' && ch != 'c' && ch != 'd' && ch != 'e' && ch != 'f'))
                    return "Neither";
        }
        return "IPv6";
    }

    private static String validateIpV4(String str) {
        if (str.charAt(0) == '.' || str.charAt(str.length() - 1) == '.') {
            return "Neither";
        }

        String[] parts = str.split("\\.");
        if (parts.length != 4) return "Neither";
        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3 || (part.length() > 1 && part.charAt(0) == '0'))
                return "Neither";

            for (char ch : part.toCharArray())
                if (ch < '0' || ch > '9') return "Neither";

            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return "Neither";
        }
        return "IPv4";
    }
}
