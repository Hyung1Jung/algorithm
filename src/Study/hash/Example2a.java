package Study.hash;

public class Example2a {
    static class MyArray {
        int[] a;
        int count;

        public MyArray(int size) {

            a = new int[size];
            count = 0;

        }

        public void add(int value) {

            a[count] = value;
            ++count;

        }

        public int findIndex(int value) {
            for (int i = 0; i < a.length; ++i)
                if (a[i] == value)
                    return i;
            return -1;

        }

        public void remove(int value) {
            int index = findIndex(value);
            if (index == -1)
                return;
            for (int i = index; i < a.length - 1; ++i)

                a[i] = a[i + 1];
            --count;

        }

        public boolean contains(int value) {
            return findIndex(value) != -1;

        }

        public int get(int index) {
            return a[index];

        }

    }

    public static void main(String[] args) {
        int maxValue = 200, maxCount = 10;
        MyArray myArray = new MyArray(maxCount);
        int[] data = { 1, 13, 105, 7, 9, 11, 14, 115, 107, 197 };
        for (int i = 0; i < data.length; ++i)
            myArray.add(data[i]);
        for (int i = 0; i < maxCount; ++i)
            System.out.println(myArray.get(i));

    }
}

