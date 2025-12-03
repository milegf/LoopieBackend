package com.example.loopie.Pedidos.service;

import com.example.loopie.Pedidos.dto.ItemPedidoRequest;
import com.example.loopie.Pedidos.dto.PedidoRequest;
import com.example.loopie.Pedidos.model.Pedido;
import com.example.loopie.Pedidos.model.ItemPedido;
import com.example.loopie.Pedidos.repository.PedidoRepository;
import com.example.loopie.Products.model.Product;
import com.example.loopie.Products.repository.ProductRepository;
import com.example.loopie.Users.model.User;
import com.example.loopie.Users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Transactional
    public Pedido createPedido(PedidoRequest request) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Pedido pedido = new Pedido();
        pedido.setUser(user);
        pedido.setStatus("Pendiente");
        pedido.setCreatedAt(LocalDateTime.now());
        
        List<ItemPedido> items = new ArrayList<>();
        double totalCalculado = 0;

        for (ItemPedidoRequest itemRequest : request.getItems()) {
            Product product = productRepository.findById(itemRequest.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            
            ItemPedido item = new ItemPedido();
            item.setPedido(pedido);
            item.setProduct(product);
            item.setCantidad(itemRequest.getCantidad());
            // Usa el precio de oferta si está disponible y es true
            if (Boolean.TRUE.equals(product.getEnOferta()) && product.getPrecioOferta() != null) {
                item.setPrecio(product.getPrecioOferta());
            } else {
                item.setPrecio(product.getPrecio());
            }
            
            items.add(item);
            totalCalculado += item.getPrecioItem() * item.getCantidad();
        }

        pedido.setItems(items);
        pedido.setTotalPedido(request.getTotal() != null ? request.getTotal() : totalCalculado);

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> getMisPedidos() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return pedidoRepository.findByUser(user);
    }

    public Pedido getPedidoById(int id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }
}
