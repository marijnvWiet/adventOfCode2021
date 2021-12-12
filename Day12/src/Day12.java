import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Day12 {
    private ArrayList<String> connections;

    public static void main(String[] args) throws FileNotFoundException {
        Day12 day12 = new Day12();
        day12.part2();
    }
    public Day12() throws FileNotFoundException {
        Scanner reader = null;
        reader = new Scanner(new File("N:/java/adventOfCode/2021/adventOfCode2021/Day12/src/paths.txt"));
        connections = new ArrayList<String>();
        while (reader.hasNext()) {
            connections.add(reader.nextLine());
        }
        reader.close();
    }

    public void part1() {
        ArrayList<String> paths = generatePaths(false);
        System.out.println(paths.size());
    }

    public void part2() {
        ArrayList<String> paths = generatePaths(true);
        System.out.println(paths.size());
    }

    /**
     * @param part2 True if we are generating paths based on the rule change for
     *              part 2. False, otherwise.
     * @return A list of all paths from "start" to "end" based on slightly different
     * rules for part 1 and part 2.
     */
    public ArrayList<String> generatePaths(boolean part2) {
        ArrayList<String> completedPaths = new ArrayList<String>();
        Stack<String> pathsInProgress = new Stack<String>();
        pathsInProgress.add("start");
        while (pathsInProgress.size() > 0) {
            String path = pathsInProgress.pop();
            String currentCave = path.substring(path.lastIndexOf("-") + 1);
            String connectingCaves = "";
            for (String connection : connections) {
                if (connection.contains(currentCave)) {
                    connectingCaves += connection.replace("-", "").replace(currentCave, "") + " ";
                }
            }
            String[] cavesWeCanAccess = connectingCaves.trim().split(" ");
            for (String cave : cavesWeCanAccess) {
                if (cave.equals("start")) {
                } else if (cave.equals("end")) {
                    completedPaths.add(path + "-" + cave);
                } else if (cave.equals(cave.toLowerCase())) {
                    if (!path.contains(cave)) {
                        pathsInProgress.add(path + "-" + cave);
                    } else if (part2 && !path.contains("X:")) {
                        pathsInProgress.add("X:" + path + "-" + cave);
                    }
                } else {
                    pathsInProgress.add(path + "-" + cave);
                }
            }
        }

        return completedPaths;
    }
}
