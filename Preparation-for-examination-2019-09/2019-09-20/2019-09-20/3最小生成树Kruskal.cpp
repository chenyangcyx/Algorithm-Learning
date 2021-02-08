//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
//#include <algorithm>
//using namespace std;
//#define max_n 10000
//
//struct Road
//{
//	int a, b;
//	int length;
//
//	bool operator <(const Road& r) const
//	{
//		return length < r.length;
//	}
//}road[max_n];
//
//int Tree[max_n];
//
//int FindRoot(int x)
//{
//	if (Tree[x] == -1) return x;
//	int tmp = FindRoot(Tree[x]);
//	Tree[x] = tmp;
//	return tmp;
//}
//
//int main()
//{
//	int n;
//	while (scanf("%d", &n) != EOF && n != 0)
//	{
//		memset(Tree, -1, sizeof(Tree));
//		for (int i = 1; i <= n * (n - 1) / 2; i++)
//			scanf("%d %d %d", &road[i].a, &road[i].b, &road[i].length);
//
//		sort(road + 1, road + 1 + n * (n - 1) / 2);
//		int ans = 0;
//		for (int i = 1; i <= n * (n - 1) / 2; i++)
//		{
//			//Ð´·¨¶þ
//			int a = road[i].a;
//			int b = road[i].b;
//			a = FindRoot(a);
//			b = FindRoot(b);
//			if (a != b)
//			{
//				Tree[a] = b;
//				ans += road[i].length;
//			}
//		}
//		printf("%d\n", ans);
//	}
//	return 0;
//}