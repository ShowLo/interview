/*
一个面试题，要求大致如下
给定一个整数，比如6606，它的二进制数为01100111001110
将其两两配对，然后奇数对的比特互换，即10101011001101，对应的整数为10957
*/
public class changeBit
{
    public int exchangeBit(int num)
    {
        int getOddPair = 0x33333333;
        int temp1 = ((num & getOddPair) >> 1) & getOddPair;
        int temp2 = ((num & getOddPair) << 1) & getOddPair;
        return (num & (~getOddPair)) | temp1 | temp2;
    }
    
    public static void main(String[] args)
    {
        changeBit cb = new changeBit();
        System.out.println(cb.exchangeBit(6606));
    }
}