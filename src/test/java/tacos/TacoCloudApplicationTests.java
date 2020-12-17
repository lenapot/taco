package tacos;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
//import tacos.data.OrderRepository;
//import tacos.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TacoCloudApplicationTests {

//	@Autowired
//	OrderService orderService;
//
//	@MockBean
//	OrderRepository orderRepository;
//
//	@Test
//	public void testAddOrder() {
//		Order order = new Order();
//		order.setStatus(Order.Status.DONE);
//		order.setName("Test");
//		Order createdOrder = orderService.saveOrder(order);
//		Assert.assertNotNull(createdOrder);
//
//		Mockito.verify(orderRepository, Mockito.times(1)).save(order);
//	}

}
