package br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.principal;

import br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.model.VehicleBrandsData;
import br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.service.APIConsume;
import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.fasterxml.jackson.databind.util.ISO8601Utils;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Principal {

    public void showMenu(){

        APIConsume apiConsume = new APIConsume();

        Scanner t = new Scanner(System.in);

        System.out.println("**** OPÇÕES **** ");
        System.out.println("Carro \nMoto \nCaminhão " +
                "\nDigite uma das opções para consultar valores: ");
        var resp = t.nextLine().trim().toUpperCase();
        String vehicleType = null;

        switch (resp) {
            case ("CARRO"):
                vehicleType = "carros";
                break;
            case ("MOTO"):
                vehicleType = "motos";
                break;
            case ("CAMINHAO"):
                vehicleType = "caminhoes";
                break;
        }

       String vehicleList = apiConsume.getData("https://parallelum.com.br/fipe/api/v1/" + vehicleType + "/marcas");




        List<VehicleBrandsData> vehicleBrandsData = new ArrayList<>();



    }



    APIConsume apiConsume = new APIConsume();




}
