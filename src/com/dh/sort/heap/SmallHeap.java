package com.dh.sort.heap;

/**
 * 小顶堆
 * 
 * @author Lenovo
 *
 */
public class SmallHeap {
	private int[] data;
	private int currentSize;
	private int length;

	public SmallHeap() {
		data = new int[8];
		length = 8;
		currentSize = 1;
	}

	public SmallHeap(int length) {
		data = new int[length];
		this.length = length;
		currentSize = 1;
	}

	/**
	 * 长度
	 * 
	 * @return
	 */
	public int getLength() {
		return length;
	}

	/**
	 * 容积
	 * 
	 * @return
	 */
	public int getSize() {
		return currentSize;
	}

	/**
	 * 插入数据
	 * 
	 * @param node
	 */
	public void insert(int node) {
		resize();
		data[currentSize] = node;
		int tempIndex = currentSize;
		while (tempIndex > 0) {
			if (tempIndex / 2 <= 0)
				break;
			if (data[tempIndex / 2] < data[tempIndex])
				break;
			if (data[tempIndex / 2] > data[tempIndex]) {
				swap(data, tempIndex / 2, tempIndex);
				tempIndex = tempIndex / 2;
			}
		}
		currentSize++;

	}

	public void resize() {
		boolean flag = true;
		int[] newData = null;
		if (length < currentSize * 2) {
			flag = false;
			newData = new int[length * 2];
			length = length * 2;
		} else if (length / 10 > currentSize) {
			flag = false;
			newData = new int[length / 2];
			length = length / 2;
		}
		if (flag)
			return;
		int cursor = data.length > length ? length : data.length;
		for (int i = 1; i < cursor; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	/**
	 * 删除root节点
	 */
	public void deleteRoot() {
		resize();
		if (currentSize == 1) {
			return;
		}
		if (currentSize == 2) {
			data[1] = 0;
			currentSize--;
			return;
		}
		data[1] = data[currentSize - 1];
		data[currentSize - 1] = 0;
		currentSize--;
		int tempIndex = 1;
		while (tempIndex < currentSize) {

			int flag = 0;
			int left = 0;
			int right = 0;
			int min = 0;
			if (tempIndex * 2 < currentSize)
				left = data[tempIndex * 2];
			if (tempIndex * 2 + 1 < currentSize)
				right = data[tempIndex * 2 + 1];

			if (left > 0 && right > 0) {
				min = left < right ? left : right;
				if (left < right) {
					min = left;
					flag = 1;
				} else {
					min = right;
					flag = 2;
				}
			} else if (left <= 0 && right > 0) {
				min = right;
				flag = 2;

			} else if (left > 0 && right <= 0) {
				min = left;
				flag = 1;
			}

			int currentNode = data[tempIndex];
			if (currentNode < min) {
				break;
			}

			switch (flag) {

			case 1:
				swap(data, tempIndex, tempIndex * 2);
				tempIndex = tempIndex * 2;
				break;
			case 2:
				swap(data, tempIndex, tempIndex * 2 + 1);
				tempIndex = tempIndex * 2 + 1;
				break;
			default:
				return;

			}

		}

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
