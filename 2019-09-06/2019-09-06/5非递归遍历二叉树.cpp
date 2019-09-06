#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

struct TreeNode {
	TreeNode* lchild;
	TreeNode* rchild;
	char data;
};

char str[100];		//��������ǰ������
int index = 0;

//ǰ�����
void PreOrder(TreeNode* T)
{
	printf("%c", T->data);
	if (T->lchild != NULL)
		PreOrder(T->lchild);
	if (T->rchild != NULL)
		PreOrder(T->rchild);
}

//�������
void MidOrder(TreeNode* T)
{
	if (T->lchild != NULL)
		MidOrder(T->lchild);
	printf("%c", T->data);
	if (T->rchild != NULL)
		MidOrder(T->rchild);
}

//�������
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
	//ǰ�򴴽�������
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
	printf("�����ַ�����%s\n", str);
	TreeNode* T = NULL;
	CreateTree(T);
	//ǰ�����
	printf("ǰ�������\n");
	PreOrder(T);
	//�������
	printf("\n���������\n");
	MidOrder(T);
	//�������
	printf("\n���������\n");
	AfterOrder(T);
	return 0;
}