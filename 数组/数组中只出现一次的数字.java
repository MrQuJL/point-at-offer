
/**
 * 题目名称：数组中只出现一次的数字
 * 题目描述：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * NOTE:将num1[0],num2[0]设置为返回结果
 */
public class Solution {

    /**
     * 思路：
     * 1.一个数异或同一个数两次结果还是它自己
     * 2.如果数组中只有一个只出现一次的数字，那我们从头到尾依次异或数组中的每一个数字就可以得到那个数
     * 3.把原数组分成两个子数组，每个子数组中都包含一个只出现一次的数字，那么怎么进行分组呢？
     *
     * 4.把数组中的数从头到尾异或一遍得到一个值，假设为x（x一定是两个只出现一次的数字异或的结果）
     * 5.因为这两个数字一定不同，所以x的二进制表示中至少有一位是1，找到这一位，设为n
     * 6.我们就按照第n位是不是1把整个数组划分为两组
     * 7.因为出现了两次的数字它们的每一位都一定相同，所以出现了两次的数字一定会被分到同一组
     * 8.而每一组中又只包含一个只出现一次的数字，再每一组中找出那一个数字即可。
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        // 1.把数组中的数从头到尾异或一遍得到一个值，假设为x
        int xor = getXorNumOfArray(array, 0, array.length - 1);
        
        // 2.在x中找到二进制中第一个为1的位的位置（记为n）
        int pos = findFirst1Pos(xor);
        
        // 3.对数组中所有的数按照第n位是不是1来进行分组
        int border = divideArrayBy1(array, pos);
        
        // 4.找出每一组中只出现一次的数字
        int left = getXorNumOfArray(array, 0, border);
        int right = getXorNumOfArray(array, border + 1, array.length - 1);
        
        // 返回这两个只出现一次的数据
        num1[0] = left;
        num2[0] = right;
        return;
    }
    
    /**
     * 获得将数组中的所有数字都异或一遍后的那个数值
     */
    public int getXorNumOfArray(int[] array, int left, int right) {
        int temp = array[left];
        for (int i = left + 1; i <= right; i++) {
            temp ^= array[i];
        }
        return temp;
    }
    
    /**
     * 返回num的二进制表示中第一个为1的位的位置
     */
    public int findFirst1Pos(int num) {
        int indexBit = 0;
        while ((num & 0x1) != 1) {
            num = num >> 1;
            indexBit++;
        }
        return indexBit;
    }
    
    /**
     * 判断数字num的pos位是不是1，是1就返回true，不是1就返回false
     */
    public boolean isNum1InBinary(int num, int pos) {
        int indexBit = 0;
        while (pos-- > 0) {
            num = num >> 1;
        }
        return (num & 0x1) == 1 ? true : false;
    }
    
    /**
     * 根据数字的二进制表示的从右向左数的第pos位是不是1，将数组划分为两组，并返回左边那一组的右边界
     */
    public int divideArrayBy1(int[] array, int pos) {
        // 第pos位为1的数从数组左边开始填充，不为1的数从数组右边开始填充
        int indexLeft = 0;
        int indexRight = array.length - 1;
        // 临时数组
        int[] copy = new int[array.length];
        // 遍历数组
        for (int i = 0; i < array.length; i++) {
            if (isNum1InBinary(array[i], pos)) {
                copy[indexLeft++] = array[i];
            } else {
                copy[indexRight--] = array[i];
            }
        }
        // 复制回原数组
        for (int i = 0; i < array.length; i++) {
            array[i] = copy[i];
        }
        return --indexLeft;
    }
    
}