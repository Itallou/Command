package Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editor {
    private TV tv;
    private CommandHistory history = new CommandHistory();

    public void init() {
        tv = new TV();
        JFrame frame = new JFrame("Controle Remoto da TV");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        // Painel para os botões de controle
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnLigar = new JButton("Ligar TV");
        JButton btnDesligar = new JButton("Desligar TV");
        JButton btnAumentarVolume = new JButton("Aumentar Volume");
        JButton btnDiminuirVolume = new JButton("Diminuir Volume");
        JButton btnUndo = new JButton("Desfazer");

        // Ações para os botões
        btnLigar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new LigarTVCommand(tv));
            }
        });

        btnDesligar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new DesligarTVCommand(tv));
            }
        });

        btnAumentarVolume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new AumentarVolumeCommand(tv));
            }
        });

        btnDiminuirVolume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new AbaixarVolumeCommand(tv));
            }
        });

        btnUndo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undo();
            }
        });

        // Adicionando os botões ao painel
        buttons.add(btnLigar);
        buttons.add(btnDesligar);
        buttons.add(btnAumentarVolume);
        buttons.add(btnDiminuirVolume);
        buttons.add(btnUndo);
        content.add(buttons);

        // Configurando a janela
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    private void undo() {
        if (history.isEmpty()) {
            System.out.println("Não há comandos para desfazer.");
            return;
        }

        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Editor editor = new Editor();
            editor.init();
        });
    }
}
