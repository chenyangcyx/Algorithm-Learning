//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
//#include <memory.h>
//#define max_N 100
//
//int Tree[max_N];
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
//	int n, m;
//	while (scanf("%d %d", &n, &m) != EOF)
//	{
//		memset(Tree, -1, sizeof(Tree));
//		int a, b;
//		while (m--)
//		{
//			scanf("%d %d", &a, &b);
//			a = FindRoot(a);
//			b = FindRoot(b);
//			if (a != b)
//				Tree[a] = b;
//		}
//		int ans = 0;
//		for (int i = 1; i <= n; i++)
//			if (Tree[i] == -1)
//				ans++;
//		printf("%d\n", ans - 1);
//	}
//	return 0;
//}