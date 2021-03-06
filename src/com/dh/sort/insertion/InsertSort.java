package com.dh.sort.insertion;

import com.dh.sort.Sort;

/**
 * 插入排序，稳定排序（遇到一样的，不位移即可，）原地排序，时间复杂度为和冒泡一样，
 * 插入排序，从当前数组第二个元素开始，和前面的元素比较大小，若是比我大，那么就后移一位，如果不是，说明到了我该进去的位置了。
 * 
 * @author Lenovo
 *
 */
public class InsertSort implements Sort {

	@Override
	public void sort(int[] a, int n) {
		if (n <= 1)
			return;
		for (int i = 1; i < n; i++) {
			int temp = a[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (a[j] > temp) {
					a[j + 1] = a[j];// 数据向后位移
				} else {
					break;// 无法交换之后跳出循环
				}

			}
			// 判断出是这个a[j]小于temp,那么这个元素就排在后面一位
			a[j + 1] = temp;
		}

	}

	/**
	 * 第二次编写 插入排序，从当前数组第二个元素开始，和前面的元素比较大小，若是比我大，那么就后移一位，如果不是，说明到了我该进去的位置了。
	 * 相当于分了2个区间，第一个有序的，和后面无序的，一点点遍历，使得数据变得有序。
	 * 
	 * @param a
	 */
	public void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					displacement(a, j, i);
				}
			}
		}

	}

	/**
	 * 位移,将j的数据放到i上，其余的数据后移
	 */
	public void displacement(int[] a, int i, int j) {
		int temp = a[j];
		for (int k = j; k > i; k--) {
			a[k] = a[k - 1];
		}
		a[i] = temp;

	}

	/**
	 * 交换数据
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
