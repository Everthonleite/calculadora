import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class teste {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Pro Rata Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel reservaLabel = new JLabel("Data da Reserva (dd/MM/yyyy):");
        JTextField reservaField = new JTextField();
        JLabel aniversarioLabel = new JLabel("Data de Aniversário (dd/MM/yyyy):");
        JTextField aniversarioField = new JTextField();
        JButton calcularButton = new JButton("Calcular Pro Rata");
        JLabel resultadoLabel = new JLabel("Pro rata:");

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date reservaDate = dateFormat.parse(reservaField.getText());
                    Date aniversarioDate = dateFormat.parse(aniversarioField.getText());

                    Calendar reservaCalendar = Calendar.getInstance();
                    reservaCalendar.setTime(reservaDate);

                    Calendar aniversarioCalendar = Calendar.getInstance();
                    aniversarioCalendar.setTime(aniversarioDate);

                    int proRataMonths = 0;

                    reservaCalendar.add(Calendar.MONTH, 1);

                    while (reservaCalendar.before(aniversarioCalendar)) {
                        proRataMonths++;
                        reservaCalendar.add(Calendar.MONTH, 1);
                    }

                    resultadoLabel.setText("Pro rata: " + proRataMonths + " meses");
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(frame, "Formato de data inválido. Use o formato dd/MM/yyyy.");
                }
            }
        });

        frame.add(reservaLabel);
        frame.add(reservaField);
        frame.add(aniversarioLabel);
        frame.add(aniversarioField);
        frame.add(calcularButton);
        frame.add(resultadoLabel);

        frame.pack();
        frame.setVisible(true);
    }
}
