func topKFrequent(nums []int, k int) []int {
    frequencyMap := make(map[int]int)
	for _, num := range nums {
		frequencyMap[num]++
	}
	uniqueNums := make([]int, 0, len(frequencyMap))
	for num := range frequencyMap {
		uniqueNums = append(uniqueNums, num)
	}

	sort.Slice(uniqueNums, func(i, j int) bool {
		return frequencyMap[uniqueNums[i]] > frequencyMap[uniqueNums[j]]
	})
	return uniqueNums[:k]
}
