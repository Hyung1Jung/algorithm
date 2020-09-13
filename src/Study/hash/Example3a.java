package Study.hash;

public class Example3a {
    static class HashTable {
        int[] a;

        public HashTable() {
            a = new int[37];
        }

        public void add(int value) {
            a[value % 37] = value;
        }

        public void remove(int value) {
            a[value % 37] = 0;
        }

        public boolean contains(int value) {
            return a[value % 37] == value;
        }
    }

    public static void main(String[] args) {
        int maxValue = 200, maxCount = 10;
        HashTable hashTable = new HashTable();
        int[] data = { 1, 13, 105, 7, 9, 11, 14, 115, 107, 197 };
        for (int i = 0; i < data.length; ++i)
            hashTable.add(data[i]);
        for (int i = 1; i <= maxValue; ++i)
            if (hashTable.contains(i))
                System.out.println(i);
    }
}