//官方题解 方法一
//[a-zA-Z] == 所有大小写字母中的任意一个 
//[0-9A-Za-z] == 任意一个字母或者数字
//X{n,m} X至少n次，且不超过m次
//x{n} X恰好n次
import java.util.regex.Pattern;
class Solution {
  String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
  Pattern pattenIPv4 =
          Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

  String chunkIPv6 = "([0-9a-fA-F]{1,4})";
  Pattern pattenIPv6 =
          Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

  public String validIPAddress(String IP) {
    if (IP.contains(".")) {
      return (pattenIPv4.matcher(IP).matches()) ? "IPv4" : "Neither";
    }
    else if (IP.contains(":")) {
      return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
    }
    return "Neither";
  }
}

//官方题解 方法二
class Solution {
    public String validateIPv4(String IP) {
        String[] nums = IP.split("\\.", -1);
        for (String x : nums) {
            // Validate integer in range (0, 255):
            // 1. length of chunk is between 1 and 3
            if (x.length() == 0 || x.length() > 3) return "Neither";
            // 2. no extra leading zeros
            if (x.charAt(0) == '0' && x.length() != 1) return "Neither";
            // 3. only digits are allowed
            for (char ch : x.toCharArray()) {
                if (! Character.isDigit(ch)) return "Neither";
            }
            // 4. less than 255
            if (Integer.parseInt(x) > 255) return "Neither";
        }
        return "IPv4";
    }

    public String validateIPv6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            // Validate hexadecimal in range (0, 2**16):
            // 1. at least one and not more than 4 hexdigits in one chunk
            if (x.length() == 0 || x.length() > 4) return "Neither";
            // 2. only hexdigits are allowed: 0-9, a-f, A-F
            for (Character ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }

    public String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        }
        else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6(IP);
        }
        else return "Neither";
    }
}


