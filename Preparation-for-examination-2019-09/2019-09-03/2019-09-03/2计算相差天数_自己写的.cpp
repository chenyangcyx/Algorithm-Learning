//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
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
//struct Date
//{
//	int year;
//	int month;
//	int day;
//	int is_yeap;
//	int CalDaysTo(int y, int m, int d)
//	{
//		int yh, mh, dh;
//		int yl, ml, dl;
//		if (year * 10000 + month * 100 + day >= y * 10000 + m * 100 + d)
//		{
//			yh = year;
//			mh = month;
//			dh = day;
//			yl = y;
//			ml = m;
//			dl = d;
//		}
//		else
//		{
//			yh = y;
//			mh = m;
//			dh = d;
//			yl = year;
//			ml = month;
//			dl = day;
//		}
//		int cnt = 1;
//		is_yeap = ISYEAP(yl);
//		while (!(yl == yh && ml == mh && dl == dh))
//		{
//			dl++;
//			cnt++;
//			if (dl > dayOfMonth[ml][is_yeap])
//			{
//				dl = 1;
//				ml++;
//				if (ml > 12)
//				{
//					ml = 1;
//					yl++;
//					is_yeap = ISYEAP(yl);
//				}
//			}
//		}
//		return cnt;
//	}
//};
//
//int main()
//{
//	int y1, m1, d1;
//	int y2, m2, d2;
//	while (scanf("%4d%2d%2d",&y1,&m1,&d1)!=EOF)
//	{
//		scanf("%4d%2d%2d", &y2, &m2, &d2);
//		Date t{ y1,m1,d1 };
//		printf("%d\n", t.CalDaysTo(y2, m2, d2));
//	}
//}