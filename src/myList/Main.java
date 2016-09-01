package myList;

/**
 * Created by Asus on 31.08.2016.
 */
public class Main {
public static void main(String[] args){
    MyIntegerList myIntegerList = new MyIntegerList();
    myIntegerList.put(Integer.valueOf(23));
    myIntegerList.put(Integer.valueOf(12));

    System.out.println(myIntegerList.toString());

}
}
