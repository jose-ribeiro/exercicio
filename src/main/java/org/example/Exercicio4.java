package org.example;

import java.util.HashMap;
import java.util.Map;

public class Exercicio4 {
    public static void main(String[] args) {
        calcularPercentuais();
    }

    public static void calcularPercentuais() {
        Map<String, Double> faturamento = new HashMap<>();
        faturamento.put("SP", 67836.43);
        faturamento.put("RJ", 36678.66);
        faturamento.put("MG", 29229.88);
        faturamento.put("ES", 27165.48);
        faturamento.put("Outros", 19849.53);

        double faturamentoTotal = 0;
        for (double valor : faturamento.values()) {
            faturamentoTotal += valor;
        }

        for (Map.Entry<String, Double> entry : faturamento.entrySet()) {
            String estado = entry.getKey();
            double percentual = (entry.getValue() / faturamentoTotal) * 100;
            System.out.printf("%s: %.2f%%\n", estado, percentual);
        }
    }
}

