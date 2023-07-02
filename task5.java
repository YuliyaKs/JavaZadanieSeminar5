import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class task5 {
    static ArrayList<String> name = new ArrayList<>(); // ��� �������� ����
    static ArrayList<Integer> count = new ArrayList<>(); // ��� �������� ���������� �������
    static HashMap<String, String> phoneBook = new HashMap<>(); // ���������� �����

    // ����� ��� ���������� ���������� �����
    public static void addContact(String fio, String phone) {
        int index = 0;
        if (!phoneBook.containsValue(fio)){
            phoneBook.put(phone, fio);
            name.add(fio);
            count.add(1);
        } 
        else{
            phoneBook.put(phone, fio);
            index = name.indexOf(fio);
            count.set(index, count.get(index) + 1);
        }
    }  

    // ����� ��� ������ �� ������ ���������� �����
    public static void printContact(){
        ArrayList<Integer> name1 = new ArrayList<>(); // ������� ��������������� ������
        for (int i = 0; i < name.size(); i++) {
            name1.add(i);
        }
        Collections.sort(name1, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * (count.get(o1) - count.get(o2));
            }

        });
        for (int index : name1) {
            for (String key : phoneBook.keySet()) {
                if (phoneBook.get(key).equals(name.get(index))){
                    System.out.println(phoneBook.get(key) + ", ����� ��������: " + key);
                }
                
            }

        }
 
    }
        
    public static void main(String[] args) {
        addContact("������ �.�.", "123456789");
        addContact("������ �.�.", "987654321");
        addContact("������� �.�.", "135797531");
        addContact("������ �.�.", "246886420");
        addContact("������ �.�.", "123789456");
        addContact("������� �.�.", "456123789");
        addContact("�������� �.�.", "123010121");
        printContact();
    }   
}   