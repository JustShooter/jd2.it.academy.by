package by.academy.it.jd2.task01;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task01 {
    public static final String TAB_REGEX = "\t";
    public static final String IN_TXT = "src/main/resources/in.txt";
    public static final String OUT_TXT = "src/main/resources/out.txt";
    public static final String DIGITS_REGEX = "^\\d+";
    private static int linesCount;
    private static int linesCount2;

    public static void main(String[] args) {
        File inputFile = new File(IN_TXT);
        File outputFile = new File(OUT_TXT);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            br.lines()
                    .map(s -> {linesCount++;
                            return Arrays.stream(s.split(TAB_REGEX))
                            .collect(Collectors.toList());})
                    .sorted(getListComparator())
                    .forEach(writeOutputFIle(bw));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Consumer<List<String>> writeOutputFIle(BufferedWriter bw) {
        return s -> {
            linesCount2++;
            for (int i = 0; i < s.size(); i++) {
                try {
                    if (i < s.size() - 1) {
                        bw.write(s.get(i) + "\t");
                    } else {
                        if (linesCount2 == linesCount) {
                            bw.write(s.get(i));
                        } else {
                            bw.write(s.get(i) + "\n");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private static Comparator<List<String>> getListComparator() {
        return (o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                if (o1.get(i).equals(o2.get(i))) {
                    continue;
                }
                Pattern pattern = Pattern.compile(DIGITS_REGEX);
                Matcher matcher1 = pattern.matcher(o1.get(i));
                Matcher matcher2 = pattern.matcher(o2.get(i));
                if (matcher1.matches() && matcher2.matches()) {
                    return Integer.valueOf(o1.get(i)).compareTo(Integer.valueOf(o2.get(i)));
                }
                if (!matcher1.matches() && !matcher2.matches()) {
                    return o1.get(i).compareTo(o2.get(i));
                }
            }
            return 0;
        };
    }
}
