/*
����˼·:����̰�Ĳ���,������˵ļ���վ��ʼ,ÿ������վ�ӵ����������cmax*davg·��.
����һ��30000��С��flag�����¼�Ƿ����غ�����
*/
#include<cstdio>
#include<algorithm>
using namespace std;

struct sta {
	double pi;
	int di;
	bool operator < (const sta& b) const {
		return pi < b.pi;
	}
}a[501];

int main() {
	int cmax, d, davg, n;
	double sum;
	while (scanf("%d %d %d %d", &cmax, &d, &davg, &n) != EOF) {
		for (int i = 0; i < n; i++) scanf("%lf %d", &a[i].pi, &a[i].di);
		sort(a, a + n);
		//
		sum = 0;//��¼����
		int flag[30001] = { 0 }, max = cmax * davg, tmp, cnt;
		for (int i = 0; i < n; i++) {
			tmp = (a[i].di + max < d ? max : d - a[i].di);    //������յ����<max,ֻ������㹻�ߵ��յ����
			cnt = 0;    //��¼�ж೤������Ҫ�ü���վ����
			for (int j = a[i].di; j < a[i].di + tmp; j++) {
				if (flag[j] == 0) {
					flag[j] = 1;
					cnt++;
				}
			}
			sum += cnt / (davg * 1.0) * a[i].pi;    //�����ڸü���վ�Ļ���
		}
		//check
		int i;
		for (i = 0; i < d; i++) {
			//�е�·��û�б����ǵ�˵���߲�������
			if (flag[i] == 0) {
				printf("The maximum travel distance = %.2lf\n", (double)i);
				break;
			}
		}
		if (i == d) {
			printf("%.2lf\n", sum);
		}
	}
	return 0;
}