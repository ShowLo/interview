/*
һ�������⣬Ҫ���������
����һ������������6606�����Ķ�������Ϊ01100111001110
����������ԣ�Ȼ�������Եı��ػ�������10101011001101����Ӧ������Ϊ10957
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