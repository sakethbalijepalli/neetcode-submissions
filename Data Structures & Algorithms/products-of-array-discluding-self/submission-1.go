func productExceptSelf(nums []int) []int {
    n := len(nums)
	res := make([]int, n)

	// Step 1: Use the result array to store prefixes
	res[0] = 1
	for i := 1; i < n; i++ {
		res[i] = res[i-1] * nums[i-1]
	}

	// Step 2: Multiply suffixes on the fly walking backwards
	rightProduct := 1
	for i := n - 1; i >= 0; i-- {
		res[i] = res[i] * rightProduct
		rightProduct = rightProduct * nums[i]
	}

	return res
}
