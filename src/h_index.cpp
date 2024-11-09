#include <algorithm>
#include <bitset>
#include <cstddef>
#include <iostream>
#include <iterator>
#include <vector>

using std::vector;

class Solution {
public:
  int hIndex(vector<int> &citations) {
    int n = citations.size(), total = 0;
    vector<int> counter(n + 1, 0);
    for (auto i = 0; i < n; ++i) {
      if (citations[i] >= n) {
        // 大于n的单独处理
        counter[n]++;
      } else {
        // 统计等于这个引用数的有几个
        counter[citations[i]]++;
      }
    }
    // 倒序求和，如果sum大于下标，证明已经有大于下标个数的引用
    for (auto i = n; i >= 0; --i) {
      total += counter[i];
      if (total >= i) {
        return i;
      }
    }
    return 0;
  }
};

int main(int, char **) {
  Solution solution;
  vector<int> citations1{3, 0, 6, 1, 5};
  std::cout << solution.hIndex(citations1) << std::endl;
  vector<int> citations2{1, 3, 1};
  std::cout << solution.hIndex(citations2) << std::endl;
  return 0;
}