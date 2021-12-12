import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.util.Comparator.naturalOrder;

public class Day10 {
    static String[] missing = new String[0];

    public static void main(String[] args) throws FileNotFoundException {
        part2();
    }

    private static void part1() throws FileNotFoundException {
        File myObj = new File("N:/java/adventOfCode/2021/adventOfCode2021/Day10/src/lines.txt");
        Scanner myReader = null;
        int total = 0;
        myReader = new Scanner(myObj);
        String[] datas = new String[0];
        while (myReader.hasNextLine()) {
            String  data = myReader.nextLine();
            datas = data.split("");
            String result = check(datas);
        if (result.equals("}")){
            total += 1197;
        }else if(result.equals(">")){
            total += 25137;
        }else if(result.equals(")")){
            total += 3;
        }else if (result.equals("]")){
            total += 57;
        }
//            System.out.println(data);
        }
        System.out.println(total);
    }
    private static void part2() throws FileNotFoundException {
        File myObj = new File("N:/java/adventOfCode/2021/adventOfCode2021/Day10/src/lines.txt");
        Scanner myReader = null;
        myReader = new Scanner(myObj);
        String[] datas = new String[0];
        ArrayList<Long> results = new ArrayList<Long>();
        while (myReader.hasNextLine()) {
            String  data = myReader.nextLine();
            datas = data.split("");
            String result = check(datas);
            if (result.equals("}")){
                missing = new String[0];
            }else if(result.equals(">")){
                missing = new String[0];
            }else if(result.equals(")")){
                missing = new String[0];
            }else if (result.equals("]")){
                missing = new String[0];
            }else {
//                System.out.println(Arrays.toString(missing));
                results.add(checkData());
            }
        }
        results.sort(naturalOrder());
        System.out.println(results.get(results.size()/2));
    }

    private static String check(String[] data){
        ArrayList<String> open = new ArrayList<>();
        int counter = 0;
        for (int i =0;i < data.length;i++){
//            System.out.println(open);
            if (data[i].equals("(") || data[i].equals("[") || data[i].equals("{") || data[i].equals("<")){
                open.add(data[i]);
                counter++;
//                System.out.println(data[i]);
            }else if (data[i].equals(")")){
                if (!(open.get(counter-1).equals("("))){
                    return data[i];
                }else {
                    open.remove(counter-1);
                    counter--;
                }
            }else if (data[i].equals("]")){
                if (!(open.get(counter-1).equals("["))){
                    return data[i];
                }else {
                    open.remove(counter-1);
                    counter--;

                }
            }else if (data[i].equals("}")){
                if (!(open.get(counter-1).equals("{"))){
                    return data[i];
                }else {
                    open.remove(counter-1);
                    counter--;
                }
            }else if (data[i].equals(">")){
                if (!(open.get(counter-1).equals("<"))){
                    return data[i];
                }else {
                    open.remove(counter-1);
                    counter--;
                }
            }
        }
        missing = open.toArray(new String[0]);
        return "";
    }
    private static long checkData(){
        long total = 0;
        for (int i=missing.length-1;i>=0;i--){
            total = total*5;
            if (missing[i].equals("{")){
                total +=3;
            }else if(missing[i].equals("<")){
                total +=4;
            }else if(missing[i].equals("(")){
                total +=1;
            }else if (missing[i].equals("[")){
                total +=2;
            }
        }
        return total;
    }
}
