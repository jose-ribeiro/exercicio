package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercicio3 {

    public static void main(String[] args) {
        // Caminho corrigido para o arquivo JSON
        String arquivoJson = "src/main/resources/dados.json";
        analisarFaturamento(arquivoJson);
    }

    public static void analisarFaturamento(String arquivoJson) {
        JSONParser parser = new JSONParser();

        try {
            // Parseando o arquivo JSON
            JSONArray faturamentoArray = (JSONArray) parser.parse(new FileReader(arquivoJson));

            List<Double> valoresValidos = new ArrayList<>();

            // Iterando sobre o array de faturamento
            for (Object obj : faturamentoArray) {
                JSONObject faturamento = (JSONObject) obj;
                double valor = (double) faturamento.get("valor");

                // Filtrando dias com faturamento maior que zero
                if (valor > 0) {
                    valoresValidos.add(valor);
                }
            }

            // Verificando se há dados válidos
            if (valoresValidos.isEmpty()) {
                System.out.println("Não houve faturamento em nenhum dia.");
                return;
            }

            // Encontrar menor e maior valor de faturamento
            double menorFaturamento = Collections.min(valoresValidos);
            double maiorFaturamento = Collections.max(valoresValidos);

            // Calcular a soma e a média mensal
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
            System.out.printf("Média mensal: R$%.2f\n", mediaMensal);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaMedia);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
