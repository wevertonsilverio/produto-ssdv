package com.example.exemplo_prod.service;

import com.example.exemplo_prod.entity.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class ProdutoService {
    private List<Produto> produtos;

    public ProdutoService(){
        produtos = new ArrayList<>();
    }

    public List<Produto> buscarProdutos(){
        return produtos;
    }

    public Produto criarProduto(Produto produto){
       produtos.add(produto);
        return produto;
    }

    public Produto buscarProduto(Long id) throws Exception {
        Optional<Produto> produto = produtos.stream().filter
                (e -> Objects.equals(e.getId(), id)).findFirst();
        if(produto.isPresent()){
            return produto.get();
        } else {
            throw new Exception("Produto não encontrado!");
        }
    }

}

