package tacos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tacos.domain.Order;
import tacos.domain.TacoType;
import tacos.domain.User;
import tacos.repo.TacoTypeRepository;
import tacos.props.OrderProps;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TacoTypeServiceImpl implements TacoTypeService{

    @Autowired
    private OrderProps props;

    @Autowired
    TacoTypeRepository tacoTypeRepository;

    @Autowired
    OrderService orderService;

    @Override
    public TacoType saveTacoType(TacoType tacoType) {
        return tacoTypeRepository.save(tacoType);
    }

    @Override
    public TacoType getTacoType(long tacoId) {
        Optional<TacoType> optionalTacoType = tacoTypeRepository.findById(tacoId);
        return optionalTacoType.orElseGet(() -> optionalTacoType.orElseThrow(RuntimeException::new));
    }

    @Override
    public Page<TacoType> getTacoTypesByUser(User user, int pageNum) {
        PageRequest pageable = PageRequest.of(pageNum - 1, props.getPageSize());
        List<Order> orderPage = orderService.getOrdersByUser(user);
        List<TacoType> userTacos = orderPage.stream()
                .map(Order::getTacos)
                .flatMap(List::stream)
                .map(taco -> taco.getTacotype())
                .distinct()
                .collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize()) > userTacos.size() ? userTacos.size() : (start + pageable.getPageSize());

        Page<TacoType> tacoPage = new PageImpl<TacoType>(userTacos.subList(start, end), pageable, userTacos.size());

        return tacoPage;
    }
}
