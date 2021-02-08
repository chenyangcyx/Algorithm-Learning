//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
//#include <queue>
//using namespace std;
//
//void test1()
//{
//	queue<int> qu;
//	for (int i = 0; i < 10; i++)
//		qu.push(i);
//	while (!qu.empty())
//	{
//		printf("%d\n", qu.front());
//		qu.pop();
//	}
//}
//
//struct Node {
//	int x;
//	int y;
//	Node(int xx,int yy):x(xx),y(yy){}
//	//bool operator < (const Node &other) const {
//	//	if (x == other.x)
//	//	{
//	//		return y < other.y;
//	//	}
//	//	else
//	//		return x < other.x;
//	//}
//};
//
//struct cmp
//{
//	bool operator ()(Node& n1, Node& n2)
//	{
//		if (n1.x == n2.x)
//			return n1.y < n2.y;
//		else
//			return n1.x < n2.x;
//	}
//};
//
//void test2()
//{
//	priority_queue<Node,vector<Node>,cmp> qu;
//	for (int i = 0; i < 10; i++)
//		for (int j = 0; j < 10; j++)
//			qu.push(Node(i, j));
//	while (!qu.empty())
//	{
//		printf("x=%d,y=%d\n", qu.top().x,qu.top().y);
//		qu.pop();
//	}
//}
//
//int main()
//{
//	test1();
//	test2();
//	return 0;
//}