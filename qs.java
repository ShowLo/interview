
/*
#面试题之一
#面试官让写出一种排序算法
#当时写了快排
#不过现在想想当时写的不是很对
#特此铭记
*/
public class qs
{
    public void quickSort(int[] array, int left, int right)
    {
        if(left >= right)                           //如果左指针已经在右指针右边或者重叠，结束
        {
            return;
        }
        int i = left;
        int j = right;
        int referValue = array[left];               //以左边的值为参考值
        while(i < j)
        {
            while(j > i && array[j] >= referValue)  //往左找到比参考值小的
            {
                --j;
            }
            while(i < j && array[i] <= referValue)  //往右找到比参考值大的
            {
                ++i;
            }
            if(i < j)                               //左右指针未相遇，交换值
            {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[left] = array[j];                     //此时左右指针已相遇
        array[j] = referValue;                      //将相遇点的值与参考值互换
        quickSort(array, left, i - 1);              //对相遇点左边继续排序
        quickSort(array, i + 1, right);             //对相遇点右边继续排序
    }
    
    public static void main(String[] args)
    {
        int[] array = {1,9,8,66,7,979,45,58,778,76,8,7,878,88};
        qs test = new qs();
        test.quickSort(array, 0, array.length - 1);
        for(int a : array)
        {
            System.out.print(a);
            System.out.print("\t");
        }
    }
}