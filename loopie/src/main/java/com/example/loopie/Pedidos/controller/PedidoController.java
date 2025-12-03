package com.example.loopie.Pedidos.controller;

import com.example.loopie.Pedidos.dto.PedidoRequest;
import com.example.loopie.Pedidos.model.Pedido;
import com.example.loopie.Pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
@RequiredArgsConstructor

public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody PedidoRequest request) {
        return ResponseEntity.ok(pedidoService.createPedido(request));
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getMisPedidos() {
        return ResponseEntity.ok(pedidoService.getMisPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable int id) {
        return ResponseEntity.ok(pedidoService.getPedidoById(id));
    }
}
