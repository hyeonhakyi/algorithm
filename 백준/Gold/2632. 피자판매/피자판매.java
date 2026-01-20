import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[m];
        int[] b = new int[n];

        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n; i++){
            b[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> listA = getAllSums(a);
        List<Integer> listB = getAllSums(b);

        Collections.sort(listB);

        long answer = 0;

        for(int i : listA){
            int need = target - i;
            answer += countByBinarySearch(listB,need);
        }

        System.out.println(answer);
    }//main end

    private static List<Integer> getAllSums(int[] arr){
        int[] arr2 = new int[arr.length * 2];

        for(int i = 0; i < arr.length; i++){
            arr2[i] = arr[i];
            arr2[i + arr.length] = arr[i];
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);

        int total = 0;
        for(int i : arr){
            total += i;
        }
        list.add(total);

        for(int start = 0; start < arr.length; start++){
            int sum = 0;
            for(int len = 1; len < arr.length; len++){
                sum += arr2[start + len - 1];
                list.add(sum);
            }
        }

        return list;
    }//getAllSums end

    private static int countByBinarySearch(List<Integer> list, int target){
        int left = lowerBound(list,target);
        int right = upperBound(list,target);
        return right - left;
    }//countByBinarySearch end

    private static int lowerBound(List<Integer> list, int target){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }//lowerBound end

    private static int upperBound(List<Integer> list, int target){
        int left = 0;
        int right = list.size();

        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }//upperBound end
}//class end
