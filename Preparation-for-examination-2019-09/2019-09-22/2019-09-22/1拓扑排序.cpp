#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <memory>
#include <vector>
#include <queue>
using namespace std;
#define max_n 1000

vector<int> relations[max_n];
queue<int> tp_sort;
int rudu[max_n];		//每个点的入度

int main()
{
	int n, m;
	while (scanf("%d %d", &n, &m) != EOF && n != 0 && m != 0)
	{
		//初始化数组
		memset(rudu, 0, sizeof(rudu));
		while (!tp_sort.empty()) tp_sort.pop();
		for (int i = 0; i < n; i++) relations[i].clear();
		//输入关系
		while (m--)
		{
			int a, b;
			scanf("%d %d", &a, &b);
			rudu[b]++;
			relations[a].push_back(b);
		}
		//开始判断，先将入度为0的点加入
		for (int i = 0; i < n; i++)
			if (rudu[i] == 0)
				tp_sort.push(i);
		int cnt = 0;		//计数器，用于累加已经确定的结点的个数
		while (!tp_sort.empty())
		{
			int p = tp_sort.front();
			tp_sort.pop();
			cnt++;			//确定的点的个数+1
			//从改点出发，查看其出发的边的弧尾结点
			//同时，去除该条边
			for (int i = 0; i < relations[p].size(); i++)
			{
				rudu[relations[p][i]]--;
				if (rudu[relations[p][i]] == 0)
					tp_sort.push(relations[p][i]);
			}
		}
		if (cnt == n)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}