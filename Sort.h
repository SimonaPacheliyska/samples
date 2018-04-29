#pragma once

template <typename T>
class Sort
{
private:
	Sort() = delete;
	Sort(const Sort<T>&) = delete;
	const Sort& operator= (const Sort<T>&) = delete;
	~Sort() = delete;
public:
	static void mergeSort(T* array, const size_t size);
	static bool isSorted(T* arr, const size_t size);
private:
	static void mergeSortHalves(T* array, const size_t size, T* buffer);
	static void merge(T* fst, const size_t fstSize, T* snd, const size_t sndSize, T* result);
};

template<typename T>
void Sort<T>::mergeSort(T * array, const size_t size)
{
	if (!array || size == 0) {
		return;
	}

	T* buffer = new T[size];
	mergeSortHalves(array, size, buffer);

	delete[] buffer;
}

template<typename T>
bool Sort<T>::isSorted(T * arr, const size_t size)
{
	for (int i = 0; i < size-1; ++i) {
		if (arr[i] > arr[i + 1]) {
			return false;
		}
	}
	return true;
}

template<typename T>
void Sort<T>::mergeSortHalves(T * array, const size_t size, T * buffer)
{
	if (size < 2) {
		return;
	}

	int middle = size / 2;
	mergeSortHalves(array, middle, buffer);
	mergeSortHalves(array + middle, size - middle, buffer + middle);
	merge(array, middle, array + middle, size - middle, buffer);

	for (int i = 0; i < size; ++i) {
		array[i] = buffer[i];
	}
}

template<typename T>
void Sort<T>::merge(T * fst, const size_t fstSize, T * snd, const size_t sndSize, T * result)
{
	size_t iA = 0, iB = 0, iResult = 0;

	while (iA < fstSize && iB < sndSize) {
		if (fst[iA] < snd[iB]) {
			result[iResult++] = fst[iA++];
		}
		else {
			result[iResult++] = snd[iB++];
		}
	}
	while (iA < fstSize) {
		result[iResult++] = fst[iA++];
	}
	while (iB < sndSize) {
		result[iResult++] = snd[iB++];
	}
}
