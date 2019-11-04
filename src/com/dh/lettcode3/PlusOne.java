package com.dh.lettcode3;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3] 输出: [1,2,4] 解释: 输入数组表示数字 123。 示例 2:
 * 
 * 输入: [4,3,2,1] 输出: [4,3,2,2] 解释: 输入数组表示数字 4321。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class PlusOne {
	/**
	 * 999 这种即将进位的考虑下
	 * 
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {

		digits[digits.length - 1] = digits[digits.length - 1] + 1;
		for (int i = digits.length - 1; i >= 0; i--) {

			if (digits[i] / 10 > 0) {

				if (i - 1 >= 0) {
					digits[i - 1] = digits[i - 1] + 1;
				} else {
					digits[i] = digits[i] % 10;
					int[] newDigits = new int[digits.length + 1];
					newDigits[0] = 1;
					return newDigits;
				}
			}
			digits[i] = digits[i] % 10;
		}

		return digits;

	}

}
