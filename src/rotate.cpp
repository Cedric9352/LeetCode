#include <algorithm>
#include <bitset>
#include <cstddef>
#include <iostream>
#include <iterator>
#include <vector>

using std::vector;

class Solution {
public:
  void rotate(vector<int> &nums, int k) {
    auto size = nums.size();
    k = k % size;
    if (k == 0) {
      return;
    }
    // 使用bitset保存该位是否被rotated
    std::bitset<100000> rotated;
    auto o = 0, n = k;
    auto save = nums[n];
    auto replace = nums[o];
    while (rotated.count() != size) {
      if (!rotated.test(n)) {
        // 将该bit置为1
        rotated.set(n);
        // 保存新位置上原有的数
        save = nums[n];
        nums[n] = replace;
        o = n;
        n = (n + k) % size;
        replace = save;
      } else {
        // 前移1位
        n = (n + 1) % size;
        // 在新的n的基础上前移k位
        o = n - k < 0 ? n - k + size : n - k;
        save = nums[n];
        replace = nums[o];
      }
    }
  }
};

int main(int, char **) {
  Solution solution;
  vector<int> nums1{1, 2, 3, 4, 5, 6, 7};
  solution.rotate(nums1, 3);
  std::copy(nums1.begin(), nums1.end(),
            std::ostream_iterator<int>(std::cout, " "));
  std::cout << std::endl;

  vector<int> nums2{-1, -100, 3, 99};
  solution.rotate(nums2, 2);
  std::copy(nums2.begin(), nums2.end(),
            std::ostream_iterator<int>(std::cout, " "));
  std::cout << std::endl;

  vector<int> nums3{1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11, 12, 13, 14, 15,
                    16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                    31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45};
  solution.rotate(nums3, 2);
  std::copy(nums3.begin(), nums3.end(),
            std::ostream_iterator<int>(std::cout, " "));
  std::cout << std::endl;
}