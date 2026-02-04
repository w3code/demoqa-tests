package utils;

import java.util.List;

public class RandomUtils {
    public static int getRandomIntFromRange(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public static String getRandomItemFromList(List<String> list) {
        int randomNum = getRandomIntFromRange(0, list.size() - 1);
        return list.get(randomNum);
    }

    public static String getRandomItemFromArgs(String ...args) {
        int randomNum = getRandomIntFromRange(0, args.length - 1);
        return args[randomNum];
    }
}
