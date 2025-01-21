package com.vitor.oliveira.ecomaireviewapi.service;

import com.vitor.oliveira.ecomaireviewapi.DTO.OrderDTO;
import com.vitor.oliveira.ecomaireviewapi.DTO.forms.OrderForm;
import com.vitor.oliveira.ecomaireviewapi.model.Order;

public interface OrderService {

    public Order create(OrderForm form);
}
