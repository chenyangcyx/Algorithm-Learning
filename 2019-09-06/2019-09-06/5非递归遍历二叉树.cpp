#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
	TreeNode* lchild;
	TreeNode* rchild;
	char data;
};

char str[100];		//二叉树的前序序列
int index = 0;

//前序遍历
void PreOrder(TreeNode* T)
{
	printf("%c", T->data);
	if (T->lchild != NULL)
		PreOrder(T->lchild);
	if (T->rchild != NULL)
		PreOrder(T->rchild);
}

//中序遍历
void MidOrder(TreeNode* T)
{
	if (T->lchild != NULL)
		MidOrder(T->lchild);
	printf("%c", T->data);
	if (T->rchild != NULL)
		MidOrder(T->rchild);
}

//后序遍历
void AfterOrder(TreeNode* T)
{
	if (T->lchild != NULL)
		AfterOrder(T->lchild);
	if (T->rchild != NULL)
		AfterOrder(T->rchild);
	printf("%c", T->data);
}

void CreateTree(TreeNode* &T)
{
	//前序创建二叉树
	if (str[index] == '*')
	{
		T = NULL;
		index++;
		return;
	}
	else
	{
		T = (TreeNode*)malloc(sizeof(TreeNode));
		T->data = str[index++];
		CreateTree(T->lchild);
		CreateTree(T->rchild);
	}
}

int main()
{
	gets_s(str);
	printf("输入字符串：%s\n", str);
	TreeNode* T = NULL;
	CreateTree(T);
	//前序遍历
	printf("前序遍历：\n");
	PreOrder(T);
	//中序遍历
	printf("\n中序遍历：\n");
	MidOrder(T);
	//后序遍历
	printf("\n后序遍历：\n");
	AfterOrder(T);
	return 0;
}