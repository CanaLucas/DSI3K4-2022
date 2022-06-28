

package com.yoprogramo.dsicu23;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * 
 */
public class DsiCU23 {

    public static void main(String[] args) throws InterruptedException {
       /*CREACION DE LOS OBJETOS SIN BASE DE DATOS*/
        TipoRecursoTecnologico tRTTodas = new TipoRecursoTecnologico("TODAS","");
        TipoRecursoTecnologico tRTMicro = new TipoRecursoTecnologico("MICROSCOPIO DE MEDICON","");
        TipoRecursoTecnologico tRTBalanza = new TipoRecursoTecnologico("BALANZA DE PRECISION","");
        TipoRecursoTecnologico tRTResona = new TipoRecursoTecnologico("RESONADOR MAGNETICO","");
        TipoRecursoTecnologico tRTEqCompu = new TipoRecursoTecnologico("EQUIPAMENTO COMPUTO","");
        TipoRecursoTecnologico tRTCamTer = new TipoRecursoTecnologico("CAMARA TERMICA","");
        
       /*Agregando los tipos de recursos a un array para poder setearlos en la relacion de uno a muchos*/
        TipoRecursoTecnologico[] arrayTipos = new TipoRecursoTecnologico[6];
        arrayTipos[0] = tRTTodas;
        arrayTipos[1] = tRTMicro;
        arrayTipos[2] = tRTBalanza;
        arrayTipos[3] = tRTResona;
        arrayTipos[4] = tRTEqCompu;
        arrayTipos[5] = tRTCamTer;
        
       /*Creando las relaciones del recurso con un estado */
        Estado estadoDispo = new Estado("Disponible","","Recurso Tecnologico",true,false);
        Estado estadoMante = new Estado("En Mantenimiento","","Recurso Tecnologico",true,false);
        Estado estadoManteCo = new Estado("Inicio Mantenimiento Correctivo","","Recurso Tecnologico",true,false);
        Estado estadoBajaT = new Estado("Baja Tecnica","","Recurso Tecnologico",false,false);
        Estado estadoBajaD = new Estado("Baja Definitiva","","Recurso Tecnologico",false,false);
        Estado estadoIngre = new Estado("Ingresado","","Recurso Tecnologico",false,false);
        
        Date desde = new Date(122,6,22,0,0);
        Date hasta = new Date(122,6,30,0,0);
        
        CambioEstadoRT cambioE1 = new CambioEstadoRT(desde,hasta,estadoDispo);
        CambioEstadoRT cambioE2 = new CambioEstadoRT(desde,hasta,estadoMante);
        CambioEstadoRT cambioE3 = new CambioEstadoRT(desde,hasta,estadoManteCo);
        CambioEstadoRT cambioE4 = new CambioEstadoRT(desde,hasta,estadoBajaT);
        CambioEstadoRT cambioE5 = new CambioEstadoRT(desde,hasta,estadoBajaD);
        CambioEstadoRT cambioE6 = new CambioEstadoRT(desde,hasta,estadoIngre);
        
       /*Creando las relaciones del Marca y Modelo */
        Marca marcaShi = new Marca("Shidmazu");
        Marca marcaNikon = new Marca("Nikon");
        Marca marcaGenElec = new Marca("General Electric");
        Marca marcaSie = new Marca("Siemens");
        Marca marcaGramPre = new Marca("Gram Precision");
        Marca marcaOpt = new Marca("Optris");
        
        Modelo modelShi = new Modelo("TX200",marcaShi);
        Modelo modelNikon = new Modelo("M1000",marcaNikon);
        Modelo modelGenElec = new Modelo("X8",marcaGenElec);
        Modelo modelSie = new Modelo("Magneton",marcaSie);
        Modelo modelGramPre = new Modelo("FH-100",marcaGramPre);
        Modelo modelOpt = new Modelo("PI 450i",marcaOpt);
        
       /*Creando Centros de Investigaciones */
        CentroDeInvestigacion centroSern = new CentroDeInvestigacion("SERN",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        CentroDeInvestigacion centroNasa = new CentroDeInvestigacion("NASA",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        CentroDeInvestigacion centroSpace = new CentroDeInvestigacion("Space X",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        
        ArrayList <CentroDeInvestigacion> centrosArray = new ArrayList<>();
        centrosArray.add(centroSern);
        centrosArray.add(centroNasa);
        centrosArray.add(centroSpace);
        
       /*Creando RTs */
        RecursoTecnologico rt1 = new RecursoTecnologico(1,null,null,null,null,null,modelShi,tRTMicro,cambioE1,null,centroSern);
        RecursoTecnologico rt2 = new RecursoTecnologico(2,null,null,null,null,null,modelNikon,tRTMicro,cambioE2,null, centroSern);        
        RecursoTecnologico rt3 = new RecursoTecnologico(3,null,null,null,null,null,modelGenElec,tRTMicro,cambioE3,null, centroNasa);
        RecursoTecnologico rt4 = new RecursoTecnologico(4,null,null,null,null,null,modelNikon,tRTResona,cambioE4,null,centroNasa); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico rt5 = new RecursoTecnologico(5,null,null,null,null,null,modelOpt,tRTCamTer,cambioE1,null,centroSpace); 
        RecursoTecnologico rt6 = new RecursoTecnologico(6,null,null,null,null,null,modelGenElec,tRTMicro,cambioE1,null,centroSern);
        RecursoTecnologico rt7 = new RecursoTecnologico(7,null,null,null,null,null,modelSie,tRTBalanza,cambioE3,null,centroNasa);
        RecursoTecnologico rt8 = new RecursoTecnologico(8,null,null,null,null,null,modelSie,tRTResona,cambioE3,null,centroSpace);
        RecursoTecnologico rt9 = new RecursoTecnologico(9,null,null,null,null,null,modelShi,tRTEqCompu,cambioE1,null,centroNasa);
        RecursoTecnologico rt10 = new RecursoTecnologico(10,null,null,null,null,null,modelSie,tRTMicro,cambioE1,null,centroNasa);
        RecursoTecnologico rt11 = new RecursoTecnologico(11,null,null,null,null,null,modelShi,tRTMicro,cambioE6,null,centroSern);
        RecursoTecnologico rt12 = new RecursoTecnologico(12,null,null,null,null,null,modelOpt,tRTCamTer,cambioE2,null, centroSern);        
        RecursoTecnologico rt13 = new RecursoTecnologico(13,null,null,null,null,null,modelGenElec,tRTMicro,cambioE6,null, centroNasa); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico rt14 = new RecursoTecnologico(14,null,null,null,null,null,modelGramPre,tRTResona,cambioE4,null,centroNasa); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico rt15 = new RecursoTecnologico(15,null,null,null,null,null,modelNikon,tRTEqCompu,cambioE5,null,centroSpace); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico rt16 = new RecursoTecnologico(16,null,null,null,null,null,modelGenElec,tRTMicro,cambioE2,null,centroSern);
        RecursoTecnologico rt17 = new RecursoTecnologico(17,null,null,null,null,null,modelGramPre,tRTBalanza,cambioE3,null,centroNasa);
        RecursoTecnologico rt18 = new RecursoTecnologico(18,null,null,null,null,null,modelGenElec,tRTResona,cambioE1,null,centroSpace);
        RecursoTecnologico rt19 = new RecursoTecnologico(19,null,null,null,null,null,modelShi,tRTResona,cambioE1,null,centroNasa);
        RecursoTecnologico rt20 = new RecursoTecnologico(20,null,null,null,null,null,modelOpt,tRTCamTer,cambioE1,null,centroNasa);
        
       /*Creando relacion RTs con Centros */
        ArrayList <RecursoTecnologico> rtCentroSern= new ArrayList<>();
        rtCentroSern.add(rt1);
        rtCentroSern.add(rt2);
        rtCentroSern.add(rt6);
        rtCentroSern.add(rt11);
        rtCentroSern.add(rt12);
        rtCentroSern.add(rt16);
        
        centroSern.setRecursosTecnologicos(rtCentroSern);       
        
        ArrayList <RecursoTecnologico> rtCentroNasa= new ArrayList<>();
        rtCentroNasa.add(rt3);
        rtCentroNasa.add(rt4);
        rtCentroNasa.add(rt7);
        rtCentroNasa.add(rt9);
        rtCentroNasa.add(rt10);
        rtCentroNasa.add(rt13);
        rtCentroNasa.add(rt14);
        rtCentroNasa.add(rt17);
        rtCentroNasa.add(rt19);
        rtCentroNasa.add(rt20);
        
        centroNasa.setRecursosTecnologicos(rtCentroNasa);
        
        ArrayList <RecursoTecnologico> rtCentroSpace= new ArrayList<>();
        rtCentroSpace.add(rt5);
        rtCentroSpace.add(rt8);
        rtCentroSpace.add(rt15);
        rtCentroSpace.add(rt18);
        
        centroSpace.setRecursosTecnologicos(rtCentroSpace);
       
       /*lista de RTs */
        ArrayList<RecursoTecnologico> rec = new ArrayList<>();
        rec.add(rt1);
        rec.add(rt2);
        rec.add(rt3);
        rec.add(rt4);
        rec.add(rt5);
        rec.add(rt6);
        rec.add(rt7);
        rec.add(rt8);
        rec.add(rt9);
        rec.add(rt10);
        rec.add(rt11);
        rec.add(rt12);
        rec.add(rt13);
        rec.add(rt14);
        rec.add(rt15);
        rec.add(rt16);
        rec.add(rt17);
        rec.add(rt18);
        rec.add(rt19);
        rec.add(rt20);
        
       /*Creando Personal Cientifico/AsignacionT con Centros */
        ArrayList <AsignacionCientificoDelCI> asignaciones = new ArrayList <>();
        
        PersonalCientifico cientifico1 = new PersonalCientifico(1,"Bruce","Wayne",39393939,"brucewayne@gmail.com","iambatman@gmail.com",351351523);
        
        AsignacionCientificoDelCI asignacion1 = new AsignacionCientificoDelCI(null,null,cientifico1);
        
        asignaciones.add(asignacion1);       
        
        centroSern.setAsignacionCientifico(asignaciones);
        
        PersonalCientifico cientifico2 = new PersonalCientifico(2,"Alfred","Lord",236547891,"alfredlord@gmail.com","eljefe@gmail.com",351351232);
        PersonalCientifico cientifico3 = new PersonalCientifico(3,"Thomas","Wayne",31394839,"thomaswayne@gmail.com","iamjoker@gmail.com",35145823);
        PersonalCientifico cientifico4 = new PersonalCientifico(4,"Selina","Kyle",35395439,"selinekyle@gmail.com","iamcatwomen@gmail.com",35135423);
        
       /*Creando Turnos y sus cambios de estados */
        ArrayList <Turno> turnos = new ArrayList <>();
        ArrayList <CambioEstadoTurno> cambioEstadoturnos = new ArrayList <>();
        ArrayList <CambioEstadoTurno> cambioEstadoturnos2 = new ArrayList <>();
        ArrayList <CambioEstadoTurno> cambioEstadoturnos3 = new ArrayList <>();
      
        Estado estadoTurnoDispo = new Estado("Disponible","","Turno",false,true);
        Estado estadoTurnoPteConf = new Estado("Pendiente Confirmacion","","Turno",false,true);
        Estado estadoTurnoReser = new Estado("Reservado","","Turno",false,true);
       
        CambioEstadoTurno cambioTurno1 = new CambioEstadoTurno(desde,hasta,estadoTurnoDispo);
        CambioEstadoTurno cambioTurno2 = new CambioEstadoTurno(desde,hasta,estadoTurnoPteConf);
        CambioEstadoTurno cambioTurno3 = new CambioEstadoTurno(desde,hasta,estadoTurnoReser);
       
        cambioEstadoturnos.add(cambioTurno1);
        cambioEstadoturnos2.add(cambioTurno2);
        cambioEstadoturnos3.add(cambioTurno3);
       
        Date horajunio1ini = new Date(122,6,28,10,0,0); /*disponible 1 julio*/
        Date horajunio2ini = new Date(122,6,30,14,0,0); 
        Date horajunio3ini = new Date(122,6,29,15,0,0); 
       
        Date horajunio1fin = new Date(122,7,2,10,0,0); /*disponible 1 julio*/
        Date horajunio2fin = new Date(122,7,8,14,0,0); 
        Date horajunio3fin = new Date(122,7,15,15,0,0); 
       
        Turno turno1 = new Turno(null,null,horajunio1ini,horajunio1fin,null);
        Turno turno2 = new Turno(null,null,horajunio2ini,horajunio2fin,null);
        Turno turno3 = new Turno(null,null,horajunio3ini,horajunio3fin,null);
        Turno turno4 = new Turno(null,null,null,null,null);
        Turno turno5 = new Turno(null,null,null,null,null);
        
        turno1.setCambioEstadoTurno(cambioEstadoturnos);
        turno2.setCambioEstadoTurno(cambioEstadoturnos2);
        turno3.setCambioEstadoTurno(cambioEstadoturnos3);
       
       /*Los recursos tecnologicos del recurso a*/
        turnos.add(turno1);
        turnos.add(turno2);
        turnos.add(turno3);
       
        rt1.setTurnos(turnos);
       
        
        /*Creamos la pantalla*/
        PantallaRegistrarReservaTurnoDeRT pantalla = new PantallaRegistrarReservaTurnoDeRT();
        
        /*Llamamos al metodo de interfaz*/
     
        /*Creamos al gestor y se le setean los tipos de recursos que conforman su relacion*/
        GestorRegistrarReservaTurnoDeRT gestor = new GestorRegistrarReservaTurnoDeRT();  
        
        /*Esto pasa nomas porq no tenemos base de datos, sino no se inicializarian y se traerian directamente*/
        gestor.setTiposDeRecursosTecnologicos(arrayTipos);
        gestor.setRecursosTecnologicos(rec);
        
        /*Inicia el Caso de Uso*/
        
        while(pantalla.getBtnOpcionReservarTurnoDeRT() == 0){
            pantalla.habilitarPantalla();
        }
    
        /*Sale del bucle si se presiona el boton que setea la opcion btn reserva en 1*/
        if(pantalla.getBtnOpcionReservarTurnoDeRT() == 1){
            
            /*DEVUELVE UN ARRAY QUE CONTIENE TODOS LOS TIPOS DE RECURSO POSIBLES*/
            ArrayList <String> cmbTiposDeRecursos = gestor.opcionReservaTurnoDeRT(pantalla.getBtnOpcionReservarTurnoDeRT());
            
            /*Declaro un string*/
            String seleccion = new String();
            
            /*Declaro el array que contendra los recursos de tipo elegido*/
            ArrayList<RecursoTecnologico> recursos = new ArrayList <>();   
            
            /*ENTRA EN UN CICLO PORQ SI ELIGE UN TIPO DE RECURSO QUE NO SE PUEDE RESERVAR ENTONCES VUELVE A PEDIR QUE SELECCIONES UN NUEVO TIPO*/
            while(recursos.isEmpty()){    
                /*Llamo a la interfaz que te hace seleccionar un tipo de producto*/
                seleccion = pantalla.mostrarTiposDeRecursos(cmbTiposDeRecursos);
                
                /*Mando al gestor para que pueda obtener todos los recursos con el tipo pasado por parametro*/
                recursos = gestor.buscarRTDeTipoSeleccionado(seleccion);
            }
            
            /*Comprobacion de que lo que se selecciona en el formulario se devuelve*/
            System.out.print(seleccion);
            /*LE PASA LOS RECURSOS A LA PANTALLA*/
            pantalla.setListaRT(recursos);
            
            /*Buscar y obtener los datos de los recursos, ACA NO SE SI DEVOLVERIA UN ARRAY DE RECURSOS PORQUE TIENE Q CONTENER EL CENTRO AL QUE PERTENECE */
            ArrayList<RecursoTecnologico> recursosAll = gestor.buscarInformacionRecursosTecnologicos(recursos);
           
            /*OBTENIENDO DATOS PARA VER COMO SE PASAN A LA INTERFAZ PARA AGRUPARLOS POR EL CENTRO*/
            for(int i=0;i<recursosAll.size();i++){
                System.out.print(recursosAll.get(i).toString());           
            }
            
            /*HAY QUE VER COMO SE IMPLEMENTA LA DEPENDENCIA PARA PODER SABER Q RECURSOS TIENE UN CENTRO, ENTONCES LE MANDAS O UN ARRAY Q TIENE EL CENTRO O LOS CENTROS POR SEPARADOS*/
            gestor.agruparRTPorCI();
            
            /*setea todos los centros que existen en un array list*/
            pantalla.setCentrosInvestigacion(centrosArray);
            
            /*llama a la pantalla y esta o crea una nueva gui q muestre todos los recursos agrupados y espera a q selecciones una para setearlo como recurso seleccionado
            ESTE METODO TERMINA HACIENDO UN MONTON DE PASOS Y MENSAJES DEL DIAGRAMA, NO ESTA AGRUPANDO COMO TAL PERO SI VA A MOSTRAR LOS RECURSOS SEGUN EL CENTRO Q TIENEN,
            TENDRIAMOS QUE VER SI ES NECESARIO CAMBIAR LOS METODOS PARA Q HAGAN COSAS O QUE HACER
            */
            
            pantalla.mostrarRTAgrupados(recursosAll);
            
            /*RECURSO SELECCIONADO POR EL USUARIO*/
            gestor.setRecursoTecnologicoSeleccionado(pantalla.getRecursoSeleccionado());
           
            gestor.setUsuarioLogueado(cientifico1);
            boolean estaLogueado = gestor.buscarUsuarioLogueado(cientifico1);
            String correoInstitucionalCientifico = gestor.verificarCIDeCientifico(cientifico1);
            
            System.out.print("---" + correoInstitucionalCientifico+"-----");
            
            /*Obtiene la hora actual del sistema*/
            Date horaActual = gestor.obtenerFechaYHoraActual();
            System.out.print(horaActual);
            
            gestor.setFechaActual(horaActual);
            
            /*TURNOS*/
            gestor.obtenerTurnosDelRTSeleccionado();
            
            /*YA TENGO LOS TURNOS*/
            
            pantalla.mostrarTurnos(gestor.getTurnoDelRT());
            
            
            /*LA PARTE DEL AMBITO*/
            String amb = "Recurso tecnologico";
            
            //gestor.reservarTurnoDeRT(amb);
            
            /* Lo que muestra recursosAll
            for(int i=0;i<recursosAll.size();i++){
                System.out.print(recursosAll.get(i) + " ");
            
            }
            */                  
        }
        else{
            System.out.print("Funcion aun no desarrollada");
        }
    }
}
