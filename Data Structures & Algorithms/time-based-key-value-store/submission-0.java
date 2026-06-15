class TimeMap {
 private Map<String,List<TimeData>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>())
                .add(new TimeData(timestamp,value));
    }

    public String get(String key, int timestamp) {
        if(keyStore.containsKey(key)){
            List<TimeData> map = keyStore.get(key);
            if(map.isEmpty()){
                return "";
            }else{
                int left = 0, right = map.size() - 1;
                String result = "";
                while (left <= right){
                    int mid = left + (right - left) / 2;
                    if(map.get(mid).timestamp == timestamp){
                        return map.get(mid).value;
                    } else if (map.get(mid).timestamp < timestamp) {
                        result = map.get(mid).value;
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                return result;
            }
        }
        return "";
    }

    private static class TimeData {
        int timestamp;
        String value;

        TimeData(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
