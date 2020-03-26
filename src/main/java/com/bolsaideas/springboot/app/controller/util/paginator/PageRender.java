package com.bolsaideas.springboot.app.controller.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	
	private String url;
	private Page<T> page;
	private int totalPaginas;
	private int numElememtosPorPagina;
	
	private int paginaActual;
	
	private List<PageItem> paginas;
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();
		numElememtosPorPagina = page.getSize();
		totalPaginas = page.getTotalPages();
		paginaActual = page.getNumber();
		int desde, hasta;
		if(totalPaginas <= numElememtosPorPagina) {
			desde = 1;
			hasta = totalPaginas;
		}else {
			if(paginaActual <= numElememtosPorPagina/2) {
				desde = 1;
				hasta = numElememtosPorPagina;
			}else if(paginaActual >= totalPaginas - numElememtosPorPagina/2) {
				desde = totalPaginas - numElememtosPorPagina +1;
				hasta = numElememtosPorPagina;
			}else {
				desde = paginaActual - numElememtosPorPagina/2;
				hasta = numElememtosPorPagina;
			}
		}
		for (int i=0; i < hasta; i++) {
			paginas.add(new PageItem(desde + i, paginaActual == desde+i));
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public int getNumElememtosPorPagina() {
		return numElememtosPorPagina;
	}

	public void setNumElememtosPorPagina(int numElememtosPorPagina) {
		this.numElememtosPorPagina = numElememtosPorPagina;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public void setPaginaActual(int paginaActual) {
		this.paginaActual = paginaActual;
	}

	public List<PageItem> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<PageItem> paginas) {
		this.paginas = paginas;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
}
