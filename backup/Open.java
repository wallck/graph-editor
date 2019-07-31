package backup;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import backup.filter.Wgo;
import backup.filter.Xml;
import backup.filter.Pri;
import userInterface.MainForm;
import userInterface.dataAlgorithm.Vertice;
import userInterface.dataAlgorithm.Aresta;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import java.util.List;
import java.util.ArrayList;

public class Open
{
    public void open(MainForm screen)
    {
        JFileChooser arquivoImagem = new JFileChooser();
        arquivoImagem.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        arquivoImagem.addChoosableFileFilter(new Wgo());
        arquivoImagem.addChoosableFileFilter(new Xml());
        arquivoImagem.addChoosableFileFilter(new Pri());
        arquivoImagem.setVisible(true);

        screen.vertices.clear();
        screen.arestas.clear();

        if(arquivoImagem.showOpenDialog(null) == javax.swing.JFileChooser.CANCEL_OPTION)
            return;
        else if(arquivoImagem.getFileFilter().getDescription().equals(".wgo (Formato Texto)"))
        {
            this.openWgo(arquivoImagem.getSelectedFile(), screen);
        }
        else if(arquivoImagem.getFileFilter().getDescription().equals(".xml (Formato XML)"))
        {
            this.openXml(arquivoImagem.getSelectedFile(), screen);
        }
        else if(arquivoImagem.getFileFilter().getDescription().equals(".pri (Formato Serializado)"))
        {
            this.openPri(arquivoImagem.getSelectedFile(), screen);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Arquivo Inválido, selecione uma extenção", "Arquivo Inválido, selecione uma extenção", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    private void openWgo(File arq, MainForm screen)
    {
        String dados="";
        String[] verticeXaresta, dadosVertice, dadosAresta, coordenadaVerticeAresta;
        int i, j;
        
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(arq.getPath()));
            String line;
            StringBuffer buffer = new StringBuffer();

            while((line = in.readLine()) != null )
                buffer.append(line);

            in.close();
            dados = String.valueOf(buffer);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Nao foi possivel abrir o arquivo\n\n" +  arq.getPath() + "\n\n" + ex.getMessage(), "Leitura de arquivo", JOptionPane.ERROR_MESSAGE);
        }

        verticeXaresta = dados.split("OO");
        dadosVertice = verticeXaresta[0].split(":");
        dadosAresta = verticeXaresta[1].split(":");

        for (i=0; i<dadosVertice.length; i++)
        {
            String[] aux = dadosVertice[i].split("MM");

            if (i==0)
            {
                for (j=0; j<aux.length; j++)
                    screen.vertices.add(new Vertice(0, "V", 0, 0));
            }

            for (j=0; j<aux.length; j++)
            {
                switch(i)
                {
                    case 0: screen.vertices.get(j).setX(Integer.parseInt(aux[j]));
                            break;
                    case 1: screen.vertices.get(j).setY(Integer.parseInt(aux[j]));
                            break;
                    case 2: screen.vertices.get(j).setRotulo(aux[j]);
                            break;
                    case 3: screen.vertices.get(j).setNum(Integer.parseInt(aux[j]));
                            break;
                }
            }

            aux = null;
        }

        for (i=0; i<dadosAresta.length; i++)
        {
            String[] aux = dadosAresta[i].split("MM");

            if (i==0)
            {
                for (j=0; j<aux.length; j++)
                    screen.arestas.add(new Aresta(new Vertice(0, "V", 0, 0), new Vertice(0, "V", 0, 0), 0));
            }

            for (j=0; j<aux.length; j++)
            {
                switch(i)
                {
                    case 0: screen.arestas.get(j).setVo(screen.getVertice(Integer.parseInt(aux[j])));
                            break;
                    case 1: screen.arestas.get(j).setVd(screen.getVertice(Integer.parseInt(aux[j])));
                            break;
                    case 2: screen.arestas.get(j).setPeso(Integer.parseInt(aux[j]));
                            break;
                }
            }

            aux = null;
        }
    }
    
    private void openXml(File arq, MainForm screen)
    {
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();

        try
        {
            doc = builder.build(arq.getPath());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Nao foi possivel abrir o arquivo\n\n" +  arq.getPath() + "\n\n" + e.getMessage(), "Leitura de arquivo", JOptionPane.ERROR_MESSAGE);
        }

        Element eGrafo = doc.getRootElement();
        List<Element> lista;

        lista = eGrafo.getChildren("Vertice");

        for (Element e: lista)
        {
            screen.vertices.add(new Vertice(
                Integer.parseInt(e.getChildText("Numero")),
                e.getChildText("Rotulo"),
                Integer.parseInt(e.getChildText("X")),
                Integer.parseInt(e.getChildText("Y"))
            ));
        }

        lista = null;
        lista = eGrafo.getChildren("Aresta");

        for (Element e: lista)
        {
            screen.arestas.add(new Aresta(
                screen.getVertice(Integer.parseInt(e.getChildText("VerticeInicial_Numero"))),
                screen.getVertice(Integer.parseInt(e.getChildText("VerticeDestino_Numero"))),
                Integer.parseInt(e.getChildText("Peso"))
            ));
        }
    }
    
    private void openPri(File arq, MainForm screen)
    {
        try
        {
            ObjectInputStream objLeitura = new ObjectInputStream(new FileInputStream(arq.getPath()));

            screen.vertices.clear();
            screen.arestas.clear();

            try
            {
                screen.vertices = (ArrayList<Vertice>)objLeitura.readObject();
                screen.arestas = (ArrayList<Aresta>)objLeitura.readObject();
            }
            catch(Exception ex) {}
            
            objLeitura.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
