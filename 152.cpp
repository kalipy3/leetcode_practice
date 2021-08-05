
#include <sstream>
#include <algorithm>
#include <vector>
#include <iostream>
#include <string>
#include <ctype.h>
using namespace std;

class Solution {
    public:
        //int maxProduct(vector<int>& nums) {
        //    vector <int> maxF(nums), minF(nums);
        //    for (int i = 1; i < nums.size(); ++i) {
        //        maxF[i] = max(maxF[i - 1] * nums[i], max(nums[i], minF[i - 1] * nums[i]));
        //        minF[i] = min(minF[i - 1] * nums[i], min(nums[i], maxF[i - 1] * nums[i]));
        //    }
        //    return *max_element(maxF.begin(), maxF.end());
        //}
        
        //滚动数组
        int maxProduct(vector<int>& nums) {
            int maxF = nums[0], minF = nums[0], ans = nums[0];
            for (int i = 1; i < nums.size(); ++i) {
                int mx = maxF, mn = minF;
                maxF = max(mx * nums[i], max(nums[i], mn * nums[i]));
                minF = min(mn * nums[i], min(nums[i], mx * nums[i]));
                ans = max(maxF, ans);
            }
            return ans;
        }
};


void trimLeftTrailingSpaces(string &input) {
    input.erase(input.begin(), find_if(input.begin(), input.end(), [](int ch) {
                return !isspace(ch);
                }));
}

void trimRightTrailingSpaces(string &input) {
    input.erase(find_if(input.rbegin(), input.rend(), [](int ch) {
                return !isspace(ch);
                }).base(), input.end());
}

vector<int> stringToIntegerVector(string input) {
    vector<int> output;
    trimLeftTrailingSpaces(input);
    trimRightTrailingSpaces(input);
    input = input.substr(1, input.length() - 2);
    stringstream ss;
    ss.str(input);
    string item;
    char delim = ',';
    while (getline(ss, item, delim)) {
        output.push_back(stoi(item));
    }
    return output;
}

int main() {
    string line;
    while (getline(cin, line)) {
        vector<int> nums = stringToIntegerVector(line);

        int ret = Solution().maxProduct(nums);

        string out = to_string(ret);
        cout << out << endl;
    }
    return 0;
}
