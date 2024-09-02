package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercicio3 {

    public static void main(String[] args) {
        // Caminho corrigido para o arquivo JSON
        String arquivoJson = "src/main/resources/faturamento.json";
        analisarFaturamento(arquivoJson);
    }

    public static void analisarFaturamento(String arquivoJson) {
        JSONParser parser = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(arquivoJson));
            JSONArray faturamentoDiario = (JSONArray) jsonObject.get("faturamento_diario");

            List<Double> valoresValidos = new ArrayList<>();

            // Filtrar valores maiores que zero
            for (Object obj : faturamentoDiario) {
                double valor = ((Number) obj).doubleValue();
                if (valor > 0) {
                    valoresValidos.add(valor);
                }
            }

            // Encontrar menor e maior valor de faturamento
            double menorFaturamento = Collections.min(valoresValidos);
            double maiorFaturamento = Collections.max(valoresValidos);

            // Calcular média mensal
            double somaTotal = 0;
            for (double valor : valoresValidos) {
                somaTotal += valor;
            }
            double mediaMensal = somaTotal / valoresValidos.size();

            // Contar dias acima da média
            int diasAcimaMedia = 0;
            for (double valor : valoresValidos) {
                if (valor > mediaMensal) {
                    diasAcimaMedia++;
                }
            }

            // Exibir resultados
            System.out.printf("Menor faturamento: R$%.2f\n", menorFaturamento);
            System.out.printf("Maior faturamento: R$%.2f\n", maiorFaturamento);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
