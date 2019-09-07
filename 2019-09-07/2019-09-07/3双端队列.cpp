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
	printf("\n�������У���ʽһ��\n");
	for (int i = 0; i < qu.size(); i++)
		printf("%d ", qu[i]);
	printf("\n");
}

void ShowDeque2()
{
	printf("\n�������У���ʽ����\n");
	for (deque<int>::iterator it = qu.begin(); it != qu.end(); it++)
		printf("%d ", *it);
	printf("\n");
}

//�ڶ��к�˼���Ԫ��
void AddBack()
{
	printf("\n�ں������Ԫ�أ�\n");
	for (int i = 10; i < 20; i++)
		qu.push_back(i);
}

//�ڶ���ǰ�˼���Ԫ��
void AddFront()
{
	printf("\n��ǰ�����Ԫ�أ�\n");
	for (int i = -10; i < 0; i++)
		qu.push_front(i);
}

//�ڶ������������Ԫ��
void AddRandomLoaction()
{
	printf("\n���м��������Ԫ�أ�\n");
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