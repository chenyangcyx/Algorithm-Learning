#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <stack>
using namespace std;

//ö�����ͣ����left����right
enum Tag
{
	left,right
};

struct TreeNode {
	TreeNode* lchild;
	TreeNode* rchild;
	char data;
	Tag tag;
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

//�ǵݹ��ǰ�����������һ
void PreOrder_NoRecursion1(TreeNode* T)
{
	stack<TreeNode*>st;
	TreeNode* p = NULL;
	st.push(T);
	while (!st.empty())
	{
		p = st.top();
		printf("%c", p->data);
		st.pop();
		if (p->rchild != NULL)
			st.push(p->rchild);
		if (p->lchild != NULL)
			st.push(p->lchild);
	}
}

//�ǵݹ��ǰ�������������
void PreOrder_NoRecursion2(TreeNode* T)
{
	stack<TreeNode*>st;
	TreeNode* p = T;
	while (!st.empty() || p)
	{
		while (p)
		{
			printf("%c", p->data);
			st.push(p);
			p = p->lchild;
		}
		if (!st.empty())
		{
			p = st.top();
			st.pop();
			p = p->rchild;
		}
	}
}

//�ǵݹ��ǰ�������������
void PreOrder_NoRecursion3(TreeNode* T)
{
	stack<TreeNode*>st;
	TreeNode* p = T;
	while (!st.empty() || p)
	{
		if (p)
		{
			printf("%c", p->data);
			st.push(p);
			p = p->lchild;
		}
		else
		{
			p = st.top();
			st.pop();
			p = p->rchild;
		}
	}
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

//�ǵݹ�����������д��һ
void MidOrder_NoRecursion1(TreeNode* T)
{
	stack<TreeNode*>st;
	TreeNode* p = T;
	while (!st.empty() || p)
	{
		while (p)
		{
			st.push(p);
			p = p->lchild;
		}
		if (!st.empty())
		{
			p = st.top();
			st.pop();
			printf("%c", p->data);
			p = p->rchild;
		}
	}
}

//�ǵݹ�����������д����
void MidOrder_NoRecursion2(TreeNode* T)
{
	stack<TreeNode*>st;
	TreeNode* p = T;
	while (!st.empty() || p)
	{
		if (p)
		{
			st.push(p);
			p = p->lchild;
		}
		else
		{
			p = st.top();
			st.pop();
			printf("%c", p->data);
			p = p->rchild;
		}
	}
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

//�ǵݹ�ĺ��������д��һ
void AfterOrder_NoRecursion1(TreeNode* T)
{
	stack<TreeNode*>st;
	TreeNode* p = T, * last_p = NULL;
	//�Ȱ�ָ���Ƶ����±ߵ�������
	while (p)
	{
		st.push(p);
		p = p->lchild;
	}
	//��ʼ�����±ߵ���������ʼ����
	while (!st.empty())
	{
		//����ΪNULL��ָ�룬�����ݴ�ָ���ж��Ƿ�������
		p = st.top();
		st.pop();
		if (p->rchild == NULL || p->rchild == last_p)
		{
			//һ�����ڵ��ܹ������ʵ�ǰ���ǣ�
			//1����������   ��
			//2���������ѱ����ʹ�
			printf("%c", p->data);
			last_p = p;
		}
		else
		{
			//˵�������ܹ����ʸ��ڵ�
			//����ڵ��ٴ���ջ
			st.push(p);
			p = p->rchild;		//��ʱ����ȷ����һ����������
			while (p)
			{
				//�����������ٴη��������±ߵ�������
				st.push(p);
				p = p->lchild;
			}
		}
	}
}

//�ǵݹ�ĺ��������д����
void AfterOrder_NoRecursion2(TreeNode* T)
{
	stack<TreeNode*>st;
	TreeNode* p = T;
	TreeNode* tagnode = NULL;
	while (!st.empty()||p)
	{
		while (p)
		{
			tagnode = p;
			//�������������������ʹ�
			tagnode->tag = Tag::left;
			st.push(tagnode);
			p = p->lchild;
		}
		tagnode = st.top();
		st.pop();
		if (tagnode->tag == Tag::left)
		{
			//�û����
			tagnode->tag = Tag::right;
			//�ٴ���ջ
			st.push(tagnode);
			p = tagnode;
			//����������
			p = p->rchild;
		}
		else
		{
			printf("%c", tagnode->data);
			//�ÿգ��ٴγ�ջ
			p = NULL;
		}
	}
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
	printf("\n�����ַ�����\n%s", str);
	TreeNode* T = NULL;
	CreateTree(T);
	//ǰ�����
	printf("\nǰ�������\n");
	PreOrder(T);
	//�ǵݹ��ǰ�����������һ
	printf("\n�ǵݹ��ǰ�����������һ��\n");
	PreOrder_NoRecursion1(T);
	//�ǵݹ��ǰ�������������
	printf("\n�ǵݹ��ǰ���������������\n");
	PreOrder_NoRecursion2(T);
	//�ǵݹ��ǰ�������������
	printf("\n�ǵݹ��ǰ���������������\n");
	PreOrder_NoRecursion3(T);
	//�������
	printf("\n���������\n");
	MidOrder(T);
	//�ǵݹ���������������һ
	printf("\n�ǵݹ���������������һ��\n");
	MidOrder_NoRecursion1(T);
	//�ǵݹ�����������������
	printf("\n�ǵݹ�������������������\n");
	MidOrder_NoRecursion2(T);
	//�������
	printf("\n���������\n");
	AfterOrder(T);
	//�ǵݹ�ĺ������������һ
	printf("\n�ǵݹ�ĺ������������һ��\n");
	AfterOrder_NoRecursion1(T);
	//�ǵݹ�ĺ��������������
	printf("\n�ǵݹ�ĺ����������������\n");
	AfterOrder_NoRecursion2(T);
	return 0;
}