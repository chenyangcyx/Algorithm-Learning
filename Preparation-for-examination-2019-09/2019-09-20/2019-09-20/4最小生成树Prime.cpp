//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
//#include <memory.h>
//#include <limits.h>
//#define max_n 1000
//#define INF -1
//
//int graph[max_n][max_n];
//bool visit[max_n];
//int dis[max_n];
//
//int main()
//{
//	int n;
//	while (scanf("%d", &n) != EOF && n != 0)
//	{
//		memset(graph, INF, sizeof(graph));
//		memset(visit, false, sizeof(visit));
//		memset(dis, INF, sizeof(dis));
//		int a, b, c;
//		for (int i = 1; i <= n * (n - 1) / 2; i++)
//		{
//			scanf("%d %d %d", &a, &b, &c);
//			graph[a][b] = graph[b][a] = c;
//		}
//		int ans = 0;
//		//初始化距离数组
//		for (int i = 1; i <= n; i++)
//			dis[i] = graph[1][i];
//		//开始遍历每一个点
//		visit[1] = true;
//		for (int i = 1; i < n; i++)
//		{
//			//找到最小距离的点
//			int min_length = INT_MAX;
//			int min = -1;
//			for (int j = 1; j <= n; j++)
//			{
//				if (!visit[j] && dis[j] < min_length)
//				{
//					min_length = dis[j];
//					min = j;
//				}
//			}
//			//更新标志，将该点加入集合
//			visit[min] = true;
//			ans += min_length;
//			//更新距离dis矩阵
//			for (int j = 1; j <= n; j++)
//				if (!visit[j] && dis[j] > graph[min][j])
//					dis[j] = graph[min][j];
//		}
//		printf("%d\n", ans);
//	}
//	return 0;
//}