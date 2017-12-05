import java.util.*;
 
public class QuickSort {
    public int[] quickSort(int[] A, int n) {
        quickSort_1(A,0,n-1);
        return A;
    }
 
    public int Partition(int []A,int low,int high){
        if (A==null||low<0||high>=A.length){
            return -1;
        }
        int random_index=(low+high)/2;//�������һ����ѡֵ
        int temp;
        //�Ѻ�ѡֵ�����һ�������н���
        temp=A[random_index];
        A[random_index]=A[high];
        A[high]=temp;
 
        //��ʼ��һ����¼С�ڵ��ں�ѡֵ���±�: ����������ʱ �����ǰԪ��С�ں�ѡֵ ���jλ��Ԫ���滻
        //j�ĳ�ʼֵΪ�������� low ������������� �Ѻ�ѡֵ�͵�ǰjλ�õ�Ԫ�ؽ���
        int j=low;
        for (int i=low;i<high;i++){
            if (A[i]<A[high]){
                temp=A[j];
                A[j]=A[i];
                A[i]=temp;
                j++;
            }
            if (i==high-1){
                temp=A[j];
                A[j]=A[high];
                A[high]=temp;
            }
        }
        //��ʱ������С�ں�ѡֵ������ǰ�棬���ڵ����ں���
        return j;//���غ�ѡֵ���±�λ��
    }
 
    public void quickSort_1(int []A,int low,int high){
        if (low==high){//��������ݹ����
            return;
        }
        int partition = Partition(A, low, high);//�Ժ�ѡֵΪ�ֽ��ݹ���ú������п�������
        if (partition>low){//��ѡֵ��ǰ�벿�ֵݹ�
            quickSort_1(A,low,partition-1);
        }
        if (partition<high){//��ѡֵ�ĺ�벿�ֵݹ�
            quickSort_1(A,partition+1,high);
        }
    }
}