#include <algorithm>
#include <bitset>
#include <cstddef>
#include <iostream>
#include <iterator>
#include <vector>

using std::vector;

class Solution {
public:
  bool canJump(vector<int> &nums) {
    // 贪心算法
    // maxReach表示能达到的最远的位置
    int maxReach = 0;
    for (auto i = 0; i < nums.size(); ++i) {
      // 如果最远的位置小于当前位置，说明连当前位置都到不了
      if (i > maxReach) {
        return false;
      }
      maxReach = std::max(maxReach, i + nums[i]);
    }
    return true;
  }
};

int main(int, char **) {
  Solution solution;
  vector<int> nums1{2, 3, 1, 1, 4};
  std::cout << solution.canJump(nums1) << std::endl;
  vector<int> nums2{3, 2, 1, 0, 4};
  std::cout << solution.canJump(nums2) << std::endl;
  return 0;
}