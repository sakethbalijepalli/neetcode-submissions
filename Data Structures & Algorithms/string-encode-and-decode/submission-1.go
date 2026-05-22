type Solution struct{}


func (s *Solution) Encode(strs []string) string {
	var result string
	for _, s := range strs {
		result += strconv.Itoa(len(s)) + "#" + s
	}
	return result
}

func (s *Solution) Decode(x string) []string {
	var res []string
	i := 0

	for i < len(x) {
		j := i
		for x[j] != '#' {
			j++
		}
		lengthStr := x[i:j]
		length, _ := strconv.Atoi(lengthStr)
		j++

		originalStr := x[j : j+length]
		res = append(res, originalStr)

		i = j + length
	}

	return res
}
