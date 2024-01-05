package ru.ac.uniyar.testingcourse;
<<<<<<< HEAD
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
=======

import java.awt.*;
import java.awt.datatransfer.StringSelection;
>>>>>>> 450cf193a2b137fe5bb2bbfb7cb21c6fb3725ec6
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

<<<<<<< HEAD

public class Main {
    private static String modpackLogsPath = "";
    private static int delayInSeconds = 3;
    private static volatile boolean isRunning = false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Chat Automation Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("Enter modpack logs file path:");
        panel.add(label, constraints);

        constraints.gridy = 1;
        JTextField pathField = new JTextField(20);
        panel.add(pathField, constraints);

        constraints.gridy = 2;
        JLabel delayLabel = new JLabel("Enter delay (in seconds):");
        panel.add(delayLabel, constraints);

        constraints.gridy = 3;
        JTextField delayField = new JTextField("3", 5);
        panel.add(delayField, constraints);

        constraints.gridy = 4;
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modpackLogsPath = pathField.getText();
                try {
                    delayInSeconds = Integer.parseInt(delayField.getText());
                    isRunning = true;
                    startAutomation();
                    JOptionPane.showMessageDialog(frame, "Program started!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid delay. Please enter a valid number.");
                }
            }
        });
        panel.add(startButton, constraints);

        constraints.gridx = 1;
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRunning = false;
                JOptionPane.showMessageDialog(frame, "Program stopped!");
            }
        });
        panel.add(stopButton, constraints);

        frame.getContentPane().add(panel);
        frame.setSize(600, 400);

        frame.setVisible(true);
    }
    private static void startAutomation() {
        new Thread(() -> {
            try {
                while (isRunning) {
                    Thread.sleep(250);
                    String lastLogLine = getSecondToLastLogLine();
                    if (lastLogLine != null) {
                        if (lastLogLine.contains("[CHAT] [Kaboom] Решите пример:")) {
                            String expression = lastLogLine.substring(lastLogLine.indexOf(":") + 2);
                            expression = expression.trim();
                            String[] parts = expression.split(" ");
                            int operand1 = Integer.parseInt(parts[7].trim());
                            char operator = parts[8].trim().charAt(0);
                            int operand2 = Integer.parseInt(parts[9].trim());

                            int result;
                            if (operator == '+') {
=======
public class Main {
    private static final String modpackLogsPath = "C:\\Users\\User\\AppData\\Roaming\\Kaboom\\modpacks\\1.7.10\\modpacks\\skyfactory\\logs\\latest.log";
    //private static final String modpackLogsPath = "D:\\Kaboom\\modpacks\\1.7.10\\modpacks\\skyfactory\\logs\\latest.log";

    public static void main(String[] args) {
        try {
            // Check if SystemTray is supported
            if (SystemTray.isSupported()) {
                // Create a system tray
                SystemTray tray = SystemTray.getSystemTray();

                // Load an image for the icon (replace "path_to_icon.png" with the actual path)
                Image image = Toolkit.getDefaultToolkit().getImage("path_to_icon.png");

                // Create a popup menu for the tray icon
                PopupMenu popup = new PopupMenu();
                MenuItem exitItem = new MenuItem("Exit");
                exitItem.addActionListener(e -> System.exit(0));
                popup.add(exitItem);

                // Create a tray icon with a popup menu
                TrayIcon trayIcon = new TrayIcon(image, "Your Application Name", popup);

                // Add the tray icon to the system tray
                tray.add(trayIcon);

                // Display a notification
                trayIcon.displayMessage("JAR File Activated", "Your JAR file has been activated.", TrayIcon.MessageType.INFO);
            }

            Robot robot = new Robot();

            while (true) {
                Thread.sleep(250);

                String lastLogLine = getSecondToLastLogLine();

                if (lastLogLine != null) {

                    if (lastLogLine.contains("[CHAT] [Kaboom] Решите пример:")) {
                        String expression = lastLogLine.substring(lastLogLine.indexOf(":") + 2);
                        expression = expression.trim(); // Удаляем лишние пробелы
                        String[] parts = expression.split(" "); // Разбиваем выражение на части
                        System.out.println(parts[7]+parts[8]+parts[9]);
                        int operand1 = Integer.parseInt(parts[7].trim());
                        char operator = parts[8].trim().charAt(0);
                        int operand2 = Integer.parseInt(parts[9].trim());

                        int result;
                        if (operator == '+') {
>>>>>>> 450cf193a2b137fe5bb2bbfb7cb21c6fb3725ec6
                                result = operand1 + operand2;
                            } else if (operator == '-') {
                                result = operand1 - operand2;
                            } else if (operator == '*') {
                                result = operand1 * operand2;
                            } else if (operator == '/') {
                                result = operand1 / operand2;
                            } else {
<<<<<<< HEAD
                                result = 0;
                            }

                            Robot robot = new Robot();
                            robot.keyPress(KeyEvent.VK_T);
                            robot.keyRelease(KeyEvent.VK_T);

                            robot.keyPress(KeyEvent.VK_ENTER);
                            robot.keyRelease(KeyEvent.VK_ENTER);

                            robot.keyPress(KeyEvent.VK_T);
                            robot.keyRelease(KeyEvent.VK_T);

                            Thread.sleep(delayInSeconds * 1000);

                            for (char c : String.valueOf(result).toCharArray()) {
                                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
                                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
                            }

                            robot.keyPress(KeyEvent.VK_ENTER);
                            robot.keyRelease(KeyEvent.VK_ENTER);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
=======
                                result = 0; // Значение по умолчанию
                            }
                        robot.keyPress(KeyEvent.VK_T);
                        robot.keyRelease(KeyEvent.VK_T);

                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                            // Emulate pressing 't'
                            robot.keyPress(KeyEvent.VK_T);
                            robot.keyRelease(KeyEvent.VK_T);

                            // Вводим ответ через 1 - 3 секунды
                        Thread.sleep(1000);
                        // Вводим ответ через 1 - 3 секунды
                        for (char c : String.valueOf(result).toCharArray()) {
                            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
                            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
                        }


                            // Emulate pressing 'Enter'
                            robot.keyPress(KeyEvent.VK_ENTER);
                            robot.keyRelease(KeyEvent.VK_ENTER);
                    }
                    if (lastLogLine.contains("[CHAT] Dorey joined the game.")) {
                        String result = "!Слався нашь Дори, упр СкайЭво, Ура!";

                        System.out.println("Result: " + result);
                        robot.keyPress(KeyEvent.VK_T);
                        robot.keyRelease(KeyEvent.VK_T);

                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                        robot.keyPress(KeyEvent.VK_T);
                        robot.keyRelease(KeyEvent.VK_T);
                        // Вводим ответ через 1 - 3 секунды
                        Thread.sleep(1000);

                        // Очищаем буфер обмена и копируем результат в буфер
                        StringSelection selection = new StringSelection(result);
                        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);

                        // Вставляем текст из буфера обмена
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_CONTROL);

                        // Эмулируем нажатие Enter
                        robot.keyPress(KeyEvent.VK_ENTER);
                        robot.keyRelease(KeyEvent.VK_ENTER);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
>>>>>>> 450cf193a2b137fe5bb2bbfb7cb21c6fb3725ec6
    }

    private static String getSecondToLastLogLine() {
        try (BufferedReader br = new BufferedReader(new FileReader(modpackLogsPath))) {
            String line;
            String lastLine = null;
            String secondToLastLine = null;
            while ((line = br.readLine()) != null) {
                secondToLastLine = lastLine;
                lastLine = line;
            }
            return secondToLastLine;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
