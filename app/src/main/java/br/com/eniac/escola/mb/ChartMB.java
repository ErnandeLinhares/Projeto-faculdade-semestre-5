package br.com.eniac.escola.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;


@ManagedBean
@ViewScoped
public class ChartMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private PieChartModel model;

	
	
	
	public ChartMB(){
		model = new PieChartModel();
		model.set("Brand", 540);
		model.set("Brand2", 540);
		model.set("Brand3", 540);		
	}
	
	public PieChartModel getModel(){
		return model;
	}
	

}
