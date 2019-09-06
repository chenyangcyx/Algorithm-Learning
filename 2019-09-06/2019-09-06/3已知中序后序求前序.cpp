#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

struct Node
{
	Node* lchild;
	Node* rchild;
	char c;
};

char str1[30], str2[30];

void BeforeOrder(Node* T)
{
	printf("%c", T->c);
	if (T->lchild != NULL)
		BeforeOrder(T->lchild);
	if (T->rchild != NULL)
		BeforeOrder(T->rchild);
}

void MiddleOrder(Node* T)
{
	if (T->lchild != NULL)
		MiddleOrder(T->lchild);
	printf("%c", T->c);
	if (T->rchild != NULL)
		MiddleOrder(T->rchild);
}

void AfterOrder(Node* T)
{
	if (T->lchild != NULL)
		AfterOrder(T->lchild);
	if (T->rchild != NULL)
		AfterOrder(T->rchild);
	printf("%c", T->c);
}

Node* build(int s1, int e1, int s2, int e2)
{
	Node* ret = (Node*)malloc(sizeof(Node));
	ret->lchild = ret->rchild = NULL;
	ret->c = str2[e2];		//根为后序遍历的字符串的最后一个字符
	int rootldx = 0;
	for (int i = s1; i <= e1; i++)
		if (str1[i] == str2[e2])
		{
			rootldx = i;
			break;
		}

	if (rootldx != s1)		//若左子树不为空
		ret->lchild = build(s1, rootldx - 1, s2, s2 + (rootldx - s1) - 1);

	if (rootldx != e1)		//若右子树不为空
		ret->rchild = build(rootldx + 1, e1, e2 - (e1 - rootldx), e2 - 1);

	return ret;
}

int main()
{
	while (scanf("%s", str1) != EOF)
	{
		scanf("%s", str2);
		int L1 = strlen(str1);
		int L2 = strlen(str2);
		Node* T = build(0, L1 - 1, 0, L2 - 1);
		printf("前序遍历：\n");
		BeforeOrder(T);
		printf("\n中序遍历：\n");
		MiddleOrder(T);
		printf("\n后序遍历：\n");
		AfterOrder(T);
		printf("\n");
	}
	return 0;
}