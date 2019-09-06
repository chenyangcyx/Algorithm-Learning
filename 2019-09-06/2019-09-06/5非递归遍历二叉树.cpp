#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <stack>
using namespace std;

//枚举类型，标记left或者right
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

//非递归的前序遍历，方法一
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

//非递归的前序遍历，方法二
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

//非递归的前序遍历，方法三
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

//中序遍历
void MidOrder(TreeNode* T)
{
	if (T->lchild != NULL)
		MidOrder(T->lchild);
	printf("%c", T->data);
	if (T->rchild != NULL)
		MidOrder(T->rchild);
}

//非递归的中序遍历，写法一
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

//非递归的中序遍历，写法二
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

//后序遍历
void AfterOrder(TreeNode* T)
{
	if (T->lchild != NULL)
		AfterOrder(T->lchild);
	if (T->rchild != NULL)
		AfterOrder(T->rchild);
	printf("%c", T->data);
}

//非递归的后序遍历，写法一
void AfterOrder_NoRecursion1(TreeNode* T)
{
	stack<TreeNode*>st;
	TreeNode* p = T, * last_p = NULL;
	//先把指针移到最下边的左子树
	while (p)
	{
		st.push(p);
		p = p->lchild;
	}
	//开始从最下边的左子树开始遍历
	while (!st.empty())
	{
		//弹出为NULL的指针，并依据此指针判断是否进行输出
		p = st.top();
		st.pop();
		if (p->rchild == NULL || p->rchild == last_p)
		{
			//一个根节点能够被访问的前提是：
			//1、无右子树   或
			//2、右子树已被访问过
			printf("%c", p->data);
			last_p = p;
		}
		else
		{
			//说明还不能够访问根节点
			//则根节点再次入栈
			st.push(p);
			p = p->rchild;		//此时可以确定，一定有右子树
			while (p)
			{
				//在右子树下再次访问其最下边的左子树
				st.push(p);
				p = p->lchild;
			}
		}
	}
}

//非递归的后序遍历，写法二
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
			//该子树的左子树被访问过
			tagnode->tag = Tag::left;
			st.push(tagnode);
			p = p->lchild;
		}
		tagnode = st.top();
		st.pop();
		if (tagnode->tag == Tag::left)
		{
			//置换标记
			tagnode->tag = Tag::right;
			//再次入栈
			st.push(tagnode);
			p = tagnode;
			//进入右子树
			p = p->rchild;
		}
		else
		{
			printf("%c", tagnode->data);
			//置空，再次出栈
			p = NULL;
		}
	}
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
	printf("\n输入字符串：\n%s", str);
	TreeNode* T = NULL;
	CreateTree(T);
	//前序遍历
	printf("\n前序遍历：\n");
	PreOrder(T);
	//非递归的前序遍历，方法一
	printf("\n非递归的前序遍历，方法一：\n");
	PreOrder_NoRecursion1(T);
	//非递归的前序遍历，方法二
	printf("\n非递归的前序遍历，方法二：\n");
	PreOrder_NoRecursion2(T);
	//非递归的前序遍历，方法三
	printf("\n非递归的前序遍历，方法三：\n");
	PreOrder_NoRecursion3(T);
	//中序遍历
	printf("\n中序遍历：\n");
	MidOrder(T);
	//非递归的中序遍历，方法一
	printf("\n非递归的中序遍历，方法一：\n");
	MidOrder_NoRecursion1(T);
	//非递归的中序遍历，方法二
	printf("\n非递归的中序遍历，方法二：\n");
	MidOrder_NoRecursion2(T);
	//后序遍历
	printf("\n后序遍历：\n");
	AfterOrder(T);
	//非递归的后序遍历，方法一
	printf("\n非递归的后序遍历，方法一：\n");
	AfterOrder_NoRecursion1(T);
	//非递归的后序遍历，方法二
	printf("\n非递归的后序遍历，方法二：\n");
	AfterOrder_NoRecursion2(T);
	return 0;
}