
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author EduardoMaciel
 */
public class JogoVeia extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form JogoVeia
     *
     */
    private int velha = 0;
    private int jogador1 = 0;
    private int jogador2 = 0;
    private boolean jogada = true;
    private final JButton matriz[][] = new JButton[3][3];

    public JogoVeia(){
        
        initComponents();
        adicionaBotoes();

    }

    private void adicionaBotoes() {
        Font aux = new Font("Arial", Font.BOLD, 48);
        int cont = 0;

        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                matriz[linha][coluna] = new JButton(" ");
                matriz[linha][coluna].setFont(aux);
                painelBotoes.add(matriz[linha][coluna]);
                matriz[linha][coluna].addActionListener(this); // adicionando o botao para ser escutado se acontece um evento
                matriz[linha][coluna].setActionCommand(cont + ""); // coloco um nome para o evento
                cont++;
            }
        }

        pack();

    }
    
    private void marcarPosicao(JButton botao) {
        if (jogada) {
            botao.setText("X");

        } else {
            botao.setText("O");
        }
        jogada = !jogada;
        botao.setEnabled(false);
    }

    private boolean acabou() {
        int acabou = 0;

        //contadores das diagonais
        int contadorP = 0;
        int contadorS = 0;
        for (int i = 0; i < 3; i++) {
            //Teste das diagonais
            if (matriz[i][i].getText().equals(" ")) {
            } else {
                if (matriz[i][i].getText().equals("X")) {
                    contadorP += 1;
                } else {
                    contadorP -= 1;
                }
            }
            if (matriz[i][2 - i].getText().equals(" ")) {
            } else {
                if (matriz[i][2 - i].getText().equals("X")) {
                    contadorS += 1;
                } else {
                    contadorS -= 1;
                }
            }

            //Contadores das paralelas
            int contadorH = 0;
            int contadorV = 0;
            for (int j = 0; j < 3; j++) {
                //Teste das paralelas
                if (matriz[i][j].getText().equals(" ")) {
                } else {
                    acabou += 1;
                    if (matriz[i][j].getText().equals("X")) {
                        contadorH += 1;
                    } else {
                        contadorH -= 1;
                    }
                }

                if (matriz[j][i].getText().equals(" ")) {
                } else {
                    if (matriz[j][i].getText().equals("X")) {
                        contadorV += 1;
                    } else {
                        contadorV -= 1;
                    }
                }
            }
            if(contadorH == 3){
                jogador1++;
                terminarJogo(1, i);
                return true;
            }
            if(contadorH == -3){
                jogador2++;
                terminarJogo(1, i);
                return true;
            }
            if(contadorV == 3){
                jogador1++;
                terminarJogo(2, i);
                return true;
            }
            if(contadorV == -3){
                jogador2++;
                terminarJogo(2, i);
                return true;
            }
        }
        if(contadorP == 3){
            jogador1++;
            terminarJogo(3, 1);
            return true;
        }
        if(contadorP == -3){
            jogador2++;
            terminarJogo(3, 1);
            return true;
        }
        if(contadorS == 3){
            jogador1++;
            terminarJogo(4, 1);
            return true;
        }
        if(contadorS == -3){
            jogador2++;
            terminarJogo(4, 1);
            return true;
        }
        if (acabou == 9) {
            velha++;
            return true;
        }
        return false;
    }

    private void reiniciaJogo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j].setText(" ");
                matriz[i][j].setEnabled(true);
                matriz[i][j].setForeground(Color.getColor("140,140,140"));
            }
        }
        jogada = true;
    }

   

    private void terminarJogo(int sit, int i){
        //Tipos de situação (sit)
        //1-Horizontal
        //2-Vertical
        //3-Diagonal primaria
        //4-diagonal secundaria
        
        switch (sit) {
            case 1 -> {
                for(int j=0; j<3; j++){
                    matriz[i][j].setForeground(Color.red);
                }
            }
            case 2 -> {
                for(int j=0; j<3; j++){
                    matriz[j][i].setForeground(Color.red);
                }
            }
            case 3 -> {
                for(int j=0; j<3; j++){
                    matriz[j][j].setForeground(Color.red);
                }
            }
            case 4 -> {
                for(int j=0; j<3; j++){
                    matriz[j][2-j].setForeground(Color.red);
                }
            }
            default -> {
            }
        }

        for (int lin = 0; lin < 3; lin++) {
            for (int col = 0; col < 3; col++) {
                matriz[lin][col].setEnabled(false);
            }
        }
    }
   
    private void atualizarPlacares(){
        placar1.setText(""+jogador1);
        placar2.setText(""+jogador2);
        placarVelha.setText(""+velha);
        if(jogada == true){
            placarVez.setText("X");
        }else{
            placarVez.setText("O");
        }
    }
    
    private void reiniciaPlacar(){
        jogador1 = 0;
        jogador2 = 0;
        velha = 0;
        atualizarPlacares();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelBotoes = new javax.swing.JPanel();
        painelPrincipal = new javax.swing.JPanel();
        painelPlacar1 = new javax.swing.JPanel();
        placar1 = new javax.swing.JTextField();
        painelPlacar2 = new javax.swing.JPanel();
        placar2 = new javax.swing.JTextField();
        placarVez = new javax.swing.JTextField();
        butOK = new javax.swing.JButton();
        painelConfig = new javax.swing.JPanel();
        butReiniciar = new javax.swing.JButton();
        butAlterar = new javax.swing.JButton();
        placarVelha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da velha");
        setBackground(new java.awt.Color(51, 51, 51));

        painelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelBotoes.setInheritsPopupMenu(true);
        painelBotoes.setLayout(new java.awt.GridLayout(3, 3));

        painelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        painelPlacar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Jogador 1"));
        painelPlacar1.setPreferredSize(new java.awt.Dimension(80, 80));

        placar1.setEditable(false);
        placar1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        placar1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        placar1.setText("0");
        placar1.setAutoscrolls(false);
        placar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        placar1.setEnabled(false);

        javax.swing.GroupLayout painelPlacar1Layout = new javax.swing.GroupLayout(painelPlacar1);
        painelPlacar1.setLayout(painelPlacar1Layout);
        painelPlacar1Layout.setHorizontalGroup(
            painelPlacar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(placar1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        painelPlacar1Layout.setVerticalGroup(
            painelPlacar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(placar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );

        painelPlacar2.setBorder(javax.swing.BorderFactory.createTitledBorder("Jogador 2"));
        painelPlacar2.setPreferredSize(new java.awt.Dimension(80, 80));

        placar2.setEditable(false);
        placar2.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        placar2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        placar2.setText("0");
        placar2.setAutoscrolls(false);
        placar2.setEnabled(false);

        javax.swing.GroupLayout painelPlacar2Layout = new javax.swing.GroupLayout(painelPlacar2);
        painelPlacar2.setLayout(painelPlacar2Layout);
        painelPlacar2Layout.setHorizontalGroup(
            painelPlacar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(placar2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );
        painelPlacar2Layout.setVerticalGroup(
            painelPlacar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(placar2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        placarVez.setEditable(false);
        placarVez.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        placarVez.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        placarVez.setText("X");
        placarVez.setAutoscrolls(false);
        placarVez.setEnabled(false);
        placarVez.setFocusable(false);
        placarVez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placarVezActionPerformed(evt);
            }
        });

        butOK.setText("OK");
        butOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPlacar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(placarVez)
                    .addComponent(butOK, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(painelPlacar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPlacar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(painelPlacar2, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(placarVez, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butOK)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );

        painelConfig.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        butReiniciar.setText("Reiniciar");
        butReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butReiniciarActionPerformed(evt);
            }
        });

        butAlterar.setText("Alterar modo de jogo");
        butAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAlterarActionPerformed(evt);
            }
        });

        placarVelha.setEditable(false);
        placarVelha.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        placarVelha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        placarVelha.setText("0");
        placarVelha.setAutoscrolls(false);
        placarVelha.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(140, 140, 140));
        jLabel1.setText("Velha:");

        javax.swing.GroupLayout painelConfigLayout = new javax.swing.GroupLayout(painelConfig);
        painelConfig.setLayout(painelConfigLayout);
        painelConfigLayout.setHorizontalGroup(
            painelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(placarVelha)
                .addGap(38, 38, 38)
                .addGroup(painelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelConfigLayout.createSequentialGroup()
                        .addComponent(butAlterar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelConfigLayout.createSequentialGroup()
                        .addComponent(butReiniciar)
                        .addGap(39, 39, 39))))
        );
        painelConfigLayout.setVerticalGroup(
            painelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelConfigLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelConfigLayout.createSequentialGroup()
                        .addComponent(butReiniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butAlterar))
                    .addComponent(placarVelha))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void butReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butReiniciarActionPerformed
    reiniciaJogo();
    reiniciaPlacar();
    }//GEN-LAST:event_butReiniciarActionPerformed

    private void placarVezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placarVezActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placarVezActionPerformed

    private void butAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butAlterarActionPerformed

    private void butOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butOKActionPerformed
            reiniciaJogo();       
    }//GEN-LAST:event_butOKActionPerformed

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
            java.util.logging.Logger.getLogger(JogoVeia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JogoVeia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JogoVeia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JogoVeia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JogoVeia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAlterar;
    private javax.swing.JButton butOK;
    private javax.swing.JButton butReiniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelConfig;
    private javax.swing.JPanel painelPlacar1;
    private javax.swing.JPanel painelPlacar2;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JTextField placar1;
    private javax.swing.JTextField placar2;
    private javax.swing.JTextField placarVelha;
    private javax.swing.JTextField placarVez;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton aux;
        aux = (JButton) e.getSource();
        marcarPosicao(aux);
        if(acabou()){
            
        }
        atualizarPlacares();
    }
}



// public void abrirDialogo(String texto) {
//        JOptionPane dialogo = new JOptionPane();
//        int showConfirmDialog = dialogo.showConfirmDialog(this, "Deu " + texto + ", você quer jogar novamente?");
//        if (showConfirmDialog == 0) {
//            reiniciaJogo();
//        } else {
//            System.exit(0);
//        }
//    }