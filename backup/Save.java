package backup;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import backup.filter.Wgo;
import backup.filter.Xml;
import backup.filter.Pri;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import userInterface.MainForm;

public class Save
{
    public void saveAs(MainForm screen)
    {
        JFileChooser arquivoImagem = new JFileChooser(new File("grafo"));
        arquivoImagem.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        arquivoImagem.addChoosableFileFilter(new Wgo());
        arquivoImagem.addChoosableFileFilter(new Xml());
        arquivoImagem.addChoosableFileFilter(new Pri());
        arquivoImagem.setVisible(true);
        if(arquivoImagem.showSaveDialog(null) == javax.swing.JFileChooser.CANCEL_OPTION)
            return;

        File arquivoNome = arquivoImagem.getSelectedFile();

        if(arquivoNome.getName().equals(""))
            JOptionPane.showMessageDialog(null, "Arquivo Inválido", "Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
        else
        {
            if(arquivoImagem.getFileFilter().getDescription().equals(".wgo (Formato Texto)"))
            {
                this.saveWgo(arquivoNome, screen);
            }
            else if(arquivoImagem.getFileFilter().getDescription().equals(".xml (Formato XML)"))
            {
                this.saveXml(arquivoNome, screen);
            }
            else if(arquivoImagem.getFileFilter().getDescription().equals(".pri (Formato Serializado)"))
            {
                this.savePri(arquivoNome, screen);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Arquivo Inválido, selecione uma extenção", "Arquivo Inválido, selecione uma extenção", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }
    
    private void saveWgo(File arquivoNome, MainForm screen)
    {
        arquivoNome = new File(arquivoNome.getPath()+".wgo");

        try
        {
            String gravar="";
            int i;

            PrintWriter arquivo = new PrintWriter(new BufferedWriter(new FileWriter(arquivoNome)));

            for (i=0; i<screen.vertices.size(); i++)
                gravar += String.valueOf(screen.vertices.get(i).getX()) + (i<screen.vertices.size()-1 ? "MM" : "");
            gravar += ":";
            for (i=0; i<screen.vertices.size(); i++)
                gravar += String.valueOf(screen.vertices.get(i).getY()) + (i<screen.vertices.size()-1 ? "MM" : "");
            gravar += ":";
            for (i=0; i<screen.vertices.size(); i++)
                gravar += String.valueOf(screen.vertices.get(i).getRotulo()) + (i<screen.vertices.size()-1 ? "MM" : "");
            gravar += ":";
            for (i=0; i<screen.vertices.size(); i++)
                gravar += String.valueOf(screen.vertices.get(i).getNum()) + (i<screen.vertices.size()-1 ? "MM" : "");

            gravar += "OO";

            for (i=0; i<screen.arestas.size(); i++)
                gravar += String.valueOf(screen.arestas.get(i).getVo().getNum()) + (i<screen.arestas.size()-1 ? "MM" : "");
            gravar += ":";
            for (i=0; i<screen.arestas.size(); i++)
                gravar += String.valueOf(screen.arestas.get(i).getVd().getNum()) + (i<screen.arestas.size()-1 ? "MM" : "");
            gravar += ":";
            for (i=0; i<screen.arestas.size(); i++)
                gravar += String.valueOf(screen.arestas.get(i).getPeso()) + (i<screen.arestas.size()-1 ? "MM" : "");

            arquivo.print(gravar);
            arquivo.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao gravar arquivo");
        }
    }
    
    private void saveXml(File arquivoNome, MainForm screen)
    {
        arquivoNome = new File(arquivoNome.getPath()+".xml");

        try
        {
            int i;

            Element eGrafo = new Element("Grafo");
            Document documento = new Document(eGrafo);

            Element[] eVertice = new Element[screen.vertices.size()];
            Element[] eVerticeX = new Element[screen.vertices.size()];
            Element[] eVerticeY = new Element[screen.vertices.size()];
            Element[] eVerticeRotulo = new Element[screen.vertices.size()];
            Element[] eVerticeNumero = new Element[screen.vertices.size()];

            Element[] eAresta = new Element[screen.arestas.size()];
            Element[] eArestaNumVo = new Element[screen.arestas.size()];
            Element[] eArestaNumVd = new Element[screen.arestas.size()];
            Element[] eArestaPeso = new Element[screen.arestas.size()];

            for (i=0; i<screen.vertices.size(); i++)
            {
                eVertice[i] = new Element("Vertice");

                eVerticeX[i] = new Element("X");
                eVerticeX[i].setText(String.valueOf(screen.vertices.get(i).getX()));

                eVerticeY[i] = new Element("Y");
                eVerticeY[i].setText(String.valueOf(screen.vertices.get(i).getY()));

                eVerticeRotulo[i] = new Element("Rotulo");
                eVerticeRotulo[i].setText(String.valueOf(screen.vertices.get(i).getRotulo()));

                eVerticeNumero[i] = new Element("Numero");
                eVerticeNumero[i].setText(String.valueOf(screen.vertices.get(i).getNum()));

                eVertice[i].addContent(eVerticeX[i]);
                eVertice[i].addContent(eVerticeY[i]);
                eVertice[i].addContent(eVerticeRotulo[i]);
                eVertice[i].addContent(eVerticeNumero[i]);

                eGrafo.addContent(eVertice[i]);
            }

            for (i=0; i<screen.arestas.size(); i++)
            {
                eAresta[i] = new Element("Aresta");

                eArestaNumVo[i] = new Element("VerticeInicial_Numero");
                eArestaNumVo[i].setText(String.valueOf(screen.arestas.get(i).getVo().getNum()));

                eArestaNumVd[i] = new Element("VerticeDestino_Numero");
                eArestaNumVd[i].setText(String.valueOf(screen.arestas.get(i).getVd().getNum()));

                eArestaPeso[i] = new Element("Peso");
                eArestaPeso[i].setText(String.valueOf(screen.arestas.get(i).getPeso()));

                eAresta[i].addContent(eArestaNumVo[i]);
                eAresta[i].addContent(eArestaNumVd[i]);
                eAresta[i].addContent(eArestaPeso[i]);

                eGrafo.addContent(eAresta[i]);
            }

            XMLOutputter xout = new XMLOutputter();

            try
            {
                //Criando o arquivo de saida
                FileWriter arquivo = new FileWriter(arquivoNome);

                //Imprimindo o XML no arquivo
                xout.output(documento, arquivo);

            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo");
        }
    }
    
    private void savePri(File arquivoNome, MainForm screen)
    {
        try
        {
            ObjectOutputStream p = new ObjectOutputStream(new FileOutputStream(arquivoNome.getPath()+".pri"));

            p.writeObject(screen.vertices);
            p.writeObject(screen.arestas);
            
            p.flush();
            p.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
