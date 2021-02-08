//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
//#include <string.h>
//#include <stdlib.h>
//
//struct Node
//{
//	Node* lchild;
//	Node* rchild;
//	char c;
//};
//
//char str1[30], str2[30];
//
//void AfterOrder(Node* T)
//{
//	if (T->lchild != NULL)
//		AfterOrder(T->lchild);
//	if (T->rchild != NULL)
//		AfterOrder(T->rchild);
//	printf("%c", T->c);
//}
//
//Node* build(int s1, int e1, int s2, int e2)
//{
//	Node* ret = (Node*)malloc(sizeof(Node));
//	ret->lchild = ret->rchild = NULL;
//	ret->c = str1[s1];		//�ý���ַ�Ϊǰ������е�һ���ַ�
//	int rootldx = 0;
//	for(int i=s2;i<=e2;i++)
//		if (str2[i] == str1[s1])
//		{
//			rootldx = i;
//			break;
//		}
//
//	if (rootldx != s2)		//����������Ϊ��
//		ret->lchild = build(s1 + 1, s1 + (rootldx - s2), s2, rootldx - 1);
//
//	if (rootldx != e2)		//����������Ϊ��
//		ret->rchild = build(s1 + (rootldx - s2) + 1, e1, rootldx + 1, e2);
//
//	return ret;
//}
//
//int main()
//{
//	while (scanf("%s",str1)!=EOF)
//	{
//		scanf("%s", str2);
//		int L1 = strlen(str1);
//		int L2 = strlen(str2);
//		Node* T = build(0, L1 - 1, 0, L2 - 1);
//		AfterOrder(T);
//		printf("\n");
//	}
//	return 0;
//}