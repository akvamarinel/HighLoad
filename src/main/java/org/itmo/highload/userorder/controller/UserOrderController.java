package org.itmo.highload.userorder.controller;

import lombok.RequiredArgsConstructor;
import org.itmo.highload.common.ResponsePage;
import org.itmo.highload.restaurant.controller.dto.RestaurantDto;
import org.itmo.highload.userorder.controller.dto.UserOrderDto;
import org.itmo.highload.userorder.controller.mapper.UserOrderMapper;
import org.itmo.highload.userorder.service.UserOrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("orders")
public class UserOrderController {

    private final UserOrderMapper userOrderMapper;
    private final UserOrderService userOrderService;

    @PostMapping()
    public ResponseEntity<UserOrderDto> create(@RequestBody @Valid UserOrderDto userOrderDto) {
        userOrderDto.setOrderTime(new Date());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userOrderMapper.toDto(userOrderService.create(userOrderMapper.toModel(userOrderDto))));
    }

    @GetMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> getAll(@PathVariable UUID id,  @PageableDefault Pageable pageable) {
        List<UserOrderDto> userOrderDtoList = userOrderService.getAll(id, pageable).stream()
                .map(userOrderMapper::toDto).collect(Collectors.toList());
        boolean tmp = userOrderService.getAll(id, pageable).hasNext();
        ResponseEntity.BodyBuilder bodyBuilder = tmp ? ResponseEntity.status(HttpStatus.PARTIAL_CONTENT) : ResponseEntity.status(HttpStatus.CREATED);
        return bodyBuilder.body(new ResponsePage(userOrderDtoList, tmp));
    }

}
