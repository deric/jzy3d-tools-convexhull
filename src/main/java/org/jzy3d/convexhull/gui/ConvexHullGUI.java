package org.jzy3d.convexhull.gui;


import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import javax.swing.JFileChooser;
import org.jzy3d.convexhull.algorithms.Converter;
import org.jzy3d.convexhull.algorithms.Point2f;
import org.jzy3d.convexhull.ConvexHullFunction;
import org.jzy3d.convexhull.GrahamScan;
import org.jzy3d.convexhull.JarvisMarch;
import org.jzy3d.convexhull.io.DataReader;
import org.jzy3d.convexhull.utils.LinkedList;
import org.jzy3d.convexhull.utils.List;
import org.jzy3d.convexhull.utils.Stack;

/**
 * Luokka on sisäisesti C-kielimäinen:
 * kokonaisuus riippuu yksityiskohdista ja
 * muodostaa funktiokutsuhierarkian. 
 *
 * Eli käyttöliittymä on täyttä tuubaa,
 * koska se ei noudata jaloja OO-periaatteita.
 * Tärkein periaate silti on, että sovellusalueen luokat
 * eivät riipu käyttöliittymästä eli kyseessä
 * on kerrosarkkitehtuuri.
 * 
 * @author  Teemu Linkosaari
 */
public class ConvexHullGUI extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas;
    private javax.swing.JLabel celsiusLabel;
    private javax.swing.JLabel celsiusLabel1;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton convertButton;
    private javax.swing.JButton drawHullButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField pointsTextField;
    private javax.swing.JLabel ptsLabel;
    // End of variables declaration//GEN-END:variables
    private static final long serialVersionUID = 13243234;
    final JFileChooser fileChooser = new JFileChooser();
    File file;
    // Lisatyt muuttujat
    List<Point2f> lista = new LinkedList<Point2f>();
    int points = 0;    

    /** Creates new form */
    public ConvexHullGUI() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pointsTextField = new javax.swing.JTextField();
        celsiusLabel = new javax.swing.JLabel();
        convertButton = new javax.swing.JButton();
        canvas = new java.awt.Canvas();
        drawHullButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ptsLabel = new javax.swing.JLabel();
        celsiusLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visual Convex Hull ");

        pointsTextField.setText("10");
        pointsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pointsTextFieldActionPerformed(evt);
            }
        });

        celsiusLabel.setText("Points");

        convertButton.setText("Draw");
        convertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertButtonActionPerformed(evt);
            }
        });

        canvas.setBackground(new java.awt.Color(255, 255, 255));
        canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                click(evt);
            }
        });

        drawHullButton.setText("Draw Convex Hull");
        drawHullButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawHullButtonActionPerformed(evt);
            }
        });

        jTextField1.setText("10");
        jTextField1.setEnabled(false);

        jTextField2.setText("-10");
        jTextField2.setEnabled(false);

        jLabel1.setText("x min");

        jLabel2.setText("x max");

        jTextField3.setText("-10");
        jTextField3.setEnabled(false);

        jTextField4.setText("10");
        jTextField4.setEnabled(false);

        jLabel3.setText("y max");

        jLabel4.setText("y min");

        clearButton.setText("Clear canvas");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        jButton3.setText("Update Boundaries");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ptsLabel.setText("0");

        celsiusLabel1.setText("drawn:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jarvis's March", "Graham's Scan" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Algorithm:");

        jButton1.setText("Delete Hull");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Load File");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("draw lines");
        jMenu2.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(drawHullButton)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(convertButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(celsiusLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pointsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clearButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(celsiusLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ptsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton3))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(celsiusLabel)
                            .addComponent(convertButton)
                            .addComponent(pointsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(drawHullButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(celsiusLabel1)
                            .addComponent(ptsLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)))
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3))
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );

        ptsLabel.getAccessibleContext().setAccessibleName("ptsLabel");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void pointsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pointsTextFieldActionPerformed

	}//GEN-LAST:event_pointsTextFieldActionPerformed

    private void convertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertButtonActionPerformed

        int w = (int) canvas.getBounds().getWidth();
        int h = (int) canvas.getBounds().getHeight();

        Converter c = new Converter(canvas.getWidth(), canvas.getHeight(), 10, 10);

        Graphics g = canvas.getGraphics();
        g.setColor(Color.red);
        g.drawLine(0, h / 2, w, h / 2); // horizontal axis
        g.drawLine(w / 2, 0, w / 2, h); // vertical axis

        int pts = (int) ((Double.parseDouble(pointsTextField.getText())));
        pointsTextField.setText("0");

        // Piirrä mustia pisteitä.
        g.setColor(Color.black);

        for (int i = 0; i < pts; i++) {
            double xx = w * Math.random();
            double yy = h * Math.random();

			// Piirrä
			g.fillOval((int) xx - 2, (int) yy - 2, 4, 4);
			
			// Lisää listaan
			c = new Converter(canvas.getWidth(), canvas.getHeight(), 10, 10);
            lista.insert(c.to(new Point2f(xx, yy)));
        }

        ptsLabel.setText("" + lista.size());
		
	}//GEN-LAST:event_convertButtonActionPerformed
	
    private void click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_click
		// Tulkitse viesti: poimi hiiren koordinaatit.
        int xx = evt.getX();
        int yy = evt.getY();

		// Piirrä ruudulle.
        Graphics g = canvas.getGraphics();
        g.setColor(Color.black);
        g.fillOval(xx - 2, yy - 2, 4, 4);

		// Lisää listaan.
        Converter c = new Converter(canvas.getWidth(), canvas.getHeight(), 10, 10);
        lista.insert(c.to(new Point2f(xx, yy)));

		// Näytä gui:ssa listan koko.
        ptsLabel.setText("" + lista.size());
    }//GEN-LAST:event_click

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed

		// Tyhjennä lista alustamalla se uudelleen.
        lista = new LinkedList<Point2f>();
        ptsLabel.setText("" + lista.size() );

        int w = (int) canvas.getBounds().getWidth();
        int h = (int) canvas.getBounds().getHeight();

        Graphics g = canvas.getGraphics();
        g.clearRect(0, 0, w, h);
        g.setColor(Color.red);
        g.drawLine(0, h / 2, w, h / 2); // horizontal axis
        g.drawLine(w / 2, 0, w / 2, h); // vertical axis
        
	}//GEN-LAST:event_clearButtonActionPerformed

    private void drawHullButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawHullButtonActionPerformed

        if (lista.size() < 2) {
            return;
        }

        Graphics g = canvas.getGraphics();
        g.setColor(Color.black);

        // Luo taulukko.
        Point2f[] table = new Point2f[lista.size()];
        table = lista.toArray(table);

        // Valitse peitteen hakualgoritmi.
        int idx = jComboBox1.getSelectedIndex();
        ConvexHullFunction f = null;
        if(idx == 0) {
                System.out.println("Jarvis");
                f = new JarvisMarch();
        } else if(idx == 1) {
                System.out.println("Graham");
                f = new GrahamScan();
        } else {
            throw new AssertionError("Väärä indeksi");
        }
        
		System.out.println("Input size: " + table.length );
		long start = System.currentTimeMillis();
        Stack<Point2f> pino = f.getConvexHull(table);
		long end = System.currentTimeMillis();
		System.out.println("Operation time (ms): " + (end - start) );
		System.out.println("Output size: " + pino.size() );
		
        Converter c = new Converter(canvas.getWidth(), canvas.getHeight(), 10, 10);
        g.setColor(Color.red);

        Point2f prev = c.from(pino.pop());
        Point2f first = prev;
        
        // Piirretäänkö viivat?
        boolean lines = false;
        Object[] s = jCheckBoxMenuItem1.getSelectedObjects();
        if( s != null ) {
                System.out.println("Option on: " + s[0] );
                lines = true;
            }

        // Piirrä pisteet ja mahdollisesti viivat.
        while (!pino.empty()) {
            Point2f next = c.from(pino.pop());
            g.drawOval((int) prev.getX() - 4, (int) prev.getY() - 4, 8, 8);
            if(lines)
                g.drawLine((int) prev.getX(), (int) prev.getY(),
                    (int) next.getX(), (int) next.getY() );
            prev = next;
        }
        
        
	}//GEN-LAST:event_drawHullButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        throw new UnsupportedOperationException();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        throw new UnsupportedOperationException();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int paluu = fileChooser.showOpenDialog(this);
        if (JFileChooser.APPROVE_OPTION == paluu) {
            file = fileChooser.getSelectedFile();
            try {
				List<Point2f> lista = DataReader.readData(file);
				System.out.println("Loaded: " + file);
				System.out.println("Points: " + lista.size());
				System.out.println("Toteutus viela kesken!");
				
            } catch( java.io.IOException ioe) {
                System.exit(-1);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConvexHullGUI().setVisible(true);
            }
        });
    }
}

