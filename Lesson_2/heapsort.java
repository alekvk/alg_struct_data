package Home_tasks.Lesson_2;
import java.util.Arrays;

public class heapsort {
    public static void main(String args[])
    {
        double arr[] = {8.1, 8.05, -8.698,  3.5, 22.1, 10.1, -1, -5};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    } 
    public static void sort(double arr[]) {
        int n = arr.length;
        // Выстраивание элементов массива в виде сортирующего дерева
        for (int i = n / 2 - 1; i >= 0; i--) {
            subtreeBinHeap(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            double temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            subtreeBinHeap(arr, i, 0);
        }
    }

    // Метод преобразования поддерева в двоичную кучу 
     public static void subtreeBinHeap(double arr[], int n, int i)
    {
        int root = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 

        // Левый потомок больше корневого узла
        if (left < n && arr[left] > arr[root]) {
            root = left;
        }
        // Правый потомок больше корневого узла
        if (right < n && arr[right] > arr[root]) {
            root = right;
        }
        if (root!= i) {
            double temp = arr[i];
            arr[i] = arr[root];
            arr[root] = temp;
            subtreeBinHeap(arr, n, root);
        }
    }
}



    
    



