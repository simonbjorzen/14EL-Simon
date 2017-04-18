    import java.awt.*;
    import java.awt.event.*;
    import java.util.*;
    import javax.swing.*;
    import java.awt.GridBagConstraints;
    import java.awt.GridBagLayout;

public class Core extends JFrame implements ActionListener {


    public static void main(String[] args) {
        Core gui = new Core();
    }

    private final ImageIcon II_EMPTY = new ImageIcon(getClass().getClassLoader().getResource("bin/empty.gif"));
    private Pasture pasture;
    public JLabel[][] grid;
    private JButton startButton = new JButton("Start");
    private JButton stopButton = new JButton("Stop");
    private JButton exitButton = new JButton("Exit");
    private JButton createSheep = new JButton("Create Sheep");
    private JButton createWolf = new JButton("Create Wolf");
    private JButton createPlant = new JButton("Create Plant");

    public Core() {
        pasture = new Pasture(this);
        initPastureGUI();
    }

    private void initPastureGUI() {
        setSize(pasture.getWidth() * 30, pasture.getHeight() * 30);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        exitButton.addActionListener(this);
        createSheep.addActionListener(this);
        createWolf.addActionListener(this);
        createPlant.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 3));
        buttons.add(startButton);
        buttons.add(stopButton);
        buttons.add(exitButton);
        buttons.add(createSheep);
        buttons.add(createWolf);
        buttons.add(createPlant);


        JPanel field = new JPanel();
        field.setBackground(new Color(27, 204, 89));
        field.setLayout(new GridLayout(pasture.getHeight(),
                pasture.getWidth()));
        grid = new JLabel[pasture.getWidth()][pasture.getHeight()];

        for (int y = 0; y < pasture.getHeight(); y++) {
            for (int x = 0; x < pasture.getWidth(); x++) {
                grid[x][y] = new JLabel(II_EMPTY);
                grid[x][y].setVisible(true);
                field.add(grid[x][y]);
            }
        }

        Container display = getContentPane();
        display.setBackground(new Color(27, 204, 89));
        display.setLayout(new BorderLayout());
        display.add(field, BorderLayout.CENTER);
        display.add(buttons, BorderLayout.SOUTH);
        stopButton.setEnabled(false);
        startButton.setEnabled(true);
        updateAll();
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startButton.setEnabled(false);
            pasture.start();
            stopButton.setEnabled(true);
        }
        if (e.getSource() == stopButton) {
            stopButton.setEnabled(false);
            pasture.stop();
            startButton.setEnabled(true);
        }
        if (e.getSource() == exitButton) {
            System.exit(1);
        }

        if (e.getSource() == createSheep) {
            pasture.createSheep(pasture.getRandomPos());
        }
        if (e.getSource() == createWolf) {
            pasture.createWolf(pasture.getRandomPos());
        }
        if (e.getSource() == createPlant) {
            pasture.createPlant(pasture.getRandomPos());
        }
    }
    public void updateAll() {
        int width = pasture.getWidth();
        int height = pasture.getHeight();
        Entity[][] tempGrid = new Entity[width][height];
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                tempGrid[x][y] = null;
        Collection world = pasture.getEntities();
        Iterator it = world.iterator();
        while (it.hasNext()) {
            Entity e = (Entity) it.next();
            int x = (int) e.getPosition().getX();
            int y = (int) e.getPosition().getY();
            if (tempGrid[x][y] == null) {
                tempGrid[x][y] = e;
            }
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ImageIcon icon;
                Entity e = tempGrid[x][y];
                if (e == null) icon = II_EMPTY;
                else icon = e.getImage();
                grid[x][height - y - 1].setIcon(icon);
            }
        }
        

    }
}

