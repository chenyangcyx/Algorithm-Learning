求和
时间限制： 3000MS
内存限制： 589824KB
题目描述：
小美很喜欢求和符号Σ（读作sigma）。她随手画了一张n个点m条边的简单无向图（无重边和自环，但不保证连通），她想知道这张图有多少个形如Σ的图形。由于这张图可以随意拉伸旋转等变换，故这个图形需要满足如下条件：

恰好五个点组成，这五个点互不相同

这五个点连成一条链

两个图形视为不同，当且仅当其包含的点的编号集合不同。具体例子参见样例。



输入描述
第一行两个正整数n,m；

接下来m行，每行两个正整数x,y，表示点x与y之间有一条无向边。

对于30%的数据，2≤n≤6;

对于60%的数据，2≤n≤10;

对于100%的数据,2≤n≤15,1≤m≤60,1≤x<y≤n;



输出描述
输出一行一个正整数，表示形如Σ的图形个数。


样例输入
6 7
1 2
2 3
3 4
4 5
5 6
1 6
3 6
样例输出
6

提示
样例如图：



一共有六个图形，分别为：

       (1,2,3,4,5)

       (2,3,4,5,6)

       (3,4,5,6,1)

       (4,5,6,1,2)

       (5,6,1,2,3)

       (6,1,2,3,4)

规则
请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
点击“调试”亦可保存代码
编程题可以使用本地编译器，此页面不记录跳出次数