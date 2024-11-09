#include <algorithm>
#include <bitset>
#include <cstddef>
#include <iostream>
#include <iterator>
#include <vector>

using std::vector;

class Solution {
public:
  int jump(vector<int> &nums) {
    auto size = nums.size();
    if (size == 1) {
      return 0;
    }
    // maxReach表示能达到的最远的位置
    auto bound = 0, maxReach = 0, i = 0;
    auto minStep = 0;
    while (i <= bound) {
      maxReach = std::max(maxReach, i + nums[i]);
      // 剪枝，如果已经到了，那直接退出
      if (maxReach >= size - 1) {
        minStep++;
        break;
      }
      // 贪心算法，到每轮的边界后，取最大的作为下一轮的边界
      else if (i == bound) {
        bound = maxReach;
        minStep++;
      }
      ++i;
    }
    return minStep;
  }
};

int main(int, char **) {
  Solution solution;
  vector<int> nums1{2, 3, 1, 1, 4};
  std::cout << solution.jump(nums1) << std::endl;
  vector<int> nums2{2, 3, 0, 1, 4};
  std::cout << solution.jump(nums2) << std::endl;
  return 0;
}