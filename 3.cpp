#include <sstream>
#include <algorithm>
#include <vector>
#include <iostream>
#include <string>
#include <ctype.h>
#include <unordered_set>
#include <cassert>
using namespace std;


class Solution {
    public:
        int lengthOfLongestSubstring(string s) {
            if(s.size() == 0) return 0;
            unordered_set<char> lookup;
            int maxStr = 0;
            int left = 0;
            for(int i = 0; i < s.size(); i++){
                //lookup.find() 查找对应元素，成功返回对应的迭代器，失败返回最后一个元素迭代器（即 lookup.end() ）
                //lookup.end() 大多数人认为是最后添加进去的元素对应的迭代器，其实不然，是最后添加进去的元素对应的迭代器的下一个（最后一个元素对应的迭代器）
                while (lookup.find(s[i]) != lookup.end()){
                    lookup.erase(s[left]);
                    left ++;
                }
                maxStr = max(maxStr,i-left+1);
                lookup.insert(s[i]);
            }
            return maxStr;

        }
};


string stringToString(string input) {
    assert(input.length() >= 2);
    string result;
    for (int i = 1; i < input.length() -1; i++) {
        char currentChar = input[i];
        if (input[i] == '\\') {
            char nextChar = input[i+1];
            switch (nextChar) {
                case '\"': result.push_back('\"'); break;
                case '/' : result.push_back('/'); break;
                case '\\': result.push_back('\\'); break;
                case 'b' : result.push_back('\b'); break;
                case 'f' : result.push_back('\f'); break;
                case 'r' : result.push_back('\r'); break;
                case 'n' : result.push_back('\n'); break;
                case 't' : result.push_back('\t'); break;
                default: break;
            }
            i++;
        } else {
            result.push_back(currentChar);
        }
    }
    return result;
}

int main() {
    string line;
    while (getline(cin, line)) {
        string s = stringToString(line);

        int ret = Solution().lengthOfLongestSubstring(s);

        string out = to_string(ret);
        cout << out << endl;
    }
    return 0;
}
