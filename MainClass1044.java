//这题掌握不了就算了

//暴力破解 超时
class Solution {
    public String longestDupSubstring(String s) {
      
      String result = "";

      int length = s.length();
      if (length <= 1) {
          return result;
      }
      for(int i = length - 1; i >= 1; i--) {
          List<String> subStrs = new ArrayList<String>();
          int subLength = i;
          for (int j = 0; j <= length - subLength; j++) {
              String subStr = s.substring(j, j + subLength);
              if (subStrs.contains(subStr)) {
                  result = subStr;
                  break;
              } else {
                  subStrs.add(subStr);
              }
          }
          if (!"".equals(result)) {
              break;
          }
      }
      return result;
    }
}
