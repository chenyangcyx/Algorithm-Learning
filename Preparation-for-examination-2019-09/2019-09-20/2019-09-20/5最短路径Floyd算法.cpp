//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
//#include <memory.h>
//#define max_n 1000
//#define INF -1
//
//int dis[max_n][max_n];
//
//int main()
//{
//	int n, m;
//	while (scanf("%d %d",&n,&m)!=EOF&&n!=0&&m!=0)
//	{
//		memset(dis, INF, sizeof(dis));
//		//自己和自己的距离为0
//		for (int i = 1; i <= n; i++)
//			dis[i][i] = 0;
//		int a, b, c;
//		for (int i = 1; i <= m; i++)
//		{
//			scanf("%d %d %d", &a, &b, &c);
//			dis[a][b] = dis[b][a] = c;
//		}
//		for(int k=1;k<=n;k++)
//			for(int i=1;i<=n;i++)
//				for (int j = 1; j <= n; j++)
//				{
//					if (dis[i][k] == INF || dis[k][j] == INF)
//						continue;
//					if (dis[i][j] == INF || dis[i][k] + dis[k][j] < dis[i][j])
//						dis[i][j] = dis[i][k] + dis[k][j];
//				}
//		printf("%d\n", dis[1][n]);
//	}
//	return 0;
//}