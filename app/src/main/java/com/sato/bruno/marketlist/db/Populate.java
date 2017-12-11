package com.sato.bruno.marketlist.db;

import android.content.Context;

import com.sato.bruno.marketlist.model.dao.ProdutoDAO;
import com.sato.bruno.marketlist.R;

public class Populate {

    private ProdutoDAO produtoDAO;

    public void populate(Context context) {

        produtoDAO = new ProdutoDAO(context);
        produtoDAO.salvar("Arroz", "Grãos", "", Integer.toString(R.drawable.ic_rice_bowl));
        produtoDAO.salvar("Maçã", "Frutas", "", Integer.toString(R.drawable.ic_apple));
        produtoDAO.salvar("Aspargo", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_asparagus));
        produtoDAO.salvar("Abacate", "Frutas", "", Integer.toString(R.drawable.ic_avocado));
        produtoDAO.salvar("Bacon", "Carnes", "", Integer.toString(R.drawable.ic_bacon));
        produtoDAO.salvar("Banana", "Frutas", "", Integer.toString(R.drawable.ic_banana));
        produtoDAO.salvar("Cerveja", "Bebidas", "", Integer.toString(R.drawable.ic_beer));
        produtoDAO.salvar("Beterraba", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_beet));
        produtoDAO.salvar("Água", "Bebida", "", Integer.toString(R.drawable.ic_bottle_of_water));
        produtoDAO.salvar("Pão", "Outros", "", Integer.toString(R.drawable.ic_bread));
        produtoDAO.salvar("Brócolis", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_broccoli));
        produtoDAO.salvar("Repolho", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_cabbage));
        produtoDAO.salvar("Café", "Bebidas", "", Integer.toString(R.drawable.ic_cafe));
        produtoDAO.salvar("Cenoura", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_carrot));
        produtoDAO.salvar("Aipo", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_celery));
        produtoDAO.salvar("Queijo", "Leite e derivados", "", Integer.toString(R.drawable.ic_cheese));
        produtoDAO.salvar("Cereja", "Frutas", "", Integer.toString(R.drawable.ic_cherry));
        produtoDAO.salvar("Pimenta", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_chili_pepper));
        produtoDAO.salvar("Limão", "Frutas", "", Integer.toString(R.drawable.ic_citrus));
        produtoDAO.salvar("Milho", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_corn));
        produtoDAO.salvar("Pepino", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_cucumber));
        produtoDAO.salvar("Beringela", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_eggplant));
        produtoDAO.salvar("Peixe", "Carnes", "", Integer.toString(R.drawable.ic_fish_food));
        produtoDAO.salvar("Alho", "Temperos", "", Integer.toString(R.drawable.ic_garlic));
        produtoDAO.salvar("Uva", "Frutas", "", Integer.toString(R.drawable.ic_grapes));
        produtoDAO.salvar("Mel", "Outros", "", Integer.toString(R.drawable.ic_honey));
        produtoDAO.salvar("Kiwi", "Frutas", "", Integer.toString(R.drawable.ic_kiwi));
        produtoDAO.salvar("Couve", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_kohlrabi));
        produtoDAO.salvar("Alho-poró", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_leek));
        produtoDAO.salvar("Alface", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_lettuce));
        produtoDAO.salvar("Melão", "Frutas", "", Integer.toString(R.drawable.ic_melon));
        produtoDAO.salvar("Leite", "Leite e derivados", "", Integer.toString(R.drawable.ic_milk));
        produtoDAO.salvar("Nachos", "Petiscos", "", Integer.toString(R.drawable.ic_nachos));
        produtoDAO.salvar("Miojo", "Massas", "", Integer.toString(R.drawable.ic_noodles));
        produtoDAO.salvar("Azeitona", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_olive));
        produtoDAO.salvar("Azeite", "Óleos", "", Integer.toString(R.drawable.ic_olive_oil));
        produtoDAO.salvar("Cebola", "Temperos", "", Integer.toString(R.drawable.ic_onion));
        produtoDAO.salvar("Pimentão", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_paprika));
        produtoDAO.salvar("Pêssego", "Frutas", "", Integer.toString(R.drawable.ic_peach));
        produtoDAO.salvar("Amendoim", "Petiscos", "", Integer.toString(R.drawable.ic_peanuts));
        produtoDAO.salvar("Ervilhas", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_peas));
        produtoDAO.salvar("Abacaxi", "Frutas", "", Integer.toString(R.drawable.ic_pineapple));
        produtoDAO.salvar("Pizza", "Congelados", "", Integer.toString(R.drawable.ic_pizza));
        produtoDAO.salvar("Ameixa", "Frutas", "", Integer.toString(R.drawable.ic_plum));
        produtoDAO.salvar("Batata", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_potato));
        produtoDAO.salvar("Camarão", "Carnes", "", Integer.toString(R.drawable.ic_prawn));
        produtoDAO.salvar("Rabanete", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_radish));
        produtoDAO.salvar("Farinha", "Grãos", "", Integer.toString(R.drawable.ic_sack_of_flour));
        produtoDAO.salvar("Sal", "Temperos", "", Integer.toString(R.drawable.ic_salt_shaker));
        produtoDAO.salvar("Macarrão", "Massas", "", Integer.toString(R.drawable.ic_spaghetti));
        produtoDAO.salvar("Carne", "Carnes", "", Integer.toString(R.drawable.ic_steak));
        produtoDAO.salvar("Morango", "Frutas", "", Integer.toString(R.drawable.ic_strawberry));
        produtoDAO.salvar("Chá", "Bebidas", "", Integer.toString(R.drawable.ic_tea));
        produtoDAO.salvar("Frango", "Carne", "", Integer.toString(R.drawable.ic_thanksgiving));
        produtoDAO.salvar("Tomate", "Verduras e Vegetais", "", Integer.toString(R.drawable.ic_tomato));
        produtoDAO.salvar("Melancia", "Fruta", "", Integer.toString(R.drawable.ic_watermelon));
        produtoDAO.salvar("Vinho", "Bebidas", "", Integer.toString(R.drawable.ic_wine_bottle));

    }
}
