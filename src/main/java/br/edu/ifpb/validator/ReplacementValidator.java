package br.edu.ifpb.validator;

import br.edu.ifpb.entity.Replacement;

public class ReplacementValidator {

    public static void ValidateReplacement(Replacement replacement){
        if(replacement.getSize() == null || replacement.getSize().isBlank()){
            throw new IllegalArgumentException("O tamanho do produto em uma reposição não deve ser null ou vazio.");
        }
        if(replacement.getQuantity() <= 0){
            throw new IllegalArgumentException("A quantidade de uma reposição não pode ser 0 ou negativa.");
        }
        if(replacement.getReplacementDate() == null || replacement.getReplacementDate().isBlank()){
            throw new IllegalArgumentException("A data da reposição não pode ser nula ou vazia.");
        }
        if(replacement.getBuyValue() <= 0){
            throw new IllegalArgumentException("O valor de compra de uma reposição não pode ser 0 ou negativo.");
        }
    }
}
