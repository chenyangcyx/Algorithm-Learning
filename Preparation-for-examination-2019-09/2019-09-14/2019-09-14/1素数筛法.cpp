//#include <stdio.h>
//#include <memory.h>
//
//bool mark[10001];
//int prime[10001];
//int primeSize = 0;
//
////初始化所有素数
//void init()
//{
//	for (int i = 2; i < 10001; i++)
//	{
//		if (mark[i])
//			continue;
//		prime[primeSize++] = i;
//		for (int j = i * i; j < 10001; j += i)
//			mark[j] = true;
//	}
//}
//
//int main()
//{
//	init();
//	for (int i = 0; i < primeSize; i++)
//		printf("%d\n", prime[i]);
//	return 0;
//}