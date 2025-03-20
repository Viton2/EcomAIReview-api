package com.vitor.oliveira.ecomaireviewapi.service.impl;

import com.vitor.oliveira.ecomaireviewapi.DTO.forms.OrderForm;
import com.vitor.oliveira.ecomaireviewapi.model.Order;
import com.vitor.oliveira.ecomaireviewapi.model.User;
import com.vitor.oliveira.ecomaireviewapi.repository.OrderRepository;
import com.vitor.oliveira.ecomaireviewapi.repository.UserRepository;
import com.vitor.oliveira.ecomaireviewapi.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private UserServiceImpl userServiceImpl;
    private OrderRepository orderRepository;

    public OrderServiceImpl(UserRepository userRepository, UserServiceImpl userServiceImpl, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.userServiceImpl = userServiceImpl;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(OrderForm form) {
//        UserEntity user = getUserByID(form);
        Order order = Order.builder()
                .totalPrice(form.getTotalPrice())
//                .user(userServiceImpl.convertUserEntityToUser(new User()))
                .build();
        return orderRepository.save(order);
    }

//    private UserEntity getUserByID(OrderForm form) {
//        Optional<User> user = userRepository.findById(form.getUserId());
//        if (user.isPresent()) {
//            return null;
//        }
//        throw new RuntimeException("User not found");
//    }
}
