// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
     public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSortHelper(pairs,0,pairs.size() - 1);
    }

    public List<Pair> mergeSortHelper(List<Pair> pairs, int start, int end){
        if(end - start + 1 <= 1){
            return pairs;
        }

        int mid = (start + end) / 2;
        mergeSortHelper(pairs,start,mid);
        mergeSortHelper(pairs,mid + 1,end);

        mergePairs(pairs,start,mid,end);
        return pairs;
    }

    public void mergePairs(List<Pair> pairs, int left,int mid, int right){
        int length1 = mid - left + 1;
        int length2 = right - mid;
        Pair[] L = new Pair[length1];
        Pair[] R = new Pair[length2];

        for(int i = 0;i < length1;i++){
            L[i] = new Pair(pairs.get(left + i).key,pairs.get(left + i).value);
        }

        for(int i = 0;i < length2;i++){
            R[i] = new Pair(pairs.get(mid + 1 + i).key,pairs.get(mid + 1 + i).value);
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < length1 && j < length2){
            if(L[i].key <= R[j].key){
                pairs.set(k,L[i]);
                i++;
            }else{
                pairs.set(k,R[j]);
                j++;
            }
            k++;
        }

        while (i < length1){
            pairs.set(k,L[i]);
            i++;
            k++;
        }

        while (j < length2){
            pairs.set(k,R[j]);
            j++;
            k++;
        }

    }
}
