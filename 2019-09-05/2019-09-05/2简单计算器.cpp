#include <stdio.h>
#include <string.h>
#include <stack>
using namespace std;

char str[202];
stack<int> op;
stack<double> nums;
int op_priority[][7] = {
	1,0,0,0,0,0,0,
	1,0,0,0,0,1,0,
	1,0,0,0,0,1,0,
	1,1,1,0,0,1,0,
	1,1,1,0,0,1,0,
	1,1,1,1,1,1,0,
	1,0,0,0,0,1,0
};
//数字对应的符号：
//0 - 起始/结束标识符号
//1 - +
//2 - -
//3 - *
//4 - /
//5 - (
//6 - )

void GetStrInfo(bool& if_op, double& num, int& i)
{
	if (i == 0 && op.empty() == true)
	{
		if_op = true;
		num = 0;
		return;
	}
	if (str[i] == '\0')
	{
		if_op = true;
		num = 0;
		return;
	}
	if (str[i] >= '0' && str[i] <= '9')
	{
		bool if_xiaoshu = false;
		double xiaoshu_mul = 1.0;
		if_op = false;
		num = 0;
		while (str[i] != ' ' && str[i] != '\0')
		{
			if (if_xiaoshu == false && str[i] == '.')
			{
				if_xiaoshu = true;
				i++;
			}
			if (if_xiaoshu == false)
			{
				num *= 10.0;
				num += (double)str[i++] - '0';
			}
			else
			{
				xiaoshu_mul *= 0.1;
				num += ((double)str[i++] - '0') * xiaoshu_mul;
			}
		}
		if(str[i]==' ')
			i++;
		return;
	}
	else
	{
		if_op = true;
		switch (str[i])
		{
		case '+':
			num = 1;
			break;
		case '-':
			num = 2;
			break;
		case '*':
			num = 3;
			break;
		case '/':
			num = 4;
			break;
		case '(':
			num = 5;
			break;
		case ')':
			num = 6;
			break;
		default:
			break;
		}
		if (str[i + 1] == ' ')
			i += 2;
		else
			i++;
		return;
	}
}

int main()
{
	while (gets_s(str))
	{
		if (str[0] == '0' && str[1] == '\0')
			break;
		bool if_op;
		double num;
		int str_i = 0;
		while (!op.empty())
			op.pop();
		while (!nums.empty())
			nums.pop();
		while (true)
		{
			GetStrInfo(if_op, num, str_i);
			if (if_op == false)
				nums.push(num);
			else
			{
				if (op.empty() == true || op_priority[(int)num][op.top()] == 1)
					op.push(num);
				else
				{
					while (op_priority[(int)num][op.top()] == 0)
					{
						int temp_op = op.top();
						op.pop();
						double num_2 = nums.top();
						nums.pop();
						double num_1 = nums.top();
						nums.pop();
						switch (temp_op)
						{
						case 1:
							nums.push(num_1 + num_2);
							break;
						case 2:
							nums.push(num_1 - num_2);
							break;
						case 3:
							nums.push(num_1 * num_2);
							break;
						case 4:
							nums.push(num_1 / num_2);
							break;
						default:
							break;
						}
					}
					op.push(num);
					int temp_op = op.top();
					op.pop();
					if (temp_op == 6 && op.top() == 5)
						op.pop();
					else
						op.push(temp_op);
				}
			}
			if (op.size() == 2 && op.top() == 0)
				break;
		}
		printf("%.2f\n", nums.top());
	}
	return 0;
}