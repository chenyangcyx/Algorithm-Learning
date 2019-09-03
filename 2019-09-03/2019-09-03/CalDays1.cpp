//#define _CRT_SECURE_NO_WARNINGS
//#include <iostream>
//#include <cmath>
//using namespace std;
//
//#define ISYEAP(x) x%100!=0&&x%4==0||x%400==0?1:0
//
//int dayOfMonth[13][2] = {
//	0,0,
//	31,31,
//	28,29,
//	31,31,
//	30,30,
//	31,31,
//	30,30,
//	31,31,
//	31,31,
//	30,30,
//	31,31,
//	30,30,
//	31,31
//};
//
//struct Date {
//	int year;
//	int month;
//	int day;
//	void nextDay()
//	{
//		day++;
//		if (day > dayOfMonth[month][ISYEAP(year)])
//		{
//			day = 1;
//			month++;
//			if (month > 12)
//			{
//				month = 1;
//				year++;
//			}
//		}
//	}
//};
//
//int alldays[3000][13][32];
//
//int main()
//{
//	int sum_days = 0;
//	//计算从0000-01-01到3000-12-31的每一天距离0000-01-01所过的天数
//	Date t{ 0,1,1 };		//对结构体的初始化
//	while (t.year != 3001)
//	{
//		alldays[t.year][t.month][t.day] = sum_days;
//		t.nextDay();
//		sum_days++;
//	}
//	int y1, m1, d1;
//	int y2, m2, d2;
//	while (scanf("%4d%2d%2d", &y1, &m1, &d1) != EOF)
//	{
//		scanf("%4d%2d%2d", &y2, &m2, &d2);
//		printf("%d\n", (int)abs(alldays[y1][m1][d1] - alldays[y2][m2][d2])+1);
//	}
//	return 0;
//}