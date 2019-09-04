#include<stdio.h>
#include<algorithm>
using namespace std;
typedef struct station {
	double price;
	double dis;
	bool operator <(const station& A) const {
		return dis < A.dis;
	}
}station;
int main() {
	station buf[501];
	int i, j, n;
	double cmax, d, davg, maxdis, ans;
	while (scanf("%lf%lf%lf%d", &cmax, &d, &davg, &n) != EOF) {
		ans = 0;
		maxdis = cmax * davg;
		for (i = 0; i < n; i++)
			scanf("%lf%lf", &buf[i].price, &buf[i].dis);
		buf[n].dis = d;
		sort(buf, buf + n);
		if (buf[0].dis != 0) {
			printf("The maximum travel distance = 0.00\n");
			continue;
		}
		double curpos = 0;
		double curoil = 0;
		for (i = 0; i < n; i++) {
			curpos = buf[i].dis;
			if (curpos + maxdis < buf[i + 1].dis) {
				printf("The maximum travel distance = %.2lf\n", curpos + maxdis);
				break;
			}
			if (i > 0)
				curoil -= (buf[i].dis - buf[i - 1].dis) / davg;
			double curdis = 0;
			bool ischeap = false;
			for (j = i + 1; j < n; j++) {
				curdis = buf[j].dis - buf[i].dis;
				if (curdis > maxdis) break;
				if (buf[j].price < buf[i].price) {
					double temp = (buf[j].dis - buf[i].dis) / davg;
					if (temp > curoil) {
						ans += (temp - curoil) * buf[i].price;
						curoil = temp;
					}
					ischeap = true;
					break;
				}
			}
			if (!ischeap) {
				if (curpos + maxdis >= d) {
					ans += ((d - curpos) / davg - curoil) * buf[i].price;
					printf("%.2lf\n", ans);
					break;
				}
				else {
					ans += (cmax - curoil) * buf[i].price;
					curoil = cmax;
				}
			}
		}
	}
	return 0;
}

//�����Ͽ���һЩ˼·�Ż������⣬����̰���㷨��ÿ����һ������վ����¼��ǰ�ľ����������
//Ȼ��鿴���������ڵļ���վ��û�бȵ�ǰվ���˵ģ����У���鿴������
//�������ӵ��㹻������˵�վ����û�У����������������յ㣬��������ͼ�����
//�ڵ���ûվ�Ĺ������������������������һվ������������롣
//���������û�о���Ϊ0�ļ���վ��