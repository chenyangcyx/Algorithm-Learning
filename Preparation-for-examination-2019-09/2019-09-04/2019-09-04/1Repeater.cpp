///**
//�ο����޵Ļش��ʵ��ļ���һЩ����
//���˼·:ͨ��dfs�ҵ�ÿһ����ͼ�����Ͻǵ���ʼ�㣬Ȼ����ÿһ��Ԫͼ������������
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
//void dfs(int x, int y, int level) {//x,yΪ��ͼ�ε����Ͻ���ʼ��
//	if (level == 1) {//�������˻���ͼ�μ���
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				map[x + i][y + j] = str[i][j];
//			}
//		}
//		return;
//	}
//	int Size = IntPow(n, level - 1);
//	for (int i = 0; i < n; i++) {//����ÿһ��λ�ö�Ӧ�����ŵ�λ��
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
