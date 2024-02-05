package br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.principal;

import br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.model.Models;
import br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.model.Vehicle;
import br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.model.VehicleBrandsData;
import br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.service.APIConsume;
import br.com.fipeConsume.br.com.alura.estudos.danilo.fipeConsume.service.JacksonDataConverter;
import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.fasterxml.jackson.databind.util.ISO8601Utils;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Principal {

    public void showMenu(){

        APIConsume apiConsume = new APIConsume();
        JacksonDataConverter conv = new JacksonDataConverter();
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

        String completeURL = "https://parallelum.com.br/fipe/api/v1/" + vehicleType + "/marcas";

       String brandList = apiConsume.getData(completeURL);

        var vehicleBrandsData = conv.getList(brandList, VehicleBrandsData.class);

        vehicleBrandsData.stream()
                        .sorted(Comparator.comparing(VehicleBrandsData::code))
                                .forEach(System.out::println);

        System.out.println("Informe o código da marca para consulta: ");
        String brandCodeResp = t.nextLine();

        completeURL = completeURL + "/" + brandCodeResp + "/modelos";

        String vehiclePerBrandList = apiConsume.getData(completeURL);
        var modelsList = conv.getData(vehiclePerBrandList, Models.class);

        System.out.println("Modelos da marca especificada: ");
        modelsList.models().stream()
                .sorted(Comparator.comparing(VehicleBrandsData::code))
                .forEach(System.out::println);

        System.out.println("Digite um trecho do nome do carro para consulta: ");
        String carForSearch = t.nextLine().trim();

        modelsList.models().stream()
                .filter(m -> m.name().contains(carForSearch))
                .sorted(Comparator.comparing(VehicleBrandsData::code))
                .forEach(System.out::println);

        System.out.println("Digite o código do modelo para consultar valores: ");
        String carModelCode = t.nextLine();
        completeURL = completeURL + "/" + carModelCode + "/anos";


        var modelPerYearList = apiConsume.getData(completeURL);
        List<VehicleBrandsData> years = conv.getList(modelPerYearList, VehicleBrandsData.class);
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < years.size() ; i++) {
            var urlByYear = completeURL + "/" + years.get(i).code();
            var json = apiConsume.getData(urlByYear);
            Vehicle vehicle = conv.getData(json, Vehicle.class);
            vehicles.add(vehicle);
        }

        System.out.println("Todos os veículos filtrados por avaliação por ano: ");
        vehicles.forEach(System.out::println);

    }
}
