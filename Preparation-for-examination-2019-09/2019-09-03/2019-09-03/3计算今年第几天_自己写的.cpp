#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define ISYEAP(x) x%100!=0&&x%4==0||x%400==0?1:0

int dayOfMonth[13][2] = {
	0,0,
	31,31,
	28,29,
	31,31,
	30,30,
	31,31,
	30,30,
	31,31,
	31,31,
	30,30,
	31,31,
	30,30,
	31,31
};

struct Date {
	int year;
	int month;
	int day;
	int differenceToDay(int y, int m, int d)
	{
		int diff = 1;
		int is_yeap = ISYEAP(year);
		while (!(year == y && month == m && day == d))
		{
			diff++;
			day++;
			if (day > dayOfMonth[month][is_yeap])
			{
				day = 1;
				month++;
				if (month > 12)
				{
					month = 1;
					year++;
					is_yeap = ISYEAP(year);
				}
			}
		}
		return diff;
	}
};

int main()
{
	int y, m, d;
	while (scanf("%4d%2d%2d", &y, & m, &d) != EOF)
	{
		Date t{ y,1,1 };
		printf("%d\n", t.differenceToDay(y, m, d));
	}
	return 0;
}