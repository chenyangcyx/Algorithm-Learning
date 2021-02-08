//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
//#include <memory.h>
//#include <limits.h>
//#include <vector>
//using namespace std;
//#define max_n 1000
//#define INF -1
//
//struct E
//{
//	int next;
//	int c;
//};
//
//vector<E> edge[max_n];
//bool mark[max_n];
//int dis[max_n];
//
//int main()
//{
//	int n, m;
//	while (scanf("%d %d", &n, &m) != EOF && n != 0 && m != 0)
//	{
//		//初始化邻接链表
//		for (int i = 1; i <= n; i++)
//			edge[i].clear();
//		//初始化mark和dis矩阵
//		memset(mark, false, sizeof(mark));
//		memset(dis, INF, sizeof(dis));
//		//输入边的信息
//		int input_m = m;
//		while (input_m--)
//		{
//			int a, b, c;
//			scanf("%d %d %d", &a, &b, &c);
//			E tmp;
//			tmp.c = c;
//			tmp.next = b;
//			edge[a].push_back(tmp);
//			tmp.next = a;
//			edge[b].push_back(tmp);
//			//由于为无向图，所以两个点都需要加入
//		}
//		//默认选择点1作为起点
//		int newP = 1;	//新加入点为1
//		dis[newP] = 0;		//自己与自己的距离为0
//		mark[newP] = true;	//结点1已经加入集合
//		for (int i = 1; i < n; i++)		//找其他的n-1个点，所以循环n-1次
//		{
//			//遍历新加入的点的周围临近的边
//			for (int j = 0; j < edge[newP].size(); j++)
//			{
//				int t = edge[newP][j].next;		//该边的另一个结点
//				int c = edge[newP][j].c;		//该边的权值
//				if (mark[t])
//					continue;		//另一个结点已经在集合中，则跳过
//				//如果该节点尚不可达，或者该结点从新加入的结点经过一条边到达比以往距离更短
//				//则更新该距离
//				if (dis[t] == INF || dis[t] > dis[newP] + c)
//					dis[t] = dis[newP] + c;
//			}
//			//找最小值
//			int min = INT_MAX;
//			//遍历所有结点
//			for (int j = 1; j <= n; j++)
//			{
//				if (mark[j])
//					continue;		//该结点已经加入了集合
//				if (dis[j] == INF)
//					continue;		//若该结点仍不可达，则跳过
//				if (dis[j] < min)
//				{
//					min = dis[j];
//					newP = j;		//新加入的结点
//				}
//			}
//			mark[newP] = true;		//将该点加入集合
//		}
//		printf("%d\n", dis[n]);
//	}
//	return 0;
//}