//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
//#define max_N 1000
//
//int Tree[max_N];
//int sum[max_N];
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
//	while (scanf("%d",&n)!=EOF)
//	{
//		for (int i = 0; i < max_N; i++)
//		{
//			Tree[i] = -1;
//			sum[i] = 1;
//		}
//		int input_n = n;
//		while (input_n--)
//		{
//			int a, b;
//			scanf("%d %d", &a, &b);
//			a = FindRoot(a);
//			b = FindRoot(b);
// 			if (a != b)
//			{
//				Tree[a] = b;
//				sum[b] += sum[a];
//			}
//		}
//		int ans = 1;
//		for (int i = 1; i <= max_N; i++)
//			if (sum[i] > ans && Tree[i] == -1)
//				ans = sum[i];
//		printf("%d\n", ans);
//	}
//	return 0;
//}