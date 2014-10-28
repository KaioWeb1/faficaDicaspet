package com.dicaspet.MB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.swing.Timer;

import org.primefaces.context.RequestContext;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.dicaspet.entidade.Animal;
import com.dicaspet.util.FacesContextUtil;
 
@ManagedBean
@SessionScoped
public class ReporAlimentoMB implements Serializable{
 
	/**
	 * 
	 */
	static int quantAlimentoAtual=0;
	static SimpleDateFormat teste2 = new SimpleDateFormat("HH");
	
	private static final long serialVersionUID = 1L;
	private Animal animal;
    private LineChartModel zoomModel;
    int um = 0;
	Random timer= new Random();
	Timer t;
	Timer t2;
   
    private  LineChartSeries series2;
    private LineChartModel model; 
    
    public ReporAlimentoMB(){
    	
 
    	//this.run();
    	animal = (Animal) FacesContextUtil.getSessionAttribute("animal");
    	quantAlimentoAtual = (int) animal.getAni_qtdInicAlimento();
    	timer= new Random();
    	series2 = new LineChartSeries();
    	model = new LineChartModel();
    	
  	
    }
 
    @PostConstruct
    public void init() {
        createZoomModel();
      
    }
    

    
    public void graficoUpdate() throws NullPointerException{
 	   RequestContext.getCurrentInstance().update("idGrafico"); 
    }
    
    
   public void getRepor(){
    	um++;
    	quantAlimentoAtual=(int) animal.getAni_qtdInicAlimento();
    	createZoomModel();
    	graficoUpdate();
    	
    	System.out.println(quantAlimentoAtual+"repos---------------------------------------------------------");
    	
    }
   

 
    public LineChartModel getZoomModel() {
        return zoomModel;
    }
     
    private void createZoomModel() {
        zoomModel = initLinearModel();
        zoomModel.setTitle("Verificar níveis de alimentação");
        zoomModel.setZoom(false);
        zoomModel.setLegendPosition("e");
        Axis yAxis = zoomModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(animal.getAni_qtdFimAlimento());
        Axis xAxis = zoomModel.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(23);
       
    }
     
    public LineChartModel initLinearModel() {
        //LineChartModel model = new LineChartModel();

//       LineChartSeries series1 = new LineChartSeries();
//       series1.setLabel("Água");
// 
//       series1.set(1, 2);
//       series1.set(2, 1);
//       series1.set(3, 3);
//       series1.set(4, 6);
//       series1.set(5, 8);
//teste2.format(teste.getTime())
       //LineChartSeries series2 = new LineChartSeries();
       series2.setLabel("Alimento");
       

       series2.set(um,quantAlimentoAtual);
       
       System.out.println(um +"-------------"+quantAlimentoAtual+"montando__________________________________----------------------- ");
       

      // model.addSeries(series1);
       
       if(model.getSeries()!=null){
    	   model.clear();
       }
       model.addSeries(series2);
       
       
  	 return model;
	}; 
   

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public void refresh() {
		
		if(ReporAlimentoMB.quantAlimentoAtual>1){
			ReporAlimentoMB.quantAlimentoAtual=(int) (ReporAlimentoMB.quantAlimentoAtual-15);
			um++;
			   createZoomModel();
            System.out.println(ReporAlimentoMB.quantAlimentoAtual);
			
			} else if(ReporAlimentoMB.quantAlimentoAtual<0){
				ReporAlimentoMB.quantAlimentoAtual=0;
				um++;
				   createZoomModel();
				
				System.out.println(ReporAlimentoMB.quantAlimentoAtual);
			}
			
			else{
				
				 System.out.println(ReporAlimentoMB.quantAlimentoAtual);
            }
			
	}

//	@Override
//	public void run() throws NullPointerException {
//		// TODO Auto-generated method stub
//		ActionListener action = new ActionListener() {  
//			
//			public void actionPerformed(ActionEvent a) throws NullPointerException{
//				
//				if(ReporAlimentoMB.quantAlimentoAtual>1){
//				ReporAlimentoMB.quantAlimentoAtual=(int) (ReporAlimentoMB.quantAlimentoAtual-15);
//				um++;
//				   createZoomModel();
//	            System.out.println(ReporAlimentoMB.quantAlimentoAtual);
//				
//				} else if(ReporAlimentoMB.quantAlimentoAtual<0){
//					ReporAlimentoMB.quantAlimentoAtual=0;
//					um++;
//					   createZoomModel();
//					
//					System.out.println(ReporAlimentoMB.quantAlimentoAtual);
//				}
//				
//				else{
//					
//					 System.out.println(ReporAlimentoMB.quantAlimentoAtual);
//	            }
//				
//			}
//			
//			
//	};
//    	this.t= new Timer(timer.nextInt(20000),action);
//		t.start();
//		
//	}
};

