class Solution {
    public int solution(String[] strArr) {
        int arr[] = new int[31];
        
        for(String str : strArr) {
            arr[str.length()]++;
        }
        
        int answer = 0;
        for(int num : arr) {
            answer = Math.max(num, answer);
        }
        
        return answer;
    }
}
