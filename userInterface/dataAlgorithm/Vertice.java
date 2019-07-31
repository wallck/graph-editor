package userInterface.dataAlgorithm;

import java.awt.*;
import java.util.ArrayList;

public class Vertice implements java.io.Serializable
{
	private String rotulo; // rótulo (legenda) do vértice
	private int numero; // nº do vértice
	private int x, y; // coordenadas do vértice na tela
	private boolean marcado; // define se o vértice está marcado ou não
	private Color cor; // cor do vértice desmarcado
	private Color corMarcado; // cor do vértice marcado
	
	public Vertice(int num, String rot, int x, int y) // construtor
	{
		setRotulo(rot);
		setNum(num);
  		desmarcar();
  		setCor(Color.BLACK); // define a cor padrão como BLACK
  		setCorMarcado(Color.GREEN); // define a cor padrão do marcado como GREEN
  		setXY(x, y);
	}
	
	public Vertice(int num, String rot, int x, int y, Color cor) // construtor
	{
		setRotulo(rot);
		setNum(num);
  		desmarcar();
  		setCor(cor);
  		setCorMarcado(Color.GREEN); // define a cor padrão do marcado como GREEN
  		setXY(x, y);
	}
	
	public void setXY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void marcar()
	{
		this.marcado = true;
	}
	
	public void desmarcar()
	{
		this.marcado = false;
	}
	
	public boolean getMarcado()
	{
		return this.marcado;	
	}
	
	/* DEFINE O RÓTULO DO VÉRTICE */
	public void setRotulo(String rot)
	{
		this.rotulo = rot;
	}
	
	/* RETORNA O RÓTULO DO VÉRTICE */
	public String getRotulo()
	{
		return this.rotulo;
	}
	
	/* DEFINE O NÚMERO DO VÉRTICE */
	public void setNum(int num)
	{
		this.numero = num;
	}
	
	/* RETORNA O NÚMERO DO VÉRTICE */
	public int getNum()
	{
		return this.numero;
	}
	
	/* DEFINE A COR DO VÉRTICE */
	public void setCor(Color cor)
	{
		this.cor = cor;
	}
	
	/* RETORNA A COR DO VÉRTICE */
	public Color getCor()
	{
		return this.cor;
	}
	
	/* DEFINE A COR DO VÉRTICE MARCADO */
	public void setCorMarcado(Color cor)
	{
		this.corMarcado = cor;
	}
	
	/* RETORNA A COR DO VÉRTICE MARCADO */
	public Color getCorMarcado()
	{
		return this.corMarcado;
	}
}