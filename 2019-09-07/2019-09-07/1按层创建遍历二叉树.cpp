//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
//#include <string.h>
//#include <queue>
//using namespace std;
//
//struct Node {
//	Node* lchild;
//	Node* rchild;
//	char data;
//};
//
//queue<Node*>qu_create;
//queue<Node*>qu_tranverse;
//
//char str[100];
//
//void CreateTree(Node* &T)
//{
//	int i = 0;
//	//根节点的处理
//	if (str[i] == '*')
//		return;
//	else
//	{
//		T = (Node*)malloc(sizeof(Node));
//		T->data = str[i++];
//		qu_create.push(T);
//	}
//	while (!qu_create.empty())
//	{
//		Node* p = qu_create.front();
//		qu_create.pop();
//		qu_tranverse.push(p);
//		if (str[i] == '*')
//			p->lchild = NULL;
//		else
//		{
//			p->lchild = (Node*)malloc(sizeof(Node));
//			p->lchild->data = str[i];
//			qu_create.push(p->lchild);
//		}
//		i++;
//		if (str[i] == '*')
//			p->rchild = NULL;
//		else
//		{
//			p->rchild = (Node*)malloc(sizeof(Node));
//			p->rchild->data = str[i];
//			qu_create.push(p->rchild);
//		}
//		i++;
//	}
//}
//
////前序遍历
//void PreOrder(Node* T)
//{
//	printf("%c", T->data);
//	if (T->lchild != NULL)
//		PreOrder(T->lchild);
//	if (T->rchild != NULL)
//		PreOrder(T->rchild);
//}
//
////按层遍历
//void Tranverse_Ceng(Node* T)
//{
//	Node* p = qu_tranverse.front();
//	qu_tranverse.push(qu_tranverse.front());
//	qu_tranverse.pop();
//	printf("%c", p->data);
//	while (qu_tranverse.front() != p)
//	{
//		printf("%c", qu_tranverse.front()->data);
//		qu_tranverse.push(qu_tranverse.front());
//		qu_tranverse.pop();
//	}
//}
//
//int main()
//{
//	while (gets_s(str))
//	{
//		while (!qu_create.empty())
//			qu_create.pop();
//		while (!qu_tranverse.empty())
//			qu_tranverse.pop();
//		Node* T = NULL;
//		CreateTree(T);
//		printf("二叉树创建完成！\n");
//		printf("DFS前序遍历：\n");
//		PreOrder(T);
//		printf("\n按层遍历二叉树：\n");
//		Tranverse_Ceng(T);
//	}
//	return 0;
//}