# -*- coding: utf-8 -*-
"""
Created on Sat May 13

@author: 陈佳榕

某个数字建筑领域公司的笔试题目
要求实现顺时针打印矩阵
比如对于矩阵
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16
打印出1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
"""

def clockwisePrint(matrix):
    """
    :param matrix:list[list],二维矩阵
    :rtype :list,顺时针打印出来的矩阵元素
    """
    left = top = 0;
    bottom = len(matrix) - 1;
    if bottom == -1:
        return;
    right = len(matrix[0]) - 1;
    if right == -1:
        return;
    count = 0;
    totalNum = (bottom + 1) * (right + 1);
    i = j = 0;
    result = [];
    allowRight = True;
    while count < totalNum:
        result.append(matrix[i][j]);
        count += 1;
        if j > left and j < right:          #1.如果不在左墙或右墙
            if i == top:                    #且在上墙的话，直接右移
                j += 1;
                allowDown = True;
            else:                           #在下墙的话，直接左移
                j -= 1;
                allowUp = True;
        elif j == left:                     #2.如果在左墙的话
            if i == top:                    #在上墙的话，右移
                j += 1;
                if top != 0 and allowRight: #除了刚开始不用移动左墙，其他情况左墙都需要右移
                    left += 1;
                    allowRight = False;
            elif i == bottom:               #在下墙的话，上移且下墙上移
                i -= 1;
                if allowUp:
                    bottom -= 1;
                    allowUp = False;
            else:                           #不在上墙或下墙，直接上移
                i -= 1;
                allowRight = True;
        else:                               #3.如果在右墙的话
            if i == top:                    #在上墙，下移且上墙下移
                i += 1;
                if allowDown:
                    top += 1;
                    allowDown = False;
            elif i == bottom:               #在下墙，左移且右墙左移
                j -= 1;
                if allowLeft:
                    right -= 1;
                    allowLeft = False;
            else:                           #不在上墙或下墙，直接下移
                i += 1;
                allowLeft = True;
    return result;

if __name__ == '__main__':
    matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]];
    print(clockwisePrint(matrix));