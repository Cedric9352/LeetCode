#include <algorithm>
#include <bitset>
#include <cstddef>
#include <iostream>
#include <iterator>
#include <vector>

using std::vector;

class Solution {
public:
  int maxProfit(vector<int> &prices) {
    const auto size = prices.size();
    // dp[i][0]表示在第i天结束时未持有股票的最大利润
    // dp[i][1]表示在第i天结束时持有股票的最大利润
    int dp[size][2];
    dp[0][0] = 0, dp[0][1] = -prices[0];
    // 递归方程
    // 如果第i天结束时未持有股票，可能是
    //   1.前一天结束时持有，并且今天卖了
    //   2.前一天结束时卖了，并且今天没买
    // 如果第i天结束时持有股票，可能是
    //   1.前一天结束时持有，并且今天没卖
    //   2.前一天结束时卖了，并且今天买入
    for (auto i = 1; i < size; ++i) {
      dp[i][0] = std::max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
      dp[i][1] = std::max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[size - 1][0];
  }
};

int main(int, char **) {
  Solution solution;
  vector<int> price1{7, 1, 5, 3, 6, 4};
  std::cout << solution.maxProfit(price1) << std::endl;
  return 0;
}