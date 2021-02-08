#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <memory>
#include <vector>
#include <queue>
using namespace std;
#define max_n 1000

vector<int> relations[max_n];
queue<int> tp_sort;
int rudu[max_n];		//ÿ��������

int main()
{
	int n, m;
	while (scanf("%d %d", &n, &m) != EOF && n != 0 && m != 0)
	{
		//��ʼ������
		memset(rudu, 0, sizeof(rudu));
		while (!tp_sort.empty()) tp_sort.pop();
		for (int i = 0; i < n; i++) relations[i].clear();
		//�����ϵ
		while (m--)
		{
			int a, b;
			scanf("%d %d", &a, &b);
			rudu[b]++;
			relations[a].push_back(b);
		}
		//��ʼ�жϣ��Ƚ����Ϊ0�ĵ����
		for (int i = 0; i < n; i++)
			if (rudu[i] == 0)
				tp_sort.push(i);
		int cnt = 0;		//�������������ۼ��Ѿ�ȷ���Ľ��ĸ���
		while (!tp_sort.empty())
		{
			int p = tp_sort.front();
			tp_sort.pop();
			cnt++;			//ȷ���ĵ�ĸ���+1
			//�Ӹĵ�������鿴������ıߵĻ�β���
			//ͬʱ��ȥ��������
			for (int i = 0; i < relations[p].size(); i++)
			{
				rudu[relations[p][i]]--;
				if (rudu[relations[p][i]] == 0)
					tp_sort.push(relations[p][i]);
			}
		}
		if (cnt == n)
			printf("YES\n");
		else
			printf("NO\n");
	}
	return 0;
}