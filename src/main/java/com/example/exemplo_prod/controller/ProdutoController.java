package com.example.exemplo_prod.controller;

import com.example.exemplo_prod.entity.Produto;
import com.example.exemplo_prod.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")

public class ProdutoController {

    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("todos")
    public ResponseEntity<?> buscarProdutos() {
        try {
            List<Produto> lista = produtoService.buscarProdutos();
            return new ResponseEntity(lista, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Mensagem erro", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto) {
        try {
            produto = produtoService.criarProduto(produto);
            return new ResponseEntity<>(produto, HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity(exception.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable("id") Long id) {
        try {
            Produto produto = produtoService.buscarProduto(id);
            return new ResponseEntity(produto, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("delete")
    private String excluirProduto(){
        return "Produto Excluído";
    }
}