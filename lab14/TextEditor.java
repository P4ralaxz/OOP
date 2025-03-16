
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class TextEditor implements ActionListener {

    private JFrame fr;
    private JMenuBar menubar;
    private JMenu fileMenu;
    private JMenuItem newItem, openMenuItem, saveItem, closeItem;
    private JTextArea textArea;

    public TextEditor() {
        fr = new JFrame("My Text Editor");
        menubar = new JMenuBar();
        fileMenu = new JMenu("File");
        newItem = new JMenuItem("New");
        openMenuItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        closeItem = new JMenuItem("Close");
        textArea = new JTextArea();

        fr.setJMenuBar(menubar);

        fileMenu.add(newItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(closeItem);

        menubar.add(fileMenu);

        newItem.addActionListener(this);
        closeItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveItem.addActionListener(this);

        fr.add(textArea);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500, 500);
        fr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(newItem)) {
            textArea.setText("");
        } else if (source.equals(closeItem)) {
            fr.setVisible(false);
            fr.dispose();
        } else if (source.equals(openMenuItem)) {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(fr);
            File file = fc.getSelectedFile();
            String text = "";

            try ( FileReader fileReader = new FileReader(file)) {
                int ch;
                while ((ch = fileReader.read()) != -1) {
                    text += (char) ch;
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            textArea.setText(text);

        } else if (source.equals(saveItem)) {
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(fr);
            File file = fc.getSelectedFile();
            String text = textArea.getText();

            try ( FileWriter fw = new FileWriter(file)) {
                for (int i = 0; i < text.length(); i++) {
                    fw.write(text.charAt(i));
                }
            } catch (IOException ex) {
                Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}