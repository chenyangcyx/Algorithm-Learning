///**
//参考高赞的回答，适当的加了一些解释
//题解思路:通过dfs找到每一个子图的左上角的起始点，然后在每一个元图像上面作画。
//*/
//#include <iostream>
//#include <math.h>
//
//using namespace std;
//
//char str[6][6];
//char map[3001][3001];
//int n;
//
//int IntPow(int x, int n) {
//	int ans = 1;
//	for (int i = 1; i <= n; i++)
//		ans *= x;
//	return ans;
//}
//
//void dfs(int x, int y, int level) {//x,y为子图形的左上角起始点
//	if (level == 1) {//搜索到了基础图形级别
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				map[x + i][y + j] = str[i][j];
//			}
//		}
//		return;
//	}
//	int Size = IntPow(n, level - 1);
//	for (int i = 0; i < n; i++) {//搜索每一个位置对应的缩放的位置
//		for (int j = 0; j < n; j++) {
//			if (str[i][j] != ' ')
//				dfs(x + i * Size, y + j * Size, level - 1);
//		}
//	}
//
//}
////
////void dfs1(int m, int x, int y) {
////	if (m == 1) {
////		for (int i = 0; i < n; i++)
////			for (int j = 0; j < n; j++)
////				map[x + i][y + j] = str[i][j];
////		return;
////	}
////	int size = (int)pow(n * 1.0, m - 1);
////	for (int i = 0; i < n; i++) {
////		for (int j = 0; j < n; j++) {
////			if (str[i][j] != ' ')
////				dfs1(m - 1, x + i * size, y + j * size);
////		}
////	}
////}
//
//int main()
//{
//	int m;
//	while (cin >> n) {
//		if (n == 0)break;
//		getchar();
//		for (int i = 0; i < n; i++) {
//			cin.getline(str[i], 6);
//		}
//		int m;
//		cin >> m;
//		int size = (int)pow(n * 1.0, m);
//		for (int i = 0; i < size; i++) {
//			for (int j = 0; j < size; j++)
//				map[i][j] = ' ';
//			map[i][size] = '\0';
//		}
//		dfs(0, 0, m);
//		for (int i = 0; i < size; i++) {
//			cout << map[i] << endl;
//		}
//	}
//	return 0;
//}
//
