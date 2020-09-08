package user;

import javax.swing.*;

public class ShowUser {
    public ShowUser( User user ){
        // создать новый контейнер типа JFraDe
        JFrame jfrm = new JFrame("Пользователь №" + user.numberUser + " " + user.stringFIO );
        // задать исходные размеры фрейма
        jfrm.setSize(1000, 500);
        // завершить работу, если пользователь закрывает приложение
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // создать метку с текстом сообщения



        ///////////////
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        jfrm.add(mainPanel);
        /////////////


        JLabel jlab = new JLabel("Пользователь №" + user.numberUser + " " + user.stringFIO );
        // ввести метку на панели содержимого
        panel1.add(jlab);




        String[] colHeadsAccounts = {"Счета"};
        String[][] dataAccounts = new String[user.sizeAccounts()][1];
        for(int n=0; n<user.sizeAccounts(); ++n){
            dataAccounts[n][0] = user.getAccount(n).numberAccount;
        }
        JTable tableAccounts = new JTable(dataAccounts, colHeadsAccounts);
        JScrollPane jspAccounts = new JScrollPane(tableAccounts);
        panel2.add(jspAccounts);


        String[] colHeadsPhones = {"Телефонные номера"};
        String[][] dataPhones = new String[user.sizePhones()][1];
        for(int n=0; n<user.sizePhones(); ++n){
            dataPhones[n][0] = user.getPhone(n).numberPhone;
        }
        JTable tablePhones = new JTable(dataPhones, colHeadsPhones);
        JScrollPane jspPhones = new JScrollPane(tablePhones);
        panel3.add(jspPhones);



        // отобразить фрейм
        jfrm.setVisible(true);
        // создать фрейм в потоке диспетчеризации событий
    }

}
