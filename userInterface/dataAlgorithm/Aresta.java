package userInterface.dataAlgorithm;

import javax.swing.*;
import java.awt.*;

public class Aresta implements java.io.Serializable
{
	private Vertice vo, vd; // vértice de origem e destino
	private int peso;
	private Color cor; // cor da aresta
	
	public Aresta(Vertice vo, Vertice vd, int peso)
	{
		this.vo = vo;
		this.vd = vd;
		this.peso = peso;
		setCor(Color.BLACK);
	}
	
	public Aresta(Vertice vo, Vertice vd, int peso, Color cor)
	{
		this.vo = vo;
		this.vd = vd;
		this.peso = peso;
		setCor(cor);
	}
	
	/* DEFINE O PESO */
	public void setPeso(int peso)
	{
		this.peso = peso;
	}

	/* RETORNA O PESO */
	public int getPeso()
	{
		return this.peso;	
	}
	
	/* RETORNA O VÉRTICE ORIGEM */
	public Vertice getVo()
	{
		return this.vo;	
	}
	
	public void setVo(Vertice v)
	{
		this.vo.setX(v.getX());
		this.vo.setY(v.getY());
        this.vo.setRotulo(v.getRotulo());
        this.vo.setNum(v.getNum());
	}

	/* RETORNA O VÉRTICE DESTINO */
	public Vertice getVd()
	{
		return this.vd;	
	}
	
	public void setVd(Vertice v)
	{
		this.vd.setX(v.getX());
		this.vd.setY(v.getY());
        this.vd.setRotulo(v.getRotulo());
        this.vd.setNum(v.getNum());
	}
	
	/* DEFINE A COR DA ARESTA */
	public void setCor(Color cor)
	{
		this.cor = cor;	
	}
	
	/* RETORNA A COR DA ARESTA */
	public Color getCor()
	{
		return this.cor;
	}
}