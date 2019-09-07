//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
//#include <stdlib.h>
//
//struct Node
//{
//	Node* lchild;
//	Node* rchild;
//	int data;
//};
//
//Node* InsertNum(Node* &T,int num)
//{
//	if (T == NULL)
//	{
//		T = (Node*)malloc(sizeof(Node));
//		T->lchild = T->rchild = NULL;
//		T->data = num;
//		return T;
//	}
//	else if (T->data >= num)
//		T->lchild = InsertNum(T->lchild, num);
//	else if (T->data < num)
//		T->rchild = InsertNum(T->rchild, num);
//	return T;
//}
//
////中序遍历输出二叉排序树
//void MidOrder(Node* T)
//{
//	if (T->lchild != NULL)
//		MidOrder(T->lchild);
//	printf("%d ", T->data);
//	if (T->rchild != NULL)
//		MidOrder(T->rchild);
//}
//
//int main()
//{
//	int num;
//	while (scanf("%d", &num) != EOF)
//	{
//		Node* T = NULL;
//		for (int i = 0; i < num; i++)
//		{
//			int t;
//			scanf("%d", &t);
//			InsertNum(T, t);
//		}
//		//中序遍历输出树
//		printf("中序遍历：");
//		MidOrder(T);
//		printf("\n");
//	}
//	return 0;
//}