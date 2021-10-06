package example;

public class InsertSorter implements Sorter{

    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private String plan = "";

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    @Override
    public void sort() {
        for(int index = 0; index < a.length ; index++){//外层向右的index，即作为比较对象的数据的index
            int temp = a[index];//用作比较的数据
            int leftindex = index-1;
            while(leftindex>=0 && a[leftindex]>temp){//当比到最左边或者遇到比temp小的数据时，结束循环
                swap(leftindex+1,leftindex);
                leftindex--;
            }
            a[leftindex+1] = temp;//把temp放到空位上
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
    
}
