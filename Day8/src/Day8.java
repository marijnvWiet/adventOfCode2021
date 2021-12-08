import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Day8 {
    static String een = null;
    static String vier = null;
    static String zeven = null;
    static String acht = null;

    static String drie = null;
    static String nul = null;
    static String twee = null;
    static String vijf = null;
    static String zes = null;
    static String negen = null;

    static int result = 0;

    public static void main(String[] args) throws FileNotFoundException {
        part2();
    }

    private static void part1() throws FileNotFoundException {
        File myObj = new File("N:/java/adventOfCode/2021/adventOfCode2021/Day8/src/SevenSegment.txt");
        Scanner myReader = null;
        myReader = new Scanner(myObj);
        String[] datas = new String[0];
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            datas = data.split(" ");
            Boolean delimiter = false;
            for (int i = 0; i <= 14; i++) {
                if (datas[i].length() == 1) {
                    delimiter = true;
                }
                if ((datas[i].length() == 2 || datas[i].length() == 4 || datas[i].length() == 3 || datas[i].length() == 7) && delimiter) {
                    counter++;
                }
                System.out.print(datas[i].length() + " ");
            }
            System.out.println();
        }
        System.out.println(counter);
    }

    private static void part2() throws FileNotFoundException {
        File myObj = new File("N:/java/adventOfCode/2021/adventOfCode2021/Day8/src/SevenSegment.txt");
        Scanner myReader = null;
        myReader = new Scanner(myObj);
        String[] datas = new String[0];

        String leftTopLine = null;
        String middleLine = null;
        String topLine = null;
        String bottomLine = null;
        String rightTopLine = null;
        String leftBottomLine = null;
        String rightBottomLine = null;

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            datas = data.split(" ");
            for (int i = 0; i <= 14; i++) {
                switch (datas[i].length()) {
                    case 2:
                        een = datas[i];
                        break;
                    case 3:
                        zeven = datas[i];
                        break;
                    case 4:
                        vier = datas[i];
                        break;
                    case 7:
                        acht = datas[i];
                        break;
                }
            }
            String[] zeven2 = zeven.split("");
            for (int i = 0; i <= 14; i++) {
                if ((datas[i].contains(zeven2[0]) && datas[i].contains(zeven2[1]) && datas[i].contains(zeven2[2])) && datas[i].length() == 5) {
                    drie = datas[i];
                }
            }

            for (int i = 0; i <= 2; i++) {
                if (!een.contains(zeven2[i])) {
                    topLine = zeven2[i];
                }
            }
            String[] vier2 = vier.split("");
            for (int i = 0; i <= 3; i++) {
                if (!drie.contains(vier2[i])) {
                    leftTopLine = vier2[i];
                }
            }
            for (int i = 0; i <= 3; i++) {
                if (drie.contains(vier2[i]) && !(een.contains(vier2[i]) && een.contains(vier2[i]))) {
                    middleLine = vier2[i];
                }
            }
            String[] drie2 = drie.split("");
            for (int i = 0; i <= 4; i++) {
                if (!een.contains(drie2[i]) && !equalsString(drie2[i], topLine) && !equalsString(drie2[i], middleLine)) {
                    bottomLine = drie2[i];
                }
            }
            String[] een2 = een.split("");
            for (int i = 0; i <= 14; i++) {
                if (!datas[i].contains(middleLine) && !(datas[i].length() == 1) && !equalsString(datas[i], een) && !equalsString(datas[i], zeven)) {
                    nul = (datas[i]);
                }
                if (!datas[i].contains(leftTopLine) && !(datas[i].length() == 1) && !equalsString(datas[i], een) && !equalsString(datas[i], zeven) && !equalsString(datas[i], drie)) {
                    twee = datas[i];
                    String[] twee2 = twee.split("");
                    for (int j = 0; j <= 4; j++) {
                        try {
                            if (!drie.contains(twee2[j])) {
                                leftBottomLine = twee2[j];
                            }
                            if (!twee.contains(drie2[j])) {
                                rightBottomLine = drie2[j];
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println(e.getStackTrace());
                        }
                    }
                    if (!twee.contains(een2[0]) && twee.contains(een2[1])) {
                        rightTopLine = een2[0];
                    } else if (twee.contains(een2[0]) && !twee.contains(een2[1])) {
                        rightTopLine = een2[0];
                    }
                }
            }
            vijf = topLine + leftTopLine + middleLine + rightBottomLine + bottomLine;
            zes = topLine + leftTopLine + middleLine + leftBottomLine + rightBottomLine + bottomLine;
            negen = topLine + leftTopLine + rightTopLine + middleLine + rightBottomLine + bottomLine;
            int total = parseInt(checkNumber(datas[11]) + checkNumber(datas[12]) + checkNumber(datas[13]) + checkNumber(datas[14]));
            result += total;
        }
        System.out.println(result);
    }

    public static boolean equalsString(String source, String target) {
        try {
            String[] array1 = source.split("");
            String[] array2 = target.split("");
            if (!(array1.length == array2.length)) return false;
            for (int i = 0; i < array1.length; i++) {
                if (!source.contains(array2[i])) {
                    return false;
                }
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private static String checkNumber(String source) {
        if (equalsString(source, een)) {
            return "1";
        } else if (equalsString(source, twee)) {
            return "2";
        } else if (equalsString(source, drie)) {
            return "3";
        } else if (equalsString(source, vier)) {
            return "4";
        } else if (equalsString(source, vijf)) {
            return "5";
        } else if (equalsString(source, zes)) {
            return "6";
        } else if (equalsString(source, zeven)) {
            return "7";
        } else if (equalsString(source, acht)) {
            return "8";
        } else if (equalsString(source, negen)) {
            return "9";
        } else if (equalsString(source, nul)) {
            return "0";
        }
        return "";
    }
}
