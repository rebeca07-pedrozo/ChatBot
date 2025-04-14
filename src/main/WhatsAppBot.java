package com.pruebas;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WhatsAppBot extends JFrame {
    private JCheckBox activarCheckBox;
    private JButton abrirWhatsButton;
    private JButton abrirDialogflowButton;
    private JTextField urlDialogflowTextField;
    private WebDriver driver;

    public WhatsAppBot() {
        activarCheckBox = new JCheckBox("Activar Bot");
        abrirWhatsButton = new JButton("Abrir WhatsApp Web");
        abrirDialogflowButton = new JButton("Abrir Dialogflow Demo");
        urlDialogflowTextField = new JTextField(30);

        setLayout(new FlowLayout());
        add(new JLabel("Ingrese URL de Dialogflow:"));
        add(urlDialogflowTextField);
        add(activarCheckBox);
        add(abrirWhatsButton);
        add(abrirDialogflowButton);

        activarCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (activarCheckBox.isSelected()) {
                    abrirDialogflow();
                }
            }
        });

        abrirWhatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirWhatsAppWeb();
            }
        });

        abrirDialogflowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirDialogflow();
            }
        });

        setTitle("Integración WhatsApp y Dialogflow");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void abrirDialogflow() {
        try {
            String url = urlDialogflowTextField.getText();
            if (!url.isEmpty()) {
                ChromeOptions options = new ChromeOptions();
                options.setAcceptInsecureCerts(true);
                options.addArguments("start-maximized");

                WebDriver botDriver = new ChromeDriver(options);
                botDriver.get(url);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese una URL válida de Dialogflow.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void abrirWhatsAppWeb() {
        try {
            System.setProperty("webdriver.chrome.driver", "C://Users//USUARIO//OneDrive//Documentos//diver//chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");

            driver = new ChromeDriver(options);
            driver.get("https://web.whatsapp.com");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new WhatsAppBot();
    }
}
