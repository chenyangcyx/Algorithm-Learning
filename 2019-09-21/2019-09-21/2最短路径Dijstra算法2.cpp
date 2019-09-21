#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <memory.h>
#include <vector>
using namespace std;
#define max_n 1010
#define INF -1

struct E {
	int next;
	int length;
	int cost;
};

vector<E> edge[max_n];		//�ڽӱ�
int dis[max_n];				//�������
bool mark[max_n];			//�Ƿ��ڼ�����
int money[max_n];			//����

int main()
{
	int n, m;
	int s, t;
	while (scanf("%d %d", &n, &m) != EOF && n != 0 && m != 0)
	{
		//��ʼ���ڽӱ�;���
		memset(dis, INF, sizeof(dis));
		memset(mark, false, sizeof(mark));
		memset(money, 0, sizeof(money));
		for (int i = 1; i <= n; i++)
			edge[i].clear();
		while (m--)
		{
			int a, b, length, cost;
			scanf("%d %d %d %d", &a, &b, &length, &cost);
			E tmp;
			tmp.next = b;
			tmp.length = length;
			tmp.cost = cost;
			edge[a].push_back(tmp);
			tmp.next = a;
			edge[b].push_back(tmp);
		}
		//���������յ�
		scanf("%d %d", &s, &t);
		int newP = s;		//��ʼ��ΪS
		dis[newP] = 0;
		mark[newP] = true;
		//�����������е�
		for (int i = 1; i < n; i++)
		{
			for (int j = 0; j < edge[newP].size(); j++)
			{
				int t = edge[newP][j].next;
				int len = edge[newP][j].length;
				int co = edge[newP][j].cost;
				if (mark[t])
					continue;
				if (dis[t] == INF || dis[t] > dis[newP] + len || dis[t] == dis[newP] + len && money[t] > money[newP] + co)
				{
					dis[t] = dis[newP] + len;
					money[t] = money[newP] + co;
				}
			}
			int min = INT_MAX;
			for (int j = 1; j <= n; j++)
			{
				if (mark[j])
					continue;
				if (dis[j] == INF)
					continue;
				if (dis[j] < min)
				{
					min = dis[j];
					newP = j;
				}
			}
			mark[newP] = true;
		}
		printf("%d %d\n", dis[t], money[t]);
	}
	return 0;
}