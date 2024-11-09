#include <algorithm>
#include <bitset>
#include <cstddef>
#include <iostream>
#include <iterator>
#include <vector>

using std::vector;

class Solution {
public:
  vector<int> productExceptSelf(vector<int> &nums) {
    auto n = nums.size();
    vector<int> res(n, 1);
    for (int i = 1; i < n; ++i) {
      // res的第i个位置表示从0到i-1的前缀积
      res[i] = res[i - 1] * nums[i - 1];
    }
    int save = 1;
    for (int i = n - 2; i >= 0; --i) {
      // nums的第i个位置表示从右开始算起的第n-1到i的后缀积
      int tmp = save;
      save = nums[i];
      nums[i] = tmp * nums[i + 1];
    }
    for (int i = 0; i < n - 1; ++i) {
      // 前缀积在用完后可以被覆盖
      res[i] = res[i] * nums[i];
    }
    return res;
  }
};

int main(int, char **) {
  Solution solution;
  vector<int> nums1{1, 2, 3, 4};
  const vector<int> &res1 = solution.productExceptSelf(nums1);
  std::copy(res1.begin(), res1.end(),
            std::ostream_iterator<int>(std::cout, " "));
  std::cout << std::endl;
  vector<int> nums2{-1, 1, 0, -3, 3};
  const vector<int> &res2 = solution.productExceptSelf(nums2);
  std::copy(res2.begin(), res2.end(),
            std::ostream_iterator<int>(std::cout, " "));
  std::cout << std::endl;
  return 0;
}