package userInterface;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import userInterface.dataAlgorithm.Vertice;
import userInterface.dataAlgorithm.Aresta;
import data.MainGlobal;
import data.MainAlgorithm;
import backup.Save;
import backup.Open;

public class MainForm extends JFrame implements KeyListener, MouseListener, MouseMotionListener
{
    public ArrayList<Vertice> vertices; // lista de vértices
    public ArrayList<Aresta> arestas; // lista de arestas
    private int indiceVerticeMarcado, numVertices = 0;
    private Vertice vo, aux;
    private MainGlobal mainGlobal;
    private MainAlgorithm mainAlgorithm;
    
    public MainForm()
    {
        this.mainGlobal = new MainGlobal(this.numVertices);
        this.vertices = new ArrayList();
	this.arestas = new ArrayList();
        
        initComponents();
        
        this.pnlDesenhaGrafo.addMouseListener(this);
        this.pnlDesenhaGrafo.addMouseMotionListener(this);
        this.pnlDesenhaGrafo.addKeyListener(this);
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        pnlDesenhaGrafo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        edtRotulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        edtX = new javax.swing.JTextField();
        edtY = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnProfundidade = new javax.swing.JButton();
        btnAmplitude = new javax.swing.JButton();
        btnArvoreMinima = new javax.swing.JButton();
        btnCaminhoMinimo = new javax.swing.JButton();
        btnColoracaoProfundidade = new javax.swing.JButton();
        btnColoracaoAmplitude = new javax.swing.JButton();
        btnColoracaoArestas = new javax.swing.JButton();
        btnColoracaoProfundidadeAresta = new javax.swing.JButton();
        btnColoracaoAmplitudeAresta = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatrizAdjacencia = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaParOrdenado = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        lblEuleriano = new javax.swing.JLabel();
        lblEuler = new javax.swing.JLabel();
        lblArvore = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblXG = new javax.swing.JLabel();
        lblCusto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblXGV = new javax.swing.JLabel();
        mnbPrincipal = new javax.swing.JMenuBar();
        mnuArquivo1 = new javax.swing.JMenu();
        mniNovo1 = new javax.swing.JMenuItem();
        mniAbrir1 = new javax.swing.JMenuItem();
        mniSalvar1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        mniSair1 = new javax.swing.JMenuItem();
        mnuAjuda1 = new javax.swing.JMenu();
        mniSobre1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editor de Grafos - Wallace Gon\u00e7alves de Oliveira");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlDesenhaGrafo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grafo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14)));
        org.jdesktop.layout.GroupLayout pnlDesenhaGrafoLayout = new org.jdesktop.layout.GroupLayout(pnlDesenhaGrafo);
        pnlDesenhaGrafo.setLayout(pnlDesenhaGrafoLayout);
        pnlDesenhaGrafoLayout.setHorizontalGroup(
            pnlDesenhaGrafoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 364, Short.MAX_VALUE)
        );
        pnlDesenhaGrafoLayout.setVerticalGroup(
            pnlDesenhaGrafoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 163, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "V\u00e9rtice", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12)));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel1.setText("N\u00famero");

        edtNumero.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel2.setText("R\u00f3tulo");

        edtRotulo.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel3.setText("Coordenadas:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel4.setText("Y:");

        edtX.setEnabled(false);

        edtY.setEnabled(false);

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.setNextFocusableComponent(pnlDesenhaGrafo);
        btnAlterar.setRequestFocusEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAlterarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel5.setText("X:");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jLabel2)
                    .add(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel3))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, edtNumero, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, edtRotulo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel5)
                                    .add(edtX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel4)
                                    .add(edtY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 79, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .add(93, 93, 93))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(btnAlterar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .add(93, 93, 93))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(edtNumero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(edtRotulo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(edtY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(edtX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnAlterar)
                .add(26, 26, 26))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opera\u00e7\u00f5es", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12)));
        btnProfundidade.setFont(new java.awt.Font("Arial", 0, 10));
        btnProfundidade.setText("Caminho em Profundidade");
        btnProfundidade.setRequestFocusEnabled(false);
        btnProfundidade.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnProfundidadeActionPerformed(evt);
            }
        });

        btnAmplitude.setFont(new java.awt.Font("Arial", 0, 10));
        btnAmplitude.setText("Caminho em Amplitude");
        btnAmplitude.setRequestFocusEnabled(false);
        btnAmplitude.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAmplitudeActionPerformed(evt);
            }
        });

        btnArvoreMinima.setFont(new java.awt.Font("Arial", 0, 10));
        btnArvoreMinima.setText("\u00c1rvore Geradora M\u00ednima");
        btnArvoreMinima.setRequestFocusEnabled(false);
        btnArvoreMinima.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnArvoreMinimaActionPerformed(evt);
            }
        });

        btnCaminhoMinimo.setFont(new java.awt.Font("Arial", 0, 10));
        btnCaminhoMinimo.setText("Caminho M\u00ednimo");
        btnCaminhoMinimo.setRequestFocusEnabled(false);
        btnCaminhoMinimo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCaminhoMinimoActionPerformed(evt);
            }
        });

        btnColoracaoProfundidade.setFont(new java.awt.Font("Arial", 0, 10));
        btnColoracaoProfundidade.setText("Colora\u00e7\u00e3o Profundidade");
        btnColoracaoProfundidade.setRequestFocusEnabled(false);
        btnColoracaoProfundidade.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnColoracaoProfundidadeActionPerformed(evt);
            }
        });

        btnColoracaoAmplitude.setFont(new java.awt.Font("Arial", 0, 10));
        btnColoracaoAmplitude.setText("Colora\u00e7\u00e3o Amplitude");
        btnColoracaoAmplitude.setRequestFocusEnabled(false);
        btnColoracaoAmplitude.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnColoracaoAmplitudeActionPerformed(evt);
            }
        });

        btnColoracaoArestas.setFont(new java.awt.Font("Arial", 0, 10));
        btnColoracaoArestas.setText("Colora\u00e7\u00e3o Arestas");
        btnColoracaoArestas.setRequestFocusEnabled(false);
        btnColoracaoArestas.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnColoracaoArestasActionPerformed(evt);
            }
        });

        btnColoracaoProfundidadeAresta.setFont(new java.awt.Font("Arial", 0, 8));
        btnColoracaoProfundidadeAresta.setText("Colora\u00e7\u00e3o Profundidade Arestas");
        btnColoracaoProfundidadeAresta.setRequestFocusEnabled(false);
        btnColoracaoProfundidadeAresta.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnColoracaoProfundidadeArestaActionPerformed(evt);
            }
        });

        btnColoracaoAmplitudeAresta.setFont(new java.awt.Font("Arial", 0, 8));
        btnColoracaoAmplitudeAresta.setText("Colora\u00e7\u00e3o Amplitude Arestas");
        btnColoracaoAmplitudeAresta.setRequestFocusEnabled(false);
        btnColoracaoAmplitudeAresta.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnColoracaoAmplitudeArestaActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, btnArvoreMinima, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, btnProfundidade, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, btnAmplitude, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(btnColoracaoAmplitude, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnColoracaoProfundidade, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnCaminhoMinimo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(btnColoracaoAmplitudeAresta, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnColoracaoProfundidadeAresta, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnColoracaoArestas, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCaminhoMinimo)
                    .add(btnColoracaoArestas)
                    .add(btnProfundidade))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnColoracaoProfundidade)
                    .add(btnColoracaoProfundidadeAresta)
                    .add(btnAmplitude))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnArvoreMinima)
                    .add(btnColoracaoAmplitude)
                    .add(btnColoracaoAmplitudeAresta))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matriz de Adjac\u00eancia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        tblMatrizAdjacencia.setFont(new java.awt.Font("Arial", 0, 12));
        tblMatrizAdjacencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        tblMatrizAdjacencia.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblMatrizAdjacencia.setDoubleBuffered(true);
        tblMatrizAdjacencia.setFocusable(false);
        jScrollPane1.setViewportView(tblMatrizAdjacencia);

        txaParOrdenado.setColumns(20);
        txaParOrdenado.setFont(new java.awt.Font("Arial", 0, 12));
        txaParOrdenado.setRows(1);
        txaParOrdenado.setText("E={ }");
        txaParOrdenado.setFocusable(false);
        jScrollPane2.setViewportView(txaParOrdenado);

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 115, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes do Grafo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        jPanel1.setRequestFocusEnabled(false);
        lblEuleriano.setFont(new java.awt.Font("Arial", 0, 12));
        lblEuleriano.setText("\u00c9 Euleriano");

        lblEuler.setFont(new java.awt.Font("Arial", 0, 12));
        lblEuler.setText("Tem Caminho de Euler");

        lblArvore.setFont(new java.awt.Font("Arial", 0, 12));
        lblArvore.setText("\u00c9 \u00c1rvore (N\u00e3o Tem Ciclo)");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblEuleriano)
                    .add(lblEuler)
                    .add(lblArvore))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(lblEuleriano)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblEuler)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(lblArvore)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes do Grafo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12)));
        jPanel6.setRequestFocusEnabled(false);
        jLabel11.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel11.setText("X(G) =");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel12.setText("Custo =");

        lblXG.setFont(new java.awt.Font("Arial", 0, 12));
        lblXG.setText("0");

        lblCusto.setFont(new java.awt.Font("Arial", 0, 12));
        lblCusto.setText("0");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setText("X(G,V) =");

        lblXGV.setFont(new java.awt.Font("Arial", 0, 12));
        lblXGV.setText("0");

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(jLabel11)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 130, Short.MAX_VALUE)
                        .add(lblXG))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                        .add(jLabel12)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 121, Short.MAX_VALUE)
                        .add(lblCusto))
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 119, Short.MAX_VALUE)
                        .add(lblXGV)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(lblXG))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(lblXGV))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblCusto)
                    .add(jLabel12))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        mnuArquivo1.setText("Arquivo");
        mnuArquivo1.setFont(new java.awt.Font("Arial", 0, 12));
        mniNovo1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mniNovo1.setFont(new java.awt.Font("Arial", 0, 12));
        mniNovo1.setText("Novo");
        mniNovo1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniNovo1ActionPerformed(evt);
            }
        });

        mnuArquivo1.add(mniNovo1);

        mniAbrir1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mniAbrir1.setFont(new java.awt.Font("Arial", 0, 12));
        mniAbrir1.setText("Abrir");
        mniAbrir1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniAbrir1ActionPerformed(evt);
            }
        });

        mnuArquivo1.add(mniAbrir1);

        mniSalvar1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mniSalvar1.setFont(new java.awt.Font("Arial", 0, 12));
        mniSalvar1.setText("Salvar");
        mniSalvar1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniSalvar1ActionPerformed(evt);
            }
        });

        mnuArquivo1.add(mniSalvar1);

        mnuArquivo1.add(jSeparator2);

        mniSair1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mniSair1.setFont(new java.awt.Font("Arial", 0, 12));
        mniSair1.setText("Sair");
        mniSair1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniSair1ActionPerformed(evt);
            }
        });

        mnuArquivo1.add(mniSair1);

        mnbPrincipal.add(mnuArquivo1);

        mnuAjuda1.setText("Ajuda");
        mnuAjuda1.setFont(new java.awt.Font("Arial", 0, 12));
        mniSobre1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        mniSobre1.setFont(new java.awt.Font("Arial", 0, 12));
        mniSobre1.setText("Sobre...");
        mniSobre1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mniSobre1ActionPerformed(evt);
            }
        });

        mnuAjuda1.add(mniSobre1);

        mnbPrincipal.add(mnuAjuda1);

        setJMenuBar(mnbPrincipal);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(pnlDesenhaGrafo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 7, Short.MAX_VALUE)
                        .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 197, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(3, 3, 3)
                                .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(pnlDesenhaGrafo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        setSize(new java.awt.Dimension(729, 494));
    }// </editor-fold>//GEN-END:initComponents

    private void mniSobre1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniSobre1ActionPerformed
    {//GEN-HEADEREND:event_mniSobre1ActionPerformed
        try
        {
            JOptionPane.showMessageDialog(null, "EDITOR DE GRAFOS\nversão 2006.2.2\n"+
            "Interface desenvolvida por: Wallace Gonçalves de Oliveira.\n"+
            "FACULDADE COTEMIG (somente para fins didáticos)\n\n"+
            "Colaborador Interface:\nVirglio Borges de Oliveira\n\n"+
            "Colaboradores Pacote de Dados:\n"+
            "Guilherme Caram\n"+
            "Sérgio Sandim\n"+
            "Fabiana Oliveira");
        }
        catch(Exception ex) {}

        repaint();
    }//GEN-LAST:event_mniSobre1ActionPerformed

    private void mniAbrir1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniAbrir1ActionPerformed
    {//GEN-HEADEREND:event_mniAbrir1ActionPerformed
        Open o = new Open();
        o.open(MainForm.this);
        
        this.numVertices = this.vertices.size();
        this.inicializar();
        repaint();
    }//GEN-LAST:event_mniAbrir1ActionPerformed

    private void mniSalvar1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniSalvar1ActionPerformed
    {//GEN-HEADEREND:event_mniSalvar1ActionPerformed
        Save s = new Save();
        s.saveAs(MainForm.this);
    }//GEN-LAST:event_mniSalvar1ActionPerformed

    private void mniNovo1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniNovo1ActionPerformed
    {//GEN-HEADEREND:event_mniNovo1ActionPerformed
        this.numVertices = 0;
        this.vertices.clear();
        this.arestas.clear();
        this.vo = null; // limpa a referencia a qualquer vertice marcado
        this.inicializar();
        repaint();
        
        this.edtNumero.setText("");
        this.edtRotulo.setText("");
        this.edtX.setText("");
        this.edtY.setText("");
        
        this.edtRotulo.setEnabled(false);
        this.btnAlterar.setEnabled(false);
        
        this.lblXG.setText("0");
        this.lblXGV.setText("0");
        this.lblCusto.setText("0");
        
        this.txaParOrdenado.setText("E={ }");
    }//GEN-LAST:event_mniNovo1ActionPerformed

    private void mniSair1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mniSair1ActionPerformed
    {//GEN-HEADEREND:event_mniSair1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniSair1ActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAlterarActionPerformed
    {//GEN-HEADEREND:event_btnAlterarActionPerformed
        int i;
        
        if(this.aux.getMarcado())
        {
            if (this.edtRotulo.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Dados incorretos!");
            }
            else
            {
                for (i=0; i<this.numVertices; i++)
                {
                    if (vertices.get(i).getNum() == this.aux.getNum())
                    {
                        vertices.get(i).setNum(Integer.parseInt(this.edtNumero.getText()));
                        vertices.get(i).setRotulo(this.edtRotulo.getText());
                        repaint();
                        break;
                    }
                }
                
                this.inicializar();
            }
        }
        
        
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnColoracaoAmplitudeArestaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnColoracaoAmplitudeArestaActionPerformed
    {//GEN-HEADEREND:event_btnColoracaoAmplitudeArestaActionPerformed
        try
        {
            inicializar();
            this.mainAlgorithm.breadthFirstSearchColoration();
            this.mainAlgorithm.edgeColoration();
            this.lblCusto.setText("0");
            repaint();
        }
        catch(Exception ex) {}
    }//GEN-LAST:event_btnColoracaoAmplitudeArestaActionPerformed

    private void btnColoracaoProfundidadeArestaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnColoracaoProfundidadeArestaActionPerformed
    {//GEN-HEADEREND:event_btnColoracaoProfundidadeArestaActionPerformed
        try
        {
            inicializar();
            this.mainAlgorithm.depthFirstSearchColoration();
            this.mainAlgorithm.edgeColoration();
            this.lblCusto.setText("0");
            repaint();
        }
        catch(Exception ex) {}
    }//GEN-LAST:event_btnColoracaoProfundidadeArestaActionPerformed

    private void btnColoracaoArestasActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnColoracaoArestasActionPerformed
    {//GEN-HEADEREND:event_btnColoracaoArestasActionPerformed
        try
        {
            inicializar();
            this.mainAlgorithm.edgeColoration();
            this.lblXG.setText("0");
            this.lblCusto.setText("0");
            repaint();
        }
        catch(Exception ex) {}
    }//GEN-LAST:event_btnColoracaoArestasActionPerformed

    private void btnColoracaoAmplitudeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnColoracaoAmplitudeActionPerformed
    {//GEN-HEADEREND:event_btnColoracaoAmplitudeActionPerformed
        try
        {
            inicializar();
            this.mainAlgorithm.breadthFirstSearchColoration();
            this.lblXGV.setText("0");
            this.lblCusto.setText("0");
            repaint();
        }
        catch(Exception ex) {}
    }//GEN-LAST:event_btnColoracaoAmplitudeActionPerformed

    private void btnColoracaoProfundidadeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnColoracaoProfundidadeActionPerformed
    {//GEN-HEADEREND:event_btnColoracaoProfundidadeActionPerformed
        try
        {
            inicializar();
            this.mainAlgorithm.depthFirstSearchColoration();
            this.lblXGV.setText("0");
            this.lblCusto.setText("0");
            repaint();
        }
        catch(Exception ex) {}
    }//GEN-LAST:event_btnColoracaoProfundidadeActionPerformed

    private void btnCaminhoMinimoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCaminhoMinimoActionPerformed
    {//GEN-HEADEREND:event_btnCaminhoMinimoActionPerformed
        int de = -1, ate = -1;
        
        try
        {
            inicializar();
            
            de = getNumVertice(JOptionPane.showInputDialog("De: "));
            ate = getNumVertice(JOptionPane.showInputDialog("Ate: "));

            this.mainAlgorithm.minimumWay(de, ate);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Vértice Inválido!");
        }
        
        this.lblXG.setText("0");
        this.lblXGV.setText("0");
        
        repaint();
    }//GEN-LAST:event_btnCaminhoMinimoActionPerformed

    private void btnArvoreMinimaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnArvoreMinimaActionPerformed
    {//GEN-HEADEREND:event_btnArvoreMinimaActionPerformed
        try
        {
            inicializar();
            this.mainAlgorithm.minimumTree();
            repaint();
        }
        catch(Exception ex) {}
        
        this.lblXG.setText("0");
        this.lblXGV.setText("0");
    }//GEN-LAST:event_btnArvoreMinimaActionPerformed

    private void btnAmplitudeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAmplitudeActionPerformed
    {//GEN-HEADEREND:event_btnAmplitudeActionPerformed
        int vertice = -1;
        
        try
        {
            inicializar();
            
            vertice = getNumVertice(JOptionPane.showInputDialog("Vértice: "));
            this.mainAlgorithm.breadthFirstSearch(vertice);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Vértice Inválido!");
        }
        
        this.lblXG.setText("0");
        this.lblXGV.setText("0");
        this.lblCusto.setText("0");
        
        repaint();
    }//GEN-LAST:event_btnAmplitudeActionPerformed

    private void btnProfundidadeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnProfundidadeActionPerformed
    {//GEN-HEADEREND:event_btnProfundidadeActionPerformed
        int i, vertice = -1;
        
        try 
        {
            inicializar();
            
            vertice = getNumVertice(JOptionPane.showInputDialog("Vértice: "));
            this.mainAlgorithm.depthFirstSearch(vertice);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Vértice Inválido!");
        }
        
        this.lblXG.setText("0");
        this.lblXGV.setText("0");
        this.lblCusto.setText("0");
        
        repaint();
    }//GEN-LAST:event_btnProfundidadeActionPerformed

    public void keyTyped(KeyEvent ke) {}
    public void keyPressed(KeyEvent ke) {}

    public void keyReleased(KeyEvent ke)
    {
        int i, numMarcado;
        
        try
        {
            numMarcado = vertices.get(indiceVerticeMarcado).getNum();

            if (ke.getKeyCode() == 127) // 127 == VK_DELETE
            {		
                if(this.aux.getMarcado())
                {
                    for (i=arestas.size()-1; i>=0; i--)
                    {
                        if (arestas.get(i).getVo().getNum() == numMarcado
                            || arestas.get(i).getVd().getNum() == numMarcado)
                        {
                            arestas.remove(i);
                        }
                    }

                    this.aux.desmarcar();
                    vo = null;
                    vertices.remove(indiceVerticeMarcado);
                    numVertices--;

                    for (i=0; i<numVertices; i++)
                    {
                        vertices.get(i).setNum(i);

                        /** APENAS SE RÓTULO FOR AUTOMÁTICO **/
                        vertices.get(i).setRotulo("V"+(i+1));
                        /**/
                    }
                    
                    this.inicializar();
                    this.atualizaDadosVertice();
                }
            }
        }
        catch(Exception ex) {}
        
        repaint();
    }

    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseMoved(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {}
    public void mouseExited(MouseEvent me) {}
    
    public void mouseReleased(MouseEvent me)
    {
        int x = me.getX()+12; // coordenada X do clique do mouse
      	int y = me.getY()-11; // coordenada Y do clique do mouse
      	int i, peso = -1;
      	boolean novo = true;
        
        this.pnlDesenhaGrafo.requestFocus();
      	     	
        /* ADICIONA O VERTICE v NA TELA, NAS COORDENADAS x,y DO CLICK MOUSE */
        for(i = 0; i < vertices.size(); i++)
        {
            this.aux = vertices.get(i);
            indiceVerticeMarcado = i;
            if(x <= this.aux.getX() + 12 && x >= this.aux.getX() - 7 &&
               y <= this.aux.getY() + 20 && y >= this.aux.getY() - 7)
            {
                //System.out.println(aux.getNum());
                if(this.aux.getMarcado())
                {
                    this.aux.desmarcar();
                    vo = null;
                    this.atualizaDadosVertice();
                }
                else
                {
                    this.aux.marcar();
                    this.atualizaDadosVertice();

                    if(vo != null)
                    {
                        if (getAresta(vo.getNum(), this.aux.getNum()) == null)
                        {
                            try
                            {
                                peso = Integer.parseInt(JOptionPane.showInputDialog("Peso: "));
                            }
                            catch(Exception ex) {}

                            if (peso <= 0)
                                JOptionPane.showMessageDialog(null, "Peso Inválido!");
                            else
                            {
                                arestas.add(new Aresta(vo, aux, peso));
                                this.inicializar();
                            }
                        }

                        vo.desmarcar();
                    }
                    
                    vo = this.aux;
                }

                novo = false;
                break;
            }
        }

        if(novo)
        {
            /**
            String rotulo = JOptionPane.showInputDialog("Digite sem acento.\nRótulo: ");
            vertices.add(new Vertice(numVertices, rotulo, x, y));
            /**/
            vertices.add(new Vertice(numVertices, "V" + (numVertices + 1), x, y));
            /**/
            numVertices++;
            this.inicializar();
        }

        repaint();
    }

    public void mouseDragged(MouseEvent me)
    {
        try
    	{
            if(aux.getMarcado())
            {
                vertices.get(indiceVerticeMarcado).setX(me.getX()+12);
                vertices.get(indiceVerticeMarcado).setY(me.getY()-11);
                
                repaint();
                
                this.atualizaDadosVertice();
            }
    	}
    	catch(Exception ex) {}
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        int i, j, tam;
        Vertice v;
        Aresta a;
        
        g.setFont(new Font("Arial", 0, 10));
        
        for(i = 0; i < arestas.size(); i++)
        {
            a = arestas.get(i);
            g.setColor(a.getCor());
            g.drawLine(a.getVo().getX() + 5, a.getVo().getY() + 55, a.getVd().getX() + 5, a.getVd().getY() + 55);
            g.setColor(Color.WHITE);
            tam = g.getFontMetrics().stringWidth(a.getPeso()+""); 
            g.fillRect((a.getVo().getX() + a.getVd().getX() + tam + 4) / 2, (a.getVo().getY() + a.getVd().getY() + 100) / 2, tam + 4, 15);
            g.setColor(a.getCor());
            g.drawString(a.getPeso()+"", (a.getVo().getX() + a.getVd().getX() + tam + 7) / 2, (a.getVo().getY() + a.getVd().getY() + 123) / 2);
        }

        for(i = 0; i < vertices.size(); i++)
        {
            v = vertices.get(i);

            if(v.getMarcado())
                g.setColor(v.getCorMarcado());
            else
                g.setColor(v.getCor());

            g.fillOval(v.getX(), v.getY() + 50, 8, 8);
            g.setColor(Color.WHITE);
            tam = g.getFontMetrics().stringWidth(v.getRotulo()); 
            g.fillRect(v.getX(), v.getY() + 60, tam, 10);
            g.setColor(v.getCor());
            g.drawString(v.getRotulo(), v.getX(), v.getY() + 70);

        }
    }
    
    private void resetGraphColor()
    {
        for (Vertice v : vertices)
            v.setCor(Color.BLACK);

        for (Aresta a : arestas)
            a.setCor(Color.BLACK);
    }
    
    private void inicializar()
    {
        int i;
        
        try
        {
            this.mainGlobal.reBuild(this.numVertices);

            for (i=0; i<arestas.size(); i++)
                this.mainGlobal.adjacencyMatrix.addEdge(this.arestas.get(i).getVo().getNum(), this.arestas.get(i).getVd().getNum(), this.arestas.get(i).getPeso());

            this.mainGlobal.addUserInterface(MainForm.this);
            this.mainAlgorithm = null;
            this.mainAlgorithm = new MainAlgorithm(mainGlobal);
            this.resetGraphColor();
        }
        catch(Exception ex) {}
        
        this.padrao();
    }
    
    public Vertice getVertice(int v)
    {
        int i;

        for(i=0; i<vertices.size(); i++)
        {
            if(vertices.get(i).getNum() == v)
                return vertices.get(i);
        }

        return null;
    }

    public Vertice getVertice(String rotulo)
    {
        int i;

        for(i=0; i<vertices.size(); i++)
        {
            if(vertices.get(i).getRotulo().equalsIgnoreCase(rotulo))
                return vertices.get(i);
        }

        return null;
    }

    public int getNumVertice(String rotulo)
    {
        int i;

        for(i=0; i<vertices.size(); i++)
        {
            if(vertices.get(i).getRotulo().equalsIgnoreCase(rotulo))
                return vertices.get(i).getNum();
        }

        return -1;
    }

    public Aresta getAresta(int vo, int vd)
    {
        int i;

        for(i=0; i<arestas.size(); i++)
        {
            if((arestas.get(i).getVo().getNum() == vo && arestas.get(i).getVd().getNum() == vd) ||
               (arestas.get(i).getVd().getNum() == vo && arestas.get(i).getVo().getNum() == vd))
                return arestas.get(i);
        }

        return null;
    }
    
    public void padrao()
    {
        int i;
        
        String[] titulo = new String[this.mainGlobal.adjacencyMatrix.numberVertex()];
        
        for (i=0; i<this.mainGlobal.adjacencyMatrix.numberVertex(); i++)
            titulo[i] = this.vertices.get(i).getRotulo();

        this.tblMatrizAdjacencia.setModel(new javax.swing.table.DefaultTableModel(this.mainGlobal.adjacencyMatrix.getCopy(), titulo));
        
        try
        {
            this.txaParOrdenado.setText(this.mainAlgorithm.groupE());
        }
        catch(Exception ex) {}
        
        try
        {
            this.lblEuleriano.setText(this.mainAlgorithm.isEulerian() ? "É Euleriano" : "Não é Euleriano");
            this.lblEuler.setText(this.mainAlgorithm.isEuler() ? "Tem caminho de Euler" : "Não tem caminho de Euler");
            this.lblArvore.setText(this.mainAlgorithm.isTree() ? "É Árvore (Não tem ciclo)" : "Não é Árvore (Tem ciclo)");
        }
        catch(Exception ex) {}
    }
    
    public void atualizaDadosVertice()
    {
        if(this.aux.getMarcado())
        {
            this.edtRotulo.setEnabled(true);
            this.btnAlterar.setEnabled(true);
            
            this.edtNumero.setText(String.valueOf(this.aux.getNum()));
            this.edtRotulo.setText(String.valueOf(this.aux.getRotulo()));
            this.edtX.setText(String.valueOf(this.aux.getX()));
            this.edtY.setText(String.valueOf(this.aux.getY()));
        }
        else
        {
            this.edtRotulo.setEnabled(false);
            this.btnAlterar.setEnabled(false);
            
            this.edtNumero.setText("");
            this.edtRotulo.setText("");
            this.edtX.setText("");
            this.edtY.setText("");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAmplitude;
    private javax.swing.JButton btnArvoreMinima;
    private javax.swing.JButton btnCaminhoMinimo;
    private javax.swing.JButton btnColoracaoAmplitude;
    private javax.swing.JButton btnColoracaoAmplitudeAresta;
    private javax.swing.JButton btnColoracaoArestas;
    private javax.swing.JButton btnColoracaoProfundidade;
    private javax.swing.JButton btnColoracaoProfundidadeAresta;
    private javax.swing.JButton btnProfundidade;
    private javax.swing.JTextField edtNumero;
    private javax.swing.JTextField edtRotulo;
    private javax.swing.JTextField edtX;
    private javax.swing.JTextField edtY;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblArvore;
    public javax.swing.JLabel lblCusto;
    private javax.swing.JLabel lblEuler;
    private javax.swing.JLabel lblEuleriano;
    public javax.swing.JLabel lblXG;
    public javax.swing.JLabel lblXGV;
    private javax.swing.JMenuBar mnbPrincipal;
    private javax.swing.JMenuItem mniAbrir1;
    private javax.swing.JMenuItem mniNovo1;
    private javax.swing.JMenuItem mniSair1;
    private javax.swing.JMenuItem mniSalvar1;
    private javax.swing.JMenuItem mniSobre1;
    private javax.swing.JMenu mnuAjuda1;
    private javax.swing.JMenu mnuArquivo1;
    private javax.swing.JPanel pnlDesenhaGrafo;
    private javax.swing.JTable tblMatrizAdjacencia;
    private javax.swing.JTextArea txaParOrdenado;
    // End of variables declaration//GEN-END:variables
    
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainForm().setVisible(true);
            }
        });
    }
}
