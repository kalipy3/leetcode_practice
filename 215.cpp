
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
        int quickSelect(vector<int>& a, int l, int r, int index) {
            int q = randomPartition(a, l, r);
            if (q == index) {
                return a[q];
            } else {
                return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
            }
        }

        inline int randomPartition(vector<int>& a, int l, int r) {
            int i = rand() % (r - l + 1) + l;
            swap(a[i], a[r]);
            return partition(a, l, r);
        }

        inline int partition(vector<int>& a, int l, int r) {
            int x = a[r], i = l - 1;
            for (int j = l; j < r; ++j) {
                if (a[j] <= x) {
                    swap(a[++i], a[j]);
                }
            }
            swap(a[i + 1], a[r]);
            return i + 1;
        }

        int findKthLargest(vector<int>& nums, int k) {
            srand(time(0));
            return quickSelect(nums, 0, nums.size() - 1, nums.size() - k);
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

int stringToInteger(string input) {
    return stoi(input);
}

int main() {
    string line;
    while (getline(cin, line)) {
        vector<int> nums = stringToIntegerVector(line);
        getline(cin, line);
        int k = stringToInteger(line);

        int ret = Solution().findKthLargest(nums, k);

        string out = to_string(ret);
        cout << out << endl;
    }
    return 0;
}
