package com.gabrielgodoi.course.config;

import com.gabrielgodoi.course.entities.*;
import com.gabrielgodoi.course.entities.enums.OrderStatus;
import com.gabrielgodoi.course.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9823107", "123");
        User u2 = new User(null, "Alex Green", "Alexa@gmail.com", "2432432", "123");

        // letra z = o horário está no horário de greenwitch
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        // seed na tabela order_item com todos os pedidos que desejamos fazer
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        // criando o relacionamento entre produtos e suas devidas categorias
        p1.getCategory().add(cat2);
        p2.getCategory().add(cat1);
        p2.getCategory().add(cat3);
        p3.getCategory().add(cat3);
        p4.getCategory().add(cat3);
        p5.getCategory().add(cat2);

        // cadastrando categorias
        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        // cadastrando produtos
        this.productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        // cadastrando usuários
        this.userRepository.saveAll(Arrays.asList(u1, u2));


        // instancia de pagamento e relacionamento com o pedido em questão
        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);

        // associação do pay1 com o pedido em questão
        o1.setPayment(pay1);


        // cadastrando pedidos
        this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        // cadastrando itens do pedido
        this.orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
