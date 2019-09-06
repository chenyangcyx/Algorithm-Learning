//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
//#include <string.h>
//
//struct Node
//{
//	Node* lchild;
//	Node* rchild;
//	char c;
//	bool if_delete = false;
//}Tree[50];
//
//int loc;
//
//Node* create()
//{
//	Tree[loc].lchild = Tree[loc].rchild = NULL;
//	return &Tree[loc++];
//}
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
//	Node* ret = create();
//	ret->c = str1[s1];		//该结点字符为前序遍历中第一个字符
//	int rootldx = 0;
//	for(int i=s2;i<=e2;i++)
//		if (str2[i] == str1[s1])
//		{
//			rootldx = i;
//			break;
//		}
//
//	if (rootldx != s2)		//若左子树不为空
//		ret->lchild = build(s1 + 1, s1 + (rootldx - s2), s2, rootldx - 1);
//
//	if (rootldx != e2)
//		ret->rchild = build(s1 + (rootldx - s2) + 1, e1, rootldx + 1, e2);
//
//	return ret;
//}
//
//void DeleteTree(Node *T)
//{
//	if (T->lchild != NULL)
//		DeleteTree(T->lchild);
//	if (T->rchild != NULL)
//		DeleteTree(T->rchild);
//	T->if_delete = true;
//}
//
//int main()
//{
//	while (scanf("%s",str1)!=EOF)
//	{
//		scanf("%s", str2);
//		loc = 0;
//		int L1 = strlen(str1);
//		int L2 = strlen(str2);
//		Node* T = build(0, L1 - 1, 0, L2 - 1);
//		AfterOrder(T);
//		printf("\n");
//		//删除树
//		DeleteTree(T);
//		for (int i = 0; i < 50; i++)
//			printf("第%d棵数是否被删除：%d\n", i, Tree[i].if_delete);
//	}
//	return 0;
//}