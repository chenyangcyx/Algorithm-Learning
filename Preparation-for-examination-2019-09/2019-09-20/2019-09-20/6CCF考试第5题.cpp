#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <memory.h>
#include <limits.h>
#include <algorithm>
using namespace std;
#define INF -1
#define max_n 1000

int dis[max_n][max_n];
bool if_imp[max_n];
bool if_in[max_n];
int dist[max_n];
struct Road
{
	int a, b;
	int c;
	bool operator <(const Road& t)const
	{
		return c < t.c;
	}
}road[max_n];

int main()
{
	int n, m, p;
	while (scanf("%d %d %d", &n, &m, &p) != EOF && n != 0)
	{
		memset(dis, INF, sizeof(dis));
		memset(if_imp, false, sizeof(if_imp));
		memset(if_in, false, sizeof(if_in));
		memset(dist, INF, sizeof(dist));
		int po;
		for (int i = 1; i <= m; i++)
		{
			scanf("%d", &po);
			if_imp[po] = true;
		}
		int a, b, c;
		for (int i = 1; i <= n - 1; i++)
		{
			scanf("%d %d %d", &a, &b, &c);
			dis[a][b] = dis[b][a] = c;
			road[i].a = a;
			road[i].b = b;
			road[i].c = c;
		}
		//求两点之间的最短路径
		for(int k=1;k<=n;k++)
			for(int i=1;i<=n;i++)
				for (int j = 1; j <= n; j++)
				{
					if (dis[i][k] == INF || dis[k][j] == INF)
						continue;
					if (dis[i][j] == INF || dis[i][k] + dis[k][j] < dis[i][j])
						dis[i][j] = dis[i][k] + dis[k][j];
				}
		//按照权值进行排序
		sort(road + 1, road + n - 1);
		//找出起始点
		int st;
		for(int i=1;i<=n-1;i++)
			if (if_imp[road[i].a])
			{
				st = road[i].a;
				if_in[st] = true;
				break;
			}
		for (int i = 1; i <= n - 1; i++)
			dist[i] = dis[st][i];
		//开始构造
		int sum = 0;
		int already_in = 1;
		for (int i = 1; i < n; i++)
		{
			//找到最小距离点
			int min_length = INT_MAX;
			int min;
			for (int j = 1; j <= n; j++)
				if (!if_in[j] && dist[j] < min_length && if_imp[j])
				{
					min_length = dist[j];
					min = j;
				}
			//更新标志
			if_in[min] = true;
			sum += min_length;
			already_in++;
			if (already_in == p)
				break;
			//更新dist矩阵
			for (int j = 1; j <= n; j++)
			{
				if (!if_in[j] && dist[j] > dis[min][j] && if_imp[j])
					dist[j] = dis[min][j];
			}
		}
		printf("%d\n", sum);
	}
	return 0;
}