import java.util.HashMap;
import java.util.Map;

public class SymbolDefinitions {
    public static final Map<String, int[]> SYMBOLS = new HashMap<>();

    static {
        SYMBOLS.put(" ", new int[] {23, 125, 197, 12, 152, 53, 207, 232, 78, 212, 26, 202, 181, 145, 17, 32, 175, 155, 29, 142, 41, 38});
        SYMBOLS.put("!", new int[] {68});
        SYMBOLS.put(",", new int[] {110, 159, 117});
        SYMBOLS.put(".", new int[] {82, 112, 165});
        SYMBOLS.put("?", new int[] {150});
        SYMBOLS.put("a", new int[] {138, 192, 1, 42, 169, 25, 251, 252, 105, 129, 154, 215, 234});
        SYMBOLS.put("b", new int[] {97, 242, 16});
        SYMBOLS.put("c", new int[] {144, 43, 210, 249, 76});
        SYMBOLS.put("d", new int[] {238, 186, 137, 87, 206, 228, 208});
        SYMBOLS.put("e", new int[] {254, 95, 58, 134, 66, 201, 200, 156, 79, 56, 176, 139, 229, 213, 46, 223, 198, 72, 220, 237});
        SYMBOLS.put("f", new int[] {196, 4, 147, 193});
        SYMBOLS.put("g", new int[] {133, 164, 83});
        SYMBOLS.put("h", new int[] {59, 140, 190, 119, 80, 62, 73, 60, 21, 109});
        SYMBOLS.put("i", new int[] {194, 122, 81, 171, 107, 179, 240, 61, 89, 209, 149, 108});
        SYMBOLS.put("j", new int[] {118});
        SYMBOLS.put("k", new int[] {216});
        SYMBOLS.put("l", new int[] {49, 36, 24, 161, 98, 162, 10});
        SYMBOLS.put("m", new int[] {166, 236, 126, 52});
        SYMBOLS.put("n", new int[] {128, 148, 84, 214, 255, 180, 130, 37, 106, 57, 28});
        SYMBOLS.put("o", new int[] {22, 65, 44, 63, 11, 5, 121, 185, 6, 99, 74, 177});
        SYMBOLS.put("p", new int[] {120, 132, 115});
        SYMBOLS.put("q", new int[] {173});
        SYMBOLS.put("r", new int[] {141, 102, 64, 90, 33, 75, 184, 245, 111, 178});
        SYMBOLS.put("s", new int[] {15, 195, 91, 3, 35, 191, 170, 103, 8, 221, 233});
        SYMBOLS.put("t", new int[] {168, 96, 40, 174, 9, 146, 226, 20, 135, 231, 39, 116, 225, 86, 104});
        SYMBOLS.put("u", new int[] {50, 88, 219, 30, 222});
        SYMBOLS.put("v", new int[] {51, 7});
        SYMBOLS.put("w", new int[] {248, 218, 224, 67});
        SYMBOLS.put("x", new int[] {55});
        SYMBOLS.put("y", new int[] {2, 244, 157, 205});
        SYMBOLS.put("z", new int[] {151});
    }
}