package userInterface.dataAlgorithm;

import java.awt.*;
import java.util.ArrayList;

public class Vertice implements java.io.Serializable
{
	private String rotulo; // r�tulo (legenda) do v�rtice
	private int numero; // n� do v�rtice
	private int x, y; // coordenadas do v�rtice na tela
	private boolean marcado; // define se o v�rtice est� marcado ou n�o
	private Color cor; // cor do v�rtice desmarcado
	private Color corMarcado; // cor do v�rtice marcado
	
	public Vertice(int num, String rot, int x, int y) // construtor
	{
		setRotulo(rot);
		setNum(num);
  		desmarcar();
  		setCor(Color.BLACK); // define a cor padr�o como BLACK
  		setCorMarcado(Color.GREEN); // define a cor padr�o do marcado como GREEN
  		setXY(x, y);
	}
	
	public Vertice(int num, String rot, int x, int y, Color cor) // construtor
	{
		setRotulo(rot);
		setNum(num);
  		desmarcar();
  		setCor(cor);
  		setCorMarcado(Color.GREEN); // define a cor padr�o do marcado como GREEN
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
	
	/* DEFINE O R�TULO DO V�RTICE */
	public void setRotulo(String rot)
	{
		this.rotulo = rot;
	}
	
	/* RETORNA O R�TULO DO V�RTICE */
	public String getRotulo()
	{
		return this.rotulo;
	}
	
	/* DEFINE O N�MERO DO V�RTICE */
	public void setNum(int num)
	{
		this.numero = num;
	}
	
	/* RETORNA O N�MERO DO V�RTICE */
	public int getNum()
	{
		return this.numero;
	}
	
	/* DEFINE A COR DO V�RTICE */
	public void setCor(Color cor)
	{
		this.cor = cor;
	}
	
	/* RETORNA A COR DO V�RTICE */
	public Color getCor()
	{
		return this.cor;
	}
	
	/* DEFINE A COR DO V�RTICE MARCADO */
	public void setCorMarcado(Color cor)
	{
		this.corMarcado = cor;
	}
	
	/* RETORNA A COR DO V�RTICE MARCADO */
	public Color getCorMarcado()
	{
		return this.corMarcado;
	}
}