import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Main {
    private static final String modpackLogsPath = "D:\\Programs\\Kaboom\\modpacks\\1.7.10\\modpacks\\skyfactory\\logs\\latest.log";

    public static void main(String[] args) {
        // Создаём цикл с задержкой каждые 250 мс
        while (true) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Читаем файл с логами и обрезаем
            String[] lastLogLines = getLastLogLines(32);

            // Обрабатываем строки и ищем решаемый пример
            for (String line : lastLogLines) {
                line = line.substring(32);

                // Является ли данная строка сообщением из чата
                if (line.substring(1, 7).equals("[CHAT]")) {
                    // Теперь ищем /\"[Kaboom] Решите пример:/\"
                    if (line.substring(8, 31).equals("[Kaboom] Решите пример:")) {
                        String expression = line.substring(32);
                        String expressionResult = "";
                        int[] ints;

                        if (expression.split("\\+").length == 2) {
                            ints = new int[2];
                            String[] splitExpression = expression.split("\\+");
                            for (int i = 0; i < splitExpression.length; i++) {
                                ints[i] = Integer.parseInt(splitExpression[i]);
                            }
                            expressionResult = Integer.toString(ints[0] + ints[1]);
                        }

                        if (expression.split("\\*").length == 2) {
                            ints = new int[2];
                            String[] splitExpression = expression.split("\\*");
                            for (int i = 0; i < splitExpression.length; i++) {
                                ints[i] = Integer.parseInt(splitExpression[i]);
                            }
                            expressionResult = Integer.toString(ints[0] * ints[1]);
                        }

                        // Вводим результат в чат через 1 - 3 секунды
                        try {
                            Thread.sleep((long) (Math.random() * 2.723456789 * 1000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("t");
                        System.out.println(expressionResult);
                        System.out.println("enter");
                    }
                }
            }
        }
    }

    private static String[] getLastLogLines(int count) {
        String[] lines = new String[count];
        try (BufferedReader br = new BufferedReader(new FileReader(modpackLogsPath))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null && index < count) {
                lines[index++] = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
