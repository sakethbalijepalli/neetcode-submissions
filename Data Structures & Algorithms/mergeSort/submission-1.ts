/** Pair class to store key-value pairs */
// class Pair {
//   /**
//    * @param {number} key The key to be stored in the pair
//    * @param {string} value The value to be stored in the pair
//    */
//   constructor(key, value) {
//       this.key = key;
//       this.value = value;
//   }
// }
class Solution {
    /**
     * @param {Pair[]} pairs
     * @returns {Pair[]}
     */
    mergeSort(pairs: Pair[]): Pair[] {
        if (pairs.length <= 1) {
            return pairs;
        }
        const mid = Math.floor(pairs.length / 2);
        const left = pairs.slice(0, mid);
        const right = pairs.slice(mid);
        return this.merge(this.mergeSort(left), this.mergeSort(right));
    }

    merge(left: Pair[], right: Pair[]): Pair[] {
        const result: Pair[] = [];
        let leftIndex = 0;
        let rightIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].key <= right[rightIndex].key) {
                result.push(left[leftIndex]);
                leftIndex++;
            } else {
                result.push(right[rightIndex]);
                rightIndex++;
            }
        }   
        return result.concat(left.slice(leftIndex)).concat(right.slice(rightIndex));
    }
}