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
//		//��ʼ���ڽ�����
//		for (int i = 1; i <= n; i++)
//			edge[i].clear();
//		//��ʼ��mark��dis����
//		memset(mark, false, sizeof(mark));
//		memset(dis, INF, sizeof(dis));
//		//����ߵ���Ϣ
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
//			//����Ϊ����ͼ�����������㶼��Ҫ����
//		}
//		//Ĭ��ѡ���1��Ϊ���
//		int newP = 1;	//�¼����Ϊ1
//		dis[newP] = 0;		//�Լ����Լ��ľ���Ϊ0
//		mark[newP] = true;	//���1�Ѿ����뼯��
//		for (int i = 1; i < n; i++)		//��������n-1���㣬����ѭ��n-1��
//		{
//			//�����¼���ĵ����Χ�ٽ��ı�
//			for (int j = 0; j < edge[newP].size(); j++)
//			{
//				int t = edge[newP][j].next;		//�ñߵ���һ�����
//				int c = edge[newP][j].c;		//�ñߵ�Ȩֵ
//				if (mark[t])
//					continue;		//��һ������Ѿ��ڼ����У�������
//				//����ýڵ��в��ɴ���߸ý����¼���Ľ�㾭��һ���ߵ���������������
//				//����¸þ���
//				if (dis[t] == INF || dis[t] > dis[newP] + c)
//					dis[t] = dis[newP] + c;
//			}
//			//����Сֵ
//			int min = INT_MAX;
//			//�������н��
//			for (int j = 1; j <= n; j++)
//			{
//				if (mark[j])
//					continue;		//�ý���Ѿ������˼���
//				if (dis[j] == INF)
//					continue;		//���ý���Բ��ɴ������
//				if (dis[j] < min)
//				{
//					min = dis[j];
//					newP = j;		//�¼���Ľ��
//				}
//			}
//			mark[newP] = true;		//���õ���뼯��
//		}
//		printf("%d\n", dis[n]);
//	}
//	return 0;
//}