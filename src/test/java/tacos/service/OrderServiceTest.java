package tacos.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import tacos.domain.Order;
import tacos.repo.OrderRepository;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {



    @Autowired
    OrderService orderService;

    @MockBean
    OrderRepository orderRepository;
    @Test
    public void addOrder() {

        when(orderRepository.save(Mockito.any(Order.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        Order order = new Order();

        order.setId(123123L);
        order.setStatus(Order.Status.DONE);
 		order.setName("Test");
        Order createdOrder = orderService.saveOrder(order);
		Assert.assertNotNull(createdOrder);

    }

}
