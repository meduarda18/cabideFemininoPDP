package br.edu.ifpb.validator;

import br.edu.ifpb.entity.Sale;

import java.util.List;

public class SaleValidator {
    public static void validateSale(Sale sale) {
        if (sale.getSaleDate() == null || sale.getSaleDate().isBlank()) {
            throw new IllegalArgumentException("A data da venda não pode ser nulo ou vazio.");
        }
        if (sale.getPaymentMethod() == null || sale.getPaymentMethod().isBlank()) {
            throw new IllegalArgumentException("O método de pagamento não poder ser null.");
        }
        if (sale.getInstalment() < 1) {
            throw new IllegalArgumentException("As parcelas de uma venda não podem ser negativas ou igual a 0.");
        }
        if (sale.getDiscount() < 0 || sale.getDiscount() > sale.getTotalSale()) {
            throw new IllegalArgumentException("O desconto de uma venda não pode ser negativo.");
        }

    }

}
