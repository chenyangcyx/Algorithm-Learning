# 最小生成树Kruskal

目标使得全省任何两个村庄之间都可以实现公路交通（但不一定有直接的公路相连，只要间接通过公路可达即可）
并要求铺设的公路总长度为最小，请计算最小的公路总长度

输入：
第一行给出村庄的数目（N<100），随后的N(N-1)/2行对应村庄间的距离，每行给出一对正整数
分别是两个村庄的编号，以及此两村庄间的距离
为简单起见，村庄从1到N编号。
当N为0时，输入结束

输出：
对每个测试用例，在1行里输出最小的公路总长度