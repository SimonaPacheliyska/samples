#include <iostream>
#include "Sort.h"
using std::cout;
using std::endl;

///
/// Finds all 3 numbers which sum is 0:
/// - ordered
/// - unordered
///

template <typename T>
bool binarySearchHelper(T* arr, size_t inf, size_t sup, const T& searched) {
	if (inf == sup) {
		return false;
	}
	size_t middle = (inf+sup) / 2;
	if (arr[middle] == searched) {
		return true;
	}
	if (arr[middle] > searched) {
		return binarySearchHelper(arr, inf, middle, searched);
	}
	return binarySearchHelper(arr, middle+1, sup, searched);
}

template <typename T>
bool binarySearch(T* arr, const size_t Size, const T& searched) {
	return binarySearchHelper(arr, 0, Size - 1, searched);
}

//
size_t getAllOrderedZeroSumThreesome(int*& arr, const size_t Size, int sentinel, size_t inf, size_t sup, size_t counter) {
	if (sentinel == arr[Size - 2]) {
		cout << ":";
		return counter;
	}
	if (inf == sup) {
		return getAllOrderedZeroSumThreesome(arr, Size, sentinel + 1, sentinel + 2, Size - 1, counter);
	}
	if (arr[inf] + arr[sup] == -arr[sentinel]) {
		cout << "{" << arr[sentinel]<<","<<arr[inf] << "," << arr[sup] << "} ";
		return getAllOrderedZeroSumThreesome(arr,Size, sentinel, inf + 1, sup, counter+1);
	}
	if (arr[inf] + arr[sup] > -arr[sentinel]) {
		return getAllOrderedZeroSumThreesome(arr,Size, sentinel, inf, sup - 1, counter);
	}
	return getAllOrderedZeroSumThreesome(arr,Size, sentinel, inf + 1, sup, counter);
}


size_t getAllOrderedZeroSumThreesome(int*& arr, const size_t Size) {
	if (!Sort<int>::isSorted(arr, Size)) {
		Sort<int>::mergeSort(arr, Size);
	}

	return getAllOrderedZeroSumThreesome(arr, Size,0, 1, Size - 1, 0);
}
//

//
template <typename T>
size_t getAllUnorderedZeroSumTreesome(T*& arr,const size_t Size, size_t sentinel,size_t inf, size_t sup, size_t counter) {
	if (sentinel == Size - 3) {
		cout << ":";
		return counter;
	}
	if (sup == Size) {
		return getAllUnorderedZeroSumTreesome(arr, Size, sentinel, inf + 1, inf+2, counter);
	}
	if (inf == Size - 2) {
		return getAllUnorderedZeroSumTreesome(arr, Size, sentinel + 1, sentinel + 2, sentinel + 3, counter);
	}
	if (arr[inf] + arr[sup] == -arr[sentinel]) {
		cout << "{" << arr[sentinel] << "," << arr[inf] << "," << arr[sup] << "} ";
		++counter;
	}
	return getAllUnorderedZeroSumTreesome(arr, Size, sentinel, inf, sup + 1, counter);
}

size_t getAllUnorderedZeroSumTreesome(int*& arr, size_t Size) {
	return getAllUnorderedZeroSumTreesome(arr, Size, 0, 1, 2, 0);
}
//


size_t orderedThreesome(int* arr, const size_t Size, size_t inf, size_t sup, size_t counter) {
	if (inf == sup) {
		cout << ":";
		return counter;
	}
	if (binarySearch(arr, Size, -(arr[inf]+arr[sup]))) {
		cout << "{" << arr[inf] << "," << arr[sup] << "," << -(arr[inf] + arr[sup]) << "} ";
		++counter;
	}
	if (arr[inf] + arr[sup] > 0) {
		return orderedThreesome(arr, Size, inf, sup - 1, counter);
	}
	return orderedThreesome(arr, Size, inf + 1, sup, counter);
}

size_t orderedThreesome(int*& arr, const size_t Size) {
	if (!Sort<int>::isSorted(arr, Size)) {
		Sort<int>::mergeSort(arr, Size);
	}
	return orderedThreesome(arr, Size, 1, Size-1, 0);
}



int main()
{
	const size_t SIZE = 10;
	int* arr = new int[SIZE]{ 2,-5,2,3,-4,7,-4, 0, 1, -6 };
	//cout << getAllOrderedZeroSumPairs(arr, Size) << endl;
	cout << orderedThreesome(arr, SIZE) << endl;



	system("pause");
	return 0;
}