package com.senla.carservice.dto.mappers.interfaces;

import com.senla.carservice.dto.OrderDto;
import com.senla.carservice.dto.mappers.OrderStatusMapper;
import com.senla.carservice.dto.mappers.UuidMapper;
import com.senla.carservice.entity.order.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-26T21:33:25+0300",
    comments = "version: 1.4.0.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private UuidMapper uuidMapper;
    @Autowired
    private OrderStatusMapper orderStatusMapper;

    @Override
    public OrderDto dtoFromOrder(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( uuidMapper.asString( order.getId() ) );
        orderDto.setStatus( orderStatusMapper.asString( order.getStatus() ) );
        if ( order.getDateBooked() != null ) {
            orderDto.setDateBooked( DateTimeFormatter.ISO_LOCAL_DATE.format( order.getDateBooked() ) );
        }
        if ( order.getStartOfExecution() != null ) {
            orderDto.setStartOfExecution( DateTimeFormatter.ISO_LOCAL_DATE.format( order.getStartOfExecution() ) );
        }
        if ( order.getFinishOfExecution() != null ) {
            orderDto.setFinishOfExecution( DateTimeFormatter.ISO_LOCAL_DATE.format( order.getFinishOfExecution() ) );
        }

        return orderDto;
    }

    @Override
    public Order orderFromDto(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( uuidMapper.asId( orderDto.getId() ) );
        order.setStatus( orderStatusMapper.asStatus( orderDto.getStatus() ) );
        if ( orderDto.getDateBooked() != null ) {
            order.setDateBooked( LocalDate.parse( orderDto.getDateBooked() ) );
        }
        if ( orderDto.getStartOfExecution() != null ) {
            order.setStartOfExecution( LocalDate.parse( orderDto.getStartOfExecution() ) );
        }
        if ( orderDto.getFinishOfExecution() != null ) {
            order.setFinishOfExecution( LocalDate.parse( orderDto.getFinishOfExecution() ) );
        }

        return order;
    }

    @Override
    public List<OrderDto> dtoFromOrders(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( orders.size() );
        for ( Order order : orders ) {
            list.add( dtoFromOrder( order ) );
        }

        return list;
    }

    @Override
    public List<Order> ordersFromDto(List<OrderDto> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( dto.size() );
        for ( OrderDto orderDto : dto ) {
            list.add( orderFromDto( orderDto ) );
        }

        return list;
    }
}
