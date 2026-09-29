import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


interface FormActions {
    void onStart();
    void onBack();
    void onConfirm(String name, String age, String major);
    void onFinalConfirm();
}


abstract class BasePanel extends JPanel {
    protected FormActions controller;

    public BasePanel(FormActions controller) {
        this.controller = controller;
        initUI();
    }

    protected abstract void initUI();
}


class StartPanel extends BasePanel {
    public StartPanel(FormActions controller) {
        super(controller);
    }

    @Override
    protected void initUI() {
        setLayout(new FlowLayout());
        JLabel label = new JLabel("Welcome to Student Registration");
        JButton startBtn = new JButton("Start");
        startBtn.addActionListener(e -> controller.onStart());
        add(label);
        add(startBtn);
    }
}


class FormPanel extends BasePanel {
    private JTextField nameField, ageField, majorField;

    public FormPanel(FormActions controller) {
        super(controller);
    }

    @Override
    protected void initUI() {
        setLayout(new GridLayout(4, 2, 10, 10));
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Major:"));
        majorField = new JTextField();
        add(majorField);

        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(e -> controller.onConfirm(
                nameField.getText(),
                ageField.getText(),
                majorField.getText()
        ));
        add(new JLabel()); 
        add(submitBtn);
    }
}


class ConfirmPanel extends BasePanel {
    private JLabel nameLabel, ageLabel, majorLabel;

    public ConfirmPanel(FormActions controller) {
        super(controller);
    }

    public void setData(String name, String age, String major) {
        nameLabel.setText("Name: " + name);
        ageLabel.setText("Age: " + age);
        majorLabel.setText("Major: " + major);
    }

    @Override
    protected void initUI() {
        setLayout(new GridLayout(5, 1, 10, 10));
        nameLabel = new JLabel();
        ageLabel = new JLabel();
        majorLabel = new JLabel();

        add(nameLabel);
        add(ageLabel);
        add(majorLabel);

        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton backBtn = new JButton("Back");
        JButton confirmBtn = new JButton("Confirm");

        backBtn.addActionListener(e -> controller.onBack());
        confirmBtn.addActionListener(e -> controller.onFinalConfirm());

        btnPanel.add(backBtn);
        btnPanel.add(confirmBtn);
        add(btnPanel);
    }
}


class ThankYouPanel extends BasePanel {
    public ThankYouPanel(FormActions controller) {
        super(controller);
    }

    @Override
    protected void initUI() {
        setLayout(new FlowLayout());
        add(new JLabel("Thank you for registering!"));
    }
}


public class StudentRegistrationApp extends JFrame implements FormActions {
    private final CardLayout cardLayout;
    private final JPanel mainPanel;
    private final FormPanel formPanel;
    private final ConfirmPanel confirmPanel;

    public StudentRegistrationApp() {
        setTitle("Student Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

      
        StartPanel startPanel = new StartPanel(this);
        formPanel = new FormPanel(this);
        confirmPanel = new ConfirmPanel(this);
        ThankYouPanel thankYouPanel = new ThankYouPanel(this);

        
        mainPanel.add(startPanel, "Start");
        mainPanel.add(formPanel, "Form");
        mainPanel.add(confirmPanel, "Confirm");
        mainPanel.add(thankYouPanel, "Thanks");

        add(mainPanel);
        cardLayout.show(mainPanel, "Start");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRegistrationApp().setVisible(true));
    }

    // Interface method implementations
    @Override
    public void onStart() {
        cardLayout.show(mainPanel, "Form");
    }

    @Override
    public void onBack() {
        cardLayout.show(mainPanel, "Form");
    }

    @Override
    public void onConfirm(String name, String age, String major) {
        confirmPanel.setData(name, age, major);
        cardLayout.show(mainPanel, "Confirm");
    }

    @Override
    public void onFinalConfirm() {
        cardLayout.show(mainPanel, "Thanks");
    }
}