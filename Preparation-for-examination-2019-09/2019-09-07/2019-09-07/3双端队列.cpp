#include <stdio.h>
#include <deque>
using namespace std;

deque<int>qu;

void InsertDeque()
{
	for (int i = 0; i < 10; i++)
		qu.push_back(i);
}

void ShowDeque1()
{
	printf("\n遍历队列，方式一：\n");
	for (int i = 0; i < qu.size(); i++)
		printf("%d ", qu[i]);
	printf("\n");
}

void ShowDeque2()
{
	printf("\n遍历队列，方式二：\n");
	for (deque<int>::iterator it = qu.begin(); it != qu.end(); it++)
		printf("%d ", *it);
	printf("\n");
}

//在队列后端加入元素
void AddBack()
{
	printf("\n在后面添加元素：\n");
	for (int i = 10; i < 20; i++)
		qu.push_back(i);
}

//在队列前端加入元素
void AddFront()
{
	printf("\n在前面添加元素：\n");
	for (int i = -10; i < 0; i++)
		qu.push_front(i);
}

//在队列中随机插入元素
void AddRandomLoaction()
{
	printf("\n在中间随机加入元素：\n");
	qu.insert(qu.begin()+7,666);
	qu.insert(qu.end() - 7, 233);

}

int main()
{
	InsertDeque();
	ShowDeque1();
	ShowDeque2();
	AddBack();
	ShowDeque1();
	ShowDeque2();
	AddFront();
	ShowDeque1();
	ShowDeque2();
	AddRandomLoaction();
	ShowDeque1();
	ShowDeque2();
	printf("max_size=%zd\n", qu.max_size());
	return 0;
}