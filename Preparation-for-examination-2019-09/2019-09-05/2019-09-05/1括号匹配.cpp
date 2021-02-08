//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
//#include <stack>
//using namespace std;
//
//char input[102], output[102];
//stack<int> st;
//
//int main()
//{
//	int i;
//	while (scanf("%s", input) != EOF)
//	{
//		for (i = 0; input[i] != '\0'; i++)
//		{
//			if (input[i] == '(')
//			{
//				st.push(i);
//				output[i] = ' ';
//			}
//			else if (input[i] == ')')
//			{
//				if (st.empty() != true)
//				{
//					st.pop();
//					output[i] = ' ';
//				}
//				else
//					output[i] = '?';
//			}
//			else
//				output[i] = ' ';
//		}
//		while (!st.empty())
//		{
//			output[st.top()] = '$';
//			st.pop();
//		}
//		output[i] = '\0';
//		puts(input);
//		puts(output);
//	}
//	return 0;
//}