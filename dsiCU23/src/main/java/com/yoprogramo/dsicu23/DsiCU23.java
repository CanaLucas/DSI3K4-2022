
package com.yoprogramo.dsicu23;

import java.util.ArrayList;
import java.util.Date;

public class DsiCU23 {

    public static void main(String[] args) throws InterruptedException {
       
        /*CREACION DE LOS OBJETOS SIN BASE DE DATOS*/
        TipoRecursoTecnologico tRTTodas = new TipoRecursoTecnologico("TODOS","");
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
        
       /*Creando Turnos y sus cambios de estados */
        ArrayList <Turno> turnosRTMicro = new ArrayList <>();
        ArrayList <Turno> turnosRTBalan = new ArrayList <>();
        ArrayList <Turno> turnosRT4 = new ArrayList <>();
        ArrayList <Turno> turnosRT5 = new ArrayList <>();
        ArrayList <Turno> turnosRT8 = new ArrayList <>();
        ArrayList <Turno> turnosRT9 = new ArrayList <>();
        ArrayList <Turno> turnosRT12 = new ArrayList <>();
        ArrayList <Turno> turnosRT14 = new ArrayList <>();
        ArrayList <Turno> turnosRT15 = new ArrayList <>();
        ArrayList <Turno> turnosRT18 = new ArrayList <>();
        ArrayList <Turno> turnosRT19 = new ArrayList <>();
        ArrayList <Turno> turnosRT20 = new ArrayList <>();
        
        Estado estadoTurnoDispo = new Estado("Disponible","","Turno",true,false);
        Estado estadoTurnoPteConf = new Estado("Pendiente Confirmacion","","Turno",true,true);
        Estado estadoTurnoReser = new Estado("Reservado","","Turno",false,true);
       
        ArrayList <Estado> estados = new ArrayList<>();
        
        Date desdeCET = new Date(122,6,28,0,0);
        
        CambioEstadoTurno cambioTurnoDispo = new CambioEstadoTurno(desdeCET,null,estadoTurnoDispo);
        CambioEstadoTurno cambioTurnoPteConf = new CambioEstadoTurno(desdeCET,null,estadoTurnoPteConf);
        CambioEstadoTurno cambioTurnoReser = new CambioEstadoTurno(desdeCET,null,estadoTurnoReser);
       
        ArrayList <CambioEstadoTurno> cETDispo = new ArrayList <>();
        ArrayList <CambioEstadoTurno> cETPteConf = new ArrayList <>();
        ArrayList <CambioEstadoTurno> cETReser = new ArrayList <>();
        
        cETDispo.add(cambioTurnoDispo);
        cETPteConf.add(cambioTurnoPteConf);
        cETReser.add(cambioTurnoReser);            
        
       //definicion de Turnos desde el 4/7/2022 al 8/7/2022
       Date fechaGenTodosTurnos = new Date(122,6,28,8,0,0);
       // Turnos para RT tipo Microscopios
        Date tMLuIni1 = new Date(122,7,1,8,0,0);
        Date tMLuFin1 = new Date(122,7,1,12,0,0); 
        Date tMLuIni2 = new Date(122,7,1,14,0,0);
        Date tMLuFin2 = new Date(122,7,1,18,0,0); 
        Date tMMaIni1 = new Date(122,7,2,8,0,0);
        Date tMMaFin1 = new Date(122,7,2,12,0,0); 
        Date tMMaIni2 = new Date(122,7,2,14,0,0);
        Date tMMaFin2 = new Date(122,7,2,18,0,0);
        Date tMMiIni1 = new Date(122,7,3,8,0,0);
        Date tMMiFin1 = new Date(122,7,3,12,0,0); 
        Date tMMiIni2 = new Date(122,7,3,14,0,0);
        Date tMMiFin2 = new Date(122,7,3,18,0,0);
        Date tMJuIni1 = new Date(122,7,4,8,0,0);
        Date tMJuFin1 = new Date(122,7,4,12,0,0); 
        Date tMJuIni2 = new Date(122,7,4,14,0,0);
        Date tMJuFin2 = new Date(122,7,4,18,0,0);
        Date tMViIni1 = new Date(122,7,5,8,0,0);
        Date tMViFin1 = new Date(122,7,5,12,0,0); 
        Date tMViIni2 = new Date(122,7,5,14,0,0);
        Date tMViFin2 = new Date(122,7,5,18,0,0);
        
        Turno turnoMA1 = new Turno(fechaGenTodosTurnos,"Lunes",tMLuIni1,tMLuFin1,cETReser);
        Turno turnoMB1 = new Turno(fechaGenTodosTurnos,"Martes",tMMaIni1,tMMaFin1,cETDispo);
        Turno turnoMC1 = new Turno(fechaGenTodosTurnos,"Miercoles",tMMiIni1,tMMiFin1,cETDispo);
        Turno turnoMD1 = new Turno(fechaGenTodosTurnos,"Jueves",tMJuIni1,tMJuFin1,cETDispo);
        Turno turnoME1 = new Turno(fechaGenTodosTurnos,"Viernes",tMViIni1,tMViFin1,cETPteConf);
        Turno turnoMA2 = new Turno(fechaGenTodosTurnos,"Lunes",tMLuIni2,tMLuFin2,cETReser);
        Turno turnoMB2 = new Turno(fechaGenTodosTurnos,"Martes",tMMaIni2,tMMaFin2,cETPteConf);
        Turno turnoMC2 = new Turno(fechaGenTodosTurnos,"Miercoles",tMMiIni2,tMMiFin2,cETReser);
        Turno turnoMD2 = new Turno(fechaGenTodosTurnos,"Jueves",tMJuIni2,tMJuFin2,cETDispo);
        Turno turnoME2 = new Turno(fechaGenTodosTurnos,"Viernes",tMViIni2,tMViFin2,cETDispo);
        
        turnosRTMicro.add(turnoMA1);
        turnosRTMicro.add(turnoMA2);
        turnosRTMicro.add(turnoMB1);
        turnosRTMicro.add(turnoMB2);
        turnosRTMicro.add(turnoMC1);
        turnosRTMicro.add(turnoMC2);
        turnosRTMicro.add(turnoMD1);
        turnosRTMicro.add(turnoMD2);
        turnosRTMicro.add(turnoME1);
        turnosRTMicro.add(turnoME2);
        
       // Turnos para RT tipo Resonador
        Date tRLuIni = new Date(122,7,1,8,0,0);
        Date tRLuFin = new Date(122,7,1,18,0,0); 
        Date tRMaIni = new Date(122,7,2,8,0,0);
        Date tRMaFin = new Date(122,7,2,18,0,0); 
        Date tRMiIni = new Date(122,7,3,8,0,0);
        Date tRMiFin = new Date(122,7,3,18,0,0); 
        Date tRJuIni = new Date(122,7,4,8,0,0);
        Date tRJuFin = new Date(122,7,4,18,0,0); 
        Date tRViIni = new Date(122,7,5,8,0,0);
        Date tRViFin = new Date(122,7,5,18,0,0);
        
        Turno turnoRA = new Turno(fechaGenTodosTurnos,"Lunes",tRLuIni,tRLuFin,cETDispo);
        Turno turnoRB = new Turno(fechaGenTodosTurnos,"Martes",tRMaIni,tRMaFin,cETReser);
        Turno turnoRC = new Turno(fechaGenTodosTurnos,"Miercoles",tRMiIni,tRMiFin,cETReser);
        Turno turnoRD = new Turno(fechaGenTodosTurnos,"Jueves",tRJuIni,tRJuFin,cETPteConf);
        Turno turnoRE = new Turno(fechaGenTodosTurnos,"Viernes",tRViIni,tRViFin,cETDispo);
        
        turnosRT4.add(turnoRA);
        turnosRT4.add(turnoRB);
        turnosRT4.add(turnoRC);
        turnosRT4.add(turnoRD);
        turnosRT4.add(turnoRE);
        turnosRT8.add(turnoRA);
        turnosRT8.add(turnoRB);
        turnosRT8.add(turnoRC);
        turnosRT8.add(turnoRD);
        turnosRT8.add(turnoRE);
        turnosRT14.add(turnoRA);
        turnosRT14.add(turnoRB);
        turnosRT14.add(turnoRC);
        turnosRT14.add(turnoRD);
        turnosRT14.add(turnoRE);
        turnosRT18.add(turnoRA);
        turnosRT18.add(turnoRB);
        turnosRT18.add(turnoRC);
        turnosRT18.add(turnoRD);
        turnosRT18.add(turnoRE);
        turnosRT19.add(turnoRA);
        turnosRT19.add(turnoRB);
        turnosRT19.add(turnoRC);
        turnosRT19.add(turnoRD);
        turnosRT19.add(turnoRE);
        
       // Turnos para RT tipo Camara Termica
        Date tCTLuIni = new Date(122,7,1,8,0,0);
        Date tCTLuFin = new Date(122,7,1,18,0,0); 
        Date tCTMaIni = new Date(122,7,2,8,0,0);
        Date tCTMaFin = new Date(122,7,2,18,0,0); 
        Date tCTMiIni = new Date(122,7,3,8,0,0);
        Date tCTMiFin = new Date(122,7,3,18,0,0); 
        Date tCTJuIni = new Date(122,7,4,8,0,0);
        Date tCTJuFin = new Date(122,7,4,18,0,0); 
        Date tCTViIni = new Date(122,7,5,8,0,0);
        Date tCTViFin = new Date(122,7,5,18,0,0); 
       
        Turno turnoCTA = new Turno(fechaGenTodosTurnos,"Lunes",tCTLuIni,tCTLuFin,cETDispo);
        Turno turnoCTB = new Turno(fechaGenTodosTurnos,"Martes",tCTMaIni,tCTMaFin,cETReser);
        Turno turnoCTC = new Turno(fechaGenTodosTurnos,"Miercoles",tCTMiIni,tCTMiFin,cETReser);
        Turno turnoCTD = new Turno(fechaGenTodosTurnos,"Jueves",tCTJuIni,tCTJuFin,cETDispo);
        Turno turnoCTE = new Turno(fechaGenTodosTurnos,"Viernes",tCTViIni,tCTViFin,cETPteConf);
        
        turnosRT5.add(turnoCTA);
        turnosRT5.add(turnoCTB);
        turnosRT5.add(turnoCTC);
        turnosRT5.add(turnoCTD);
        turnosRT5.add(turnoCTE);
        turnosRT12.add(turnoCTA);
        turnosRT12.add(turnoCTB);
        turnosRT12.add(turnoCTC);
        turnosRT12.add(turnoCTD);
        turnosRT12.add(turnoCTE);
        turnosRT20.add(turnoCTA);
        turnosRT20.add(turnoCTB);
        turnosRT20.add(turnoCTC);
        turnosRT20.add(turnoCTD);
        turnosRT20.add(turnoCTE);
        
       // Turnos para RT tipo Balanza
        Date tBLuIni1 = new Date(122,7,1,8,0,0);
        Date tBLuFin1 = new Date(122,7,1,12,0,0); 
        Date tBLuIni2 = new Date(122,7,1,14,0,0);
        Date tBLuFin2 = new Date(122,7,1,18,0,0); 
        Date tBMaIni1 = new Date(122,7,2,8,0,0);
        Date tBMaFin1 = new Date(122,7,2,12,0,0); 
        Date tBMaIni2 = new Date(122,7,2,14,0,0);
        Date tBMaFin2 = new Date(122,7,2,18,0,0);
        Date tBMiIni1 = new Date(122,7,3,8,0,0);
        Date tBMiFin1 = new Date(122,7,3,12,0,0); 
        Date tBMiIni2 = new Date(122,7,3,14,0,0);
        Date tBMiFin2 = new Date(122,7,3,18,0,0);
        Date tBJuIni1 = new Date(122,7,4,8,0,0);
        Date tBJuFin1 = new Date(122,7,4,12,0,0); 
        Date tBJuIni2 = new Date(122,7,4,14,0,0);
        Date tBJuFin2 = new Date(122,7,4,18,0,0);
        Date tBViIni1 = new Date(122,7,5,8,0,0);
        Date tBViFin1 = new Date(122,7,5,12,0,0); 
        Date tBViIni2 = new Date(122,7,5,14,0,0);
        Date tBViFin2 = new Date(122,7,5,18,0,0); 
       
        Turno turnoBA1 = new Turno(fechaGenTodosTurnos,"Lunes",tBLuIni1,tBLuFin1,cETReser);
        Turno turnoBB1 = new Turno(fechaGenTodosTurnos,"Martes",tBMaIni1,tBMaFin1,cETDispo);
        Turno turnoBC1 = new Turno(fechaGenTodosTurnos,"Miercoles",tBMiIni1,tBMiFin1,cETReser);
        Turno turnoBD1 = new Turno(fechaGenTodosTurnos,"Jueves",tBJuIni1,tBJuFin1,cETPteConf);
        Turno turnoBE1 = new Turno(fechaGenTodosTurnos,"Viernes",tBViIni1,tBViFin1,cETPteConf);
        Turno turnoBA2 = new Turno(fechaGenTodosTurnos,"Lunes",tBLuIni2,tBLuFin2,cETDispo);
        Turno turnoBB2 = new Turno(fechaGenTodosTurnos,"Martes",tBMaIni2,tBMaFin2,cETPteConf);
        Turno turnoBC2 = new Turno(fechaGenTodosTurnos,"Miercoles",tBMiIni2,tBMiFin2,cETDispo);
        Turno turnoBD2 = new Turno(fechaGenTodosTurnos,"Jueves",tBJuIni2,tBJuFin2,cETDispo);
        Turno turnoBE2 = new Turno(fechaGenTodosTurnos,"Viernes",tBViIni2,tBViFin2,cETDispo);
        
        turnosRTBalan.add(turnoBA1);
        turnosRTBalan.add(turnoBA2);
        turnosRTBalan.add(turnoBB1);
        turnosRTBalan.add(turnoBB2);
        turnosRTBalan.add(turnoBC1);
        turnosRTBalan.add(turnoBC2);
        turnosRTBalan.add(turnoBD1);
        turnosRTBalan.add(turnoBD2);
        turnosRTBalan.add(turnoBE1);
        turnosRTBalan.add(turnoBE2);
        
       // Turnos para RT tipo Equipo de Computo
        Date tECLuIni = new Date(122,7,1,8,0,0);
        Date tECLuFin = new Date(122,7,1,18,0,0); 
        Date tECMaIni = new Date(122,7,2,8,0,0);
        Date tECMaFin = new Date(122,7,2,18,0,0); 
        Date tECMiIni = new Date(122,7,3,8,0,0);
        Date tECMiFin = new Date(122,7,3,18,0,0); 
        Date tECJuIni = new Date(122,7,4,8,0,0);
        Date tECJuFin = new Date(122,7,4,18,0,0); 
        Date tECViIni = new Date(122,7,5,8,0,0);
        Date tECViFin = new Date(122,7,5,18,0,0); 
       
        Turno turnoECA = new Turno(fechaGenTodosTurnos,"Lunes",tECLuIni,tECLuFin,cETDispo);
        Turno turnoECB = new Turno(fechaGenTodosTurnos,"Martes",tECMaIni,tECMaFin,cETPteConf);
        Turno turnoECC = new Turno(fechaGenTodosTurnos,"Miercoles",tECMiIni,tECMiFin,cETReser);
        Turno turnoECD = new Turno(fechaGenTodosTurnos,"Jueves",tECJuIni,tECJuFin,cETDispo);
        Turno turnoECE = new Turno(fechaGenTodosTurnos,"Viernes",tECViIni,tECViFin,cETDispo);
        
        turnosRT9.add(turnoECA);
        turnosRT9.add(turnoECB);
        turnosRT9.add(turnoECC);
        turnosRT9.add(turnoECD);
        turnosRT9.add(turnoECE);

        turnosRT15.add(turnoECA);
        turnosRT15.add(turnoECB);
        turnosRT15.add(turnoECC);
        turnosRT15.add(turnoECD);
        turnosRT15.add(turnoECE);
        
       /*Creando las relaciones del recurso con un estado */
        Estado estadoDispo = new Estado("Disponible","","Recurso Tecnologico",true,false);
        Estado estadoMante1 = new Estado("En Mantenimiento","","Recurso Tecnologico",true,false);
        Estado estadoManteCo = new Estado("Inicio Mantenimiento Correctivo","","Recurso Tecnologico",true,false);
        Estado estadoBajaT = new Estado("Baja Tecnica","","Recurso Tecnologico",false,false);
        Estado estadoBajaD = new Estado("Baja Definitiva","","Recurso Tecnologico",false,false);
        Estado estadoIngre = new Estado("Ingresado","","Recurso Tecnologico",false,false);
        
        estados.add(estadoDispo);
        estados.add(estadoMante1);
        estados.add(estadoManteCo);
        estados.add(estadoBajaT);
        estados.add(estadoBajaD);
        estados.add(estadoIngre);
        estados.add(estadoTurnoDispo);
        estados.add(estadoTurnoPteConf);
        estados.add(estadoTurnoReser);
        
        Date desde = new Date(122,6,22,0,0);
        Date hasta = new Date(122,6,30,0,0);
        
        CambioEstadoRT cambioE1 = new CambioEstadoRT(desde,null,estadoDispo);
        CambioEstadoRT cambioE2 = new CambioEstadoRT(desde,null,estadoMante1);
        CambioEstadoRT cambioE3 = new CambioEstadoRT(desde,null,estadoManteCo);
        CambioEstadoRT cambioE4 = new CambioEstadoRT(desde,null,estadoBajaT);// no debe aparecer
        CambioEstadoRT cambioE5 = new CambioEstadoRT(desde,null,estadoBajaD);// no debe aparecer
        CambioEstadoRT cambioE6 = new CambioEstadoRT(desde,null,estadoDispo);
        CambioEstadoRT cambioE7 = new CambioEstadoRT(desde,null,estadoDispo);
        CambioEstadoRT cambioE8 = new CambioEstadoRT(desde,null,estadoDispo);
        CambioEstadoRT cambioE9 = new CambioEstadoRT(desde,null,estadoDispo);
        CambioEstadoRT cambioE10 = new CambioEstadoRT(desde,null,estadoIngre); // no debe aparecer
        CambioEstadoRT cambioE11= new CambioEstadoRT(desde,null,estadoMante1);
        CambioEstadoRT cambioE12 = new CambioEstadoRT(desde,null,estadoManteCo);
        CambioEstadoRT cambioE13 = new CambioEstadoRT(desde,null,estadoMante1);
        CambioEstadoRT cambioE14 = new CambioEstadoRT(desde,null,estadoBajaT);// no debe aparecer
        CambioEstadoRT cambioE15 = new CambioEstadoRT(desde,null,estadoMante1);
        CambioEstadoRT cambioE16= new CambioEstadoRT(desde,null,estadoDispo);
        CambioEstadoRT cambioE17 = new CambioEstadoRT(desde,null,estadoDispo);
        CambioEstadoRT cambioE18 = new CambioEstadoRT(desde,null,estadoBajaD);// no debe aparecer
        CambioEstadoRT cambioE19 = new CambioEstadoRT(desde,hasta,estadoIngre);// no debe aparecer
        CambioEstadoRT cambioE20 = new CambioEstadoRT(desde,hasta,estadoIngre);// no debe aparecer
        
        /*Arrays para setearles a los muchos cambios de estado que tengan los recursos*/
        ArrayList <CambioEstadoRT> estadosRecurso1 = new ArrayList();
        estadosRecurso1.add(cambioE1);        
        ArrayList <CambioEstadoRT> estadosRecurso2 = new ArrayList();
        estadosRecurso2.add(cambioE2);
        ArrayList <CambioEstadoRT> estadosRecurso3 = new ArrayList();
        estadosRecurso3.add(cambioE3);
        ArrayList <CambioEstadoRT> estadosRecurso4 = new ArrayList();
        estadosRecurso4.add(cambioE4);
        ArrayList <CambioEstadoRT> estadosRecurso5 = new ArrayList();
        estadosRecurso5.add(cambioE5);        
        ArrayList <CambioEstadoRT> estadosRecurso6 = new ArrayList();
        estadosRecurso6.add(cambioE6);
        ArrayList <CambioEstadoRT> estadosRecurso7 = new ArrayList();
        estadosRecurso7.add(cambioE7);
        ArrayList <CambioEstadoRT> estadosRecurso8 = new ArrayList();
        estadosRecurso8.add(cambioE8);
        ArrayList <CambioEstadoRT> estadosRecurso9 = new ArrayList();
        estadosRecurso9.add(cambioE9);
        ArrayList <CambioEstadoRT> estadosRecurso10 = new ArrayList();
        estadosRecurso10.add(cambioE10);
        ArrayList <CambioEstadoRT> estadosRecurso11 = new ArrayList();
        estadosRecurso11.add(cambioE11);
        ArrayList <CambioEstadoRT> estadosRecurso12 = new ArrayList();
        estadosRecurso12.add(cambioE12);
        ArrayList <CambioEstadoRT> estadosRecurso13 = new ArrayList();
        estadosRecurso13.add(cambioE13);
        ArrayList <CambioEstadoRT> estadosRecurso14 = new ArrayList();
        estadosRecurso14.add(cambioE14);
        ArrayList <CambioEstadoRT> estadosRecurso15 = new ArrayList();
        estadosRecurso15.add(cambioE15);
        ArrayList <CambioEstadoRT> estadosRecurso16 = new ArrayList();
        estadosRecurso16.add(cambioE16);
        ArrayList <CambioEstadoRT> estadosRecurso17 = new ArrayList();
        estadosRecurso17.add(cambioE17);
        ArrayList <CambioEstadoRT> estadosRecurso18 = new ArrayList();
        estadosRecurso18.add(cambioE18);
        ArrayList <CambioEstadoRT> estadosRecurso19 = new ArrayList();
        estadosRecurso19.add(cambioE19);
        ArrayList <CambioEstadoRT> estadosRecurso20 = new ArrayList();
        estadosRecurso20.add(cambioE20);

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
        RecursoTecnologico rt1 = new RecursoTecnologico(1,null,null,null,null,null,modelShi,tRTMicro,estadosRecurso1,turnosRTMicro,centroSern);
        RecursoTecnologico rt2 = new RecursoTecnologico(2,null,null,null,null,null,modelNikon,tRTMicro,estadosRecurso2,turnosRTMicro,centroSern);        
        RecursoTecnologico rt3 = new RecursoTecnologico(3,null,null,null,null,null,modelGenElec,tRTMicro,estadosRecurso3,turnosRTMicro,centroNasa);
        RecursoTecnologico rt4 = new RecursoTecnologico(4,null,null,null,null,null,modelNikon,tRTResona,estadosRecurso4,turnosRT4,centroNasa); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico rt5 = new RecursoTecnologico(5,null,null,null,null,null,modelOpt,tRTCamTer,estadosRecurso5,turnosRT5,centroSpace); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico rt6 = new RecursoTecnologico(6,null,null,null,null,null,modelGenElec,tRTMicro,estadosRecurso6,turnosRTMicro,centroSern);
        //RecursoTecnologico rt7 = new RecursoTecnologico(7,null,null,null,null,null,modelSie,tRTBalanza,estadosRecurso7,turnosRTBalan,centroNasa);
        RecursoTecnologico rt8 = new RecursoTecnologico(8,null,null,null,null,null,modelSie,tRTResona,estadosRecurso8,turnosRT8,centroSpace);
        RecursoTecnologico rt9 = new RecursoTecnologico(9,null,null,null,null,null,modelShi,tRTEqCompu,estadosRecurso9,turnosRT9,centroNasa);
        RecursoTecnologico rt10 = new RecursoTecnologico(10,null,null,null,null,null,modelGramPre,tRTMicro,estadosRecurso10,turnosRTMicro,centroNasa); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico rt11 = new RecursoTecnologico(11,null,null,null,null,null,modelShi,tRTMicro,estadosRecurso11,turnosRTMicro,centroSern);
        RecursoTecnologico rt12 = new RecursoTecnologico(12,null,null,null,null,null,modelOpt,tRTCamTer,estadosRecurso12,turnosRT12, centroSern);        
        RecursoTecnologico rt13 = new RecursoTecnologico(13,null,null,null,null,null,modelGenElec,tRTMicro,estadosRecurso13,turnosRTMicro, centroSern); 
        RecursoTecnologico rt14 = new RecursoTecnologico(14,null,null,null,null,null,modelGramPre,tRTResona,estadosRecurso14,turnosRT14,centroSern); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico rt15 = new RecursoTecnologico(15,null,null,null,null,null,modelNikon,tRTEqCompu,estadosRecurso15,turnosRT15,centroSpace);
        RecursoTecnologico rt16 = new RecursoTecnologico(16,null,null,null,null,null,modelGenElec,tRTMicro,estadosRecurso16,turnosRTMicro,centroSern);
        //RecursoTecnologico rt17 = new RecursoTecnologico(17,null,null,null,null,null,modelGramPre,tRTBalanza,estadosRecurso17,turnosRTBalan,centroSern);
        RecursoTecnologico rt18 = new RecursoTecnologico(18,null,null,null,null,null,modelGenElec,tRTResona,estadosRecurso18,turnosRT18,centroSpace); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico rt19 = new RecursoTecnologico(19,null,null,null,null,null,modelShi,tRTResona,estadosRecurso19,turnosRT19,centroNasa); /*NO DEBERIA PODER RESERVARSE*/
        RecursoTecnologico rt20 = new RecursoTecnologico(20,null,null,null,null,null,modelOpt,tRTCamTer,estadosRecurso20,turnosRT20,centroNasa); /*NO DEBERIA PODER RESERVARSE*/
//        
       /*Creando relacion RTs con Centros */
        ArrayList <RecursoTecnologico> rtCentroSern= new ArrayList<>();
        rtCentroSern.add(rt1);
        rtCentroSern.add(rt2);
        rtCentroSern.add(rt6);
        rtCentroSern.add(rt11);
        rtCentroSern.add(rt12);
        rtCentroSern.add(rt16);
        rtCentroSern.add(rt13);
        rtCentroSern.add(rt14);
        //rtCentroSern.add(rt17);

        centroSern.setRecursosTecnologicos(rtCentroSern);       
        
        ArrayList <RecursoTecnologico> rtCentroNasa= new ArrayList<>();
        rtCentroNasa.add(rt3);
        rtCentroNasa.add(rt4);
        //rtCentroNasa.add(rt7);
        rtCentroNasa.add(rt9);
        rtCentroNasa.add(rt10);     
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
        //rec.add(rt7);
        rec.add(rt8);
        rec.add(rt9);
        rec.add(rt10);
        rec.add(rt11);
        rec.add(rt12);
        rec.add(rt13);
        rec.add(rt14);
        rec.add(rt15);
        rec.add(rt16);
        //rec.add(rt17);
        rec.add(rt18);
        rec.add(rt19);
        rec.add(rt20);
        
       /*Creando Personal Cientifico/AsignacionT con Centros */
        ArrayList <AsignacionCientificoDelCI> asignaciones = new ArrayList <>();
        Usuario user1 = new Usuario("pcuser1","12345678" );
        
        Date fechaSesIni = new Date(122,6,15,0,0);
        Sesion sesionAc = new Sesion (user1, fechaSesIni, null);
        
        PersonalCientifico cientifico1 = new PersonalCientifico(1,"Bruce","Wayne",39393939,"brucewayne@gmail.com","iambatman@gmail.com",351351523, user1);
        AsignacionCientificoDelCI asignacion1 = new AsignacionCientificoDelCI(desde,null,cientifico1);
        asignaciones.add(asignacion1);       
        centroSern.setAsignacionCientifico(asignaciones);
        
        /*Otro Cientifico asociado a sus centro NASA*/
//        ArrayList <AsignacionCientificoDelCI> asignaciones2 = new ArrayList <>();
//        PersonalCientifico cientifico2 = new PersonalCientifico(4,"Selina","Kyle",35395439,"selinekyle@gmail.com","iamcatwomen@gmail.com",35135423);
//        AsignacionCientificoDelCI asignacion2 = new AsignacionCientificoDelCI(desde,null,cientifico2);
//        asignaciones2.add(asignacion2);       
//        centroNasa.setAsignacionCientifico(asignaciones2);
        
        /*Otro Cientifico asociado a sus centro SPACE X*/
//        ArrayList <AsignacionCientificoDelCI> asignaciones3 = new ArrayList <>();
//        PersonalCientifico cientifico3 = new PersonalCientifico(3,"Thomas","Wayne",31394839,"thomaswayne@gmail.com","iamjoker@gmail.com",35145823);
//        AsignacionCientificoDelCI asignacion3 = new AsignacionCientificoDelCI(desde,null,cientifico3);
//        asignaciones3.add(asignacion3);       
      
        /*---------------------------------------------------------------------------------------------------------------------------------------------*/
        /*Se crea la pantalla*/
        PantallaRegistrarReservaTurnoDeRT pantalla = new PantallaRegistrarReservaTurnoDeRT();
     
        /*Se crea el gestor y se le setean los tipos de recursos que conforman su relacion*/
        GestorRegistrarReservaTurnoDeRT gestor = new GestorRegistrarReservaTurnoDeRT(pantalla);
        
        // se pasala pantalla y los objetos necesarios creados para el CU23
        gestor.tomarOpcionReservarTurnoDeRecursoTecnologico(arrayTipos, rec, estados, centrosArray, sesionAc ); 
    }
}