/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prenomprojet;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexys
 */
public class jfPrenom extends javax.swing.JFrame {

    /**
     * Creates new form jfPrenom
     */
    public jfPrenom() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTrier = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTrier.setText("Trier les prénoms");
        btnTrier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTrier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTrier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrierActionPerformed
        final String VOYELLES = "[aeéiouyAEÉIOUY]";
        final String NOM_FICHIER_A_LIRE = "prenoms.txt";
        final String NOM_FICHIER_A_ECRIRE = "sortie.txt";
        List<String> listeNom = new ArrayList<>();
        String prenomSeul;
        int nombreDeVoyelles = 0;
        try
        {
            FileReader fr = new FileReader(NOM_FICHIER_A_LIRE);
            BufferedReader lecteurDeNom = new BufferedReader(fr);
            
            while((prenomSeul = lecteurDeNom.readLine()) != null)
            {
                char[] prenomSeulEnChar = prenomSeul.toCharArray();
                for(char c : prenomSeulEnChar)
                {
                    if(Pattern.matches(VOYELLES,Character.toString(c)))
                    {
                        nombreDeVoyelles++; 
                    }  
                }
                if(nombreDeVoyelles % 2 == 0)
                {
                    listeNom.add(prenomSeul);
                }
                nombreDeVoyelles = 0;
            }
            Collections.sort(listeNom, String.CASE_INSENSITIVE_ORDER);
            File fichierAEcrire = new File(NOM_FICHIER_A_ECRIRE);
            FileWriter ecriveurFichierAEcrire = new FileWriter(fichierAEcrire, false);
            if(!fichierAEcrire.exists())
            {
                fichierAEcrire.createNewFile();
            }
            
            for(String nom : listeNom)
            {
                ecriveurFichierAEcrire.write(nom);
                ecriveurFichierAEcrire.write("\r\n");
            }
            ecriveurFichierAEcrire.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Il y a eu une erreuré Voici l'erreur : " + e.getMessage());
        }
    }//GEN-LAST:event_btnTrierActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfPrenom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfPrenom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfPrenom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfPrenom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfPrenom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTrier;
    // End of variables declaration//GEN-END:variables
}
